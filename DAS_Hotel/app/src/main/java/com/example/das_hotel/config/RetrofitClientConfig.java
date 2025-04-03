package com.example.das_hotel.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientConfig {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://10.0.2.2:8080"; // Thay thế với URL của Spring Boot API

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // Chuyển đổi JSON sang đối tượng
                    .build();
        }
        return retrofit;
    }
}
