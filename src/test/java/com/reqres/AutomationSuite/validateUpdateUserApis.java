package com.reqres.AutomationSuite;

import com.reqres.RequestClient.UpdateUserApisRequest;
import com.reqres.Service.FakerData;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.http.HttpResponse;

import static com.reqres.Utils.ExtentTestManager.startTest;

public class validateUpdateUserApis {

    @Test(testName = "TC_08", description = "Validate UpdateUser With ValidData")
    public void validateUpdateUserWithValidData(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            UpdateUserApisRequest updateUserApisRequest = new UpdateUserApisRequest();
            updateUserApisRequest.setId("2");
            JSONObject jsonObject = new JSONObject();
            FakerData faker = new FakerData();
            String name = faker.getFullName();
            String job = faker.getJob();
            jsonObject.put("name", name);
            jsonObject.put("job", job);
            updateUserApisRequest.setRequestBody(jsonObject);
            HttpResponse<String> response = updateUserApisRequest.updateUser();
            int statusCode = response.statusCode();
            JSONObject jsonResponse = new JSONObject(response.body());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 200);
            softAssert.assertEquals(jsonResponse.get("name"), name);
            softAssert.assertEquals(jsonResponse.get("job"), job);
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
