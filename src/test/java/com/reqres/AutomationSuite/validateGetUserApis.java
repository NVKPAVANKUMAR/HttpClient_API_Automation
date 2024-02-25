package com.reqres.AutomationSuite;

import com.reqres.RequestClient.GetUserDetailsRequest;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static com.reqres.Utils.ExtentTestManager.startTest;

public class validateGetUserApis {
    HashMap<String, Object> paramMap = new HashMap<>();

    @Test(testName = "TC_01", description = "Validate GetApis WithoutQueryParam")
    public void validateGetApisWithoutQueryParam(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            paramMap.clear();
            GetUserDetailsRequest getUserDetailsRequest = new GetUserDetailsRequest();
            HttpResponse<String> response = getUserDetailsRequest.getUserApiResponse();
            int statusCode = response.statusCode();
            JSONObject responseBody = new JSONObject(response.body());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 200);
            softAssert.assertEquals(responseBody.get("page"), 1, "default page is not set to 1");
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Test(testName = "TC_02", description = "Validate GetApis WithQueryParam")
    public void validateGetApisWithQueryParam(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            paramMap.clear();
            GetUserDetailsRequest getUserDetailsRequest = new GetUserDetailsRequest();
            paramMap.put("page", 2);
            getUserDetailsRequest.setParamMap(paramMap);
            HttpResponse<String> response = getUserDetailsRequest.getUserApiResponse();
            int statusCode = response.statusCode();
            JSONObject responseBody = new JSONObject(response.body());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 200);
            softAssert.assertEquals(responseBody.get("page"), 2, "Page Value Mismatch");
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Test(testName = "TC_03", description = "Validate GetApis For SingleExistingUser")
    public void validateGetApisForSingleExistingUser(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            paramMap.clear();
            GetUserDetailsRequest getUserDetailsRequest = new GetUserDetailsRequest();
            String id = "3";
            getUserDetailsRequest.setId(id);
            HttpResponse<String> response = getUserDetailsRequest.getUserApiResponse();
            int statusCode = response.statusCode();
            JSONObject responseBody = new JSONObject(response.body());
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 200);
            softAssert.assertEquals(responseBody.getJSONObject("data").get("id"), 3, "Id Value Mismatch");
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    @Test(testName = "TC_04", description = "Validate GetApis For Single NonExistingUser")
    public void validateGetApisForSingleNonExistingUser(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            paramMap.clear();
            GetUserDetailsRequest getUserDetailsRequest = new GetUserDetailsRequest();
            String id = "23";
            getUserDetailsRequest.setId(id);
            HttpResponse<String> response = getUserDetailsRequest.getUserApiResponse();
            int statusCode = response.statusCode();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(statusCode, 404);
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
