# Counter-API =  API Based on Spring-Boot/Integration + Elastic Search 


## Summary

This is a learning project whose functionality, for the moment, is to:
- Serch text in a file and return number of times it is present.
- Give top repeated words in a file


On technical side:
- The latest Spring Boot version is to be used
-- Using basic pojo repository. I couldn't integrate elasticsearch (spring-data version didn't support analyzer for embedded nodes)
-  Uses Basic Authentication for now will introduce OAuth2 as authentication system later (Probably stormpath or okta)

This is how the deployment looks like:

##Requirements
Set file path in application.properties = ${app.file.path}

## Running Application
mvnw[.bat] spring-boot:run

Configured End Points
 - http://localhost/counter-api/v1/search = Post Json - Returns Json with word count.
 - http://localhost/counter-api/v1/top/{id} = Returns top {id} , case sensitive, words found in a set of files.

Example:
curl -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" http://host/counter-api/v1/search - d’{“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ -H "Content-Type: application/json" –X POST


## Pending improvements
- Improve error reporting
- Integrate with ElasticSearch
- Provide a GUI with embedded Kibana visualizations
- Admin Endpoints