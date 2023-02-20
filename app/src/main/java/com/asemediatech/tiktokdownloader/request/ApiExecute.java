package com.asemediatech.tiktokdownloader.request;

import com.asemediatech.tiktokdownloader.model.VideoModel;
import com.asemediatech.tiktokdownloader.retrofit.ApiService;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Callback;

public class ApiExecute {
    private Map<String, String> params;
    private Map<String, String> headers;

    public void getVideo(Callback<VideoModel> callback){
        ApiService.endpoint().getVideo(this.headers, this.params).enqueue(callback);
    }

    public void getVideoID(String url, Callback<ResponseBody> callback){
        ApiService.optional().getVideoId(url).enqueue(callback);
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
