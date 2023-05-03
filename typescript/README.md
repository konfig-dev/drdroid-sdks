# drdroid-typescript-sdk@1.0.0

Join event streams in real-time to setup complex alerts
## Installing

### npm
```
npm install drdroid-typescript-sdk --save
```

### yarn
```
yarn add drdroid-typescript-sdk
```

**Important note: this library is can be used in both the client-side or server-side, but using it
in client-side browser code is not recommended as you would expose security credentials.**



## Getting Started

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

## Documentation for API Endpoints

All URIs are relative to *https://ingest.drdroid.io*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*EventApi* | [**ingest**](docs/EventApi.md#ingest) | **POST** /e/ingest/events/v2 | Ingestion V2

