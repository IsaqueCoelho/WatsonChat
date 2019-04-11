package com.example.isaquecoelho.watsonchat.utils;

import com.example.isaquecoelho.watsonchat.model.Message;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RequestUtils {

    String BASE_URL = "https://gateway.watsonplatform.net/assistant/api/v1/";
    String VERSION = "?version=2019-02-28";
    String METHOD_MESSAGE = "/message";
    String WORKSPACE = "workspaces/8d567f97-bc61-4b68-8216-be7380aac615";

    String AUTHORIZATION = "autho";

    @Headers({
            "Content-Type: application/json",
            "Authorization: Basic " + AUTHORIZATION})
    @POST(WORKSPACE + METHOD_MESSAGE + VERSION)
    Call<Message> messageData(@Body Message messageInput);
}
