package com.reqres.AutomationSuite;

import com.reqres.RequestClient.DeleteUserApisRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.http.HttpResponse;

import static com.reqres.Utils.ExtentTestManager.startTest;

public class validateDeleteApis {
    @Test(testName = "TC_09", description = "validate DeleteUser Api")
    public void validateDeleteUserApis(Method method) {
        try {
            startTest(method.getName(), method.getName().replace("_", " "));
            DeleteUserApisRequest deleteUserApisRequest = new DeleteUserApisRequest();
            deleteUserApisRequest.setId("2");
            HttpResponse<String> response = deleteUserApisRequest.deleteUser();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(response.statusCode(), 204);
            softAssert.assertAll();
        } catch (Exception e) {
            Assert.fail(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
