package com.asemediatech.tiktokdownloader.model;

import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceModel {
    private String aweme_id;
    private String retry_type = "no_retry";
    private String mcc_mnc = "";
    private String app_language = "US";
    private String language =  "us";
    private String region = Locale.getDefault().getCountry();
    private String sys_region = Locale.getDefault().getCountry();
    private String carrier_region = Locale.getDefault().getCountry();
    private String carrier_region_v2  = Locale.getDefault().getCountry();
    private String timezone_offset = String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
    private String timezone_name = TimeZone.getDefault().getID();
    private String is_my_cn = "0";
    private String fp = "";
    private String pass_region = "1";
    private String pass_route = "1";
    private String ac = "wifi";
    private String channel = "googleplay";
    private String aid = "1180";
    private String app_name = "trill";
    private String version_code = "494";
    private String device_platform = "android";
    private String ab_version = "4.9.3";
    private String ssmix = "a";
    private String manifest_version_code = "4.9.3";
    private String update_version_code = "4940";
    private String resolution = "1440*2816";
    private String dpi = "480";
    private String iid = "6874075317566359298";
    private String device_id = "6871537129001960965";
    private String openudid = "26e22af6b95b6ba";
    private String device_type = "Samsung Galaxy S8";
    private String os_version = "8.0.0";
    private String os_api = "26";
    private String device_brand = "Samsung";

    public String getAweme_id() {
        return aweme_id;
    }

    public void setAweme_id(String aweme_id) {
        this.aweme_id = aweme_id;
    }

    public String getRetry_type() {
        return retry_type;
    }

    public void setRetry_type(String retry_type) {
        this.retry_type = retry_type;
    }

    public String getMcc_mnc() {
        return mcc_mnc;
    }

    public void setMcc_mnc(String mcc_mnc) {
        this.mcc_mnc = mcc_mnc;
    }

    public String getApp_language() {
        return app_language;
    }

    public void setApp_language(String app_language) {
        this.app_language = app_language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSys_region() {
        return sys_region;
    }

    public void setSys_region(String sys_region) {
        this.sys_region = sys_region;
    }

    public String getCarrier_region() {
        return carrier_region;
    }

    public void setCarrier_region(String carrier_region) {
        this.carrier_region = carrier_region;
    }

    public String getCarrier_region_v2() {
        return carrier_region_v2;
    }

    public void setCarrier_region_v2(String carrier_region_v2) {
        this.carrier_region_v2 = carrier_region_v2;
    }

    public String getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(String timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public String getIs_my_cn() {
        return is_my_cn;
    }

    public void setIs_my_cn(String is_my_cn) {
        this.is_my_cn = is_my_cn;
    }

    public String getFp() {
        return fp;
    }

    public void setFp(String fp) {
        this.fp = fp;
    }

    public String getPass_region() {
        return pass_region;
    }

    public void setPass_region(String pass_region) {
        this.pass_region = pass_region;
    }

    public String getPass_route() {
        return pass_route;
    }

    public void setPass_route(String pass_route) {
        this.pass_route = pass_route;
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

    public String getDevice_platform() {
        return device_platform;
    }

    public void setDevice_platform(String device_platform) {
        this.device_platform = device_platform;
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

    public String getManifest_version_code() {
        return manifest_version_code;
    }

    public void setManifest_version_code(String manifest_version_code) {
        this.manifest_version_code = manifest_version_code;
    }

    public String getUpdate_version_code() {
        return update_version_code;
    }

    public void setUpdate_version_code(String update_version_code) {
        this.update_version_code = update_version_code;
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

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getOpenudid() {
        return openudid;
    }

    public void setOpenudid(String openudid) {
        this.openudid = openudid;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getOs_api() {
        return os_api;
    }

    public void setOs_api(String os_api) {
        this.os_api = os_api;
    }

    public String getDevice_brand() {
        return device_brand;
    }

    public void setDevice_brand(String device_brand) {
        this.device_brand = device_brand;
    }

    public HashMap<String, String> toMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("aweme_id", this.aweme_id);
        map.put("retry_type", this.retry_type);
        map.put("mcc_mnc", this.mcc_mnc);
        map.put("app_language", this.app_language);
        map.put("language", this.language);
        map.put("region", this.region);
        map.put("sys_region", this.sys_region);
        map.put("carrier_region", this.carrier_region);
        map.put("carrier_region_v2", this.carrier_region_v2);
        map.put("timezone_offset", this.timezone_offset);
        map.put("timezone_name", this.timezone_name);
        map.put("is_my_cn", this.is_my_cn);
        map.put("fp", this.fp);
        map.put("pass-region", this.pass_region);
        map.put("pass-route", this.pass_route);
        map.put("ac", this.ac);
        map.put("channel", this.channel);
        map.put("aid", this.aid);
        map.put("app_name", this.app_name);
        map.put("version_code", this.version_code);
        map.put("device_platform", this.device_platform);
        map.put("ab_version", this.ab_version);
        map.put("ssmix", this.ssmix);
        map.put("manifest_version_code", this.manifest_version_code);
        map.put("update_version_code", this.update_version_code);
        map.put("resolution", this.resolution);
        map.put("dpi", this.dpi);
        map.put("iid", this.iid);
        map.put("device_id", this.device_id);
        map.put("openudid", this.openudid);
        map.put("device_type", this.device_type);
        map.put("os_version", this.os_version);
        map.put("os_api", this.os_api);
        map.put("device_brand", this.device_brand);
        return map;
    }
}
