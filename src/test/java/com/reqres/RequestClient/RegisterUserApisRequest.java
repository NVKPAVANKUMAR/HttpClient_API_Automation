package com.reqres.RequestClient;

import com.reqres.Service.ClientRequest;
import lombok.Data;
import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpResponse;

@Data
public class RegisterUserApisRequest {
    JSONObject requestBody;

    public HttpResponse<String> registerUser() throws IOException, InterruptedException {
        return ClientRequest.sendRegisterUserRequest(requestBody);
    }
}
