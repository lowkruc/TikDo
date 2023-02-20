package com.asemediatech.tiktokdownloader.utils;

import android.app.Activity;
import android.app.DownloadManager;
import android.net.Uri;

public class DownloadUtils {
    private String URL;
    private String NAME;
    private Activity ACTIVITY;
    private String TITLE_DOWNLOAD;
    private SystemUtils systemUtils = new SystemUtils();
    public void setContext(Activity activity) {
        this.ACTIVITY = activity;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setTITLE_DOWNLOAD(String TITLE_DOWNLOAD) {
        this.TITLE_DOWNLOAD = TITLE_DOWNLOAD;
    }

    public void StartDownload(){
        DownloadManager downloadManager = (DownloadManager) ACTIVITY.getSystemService(ACTIVITY.getApplicationContext().DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(this.URL);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setDestinationInExternalPublicDir("", "/TikDo Download/"+ this.NAME);
        request.setTitle(this.TITLE_DOWNLOAD);
        request.setNotificationVisibility(request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setVisibleInDownloadsUi(true);
        downloadManager.enqueue(request);
    }

}
