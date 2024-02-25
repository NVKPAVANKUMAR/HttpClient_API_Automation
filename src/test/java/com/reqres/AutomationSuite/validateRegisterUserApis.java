package com.reqres.AutomationSuite;

import com.reqres.RequestClient.RegisterUserApisRequest;
import com.reqres.Service.FakerData;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.http.HttpResponse;

import static com.reqres.Utils.ExtentTestManager.startTest;

public class validateRegisterUserApis {

    FakerData faker;

    @BeforeClass
    public void beforeClass() {
        faker = new FakerData();
    }

    @Test(testName = "TC_06", description = "Validate RegisterUser Apis With ValidData")
    public void validateRegisterUserApisWithValidData(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            RegisterUserApisRequest registerUserApisRequest = new RegisterUserApisRequest();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", "eve.holt@reqres.in");
            jsonObject.put("password", faker.getPassword());
            registerUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = registerUserApisRequest.registerUser();
            int statusCode = response.statusCode();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 200);
            softAssert.assertTrue(response.body().contains("token"));
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Test(testName = "TC_07", description = "Validate RegisterUser Apis Without Password")
    public void validateRegisterUserApisWithoutPassword(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            RegisterUserApisRequest registerUserApisRequest = new RegisterUserApisRequest();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", faker.getEmail());
            registerUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = registerUserApisRequest.registerUser();
            int statusCode = response.statusCode();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 400);
            softAssert.assertTrue(response.body().contains("Missing password"));
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
