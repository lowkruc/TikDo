package com.asemediatech.tiktokdownloader.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.File;
import java.util.List;

public class FileModel extends ViewModel {
    private MutableLiveData<List<File>> file;

    public MutableLiveData<List<File>> getFile(){
        if(file == null){
            file = new MutableLiveData<List<File>>();
        }
        return file;
    }

    public void setModelsLiveData(final List<File> fileData) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("FileModal Thread", Thread.currentThread().toString());
                file.postValue(fileData);
            }
        }).start();

    }
}
