# EventApi

All URIs are relative to *https://ingest.drdroid.io*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ingest**](EventApi.md#ingest) | **POST** /e/ingest/events/v2 | Ingestion V2


# **ingest**

#### **POST** /e/ingest/events/v2


### Example


```typescript
import { Drdroid } from "drdroid-typescript-sdk";

const drdroid = new Drdroid({
  // Defining the base path is optional and defaults to https://ingest.drdroid.io
  // basePath: "https://ingest.drdroid.io",
  accessToken: "ACCESS_TOKEN",
});

const ingestResponse = await drdroid.event.ingest({
  xREQUESTORG: "xREQUESTORG_example",
  data: {},
});

console.log(ingestResponse);
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **eventIngestRequest** | **EventIngestRequest**|  |
 **xREQUESTORG** | [**string**] |  | defaults to undefined


### Return type

**EventIngestResponse**

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  * Date -  <br>  * Server -  <br>  * Vary -  <br>  * Allow -  <br>  * X-Frame-Options -  <br>  * Content-Length -  <br>  * X-Content-Type-Options -  <br>  * Referrer-Policy -  <br>  * Cross-Origin-Opener-Policy -  <br>  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


