package com.asemediatech.tiktokdownloader.fregment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.os.FileObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asemediatech.tiktokdownloader.R;
import com.asemediatech.tiktokdownloader.adapter.GaleryAdapter;
import com.asemediatech.tiktokdownloader.model.FileModel;
import com.asemediatech.tiktokdownloader.utils.SystemUtils;
import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Galery#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Galery extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView.LayoutManager layoutManager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SystemUtils systemUtils = new SystemUtils();
    private Context context;
    GaleryAdapter galeryAdapter = new GaleryAdapter(context);
    private FileModel model;
    private List<File> filesGalery;
    private int countFiles = 0;
    private RecyclerView listData;
    private FileObserver observer;

    public Galery() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Galery newInstance() {
        Galery fragment = new Galery();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_galery, container, false);
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.typeTabLayout);
        tabLayout.addOnTabSelectedListener(tabClicked);
        if(ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        }
        this.listData = v.findViewById(R.id.listData);
        String path = Environment.getExternalStorageDirectory()+"/TikDo Download/";
        fileObserver(path);
        this.context = v.getContext();
        createData(v);
        return v;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isResumed() && isVisibleToUser) {
            if(countFiles == 0){
                if(systemUtils.getListFiles() != null && systemUtils.getListFiles().size() > 0){
                    this.filesGalery = systemUtils.getListFiles();
                    this.countFiles = systemUtils.getListFiles().size();
                    String path = Environment.getExternalStorageDirectory()+"/TikDo Download/";
                    model.getFile().setValue(filesGalery);
                    fileObserver(path);
                }
            }
        }
    }

    private void createData(View v){
        layoutManager = new LinearLayoutManager(v.getContext());
        listData.setLayoutManager(layoutManager);
        listData.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(v.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(v.getContext(), R.drawable.devider ));
        model = new ViewModelProvider(this).get(FileModel.class);
        model = ViewModelProviders.of(this).get(FileModel.class);
        listData.setAdapter(galeryAdapter);
        listData.addItemDecoration(dividerItemDecoration);
        model.getFile().observe(getViewLifecycleOwner(), new Observer<List<File>>() {
            @Override
            public void onChanged(List<File> files) {
                Log.d("Change Date", "Running");
                galeryAdapter.submitList(files);
            }
        });
        if(systemUtils.getListFiles() != null){
            this.filesGalery = systemUtils.getListFiles();
            this.countFiles = filesGalery.size();
        }else{
            countFiles = 0;
            List<File> dx = new ArrayList<>();
            this.filesGalery = dx;
        }
        model.getFile().setValue(filesGalery);
    }

    private TabLayout.OnTabSelectedListener tabClicked = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if(tab.getText().equals("All")){
                Log.d("Type", "All");
                model.getFile().setValue(filesGalery);
            }else if(tab.getText().equals("Video")){
                Log.d("Type", "Video");
                List<File> listVideo = new ArrayList<>();
                for(int i = 0; i < filesGalery.size(); i++){
                    if(filesGalery.get(i).getName().contains("mp4")){
                        listVideo.add(filesGalery.get(i));
                    }
                }
                model.getFile().setValue(listVideo);
                Log.d("Test", listVideo.toString());
            }else  if(tab.getText().equals("Music")){
                Log.d("Type", "Music");
                List<File> listMusic = new ArrayList<>();
                for(int i = 0; i < filesGalery.size(); i++){
                    if(filesGalery.get(i).getName().contains("mp3")){
                        listMusic.add(filesGalery.get(i));
                    }
                }
                model.getFile().setValue(listMusic);
                Log.d("Test", listMusic.toString());
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };


    private void fileObserver(String path) {
        if (observer != null) {
            observer.stopWatching();
        }else{
            Log.d("FileObserver", "Running");
        }
        observer = new FileObserver(path) {
            @Override
            public void onEvent(int event, String x) {
                switch (event & ALL_EVENTS) {
                    case CREATE:
                        Log.d("FileObserver", "Created File | Path : "+x);
                        filesGalery = systemUtils.getListFiles();
                        countFiles = systemUtils.getListFiles().size();
                        model.getFile().postValue(systemUtils.getListFiles());
                    case DELETE:
                        Log.d("FileObserver", "Delete File | Path : "+x);
                }
            }
        };
        observer.startWatching();
    }


}
