package us.kbase.setapi;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import us.kbase.auth.AuthToken;
import us.kbase.common.service.JsonClientCaller;
import us.kbase.common.service.JsonClientException;
import us.kbase.common.service.RpcContext;
import us.kbase.common.service.UnauthorizedException;

/**
 * <p>Original spec-file module name: SetAPI</p>
 * <pre>
 * </pre>
 */
public class SetAPIClient {
    private JsonClientCaller caller;
    private String serviceVersion = null;


    /** Constructs a client with a custom URL and no user credentials.
     * @param url the URL of the service.
     */
    public SetAPIClient(URL url) {
        caller = new JsonClientCaller(url);
    }
    /** Constructs a client with a custom URL.
     * @param url the URL of the service.
     * @param token the user's authorization token.
     * @throws UnauthorizedException if the token is not valid.
     * @throws IOException if an IOException occurs when checking the token's
     * validity.
     */
    public SetAPIClient(URL url, AuthToken token) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(url, token);
    }

    /** Constructs a client with a custom URL.
     * @param url the URL of the service.
     * @param user the user name.
     * @param password the password for the user name.
     * @throws UnauthorizedException if the credentials are not valid.
     * @throws IOException if an IOException occurs when checking the user's
     * credentials.
     */
    public SetAPIClient(URL url, String user, String password) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(url, user, password);
    }

    /** Constructs a client with a custom URL
     * and a custom authorization service URL.
     * @param url the URL of the service.
     * @param user the user name.
     * @param password the password for the user name.
     * @param auth the URL of the authorization server.
     * @throws UnauthorizedException if the credentials are not valid.
     * @throws IOException if an IOException occurs when checking the user's
     * credentials.
     */
    public SetAPIClient(URL url, String user, String password, URL auth) throws UnauthorizedException, IOException {
        caller = new JsonClientCaller(url, user, password, auth);
    }

    /** Get the token this client uses to communicate with the server.
     * @return the authorization token.
     */
    public AuthToken getToken() {
        return caller.getToken();
    }

    /** Get the URL of the service with which this client communicates.
     * @return the service URL.
     */
    public URL getURL() {
        return caller.getURL();
    }

    /** Set the timeout between establishing a connection to a server and
     * receiving a response. A value of zero or null implies no timeout.
     * @param milliseconds the milliseconds to wait before timing out when
     * attempting to read from a server.
     */
    public void setConnectionReadTimeOut(Integer milliseconds) {
        this.caller.setConnectionReadTimeOut(milliseconds);
    }

    /** Check if this client allows insecure http (vs https) connections.
     * @return true if insecure connections are allowed.
     */
    public boolean isInsecureHttpConnectionAllowed() {
        return caller.isInsecureHttpConnectionAllowed();
    }

    /** Deprecated. Use isInsecureHttpConnectionAllowed().
     * @deprecated
     */
    public boolean isAuthAllowedForHttp() {
        return caller.isAuthAllowedForHttp();
    }

    /** Set whether insecure http (vs https) connections should be allowed by
     * this client.
     * @param allowed true to allow insecure connections. Default false
     */
    public void setIsInsecureHttpConnectionAllowed(boolean allowed) {
        caller.setInsecureHttpConnectionAllowed(allowed);
    }

    /** Deprecated. Use setIsInsecureHttpConnectionAllowed().
     * @deprecated
     */
    public void setAuthAllowedForHttp(boolean isAuthAllowedForHttp) {
        caller.setAuthAllowedForHttp(isAuthAllowedForHttp);
    }

    /** Set whether all SSL certificates, including self-signed certificates,
     * should be trusted.
     * @param trustAll true to trust all certificates. Default false.
     */
    public void setAllSSLCertificatesTrusted(final boolean trustAll) {
        caller.setAllSSLCertificatesTrusted(trustAll);
    }
    
    /** Check if this client trusts all SSL certificates, including
     * self-signed certificates.
     * @return true if all certificates are trusted.
     */
    public boolean isAllSSLCertificatesTrusted() {
        return caller.isAllSSLCertificatesTrusted();
    }
    /** Sets streaming mode on. In this case, the data will be streamed to
     * the server in chunks as it is read from disk rather than buffered in
     * memory. Many servers are not compatible with this feature.
     * @param streamRequest true to set streaming mode on, false otherwise.
     */
    public void setStreamingModeOn(boolean streamRequest) {
        caller.setStreamingModeOn(streamRequest);
    }

    /** Returns true if streaming mode is on.
     * @return true if streaming mode is on.
     */
    public boolean isStreamingModeOn() {
        return caller.isStreamingModeOn();
    }

    public void _setFileForNextRpcResponse(File f) {
        caller.setFileForNextRpcResponse(f);
    }

    public String getServiceVersion() {
        return this.serviceVersion;
    }

    public void setServiceVersion(String newValue) {
        this.serviceVersion = newValue;
    }

    /**
     * <p>Original spec-file function name: get_differential_expression_matrix_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetDifferentialExpressionMatrixSetV1Params GetDifferentialExpressionMatrixSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.GetDifferentialExpressionMatrixSetV1Result GetDifferentialExpressionMatrixSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetDifferentialExpressionMatrixSetV1Result getDifferentialExpressionMatrixSetV1(GetDifferentialExpressionMatrixSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetDifferentialExpressionMatrixSetV1Result>> retType = new TypeReference<List<GetDifferentialExpressionMatrixSetV1Result>>() {};
        List<GetDifferentialExpressionMatrixSetV1Result> res = caller.jsonrpcCall("SetAPI.get_differential_expression_matrix_set_v1", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: save_differential_expression_matrix_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.SaveDifferentialExpressionMatrixSetV1Params SaveDifferentialExpressionMatrixSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.SaveDifferentialExpressionMatrixSetV1Result SaveDifferentialExpressionMatrixSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SaveDifferentialExpressionMatrixSetV1Result saveDifferentialExpressionMatrixSetV1(SaveDifferentialExpressionMatrixSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<SaveDifferentialExpressionMatrixSetV1Result>> retType = new TypeReference<List<SaveDifferentialExpressionMatrixSetV1Result>>() {};
        List<SaveDifferentialExpressionMatrixSetV1Result> res = caller.jsonrpcCall("SetAPI.save_differential_expression_matrix_set_v1", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_feature_set_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetFeatureSetSetV1Params GetFeatureSetSetV1Params}
     * @return   instance of type {@link us.kbase.setapi.GetFeatureSetSetV1Result GetFeatureSetSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetFeatureSetSetV1Result getFeatureSetSetV1(GetFeatureSetSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetFeatureSetSetV1Result>> retType = new TypeReference<List<GetFeatureSetSetV1Result>>() {};
        List<GetFeatureSetSetV1Result> res = caller.jsonrpcCall("SetAPI.get_feature_set_set_v1", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: save_feature_set_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.SaveFeatureSetSetV1Params SaveFeatureSetSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.SaveFeatureSetSetV1Result SaveFeatureSetSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SaveFeatureSetSetV1Result saveFeatureSetSetV1(SaveFeatureSetSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<SaveFeatureSetSetV1Result>> retType = new TypeReference<List<SaveFeatureSetSetV1Result>>() {};
        List<SaveFeatureSetSetV1Result> res = caller.jsonrpcCall("SetAPI.save_feature_set_set_v1", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_expression_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetExpressionSetV1Params GetExpressionSetV1Params}
     * @return   instance of type {@link us.kbase.setapi.GetExpressionSetV1Result GetExpressionSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetExpressionSetV1Result getExpressionSetV1(GetExpressionSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetExpressionSetV1Result>> retType = new TypeReference<List<GetExpressionSetV1Result>>() {};
        List<GetExpressionSetV1Result> res = caller.jsonrpcCall("SetAPI.get_expression_set_v1", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: save_expression_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.SaveExpressionSetV1Params SaveExpressionSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.SaveExpressionSetV1Result SaveExpressionSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SaveExpressionSetV1Result saveExpressionSetV1(SaveExpressionSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<SaveExpressionSetV1Result>> retType = new TypeReference<List<SaveExpressionSetV1Result>>() {};
        List<SaveExpressionSetV1Result> res = caller.jsonrpcCall("SetAPI.save_expression_set_v1", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_reads_alignment_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetReadsAlignmentSetV1Params GetReadsAlignmentSetV1Params}
     * @return   instance of type {@link us.kbase.setapi.GetReadsAlignmentSetV1Result GetReadsAlignmentSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetReadsAlignmentSetV1Result getReadsAlignmentSetV1(GetReadsAlignmentSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetReadsAlignmentSetV1Result>> retType = new TypeReference<List<GetReadsAlignmentSetV1Result>>() {};
        List<GetReadsAlignmentSetV1Result> res = caller.jsonrpcCall("SetAPI.get_reads_alignment_set_v1", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: save_reads_alignment_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.SaveReadsAlignmentSetV1Params SaveReadsAlignmentSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.SaveReadsAlignmentSetV1Result SaveReadsAlignmentSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SaveReadsAlignmentSetV1Result saveReadsAlignmentSetV1(SaveReadsAlignmentSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<SaveReadsAlignmentSetV1Result>> retType = new TypeReference<List<SaveReadsAlignmentSetV1Result>>() {};
        List<SaveReadsAlignmentSetV1Result> res = caller.jsonrpcCall("SetAPI.save_reads_alignment_set_v1", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_reads_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetReadsSetV1Params GetReadsSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.GetReadsSetV1Result GetReadsSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetReadsSetV1Result getReadsSetV1(GetReadsSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetReadsSetV1Result>> retType = new TypeReference<List<GetReadsSetV1Result>>() {};
        List<GetReadsSetV1Result> res = caller.jsonrpcCall("SetAPI.get_reads_set_v1", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: save_reads_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.SaveReadsSetV1Params SaveReadsSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.SaveReadsSetV1Result SaveReadsSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SaveReadsSetV1Result saveReadsSetV1(SaveReadsSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<SaveReadsSetV1Result>> retType = new TypeReference<List<SaveReadsSetV1Result>>() {};
        List<SaveReadsSetV1Result> res = caller.jsonrpcCall("SetAPI.save_reads_set_v1", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_assembly_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetAssemblySetV1Params GetAssemblySetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.GetAssemblySetV1Result GetAssemblySetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetAssemblySetV1Result getAssemblySetV1(GetAssemblySetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetAssemblySetV1Result>> retType = new TypeReference<List<GetAssemblySetV1Result>>() {};
        List<GetAssemblySetV1Result> res = caller.jsonrpcCall("SetAPI.get_assembly_set_v1", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: save_assembly_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.SaveAssemblySetV1Params SaveAssemblySetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.SaveAssemblySetV1Result SaveAssemblySetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SaveAssemblySetV1Result saveAssemblySetV1(SaveAssemblySetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<SaveAssemblySetV1Result>> retType = new TypeReference<List<SaveAssemblySetV1Result>>() {};
        List<SaveAssemblySetV1Result> res = caller.jsonrpcCall("SetAPI.save_assembly_set_v1", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_genome_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetGenomeSetV1Params GetGenomeSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.GetGenomeSetV1Result GetGenomeSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetGenomeSetV1Result getGenomeSetV1(GetGenomeSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetGenomeSetV1Result>> retType = new TypeReference<List<GetGenomeSetV1Result>>() {};
        List<GetGenomeSetV1Result> res = caller.jsonrpcCall("SetAPI.get_genome_set_v1", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: save_genome_set_v1</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.SaveGenomeSetV1Params SaveGenomeSetV1Params}
     * @return   parameter "result" of type {@link us.kbase.setapi.SaveGenomeSetV1Result SaveGenomeSetV1Result}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public SaveGenomeSetV1Result saveGenomeSetV1(SaveGenomeSetV1Params params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<SaveGenomeSetV1Result>> retType = new TypeReference<List<SaveGenomeSetV1Result>>() {};
        List<SaveGenomeSetV1Result> res = caller.jsonrpcCall("SetAPI.save_genome_set_v1", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: create_sample_set</p>
     * <pre>
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.CreateRNASeqSampleSetParams CreateRNASeqSampleSetParams}
     * @return   instance of type {@link us.kbase.setapi.CreateRNASeqSampleSetResult CreateRNASeqSampleSetResult}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public CreateRNASeqSampleSetResult createSampleSet(CreateRNASeqSampleSetParams params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<CreateRNASeqSampleSetResult>> retType = new TypeReference<List<CreateRNASeqSampleSetResult>>() {};
        List<CreateRNASeqSampleSetResult> res = caller.jsonrpcCall("SetAPI.create_sample_set", args, retType, true, true, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: list_sets</p>
     * <pre>
     * Use to get the top-level sets in a WS. Optionally can include
     * one level down members of those sets.
     * NOTE: DOES NOT PRESERVE ORDERING OF ITEM LIST IN DATA
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.ListSetParams ListSetParams}
     * @return   parameter "result" of type {@link us.kbase.setapi.ListSetResult ListSetResult}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public ListSetResult listSets(ListSetParams params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<ListSetResult>> retType = new TypeReference<List<ListSetResult>>() {};
        List<ListSetResult> res = caller.jsonrpcCall("SetAPI.list_sets", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    /**
     * <p>Original spec-file function name: get_set_items</p>
     * <pre>
     * Use to drill down into one or more sets, the position in the
     * return 'sets' list will match the position in the input ref list.
     * NOTE: DOES NOT PRESERVE ORDERING OF ITEM LIST IN DATA
     * </pre>
     * @param   params   instance of type {@link us.kbase.setapi.GetSetItemsParams GetSetItemsParams}
     * @return   parameter "result" of type {@link us.kbase.setapi.GetSetItemsResult GetSetItemsResult}
     * @throws IOException if an IO exception occurs
     * @throws JsonClientException if a JSON RPC exception occurs
     */
    public GetSetItemsResult getSetItems(GetSetItemsParams params, RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        args.add(params);
        TypeReference<List<GetSetItemsResult>> retType = new TypeReference<List<GetSetItemsResult>>() {};
        List<GetSetItemsResult> res = caller.jsonrpcCall("SetAPI.get_set_items", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }

    public Map<String, Object> status(RpcContext... jsonRpcContext) throws IOException, JsonClientException {
        List<Object> args = new ArrayList<Object>();
        TypeReference<List<Map<String, Object>>> retType = new TypeReference<List<Map<String, Object>>>() {};
        List<Map<String, Object>> res = caller.jsonrpcCall("SetAPI.status", args, retType, true, false, jsonRpcContext, this.serviceVersion);
        return res.get(0);
    }
}
