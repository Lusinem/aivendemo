* This is a very basic implementation dedicated some 2-3 hours.
* I have no experience with reactive programming, and especially no react.js experience.
* I understand the handling of the implementation would have been completely different, in case applied react.
* Application considers only happy path. 
* Missing examples:
    - Behaviour onError
    - Proper logging
* I have implemented only region selection via cloud provider part, for calculating geolocation, unfortunately I don't have time.
  - In the task is not clear how to retrieve user geolocation.
  - Anyhow I would use google services to calculate it. 
   https://cloud.google.com/blog/products/maps-platform/how-calculate-distances-map-maps-javascript-api

* In frontend also some styles are missing, like current selected region etc.


* Run:
You need java 11+ .
To start the application just run ./mvnw spring-boot:run  -> localhost:8080
* (There is a video attached demoing http://localhost:8080/clouds behaviour)
