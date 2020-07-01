Feature: Validating place APIs

@AddPlace
Scenario Outline: Verify if place being successfully added using AddPlaceAPI

	Given Add Place Payload with "<name>"  "<language>"  "<address>"
	When User calls "AddPlaceAPI" with "POST" http request
	Then API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And Verify place_Id creatd maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name 		| language		| address 			|
	|BHose		| English		| World cross Center|
#	|CHose		| FRENCH		| Asian cross Center|

@DeletePlace
Scenario: Verify if Delete Place functionality is working

	Given DeletePlace Payload
	When User calls "deletePlaceAPI" with "POST" http request
	Then API call got success with status code 200
	And "status" in response body is "OK"
	