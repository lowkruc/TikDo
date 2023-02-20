package com.asemediatech.tiktokdownloader.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;

import com.asemediatech.tiktokdownloader.model.DeviceModel;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class ApiUtils {
    private Pattern regex = Pattern.compile(".*/video(/|$).*");
    DeviceModel deviceModel = new DeviceModel();
    String aweme_id = "";
    public Map<String, String> paramsWithDevice(Context context) {
        String newV = String.valueOf(RandomV(380, 490));
        String newVerisonCode = toVersionCode(newV);
        String newOpenuud = Settings.Secure.getString(context.getContentResolver(), "android_id");
        deviceModel.setAb_version(newVerisonCode);
        deviceModel.setVersion_code(newV);
        deviceModel.setManifest_version_code(newV);
        deviceModel.setUpdate_version_code(newV+"0");
        deviceModel.setIid(SystemUtils.getRanInt(19));
        deviceModel.setDevice_id(SystemUtils.getRanInt(19));
        deviceModel.setOpenudid(newOpenuud);
        deviceModel.setDevice_brand(Build.BRAND);
        deviceModel.setDevice_type(Build.DEVICE);
        deviceModel.toMap().remove("aweme_id");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        if(height != -1 || height != 0 && width != -1 || width != 0){
            String h = String.valueOf(height);
            String w = String.valueOf(width);
            deviceModel.setResolution(w+"*"+h);
        }
        return deviceModel.toMap();
    }

    public Map<String, String> paramsWithDefault(){
        deviceModel.toMap().remove("aweme_id");
        return deviceModel.toMap();
    }

    public Map<String, String> createHeaders(){
        HashMap<String, String> header = new HashMap<>();
        header.put("Host", "api-h2.tiktokv.com");
        header.put("sdk-version", "1");
        header.put("x-ss-tc", "0");
        header.put("x-ss-req-ticket", String.valueOf(System.currentTimeMillis()));
        header.put("user-agent", "okhttp");
        return header;
    }

    private String generateParams(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for(HashMap.Entry<String, String> e : params.entrySet()){
            if(sb.length() > 0){
                sb.append('&');
            }
            sb.append(URLEncoder.encode(e.getKey(), "UTF-8")).append('=').append(URLEncoder.encode(e.getValue(), "UTF-8"));
        }
        return sb.toString();
    }


    private static int RandomV(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }

    private static String toVersionCode(String code){
        int i;
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < code.length(); i++){
            if(i == code.length() - 1){
                sb.append(code.charAt(i));
            }else {
                sb.append(code.charAt(i)+".");
            }
        };
        return sb.toString();
    }

    public String getId(String url) throws URISyntaxException {
        if(regex.matcher(url).find()){
//            String id = url.split("video/")[1];
//            return id;
            URI uri = new URI(url);
            String[] segments = uri.getPath().split("/");
            String idStr = segments[segments.length-1];
            return idStr;

        }
        return null;
    }

    public String getIdFromBody(String body){
        int getId = body.indexOf("window._I18N_LANG_MAP_ =");
//        if(getId.length > 1){
//            Log.d("getIdFromBody", getId[1]);
//        }else{
//            Log.d("Panjang GetID", String.valueOf(getId.length));
//            Log.d("Datanya", getId.toString());
//            Log.d("getIdFromBody", getId[0]);
//        }
        Log.d("Datat ", String.valueOf(getId));
//       if(getId != null && getId.length() > 0){
//           String id = getId.substring(0, 19);
//           return id;
//       }
       return "";
    }

}
