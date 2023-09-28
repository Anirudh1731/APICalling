package com.example;

import java.util.Arrays;
import java.util.Base64;
import okhttp3.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class APIPRAKHAR_1 {
    public static void main(String[] args) throws IOException {
        // Create an OkHttpClient instance.
        OkHttpClient client = new OkHttpClient();
        // Replace these values with your actual data.
        String name = "Your Name";
        // Replace "your.email@example.com" with your actual email address
        String email = "your.email@example.com";
        // Encode the email address in Base64
        String base64EncodedEmail = Base64.getEncoder().encodeToString(email.getBytes());
        System.out.println("email encoded " + base64EncodedEmail);
        String college = "Your College";
        String studentId = "Registration No.";
        String fileName = "C:\\Users\\shukl\\Java-VScode\\LinkedList\\src\\main.java";

        // Replace "your_code_file_path" with the actual path to your code file.
        File codeFile = new File("C:\\Users\\shukl\\Java-VScode\\LinkedList\\src\\main.java");
        // System.out.println(codeFile.getName());

        // Create a request body with the code file.
        RequestBody codeRequestBody = RequestBody.create(MediaType.parse("application/octet-stream"), codeFile);

        // Build the HTTP request.
        Request request = new Request.Builder()
                .url("https://prod-18.centralindia.logic.azure.com/workflows/d1dfef5cd2b54103b67a989eab024704/triggers/re%20quest/paths/invoke?api-version=2016-10-01&sp=%2Ftriggers%2Frequest%2Frun&sv=1.0&sig=ZRSj02or46cAlXseGsDU4VGUd6KqqXqe_%20U4R_W9Dxhw")
                .put(codeRequestBody)
                .addHeader("Name", name)
                .addHeader("Email", email)
                .addHeader("College", college)
                .addHeader("StudentId", studentId)
                .addHeader("FileName", fileName)
                .addHeader("Password", base64EncodedEmail)
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
