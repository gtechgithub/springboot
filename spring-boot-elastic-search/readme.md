Elastic search
--------------

Elastic search is a higly scable full text search and analytics engine.
it allows to store, search, analyse big volume of data quickly and in near real time.

usecases where it is used:

a) you run an online web store where you allow customer to search for products that you sell
in this case you can use elastic search to store your entire product catalog 
and inventory and provide search capability for them.

b) you can collect log or transaction data you want to analyse and mine this data to look
for trends, statistics, summarization or anamolies.
once data is fed into elastic search, you can run searches and aggregation to mine any information 
that is of interest of you.

Elastic search does inverted index eg: book has index page, page is choosen based on the word in the index


Elasticsearch – Key Concepts
-----------------------------
a) node: it refers to the single running instance of elastic search, single physical server or virtual server
runs multiple nodes.

b) cluster: it is collection of one or more nodes, cluster provides collective indexing and search capabilities
across all the nodes for entire data.

c) index: it is collection of differnt type of documents 

d) type/mapping: it is collection of documents sharing a set of common fields present in the same index 

e) document: it is collections of fields represented in json format.

                     ---------------------
------------            page
word         ------>       
------------
                     -----------------------


elastic search and RDBMS 
----------------------------
index              database
mapping            table
field              field
json object        Tuple / ROW



Data Representation:
                        --------------------             --------------------
---------- 
 index     ---->         multiple document        ---->   field
----------              -------------------              --------------------
                             |
                             | 
          
                        ------------------              ------------------
                         mapping type        ----->      mapping definition

                        ------------------               ----------------------



create an index
--------------
PUT http://localhost:9200/schools

response body:
{
    "acknowledged": true,
    "shards_acknowledged": true,
    "index": "schools"
}


check hitting 
http://localhost:9200/schools

o/p:
{"schools":{"aliases":{},"mappings":{},
           "settings":{"index":{"creation_date":"1523121421116","number_of_shards":"5","number_of_replicas":"1","uuid":"y8qWbAHHS8G15gDez4s6Dw","version":{"created":"6020399"},"provided_name":"schools"}}}}

Create Mapping and Add data
===========================

elastic search will auto create mapping according to the data provided in the request body, 
we will use bulk functionality to add more than one JSON object in the index

http://localhost:9200/schools/_bulk

request body

{"index": {"_index":"schools", "_type":"school", "_id":"1"}}
{"name":"Central School", "description":"CBSE Affiliation", "street":"Nagan", "city":"paprola\n"}
{"index": {"_index":"schools", "_type":"school", "_id":"2"}
{"name":"state School", "description":"ICSE Affiliation", "street":"ragan", "city":"chennai\n"}

response body

{"took":212,"errors":false,"items":[{"index":{"_index":"schools","_type":"school","_id":"1","_version":1,"result":"created","_shards":{"total":2,"successful":1,"failed":0},"_seq_no":0,"_primary_term":1,"status":201}},{"index":{"_index":"schools","_type":"school","_id":"2","_version":1,"result":"created","_shards":{"total":2,"successful":1,"failed":0},"_seq_no":0,"_primary_term":1,"status":201}}]}





create another index
---------------------

PUT http://localhost:9200/schools_gov


{
    "acknowledged": true,
    "shards_acknowledged": true,
    "index": "schools_gov"
}


Create Mapping and Add Data

POST http://localhost:9200/schools_gov/_bulk


{"index":{"_index":"schools_gov", "_type":"school", "_id":"1"}}
{"name":"Model School", "description":"CBSE Affiliation", "street":"silk city", "city":"Hyderabad\n"}
{"index":{"_index":"schools_gov", "_type":"school", "_id":"2"}}
{"name":"Government School", "description":"State Board Affiliation", "street":"Hinjewadi", "city":"Pune\n"}

search
-------

POST http://localhost:9200/schools,schools_gov/_search

POST http://localhost:9200/_all/_search

POST http://localhost:9200/schools*/_search

http://localhost:9200/school*,-schools_gov/_search
(search not from schools_gov)

POST http://localhost:9200/school*,-schools_gov,dummy/_search?ignore_unavailable=true
(if index name dummy is not found response body will contain error instead we can ignore
the error by passing ignore_unavailable to true)

POST http://localhost:9200/schools/_search?pretty = true
response will be well formatted json

POST http://localhost:9200/schools/_search?pretty=true
--> retrieves all response
{"query": {"match_all":{}}}






request body:
{"query": {"query_string":{"query": "CBSE"}}}

response body:

{"took":386,"timed_out":false,"_shards":{"total":10,"successful":10,"skipped":0,"failed":0},"hits":{"total":2,"max_score":0.2876821,"hits":[{"_index":"schools","_type":"school","_id":"1","_score":0.2876821,"_source":{"name":"Central School","description":"CBSE Affiliation","street":"Nagan","city":"paprola\n"}},{"_index":"schools_gov","_type":"school","_id":"1","_score":0.2876821,"_source":{"name":"Model School","description":"CBSE Affiliation","street":"silk city","city":"Hyderabad\n"}}]}}




document APIS
----------------

index API:

 which helps to add or update json document in an index 
below request will add the json object to the index schools and under school mapping

http://localhost:9200/schools/school/3

request body:

{
  "name":"city school", "description":"state board", "street":"kolathur",  "city":"chennai"
}

response body:
{"_index":"schools","_type":"school","_id":"3","_version":1,"result":"created","_shards":{"total":2,"successful":1,"failed":0},"_seq_no":0,"_primary_term":2}
	

version:
elastic search also provides elastic search capability, we can use a version query parameter to specify 
the version of the particular object.

PUT http://localhost:9200/schools/school/3?version=3

requst body:

{
  "name":"city school", "description":"state board", "street":"kolathur",  "city":"chennai"
}

response body
{"_index":"schools","_type":"school","_id":"3","_version":5,"result":"updated","_shards":{"total":2,"successful":1,"failed":0},"_seq_no":4,"_primary_term":2}


operation_type
---------------
this helps us to enfore the operation for eg: we can enfore create document instead of overwrite.

http://localhost:9200/schools/school/3?op_type=create

request body:
{
  "name":"city school", "description":"state board", "street":"kolathur",  "city":"chennai"
}

response body:
{"error":{"root_cause":[{"type":"version_conflict_engine_exception","reason":"[school][3]: version conflict, document already exists (current version [5])","index_uuid":"y8qWbAHHS8G15gDez4s6Dw","shard":"4","index":"schools"}],"type":"version_conflict_engine_exception","reason":"[school][3]: version conflict, document already exists (current version [5])","index_uuid":"y8qWbAHHS8G15gDez4s6Dw","shard":"4","index":"schools"},"status":409}



Get API
----------

GET http://localhost:9200/schools/school/1


GET http://localhost:9200/schools/school/1?fields = name,description

GET http://localhost:9200/schools/school/1/_source

response body:
{
    "name": "Central School",
    "description": "CBSE Affiliation",
    "street": "Nagan",
    "city": "paprola\n"
}


update api
---------
http://localhost:9200/schools/school/1/_update

response_body:

{
"_index": "schools",
"_type": "school",
"_id": "1",
"_version": 2,
"result": "updated",
"_shards": {
"total": 2,
"successful": 1,
"failed": 0
},
"_seq_no": 1,
"_primary_term": 2
}


delete api
==========
DELETE http://localhost:9200/schools/school/4


update api
------------
POST http://localhost:9200/schools_gov/school/1/_update


{
   "script":{
      "inline": "ctx._source.fees+ = inc", "params":{
         "inc": 500
      }
   }
}

multi index
============
elastic search allows us to search for the documents present in all indexes 

eg: we need to search for documents with a name that contain central

http://localhost:9200/schools,schools_gov/_search?q=name:central

response body:
{"took":4,"timed_out":false,"_shards":{"total":10,"successful":10,"skipped":0,"failed":0},"hits":{"total":1,"max_score":0.2876821,"hits":
[{"_index":"schools","_type":"school","_id":"1","_score":0.2876821,
"_source":{"name":"Central School","description":"CBSE Affiliation","street":"Nagan","city":"paprola\n"}}]}}


multi index request search

http://localhost:9200/schools/_search

reqest body:
{
   "query":{
      "query_string":{
         "query":"Affiliation"
      }
   }
}

response body:

{"took":3,"timed_out":false,"_shards":{"total":5,"successful":5,"skipped":0,"failed":0},"hits":{"total":2,"max_score":0.2876821,
"hits":
[{"_index":"schools","_type":"school","_id":"2","_score":0.2876821,
"_source":{"name":"state School","description":"ICSE Affiliation","street":"ragan","city":"chennai\n"}},
{"_index":"schools","_type":"school","_id":"1","_score":0.2876821,
"_source":{"name":"Central School","description":"CBSE Affiliation","street":"Nagan","city":"paprola\n"}}]}}


Aggregation
==========

this gives count of distinct values of particular field 

for eg:
http://localhost:9200/schools*/_search



request body:
{
   "aggs":{
      "distinct_name_count":{"cardinality":{"field":"name"}}
   }
}

response body:
………………………………………………
{
   "name":"Government School", "description":"State Board Afiliation",
   "street":"Hinjewadi", "city":"Pune", "state":"MH", "zip":"411057",
   "location":[18.599752, 73.6821995], "fees":500, "tags":["Great Sports"], 
   "rating":"4"
},

{
   "_index":"schools_gov", "_type": "school", "_id":"1", "_score":1.0,
   "_source":{
      "name":"Model School", "description":"CBSE Affiliation", "street":"silk city",
      "city":"Hyderabad", "state":"AP", "zip":"500030", 
      "location":[17.3903703, 78.4752129], "fees":700, 
      "tags":["Senior Secondary", "beautiful campus"], "rating":"3"
   }
}, "aggregations":{"disticnt_name_count":{"value":3}}
………………………………………………




elastic search DQL
----------------------
searching is carried out by query based on json objects


match_all query":
this will return all documents 

POST http://localhost:9200/schools*/_search

{
 "query":{
  "match_all":{}
  }
}


full text queries: 
this matches a text with values of one or more fields


{
 "query":{
 "match":{	
  "city":"chennai"
 }
 }
}

multi_match query:
this query matches the text with one or more fields

{
 "query":{
  "multi_match":{
    "query" : "Affiliation",
    "fields": [ "city","description" ]
   }
 }
}





