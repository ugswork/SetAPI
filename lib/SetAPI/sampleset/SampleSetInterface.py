"""
An interface for handling sample sets
"""

import traceback
from pprint import pprint

class SampleSetInterface:

    def __init__(self, workspace_client):
        self.ws_client = workspace_client

    def _ws_get_ref(self, ws_id, obj_id):
        if '/' in obj_id:
            return obj_id
        else:
            info = self.ws_client.get_object_info_new({"objects": [{'name': obj_id, 'workspace': ws_id}]})[0]
            return "{0}/{1}/{2}".format(info[6], info[0], info[4])

    def _ws_get_obj_name(self, obj_id):
        info = self.ws_client.get_object_info_new({"objects": [{'ref': obj_id}]})[0]
        return info[1]

    def create_sample_set(self, ctx, params):

        try:
            if 'sample_n_conditions' in params:
                params["sample_ids"] = [item['sample_id'] for item in params['sample_n_conditions']]
                params["condition"] = [item['condition'] for item in params['sample_n_conditions']]
                del params['sample_n_conditions']

            pprint(params)

            ### Create the working dir for the method; change it to a function call
            out_obj = {k: v for k, v in params.iteritems() if not k in ('ws_id')}

            sample_ids = params["sample_ids"]
            out_obj['num_samples'] = len(sample_ids)
            ## Validation to check if the Set contains more than one samples
            if len(sample_ids) < 2:
                raise ValueError(
                    "This methods can only take 2 or more RNASeq Samples. \
                     If you have only one read sample, run either 'Align Reads using Tophat/Bowtie2' \
                     methods directly for getting alignment")

            ## Validation to Check if the number of samples is equal to number of condition
            if len(params["condition"]) != out_obj['num_samples']:
                raise ValueError(
                    "Please specify a treatment label for each sample in the RNA-seq SampleSet. \
                     Please enter the same label for the replicates in a sample type")

            ## Validation to Check if the user is loading the same type as specified above
            if params["Library_type"] == 'PairedEnd':
                lib_type = ['KBaseAssembly.PairedEndLibrary', 'KBaseFile.PairedEndLibrary']
            else:
                lib_type = ['KBaseAssembly.SingleEndLibrary', 'KBaseFile.SingleEndLibrary']
            for reads_ref in sample_ids:
                reads_info = self.ws_client.get_object_info3({'objects': [{"ref": reads_ref}]})
                obj_type = reads_info['infos'][0][2].split('-')[0]
                if not (obj_type in lib_type):
                    raise ValueError("Library_type mentioned : {0}. Please add only {1} typed objects in Reads fields".format(
                                      params["Library_type"], params["Library_type"]))

            ## Code to Update the Provenance; make it a function later
            provenance = [{}]
            if 'provenance' in ctx:
                provenance = ctx['provenance']
            # add additional info to provenance here, in this case the input data object reference
            provenance[0]['input_ws_objects'] = [self._ws_get_ref(params['ws_id'], sample) for sample in sample_ids]

            # Saving RNASeqSampleSet to Workspace
            print("Saving {0} object to workspace".format(params['sampleset_id']))
            res = self.ws_client.save_objects(
                {"workspace": params['ws_id'],
                 "objects": [{
                     "type": "KBaseRNASeq.RNASeqSampleSet",
                     "data": out_obj,
                     "name": out_obj['sampleset_id'],
                     "provenance": provenance}]
                 })[0]
            '''
            out_obj['sample_ids'] = [self._ws_get_obj_name(sample_id) for
                                     sample_id in params['sample_ids']]
            '''
            result = dict()
            result['set_ref'] = "{0}/{1}/{2}".format(res[6], res[0], res[4])
            result['set_info'] = res

            pprint(result)
            return result

        except Exception, e:
            raise Exception(
                "Error Saving the object to workspace {0},{1}".format(out_obj['sampleset_id'], "".join(traceback.format_exc())))
