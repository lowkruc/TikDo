package com.asemediatech.tiktokdownloader.utils;

import android.os.Build;

import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceManager {
    private String[]  randomType = {};
    private String ac = "wifi";
    private String channel = "googleplay";
    private String aid = "1340";
    private String app_name = "musically_go";
    private String version_code = "160702";
    private String version_name = "16.7.2";
    private String device_platfrom = "android";
    private String ab_version = "16.7.2";
    private String ssmix = "a";
    private String device_type = "Samsung Galaxy S8";
    private String device_brand = "Samsung";
    private String language = "us";
    private String os_api = "26";
    private String os_version = "8.0.0";
    private String openudid = "26e22af6b95b6ba";
    private String manifest_version_code = "160702";
    private String resolution = "1440*2816";
    private String dpi = "480";
    private String update_version_code = "160702";
    private String _rticket = String.valueOf(System.currentTimeMillis());
    private String storage_type = "1";
    private String app_type = "normal";
    private String sys_region = Locale.getDefault().getCountry();
    private String timezone_name = TimeZone.getDefault().getID();
    private String carrier_region_v2 = "310";
    private String cpu_support64 = "false";
    private String host_abi = "armeabi-v7a";
    private String app_language = "US";
    private String carrier_region = Locale.getDefault().getCountry();
    private String ac2 = "wifi";
    private String uoo = "0";
    private String op_region = "US";
    private String timezone_offset = String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
    private String build_number = "16.7.2";
    private String locale = Locale.getDefault().getCountry().toLowerCase() + "-" + Locale.getDefault().getCountry();
    private String region = Locale.getDefault().getCountry();
    private String ts = String.valueOf(System.currentTimeMillis() / 1000);
    private String cdid = "61fb1e6e-7d3b-44ce-8d32-9a653224b12a";
    private String tt_data = "a";
    private String aweme_id;
    private String pass_route = "1";
    private String pass_region = "1";
    private String origin_type = "web";
    private String request_source = "0";
    private String device_id = "6871537129001960965";
    private String residence = Locale.getDefault().getCountry();
    private String iid = "6871537617181574917";
    private String appTheme = "light";
    private String getPackgeName = null;

    public String getGetPackgeName() {
        return getPackgeName;
    }

    public void setGetPackgeName(String getPackgeName) {
        this.getPackgeName = getPackgeName;
    }

    public String getAppTheme() {
        return appTheme;
    }

    public void setAppTheme(String appTheme) {
        this.appTheme = appTheme;
    }

    public String getRequest_source() {
        return request_source;
    }

    public void setRequest_source(String request_source) {
        this.request_source = request_source;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getVersion_code() {
        return version_code;
    }

    public void setVersion_code(String version_code) {
        this.version_code = version_code;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public String getDevice_platfrom() {
        return device_platfrom;
    }

    public void setDevice_platfrom(String device_platfrom) {
        this.device_platfrom = device_platfrom;
    }

    public String getAb_version() {
        return ab_version;
    }

    public void setAb_version(String ab_version) {
        this.ab_version = ab_version;
    }

    public String getSsmix() {
        return ssmix;
    }

    public void setSsmix(String ssmix) {
        this.ssmix = ssmix;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_brand() {
        return device_brand;
    }

    public void setDevice_brand(String device_brand) {
        this.device_brand = device_brand;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOs_api() {
        return os_api;
    }

    public void setOs_api(String os_api) {
        this.os_api = os_api;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getOpenudid() {
        return openudid;
    }

    public void setOpenudid(String openudid) {
        this.openudid = openudid;
    }

    public String getManifest_version_code() {
        return manifest_version_code;
    }

    public void setManifest_version_code(String manifest_version_code) {
        this.manifest_version_code = manifest_version_code;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getUpdate_version_code() {
        return update_version_code;
    }

    public void setUpdate_version_code(String update_version_code) {
        this.update_version_code = update_version_code;
    }

    public String get_rticket() {
        return _rticket;
    }

    public void set_rticket(String _rticket) {
        this._rticket = _rticket;
    }

    public String getStorage_type() {
        return storage_type;
    }

    public void setStorage_type(String storage_type) {
        this.storage_type = storage_type;
    }

    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }

    public String getSys_region() {
        return sys_region;
    }

    public void setSys_region(String sys_region) {
        this.sys_region = sys_region;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public String getCarrier_region_v2() {
        return carrier_region_v2;
    }

    public void setCarrier_region_v2(String carrier_region_v2) {
        this.carrier_region_v2 = carrier_region_v2;
    }

    public String getCpu_support64() {
        return cpu_support64;
    }

    public void setCpu_support64(String cpu_support64) {
        this.cpu_support64 = cpu_support64;
    }

    public String getHost_abi() {
        return host_abi;
    }

    public void setHost_abi(String host_abi) {
        this.host_abi = host_abi;
    }

    public String getApp_language() {
        return app_language;
    }

    public void setApp_language(String app_language) {
        this.app_language = app_language;
    }

    public String getCarrier_region() {
        return carrier_region;
    }

    public void setCarrier_region(String carrier_region) {
        this.carrier_region = carrier_region;
    }

    public String getAc2() {
        return ac2;
    }

    public void setAc2(String ac2) {
        this.ac2 = ac2;
    }

    public String getUoo() {
        return uoo;
    }

    public void setUoo(String uoo) {
        this.uoo = uoo;
    }

    public String getOp_region() {
        return op_region;
    }

    public void setOp_region(String op_region) {
        this.op_region = op_region;
    }

    public String getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(String timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public String getBuild_number() {
        return build_number;
    }

    public void setBuild_number(String build_number) {
        this.build_number = build_number;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getCdid() {
        return cdid;
    }

    public void setCdid(String cdid) {
        this.cdid = cdid;
    }

    public String getTt_data() {
        return tt_data;
    }

    public void setTt_data(String tt_data) {
        this.tt_data = tt_data;
    }

    public String getAweme_id() {
        return aweme_id;
    }

    public void setAweme_id(String aweme_id) {
        this.aweme_id = aweme_id;
    }

    public String getPass_route() {
        return pass_route;
    }

    public void setPass_route(String pass_route) {
        this.pass_route = pass_route;
    }

    public String getPass_region() {
        return pass_region;
    }

    public void setPass_region(String pass_region) {
        this.pass_region = pass_region;
    }

    public String getOrigin_type() {
        return origin_type;
    }

    public void setOrigin_type(String origin_type) {
        this.origin_type = origin_type;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }


//    public void setNewData(Context context){
//        changeDeviceName();
//        this.openudid = Settings.Secure.getString(context.getContentResolver(), "android_id");
//        this.cdid = UUID.randomUUID().toString();
//        this.device_id = SystemUtils.getRanInt(19);
//        this.iid = SystemUtils.getRanInt(19);
//        this.getPackgeName = context.getPackageName();
//    }

    private void changeDeviceName(){
        if(Build.DEVICE != null){
            this.device_type = Build.BRAND;
        }
        if(Build.MANUFACTURER != null){
            this.device_brand = Build.MANUFACTURER;
        }
        if(Build.VERSION.SDK_INT != 0){
            this.os_api = String.valueOf(Build.VERSION.SDK_INT);
        }
    }

    public HashMap<String, String> deviceMap(){
        HashMap<String, String> params = new HashMap<>();
        params.put("ac", getAc());
        params.put("channel", getChannel());
        params.put("aid", getAid());
        params.put("app_name", getApp_name());
        params.put("version_code", getVersion_code());
        params.put("version_name", getVersion_name());
        params.put("device_platform", getDevice_platfrom());
        params.put("ab_version", getAb_version());
        params.put("ssmix", getSsmix());
        params.put("device_type", getDevice_type());
        params.put("device_brand", getDevice_brand());
        params.put("language", getLanguage());
        params.put("os_api", getOs_api());
        params.put("os_version", getOs_version());
        params.put("openudid", getOpenudid());
        params.put("manifest_version_code", getManifest_version_code());
        params.put("resolution", getResolution());
        params.put("dpi", getDpi());
        params.put("update_version_code", getUpdate_version_code());
        params.put("_rticket", get_rticket());
        params.put("storage_type", getStorage_type());
        params.put("app_type",getApp_type());
        params.put("sys_region", getSys_region());
        params.put("timezone_name", getTimezone_name());
        params.put("carrier_region_v2", getCarrier_region_v2());
        params.put("cpu_support64", getCpu_support64());
        params.put("host_abi", getHost_abi());
        params.put("app_language", getApp_language());
        params.put("carrier_region", getCarrier_region());
        params.put("ac2", getAc2());
        params.put("uoo", getUoo());
        params.put("op_region", getOp_region());
        params.put("timezone_offset", getTimezone_offset());
        params.put("build_number", getBuild_number());
        params.put("locale", getLocale());
        params.put("region", getRegion());
        params.put("ts", getTs());
        params.put("cdid", getCdid());
        params.put("tt_data", getTt_data());
        params.put("pass-route", getPass_route());
        params.put("pass-region", getPass_region());
        params.put("aweme_id", getAweme_id());
        params.put("origin_type", getOrigin_type());
        params.put("request_source", getRequest_source());
        params.put("iid", getIid());
        params.put("device_id", getDevice_id());
        params.put("residence", getResidence());
        params.put("appTheme", getAppTheme());
        return params;
    }
}
