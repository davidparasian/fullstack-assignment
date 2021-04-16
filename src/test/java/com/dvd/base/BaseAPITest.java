package com.dvd.base;

//import com.dvd.utils.DataUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPITest {

//	protected RequestSpecification commonRequestSpec = new RequestSpecBuilder()
//			.setBaseUri(DataUtils.getDataFromExcel("DataAss", "BaseUrlAPI")).setContentType("application/json").build()
//			.log().all();
	protected RequestSpecification commonRequestSpec = new RequestSpecBuilder()
			.setBaseUri("https://api-staging-builder.engineer.ai").setContentType("application/json").build()
			.log().all();
	

}
