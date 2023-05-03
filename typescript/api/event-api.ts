/* tslint:disable */
/* eslint-disable */
/**
 * Sample
 * Join event streams in real-time to setup complex alerts
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This file is auto generated by Konfig (https://konfigthis.com).
 * https://konfigthis.com
 * Do not edit the class manually.
 */

import globalAxios, { AxiosPromise, AxiosInstance, AxiosRequestConfig } from 'axios';
import { Configuration } from '../configuration';
// Some imports not used depending on template conditions
// @ts-ignore
import { DUMMY_BASE_URL, assertParamExists, setApiKeyToObject, setBasicAuthToObject, setBearerAuthToObject, setSearchParams, serializeDataIfNeeded, toPathString, createRequestFunction } from '../common';
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, RequestArgs, BaseAPI, RequiredError } from '../base';
// @ts-ignore
import { EventIngestRequest } from '../models';
// @ts-ignore
import { EventIngestRequestData } from '../models';
// @ts-ignore
import { EventIngestResponse } from '../models';
import { paginate } from "../pagination/paginate";
import { requestBeforeHook } from '../requestBeforeHook';
import { EventApiCustom } from "./event-api-custom";
/**
 * EventApi - axios parameter creator
 * @export
 */
export const EventApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary Ingestion V2
         * @param {string} xREQUESTORG 
         * @param {EventIngestRequest} [eventIngestRequest] 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        ingest: async (xREQUESTORG: string, eventIngestRequest?: EventIngestRequest, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'xREQUESTORG' is not null or undefined
            assertParamExists('ingest', 'xREQUESTORG', xREQUESTORG)
            const localVarPath = `/e/ingest/events/v2`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions: AxiosRequestConfig = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = configuration ? { "User-Agent": configuration.userAgent } : {} as any;
            const localVarQueryParameter = {} as any;

            // authentication bearerAuth required
            // http bearer authentication required
            await setBearerAuthToObject(localVarHeaderParameter, configuration)
            if (xREQUESTORG != null) {
                localVarHeaderParameter['X-REQUEST-ORG'] = String(xREQUESTORG);
            }


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            requestBeforeHook({
                requestBody: eventIngestRequest,
                queryParameters: localVarQueryParameter,
                requestConfig: localVarRequestOptions,
                path: localVarPath,
                configuration
            });
            localVarRequestOptions.data = serializeDataIfNeeded(eventIngestRequest, localVarRequestOptions, configuration)

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * EventApi - functional programming interface
 * @export
 */
export const EventApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = EventApiAxiosParamCreator(configuration)
    return {
        /**
         * 
         * @summary Ingestion V2
         * @param {EventApiIngestRequest} requestParameters Request parameters.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async ingest(requestParameters: EventApiIngestRequest, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<EventIngestResponse>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.ingest(requestParameters.xREQUESTORG, requestParameters, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
    }
};

/**
 * EventApi - factory interface
 * @export
 */
export const EventApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = EventApiFp(configuration)
    return {
        /**
         * 
         * @summary Ingestion V2
         * @param {EventApiIngestRequest} requestParameters Request parameters.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        ingest(requestParameters: EventApiIngestRequest, options?: AxiosRequestConfig): AxiosPromise<EventIngestResponse> {
            return localVarFp.ingest(requestParameters, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * Request parameters for ingest operation in EventApi.
 * @export
 * @interface EventApiIngestRequest
 */
export type EventApiIngestRequest = {
    
    /**
    * 
    * @type {string}
    * @memberof EventApiIngest
    */
    readonly xREQUESTORG: string
    
} & EventIngestRequest

/**
 * EventApi - object-oriented interface
 * @export
 * @class EventApi
 * @extends {BaseAPI}
 */
export class EventApi extends EventApiCustom {
    /**
     * 
     * @summary Ingestion V2
     * @param {EventApiIngestRequest} requestParameters Request parameters.
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof EventApi
     */
    public ingest(requestParameters: EventApiIngestRequest, options?: AxiosRequestConfig) {
        return EventApiFp(this.configuration).ingest(requestParameters, options).then((request) => request(this.axios, this.basePath));
    }
}