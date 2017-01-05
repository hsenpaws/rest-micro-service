
Counter-API Implemented using Spring-Boot, Spring-Data-ElasticSearch (InProgress) and Spring-Data-Pojo


 - http://localhost/counter-api/v1/search = Post Json - Returns Json with word count.
 - http://localhost/counter-api/v1/top/{id} = Returns top {id} , case sensitive, words found in a set of files.

Example:
curl http://host/counter-api/v1/search -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" - d’{“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ -H "Content-Type: application/json" –X POST

To Run
1. mvnw.bat spring-boot:run 

Maven downloads all dependencies inlcuidng elasticsearch (run inbuilt)
