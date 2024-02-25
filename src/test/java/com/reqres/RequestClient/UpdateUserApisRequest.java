package com.reqres.RequestClient;

import com.reqres.Service.ClientRequest;
import lombok.Data;
import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpResponse;

@Data
public class UpdateUserApisRequest {
    String id;
    JSONObject requestBody;

    public HttpResponse<String> updateUser() throws IOException, InterruptedException {
        return ClientRequest.sendUpdateUserRequest(id, requestBody);
    }
}
