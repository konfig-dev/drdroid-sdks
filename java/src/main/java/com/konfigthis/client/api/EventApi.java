/*
 * Sample
 * Join event streams in real-time to setup complex alerts
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by Konfig (https://konfigthis.com).
 * Do not edit the class manually.
 */


package com.konfigthis.client.api;

import com.konfigthis.client.ApiCallback;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.Pair;
import com.konfigthis.client.ProgressRequestBody;
import com.konfigthis.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.konfigthis.client.model.EventIngestRequest;
import com.konfigthis.client.model.EventIngestRequestData;
import com.konfigthis.client.model.EventIngestResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class EventApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public EventApi() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public EventApi(ApiClient apiClient) throws IllegalArgumentException {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call ingestCall(String X_REQUEST_ORG, EventIngestRequest eventIngestRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = eventIngestRequest;

        // create path and map variables
        String localVarPath = "/e/ingest/events/v2";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (X_REQUEST_ORG != null) {
            localVarHeaderParams.put("X-REQUEST-ORG", localVarApiClient.parameterToString(X_REQUEST_ORG));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call ingestValidateBeforeCall(String X_REQUEST_ORG, EventIngestRequest eventIngestRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'X_REQUEST_ORG' is set
        if (X_REQUEST_ORG == null) {
            throw new ApiException("Missing the required parameter 'X_REQUEST_ORG' when calling ingest(Async)");
        }

        return ingestCall(X_REQUEST_ORG, eventIngestRequest, _callback);

    }


    private ApiResponse<EventIngestResponse> ingestWithHttpInfo(String X_REQUEST_ORG, EventIngestRequest eventIngestRequest) throws ApiException {
        okhttp3.Call localVarCall = ingestValidateBeforeCall(X_REQUEST_ORG, eventIngestRequest, null);
        Type localVarReturnType = new TypeToken<EventIngestResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call ingestAsync(String X_REQUEST_ORG, EventIngestRequest eventIngestRequest, final ApiCallback<EventIngestResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = ingestValidateBeforeCall(X_REQUEST_ORG, eventIngestRequest, _callback);
        Type localVarReturnType = new TypeToken<EventIngestResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class IngestRequestBuilder {
        private final EventIngestRequestData data;
        private final String X_REQUEST_ORG;

        private IngestRequestBuilder(EventIngestRequestData data, String X_REQUEST_ORG) {
            this.data = data;
            this.X_REQUEST_ORG = X_REQUEST_ORG;
        }

        /**
         * Build call for ingest
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  * Date -  <br>  * Server -  <br>  * Vary -  <br>  * Allow -  <br>  * X-Frame-Options -  <br>  * Content-Length -  <br>  * X-Content-Type-Options -  <br>  * Referrer-Policy -  <br>  * Cross-Origin-Opener-Policy -  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EventIngestRequest eventIngestRequest = buildBodyParams();
            return ingestCall(X_REQUEST_ORG, eventIngestRequest, _callback);
        }

        private EventIngestRequest buildBodyParams() {
            EventIngestRequest eventIngestRequest = new EventIngestRequest();
            eventIngestRequest.data(this.data);
            return eventIngestRequest;
        }

        /**
         * Execute ingest request
         * @return EventIngestResponse
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  * Date -  <br>  * Server -  <br>  * Vary -  <br>  * Allow -  <br>  * X-Frame-Options -  <br>  * Content-Length -  <br>  * X-Content-Type-Options -  <br>  * Referrer-Policy -  <br>  * Cross-Origin-Opener-Policy -  <br>  </td></tr>
         </table>
         */
        public EventIngestResponse execute() throws ApiException {
            EventIngestRequest eventIngestRequest = buildBodyParams();
            ApiResponse<EventIngestResponse> localVarResp = ingestWithHttpInfo(X_REQUEST_ORG, eventIngestRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute ingest request with HTTP info returned
         * @return ApiResponse&lt;EventIngestResponse&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  * Date -  <br>  * Server -  <br>  * Vary -  <br>  * Allow -  <br>  * X-Frame-Options -  <br>  * Content-Length -  <br>  * X-Content-Type-Options -  <br>  * Referrer-Policy -  <br>  * Cross-Origin-Opener-Policy -  <br>  </td></tr>
         </table>
         */
        public ApiResponse<EventIngestResponse> executeWithHttpInfo() throws ApiException {
            EventIngestRequest eventIngestRequest = buildBodyParams();
            return ingestWithHttpInfo(X_REQUEST_ORG, eventIngestRequest);
        }

        /**
         * Execute ingest request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  * Date -  <br>  * Server -  <br>  * Vary -  <br>  * Allow -  <br>  * X-Frame-Options -  <br>  * Content-Length -  <br>  * X-Content-Type-Options -  <br>  * Referrer-Policy -  <br>  * Cross-Origin-Opener-Policy -  <br>  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EventIngestResponse> _callback) throws ApiException {
            EventIngestRequest eventIngestRequest = buildBodyParams();
            return ingestAsync(X_REQUEST_ORG, eventIngestRequest, _callback);
        }
    }

    /**
     * Ingestion V2
     * 
     * @param X_REQUEST_ORG  (required)
     * @return IngestRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  * Date -  <br>  * Server -  <br>  * Vary -  <br>  * Allow -  <br>  * X-Frame-Options -  <br>  * Content-Length -  <br>  * X-Content-Type-Options -  <br>  * Referrer-Policy -  <br>  * Cross-Origin-Opener-Policy -  <br>  </td></tr>
     </table>
     */
    public IngestRequestBuilder ingest(EventIngestRequestData data, String X_REQUEST_ORG) throws IllegalArgumentException {
        if (data == null) throw new IllegalArgumentException("\"data\" is required but got null");
        if (X_REQUEST_ORG == null) throw new IllegalArgumentException("\"X_REQUEST_ORG\" is required but got null");
            

        return new IngestRequestBuilder(data, X_REQUEST_ORG);
    }
}
