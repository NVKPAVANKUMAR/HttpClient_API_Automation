package com.reqres.AutomationSuite;

import com.reqres.RequestClient.CreateUserApisRequest;
import com.reqres.Service.FakerData;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.http.HttpResponse;

import static com.reqres.Utils.ExtentTestManager.startTest;

public class validateCreateUserApis {

    @Test(testName = "TC_05", description = "Validate CreateUser With ValidData")
    public void validateCreateUserWithValidData(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            CreateUserApisRequest createUserApisRequest = new CreateUserApisRequest();
            JSONObject jsonObject = new JSONObject();
            FakerData faker = new FakerData();
            String name = faker.getFullName();
            String job = faker.getJob();
            jsonObject.put("name", name);
            jsonObject.put("job", job);
            createUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = createUserApisRequest.createUser();
            int statusCode = response.statusCode();
            JSONObject jsonResponse = new JSONObject(response.body());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 201);
            softAssert.assertEquals(jsonResponse.get("name"), name);
            softAssert.assertEquals(jsonResponse.get("job"), job);
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
