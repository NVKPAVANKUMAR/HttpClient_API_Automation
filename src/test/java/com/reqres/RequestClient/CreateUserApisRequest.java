package com.reqres.RequestClient;

import com.reqres.Service.ClientRequest;
import lombok.Data;
import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpResponse;

@Data
public class CreateUserApisRequest {
    JSONObject requestBody;

    public HttpResponse<String> createUser() throws IOException, InterruptedException {
        return ClientRequest.sendCreateUserRequest(requestBody);
    }
}
