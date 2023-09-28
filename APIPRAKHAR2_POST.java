package com.example;

import okhttp3.*;
import java.io.IOException;

public class APIPRAKHAR2_POST {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "{\r\n  \"Size\": 10,\r\n  \"Mean\": 53.27,\r\n  \"Median\": 50.5,\r\n  \"Mode\": 55,\r\n  \"Min\": 45,\r\n  \"Max\": 60\r\n}\r\n\r\n\r\n");
        Request request = new Request.Builder()
                .url("https://bfhldevapigw.healthrx.co.in/campus-hiring/submit?id=1234567890")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // Request was successful; you can process the response if needed.
                System.out.println(response.body().string());
            } else {
                // Handle unsuccessful response (e.g., check response code).
                System.err.println("Request failed with code: " + response.code());
            }
        } catch (IOException e) {
            // Handle any exceptions that may occur during the request.
            e.printStackTrace();
        }
    }
}
