# Data Processing

This demo enables you to simulate events of a **data ingestion and processing pipeline** to get an overview of a Dr. Droid Demo.

### Generate Events

Get your key :a[https://app.drdroid.io/signup]{href=https://app.drdroid.io/signup target=\_blank}.

:::form

::input{name=API_KEY label="Dr. Droid API Key" description="Your unique key" type="password"}

```python
%env DRDROID_AUTH_TOKEN = API_KEY
%env DRDROID_HOSTNAME = https://ingest.drdroid.io
%env DRDROID_DEBUG = False


import random
import time
import string
import os

from pydoctordroid import DrDroid

dr = DrDroid()

def publish_event(e_state, e_payload):
	dr.publish(e_state, e_payload)
	print("{} Event published for {}".format(e_state,e_payload))

## Purpose of dry run is to populate events
## in the account so that you can create rules


def publish_all_events_once():

    publish_event("data_sent_from_source", {"file_id":1234, "file_type":"audio", "file_size_mb":250, "source_id":1234})
    publish_event("data_ingested_in_sink", {"file_id":1234, "file_size_mb":250, "source_id":1234, "sink_id":1234})
    publish_event("data_cleaned_up", {"file_id":1234, "cleanup_type":"transformation"})
    publish_event("internal_processing_started", {"file_id":1234, "job_id":1234})
    publish_event("internal_processing_ended", {"file_id":1234, "job_id":1234})
    publish_event("data_stored", {"file_id":1234, "db_id":1234, "client_id":1234, "output_file_size_mb":35})
    publish_event("data_sent_to_client", {"file_id":1234, "client_id":1234, "output_file_size_mb":35})
    return None


publish_all_events_once()

## Now run a real life simulation of events


def data_processing_flow_events():


    ## Defining all the event attributes

    file_id = ''.join(random.choice(string.digits) for _ in range(8))
    file_type = random.choice(["audio","video","text","csv"])
    file_size_mb = random.randint(1,500)
    source_id = ''.join(random.choice(string.digits) for _ in range(6))
    sink_id = ''.join(random.choice(string.digits) for _ in range(6))
    cleanup_type = random.choice(["Transformation", "Deduplication", "Outlier Detection", "Data Validation"])
    job_id = ''.join(random.choice(string.digits) for _ in range(10))
    db_id = ''.join(random.choice(string.digits) for _ in range(4))
    client_id = ''.join(random.choice(string.digits) for _ in range(6))
    output_file_size_mb = random.randint(1,500)


    ##Simulating all the events of the data ingestion and processing pipeline flow

    publish_event("data_sent_from_source", {"file_id":file_id, "file_type":file_type, "file_size_mb":file_size_mb, "source_id":source_id})
    if (random.random() < 0.15):
      return None
    publish_event("data_ingested_in_sink", {"file_id":file_id, "file_size_mb":file_size_mb, "source_id":source_id, "sink_id":sink_id})
    if (random.random() < 0.15):
      return None
    publish_event("data_cleaned_up", {"file_id":file_id, "cleanup_type":cleanup_type})
    if (random.random() < 0.15):
      return None
    publish_event("internal_processing_started", {"file_id":file_id, "job_id":job_id})
    if (random.random() < 0.1):
      return None
    publish_event("internal_processing_ended", {"file_id":file_id, "job_id":job_id})
    publish_event("data_stored", {"file_id":file_id, "db_id":db_id, "client_id":client_id, "output_file_size_mb":output_file_size_mb})
    if (random.random() < 0.15):
      return None
    publish_event("data_sent_to_client", {"file_id":file_id, "client_id":client_id, "output_file_size_mb":output_file_size_mb})



# Number of simulation runs
for i in range(150):
    data_processing_flow_events()


```

::button[Generate Events]

:::

### Explore the platform:

#### **Check the events on platform.**

Go to :a[https://app.drdroid.io/events]{href=https://app.drdroid.io/events target=\_blank} to see the events published.

#### **Create monitors on UI**

Sample monitors:
1 -- pg_request_sent --> tnx_successful

2 -- tnx_successful --> order_created

3 -- low_wallet_balance --> refund_initiated

Demo video here.

#### **Create Entity on UI**

Sample entity:

pg_request_sent, tnx_successful, order_created, low_wallet_balance, refund_initiated
