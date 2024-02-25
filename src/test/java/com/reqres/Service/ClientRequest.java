package com.reqres.Service;

import org.json.JSONObject;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;

import static com.reqres.Service.ServiceURI.HOST_URL;

public class ClientRequest {

    public static HttpResponse<String> sendGetUserDetailsRequestURI(HashMap<String, Object> paramMap, String id) throws IOException, InterruptedException {
        String url = "https://" + HOST_URL + "/api/users/{id}";
        if (id == null) {
            url = url.replace("/{id}", "");
        } else {
            url = url.replace("{id}", id);
        }
        return HttpClientRequest.makeGetRequest(url, paramMap);
    }

    public static HttpResponse<String> sendCreateUserRequest(JSONObject requestBody) throws IOException, InterruptedException {
        String url = "https://" + HOST_URL + "/api/users";
        return HttpClientRequest.makePostRequest(url, requestBody);
    }

    public static HttpResponse<String> sendRegisterUserRequest(JSONObject requestBody) throws IOException, InterruptedException {
        String url = "https://" + HOST_URL + "/api/register";
        return HttpClientRequest.makePostRequest(url, requestBody);
    }

    public static HttpResponse<String> sendUpdateUserRequest(String id, JSONObject requestBody) throws IOException, InterruptedException {
        String url = "https://" + HOST_URL + "/api/users/" + id;
        return HttpClientRequest.makePutRequest(url, requestBody);
    }

    public static HttpResponse<String> sendDeleteUserRequest(String id) throws IOException, InterruptedException {
        String url = "https://" + HOST_URL + "/api/users/" + id;
        return HttpClientRequest.makeDeleteRequest(url);
    }
}
