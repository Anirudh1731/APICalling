package com.example;

import okhttp3.*;
import java.io.IOException;

public class APIPRAKHAR_2_GET {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://bfhldevapigw.healthrx.co.in/campus-hiring/submit?id=9879360680")
                .method("GET", null)
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
