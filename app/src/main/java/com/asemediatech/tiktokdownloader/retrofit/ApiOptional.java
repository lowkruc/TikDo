package com.asemediatech.tiktokdownloader.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiOptional {
    @GET
    Call<ResponseBody> getVideoId(@Url String url);
}
