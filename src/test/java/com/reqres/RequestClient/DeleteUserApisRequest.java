package com.reqres.RequestClient;

import com.reqres.Service.ClientRequest;
import lombok.Data;

import java.io.IOException;
import java.net.http.HttpResponse;

@Data
public class DeleteUserApisRequest {
    String id;

    public HttpResponse<String> deleteUser() throws IOException, InterruptedException {
        return ClientRequest.sendDeleteUserRequest(id);
    }
}
