package com.asemediatech.tiktokdownloader.utils;


import android.os.FileObserver;
import android.util.Log;

public class GaleryObserver extends FileObserver {

    String aboslutePath = "path to your directory";

    public GaleryObserver(String path) {
        super(path);
        aboslutePath = path;
    }

    @Override
    public void onEvent(int event, String path) {
        switch (event & ALL_EVENTS) {
//                    case MODIFY:
//                        Log.d("FileObserver", "Modify File | Path : "+path);
            case CREATE:
                Log.d("FileObserver", "Created File | Path : "+path);
//                    case DELETE:
//                        Log.d("FileObserver", "Delete File | Path : "+path);
            case CLOSE_WRITE:
                Log.d("FileObserver", "CLOSE_WRITE File | Path : "+path);
            case CLOSE_NOWRITE:
                Log.d("FileObserver", "CLOSE_NOWRITE File | Path : "+path);
        }
    }
}
