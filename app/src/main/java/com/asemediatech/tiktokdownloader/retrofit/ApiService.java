package com.asemediatech.tiktokdownloader.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static String PRIMARY = "https://api-h2.tiktokv.com";
    private static String SECONDARY = "https://api16-normal-c-alisg.tiktokv.com";
    private static Retrofit retrofit;
    public static ApiEndpoint endpoint(){
        retrofit = new Retrofit.Builder()
                .baseUrl( PRIMARY )
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiEndpoint.class);
    }

    public static ApiOptional optional(){
        retrofit = new Retrofit.Builder()
                .baseUrl( PRIMARY )
                .build();

        return retrofit.create(ApiOptional.class);
    }




}
