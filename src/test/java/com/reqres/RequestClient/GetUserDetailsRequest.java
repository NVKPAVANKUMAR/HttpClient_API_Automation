package com.reqres.RequestClient;

import com.reqres.Service.ClientRequest;
import lombok.Data;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;

@Data
public class GetUserDetailsRequest {
    HashMap<String, Object> paramMap;
    String id;

    public HttpResponse<String> getUserApiResponse() throws IOException, InterruptedException {
        return ClientRequest.sendGetUserDetailsRequestURI(paramMap, id);
    }
}
