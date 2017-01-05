# Counter-API =  API Based on Spring-Boot/Integration + Elastic Search 


## Summary

This is a learning project whose functionality, for the moment, is to:
- Gather historical stock quotations from Yahoo Finance 
- Gather "live" stock quotations from Google Finance
- Index everything in a Elasticsearch node so queries, graphs and alarms can be generated.
- Provide an AngularJS web interface wrapping the Kibana dashboards.
- Provide portfolio management functionalities using the Stock prices stored in ES.


On technical side:
- The latest Spring Boot version is to be used
-- This image can be associated with another images running more ElasticSearch nodes and the Kibana server
-  Uses Basic Authentication for now will introduce OAuth2 as authentication system later (Probably stormpath or okta)

This is how the deployment looks like:

## Running Application
mvnw[.bat] spring-boot:run

Configured End Points
 - http://localhost/counter-api/v1/search = Post Json - Returns Json with word count.
 - http://localhost/counter-api/v1/top/{id} = Returns top {id} , case sensitive, words found in a set of files.

Example:
curl -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" http://host/counter-api/v1/search - d’{“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ -H "Content-Type: application/json" –X POST


## Pending improvements
- Improve error reporting
- Provide a GUI with embedded Kibana visualizations
- Admin Endpoints