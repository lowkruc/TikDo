package com.asemediatech.tiktokdownloader.retrofit;

import com.asemediatech.tiktokdownloader.model.VideoModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface ApiEndpoint {
    @GET("/aweme/v1/aweme/detail/")
    Call<VideoModel> getVideo(
            @HeaderMap Map<String, String> headers,
            @QueryMap Map<String, String> options
    );
}
