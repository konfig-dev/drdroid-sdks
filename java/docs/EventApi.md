# EventApi

All URIs are relative to *https://ingest.drdroid.io*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**ingest**](EventApi.md#ingest) | **POST** /e/ingest/events/v2 | Ingestion V2 |


<a name="ingest"></a>
# **ingest**
> EventIngestResponse ingest(X_REQUEST_ORG).eventIngestRequest(eventIngestRequest).execute();

Ingestion V2

### Example
```java
import io.drdroid.client.ApiClient;
import io.drdroid.client.ApiException;
import io.drdroid.client.ApiResponse;
import io.drdroid.client.Configuration;
import io.drdroid.client.auth.*;
import io.drdroid.client.model.*;
import io.drdroid.client.api.EventApi;

public class Example {
  public static void main(String[] args) {

    ApiClient apiClient = Configuration.getDefaultApiClient();
    // Set custom base path if desired
    // apiClient.setBasePath("https://ingest.drdroid.io");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) apiClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    EventApi api = new EventApi(apiClient);
    EventIngestRequestData data = new EventIngestRequestData();
    String X_REQUEST_ORG = "{{org}}";
    try {
      EventIngestResponse result = api
              .ingest(data, X_REQUEST_ORG)
              .execute();
      System.out.println(result);
      System.out.println(result.toJson()); // Serialize response back to JSON 
    } catch (ApiException e) {
      System.err.println("Exception when calling EventApi#ingest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request 
    try {
      ApiResponse<EventIngestResponse> response = api
              .ingest(data, X_REQUEST_ORG)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EventApi#ingest");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **X_REQUEST_ORG** | **String**|  | |
| **eventIngestRequest** | [**EventIngestRequest**](EventIngestRequest.md)|  | [optional] |

### Return type

[**EventIngestResponse**](EventIngestResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  * Date -  <br>  * Server -  <br>  * Vary -  <br>  * Allow -  <br>  * X-Frame-Options -  <br>  * Content-Length -  <br>  * X-Content-Type-Options -  <br>  * Referrer-Policy -  <br>  * Cross-Origin-Opener-Policy -  <br>  |

