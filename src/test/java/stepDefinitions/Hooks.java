package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//Execute this code only when place_id is null
		//Write a code that will give you place id
		
		StepDefinition m = new StepDefinition();
		if(StepDefinition.place_Id==null)
		{
			m.add_Place_Payload_with("Praveen", "Telugu" , "Rekonda");
			m.user_calls_with_http_request("AddPlaceAPI", "POST");
			m.verify_place_Id_creatd_maps_to_using("Praveen", "getPlaceAPI");
		}
	}
}
