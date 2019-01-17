# Energy Australia Coding Test
My solution uses the Maven build automation tool to support building, testing, checkstyle and coverage checks, etc. to 
produce a single jar which can be ran to query the Energy Australia api endpoint.

## Building the module
From the root of the repository run ```mvn clean install```. This will produce a jar in the carshowservice/target
directory which can be run using the command below.

## Running the jar
From the root of the repository run ```java -jar carshowsservice/target/carshows-service-1.0-SNAPSHOT.jar```. 
This will either produce the required output or display an exception if the endpoint returns an error or the json 
cannot be parsed.

## Testing the module
From the root of the repository run ```mvn test```. This will run the unit tests.

## Running checkstyle checks
From the root of the repository run ```mvn validate```. The module has the google checkstyle applied to it and will 
fail on build if the rules are not followed.

## Running code coverage checks
From the root of the repository run ```mvn verify```. This uses the jacoco plugin to enforce a minimum code 
coverage over the whole module.