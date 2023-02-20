package com.asemediatech.tiktokdownloader.fregment;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.asemediatech.tiktokdownloader.R;
import com.asemediatech.tiktokdownloader.model.VideoModel;
import com.asemediatech.tiktokdownloader.request.ApiExecute;
import com.asemediatech.tiktokdownloader.utils.ApiUtils;
import com.asemediatech.tiktokdownloader.utils.DownloadUtils;
import com.asemediatech.tiktokdownloader.utils.SystemUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.regex.Pattern;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Download#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Download extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;
    private InterstitialAd mInterstitialAd;
    private int countShowAds = 0;
    private ApiUtils apiUtils = new ApiUtils();
    private ApiExecute apiExecute = new ApiExecute();
    public String url;
    private SystemUtils systemUtils = new SystemUtils();
    public Download() {
        // Required empty public constructor
    }


    public static Download newInstance(String param1, String param2) {
        Download fragment = new Download();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-5977365730645902/6149411158");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_download, container, false);
        hendleButton(v);

        return v;
    }

    private void hendleButton(View view){
        ImageButton pasteButton = (ImageButton) view.findViewById(R.id.pasteButton);
        Pattern uriRegex = Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]tiktok+)\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$");
        pasteButton.setOnClickListener(new View.OnClickListener() {
            ClipboardManager clipboardManager;
            @Override
            public void onClick(View v) {
                Log.d("Paste Clicked", "Clicked Paste Button");
                String textClipboard = getClipboard();
                TextView urlText = (TextView) getView().findViewById(R.id.textinputHendle);
                ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.loadingBar);
                ApiUtils apiUtils = new ApiUtils();
                countShowAds = countShowAds + 1;
                if(textClipboard != null){
                    if(uriRegex.matcher(textClipboard).matches()){
                        progressBar.setVisibility(View.VISIBLE);
                        urlText.setText(textClipboard);
                        url = textClipboard;
                        try {
                            getVideoData();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }

                    }else {
                        urlText.setText("Tap to paset link");
                        if(progressBar.getVisibility() != View.INVISIBLE){
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                        Log.d("Into Data Clipboard", "Tidak ada URL Tiktok");
                        Toast toast = Toast.makeText(getContext(), "Your paste link doesn't match TikTok Share", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }else{
                    Toast toast = Toast.makeText(getContext(), "You don't have any link in clipboard", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    private String getClipboard(){
        ClipboardManager mclipboard =(ClipboardManager) getActivity().getSystemService(CLIPBOARD_SERVICE);
        if(mclipboard.hasPrimaryClip()){
            boolean isTextPlain = mclipboard.getPrimaryClip().getDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN);
            CharSequence text = null;
            if (isTextPlain){
                ClipData clipData = mclipboard.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);
                if (  item!= null ){
                    text = item.getText();
                    if (text == null){
                        text =  item.coerceToText(getContext());
                    }
                }
                return text.toString();
            }
        }
        return null;
    }

    private void setupVideoExecute(String id){
        Map<String, String> headers;
        Map<String, String> params;
        params = apiUtils.paramsWithDevice(getContext());
        headers = apiUtils.createHeaders();
        params.put("aweme_id", id);
        apiExecute.setHeaders(headers);
        apiExecute.setParams(params);
    }


    private void getVideoData() throws URISyntaxException {
        Log.d("getVideoData", "Getting Data Video");
        String id = apiUtils.getId(url);
        if(id != null){
            setupVideoExecute(id);
            apiExecute.getVideo(callbackVideoData);

        }else{
            apiExecute.getVideoID(url, callbackVideoID);
        }
    }

    private Callback<ResponseBody> callbackVideoID = new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (mInterstitialAd.isLoaded()) {
                    if(countShowAds == 1 || countShowAds == 3 || countShowAds == 5 || countShowAds == 7 || countShowAds == 8 || countShowAds == 10 || countShowAds == 13 || countShowAds >= 13 ){
                        mInterstitialAd.show();
                        mInterstitialAd = new InterstitialAd(getContext());
                        mInterstitialAd.setAdUnitId("ca-app-pub-5977365730645902/6149411158");
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                if(response.isSuccessful()){
                    try {
                        String[] dataBody = response.body().string().split("/i18n/share/video/");
                        Log.d("CallbackVideoID", String.valueOf(dataBody.length));
                        if(dataBody.length > 1){
                            String id = dataBody[1].substring(0, 19);
                            setupVideoExecute(id);
                            apiExecute.getVideo(callbackVideoData);
                        }else{
                            Log.d("Retry get ID from Body", "TRUE");
                            call.cancel();
                            apiExecute.getVideoID(url, callbackVideoID);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        call.cancel();
                        apiExecute.getVideoID(url, callbackVideoID);
                        Log.d("CallbackVideoID", "GET ID FROM BODY NULL");
                    }
                }else{
                    Log.d("CallbackVideoID", "Error Connection");
                    call.cancel();
                    TextView urlText = (TextView) getView().findViewById(R.id.textinputHendle);
                    ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.loadingBar);
                    urlText.setText("Tap to paset link");
                    if(progressBar.getVisibility() != View.INVISIBLE){
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                    apiExecute.getVideoID(url, callbackVideoID);
                }
        }

        @Override
        public void onFailure(Call<ResponseBody> call, Throwable t) {
            TextView urlText = (TextView) getView().findViewById(R.id.textinputHendle);
            ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.loadingBar);
            urlText.setText("Tap to paset link");
            if(progressBar.getVisibility() != View.INVISIBLE){
                progressBar.setVisibility(View.INVISIBLE);
            }
            t.printStackTrace();
            Toast.makeText(getContext(), "Getting Data from URL to get ID error", Toast.LENGTH_LONG).show();
        }
    };

    private Callback<VideoModel> callbackVideoData = new Callback<VideoModel>() {
        @Override
        public void onResponse(Call<VideoModel> call, Response<VideoModel> response) {
            if(response.isSuccessful() && response.body() != null){
                Log.d("DATA VIDEO", response.body().awemeDetail.videoId);
                TextView textLink = (TextView) getView().findViewById(R.id.textinputHendle);
                ProgressBar loadingnewBar = (ProgressBar) getView().findViewById(R.id.loadingBar);
                textLink.setText("Tap to paste link");
                loadingnewBar.setVisibility(View.INVISIBLE);
                call.cancel();

                Dialog dialog = new Dialog(getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_video);
                dialog.setCancelable(true);

                final Window window = dialog.getWindow();
                window.setLayout(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                SimpleDraweeView imageCover = dialog.getWindow().findViewById(R.id.imageCover);
                TextView username = dialog.getWindow().findViewById(R.id.username);
                TextView desc = dialog.getWindow().findViewById(R.id.desc);
                TextView sizeNW = dialog.getWindow().findViewById(R.id.sizeNoWatermark);
                TextView sizeW = dialog.getWindow().findViewById(R.id.sizeWatermark);
                TextView sizeM = dialog.getWindow().findViewById(R.id.sizeMusic);
                ImageButton btnNW = dialog.getWindow().findViewById(R.id.buttonNoWatermark);
                ImageButton btnW = dialog.getWindow().findViewById(R.id.buttonWatermark);
                ImageButton btnM = dialog.getWindow().findViewById(R.id.buttonMusic);

                int sizeDNW = response.body().awemeDetail.videoData.NoWatermark.size;
                int sizeDW = response.body().awemeDetail.videoData.withWatermark.size;
                sizeNW.setText(systemUtils.humanReadableByteCountSI(sizeDNW));
                sizeW.setText(systemUtils.humanReadableByteCountSI(sizeDW));

                desc.setText(response.body().awemeDetail.descVideo);
                username.setText(response.body().awemeDetail.userProfil.nickname);
                String urlImgae = response.body().awemeDetail.videoData.dynamicCover.urlData.get(0).toString();
                DraweeController imgController = Fresco.newDraweeControllerBuilder()
                        .setUri(urlImgae)
                        .setAutoPlayAnimations(true)
                        .build();
                imageCover.setController(imgController);

                btnNW.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DownloadUtils downloadUtils = new DownloadUtils();
                        downloadUtils.setTITLE_DOWNLOAD("Downloading video from " + response.body().awemeDetail.userProfil.nickname + " No Watermark");
                        downloadUtils.setURL(response.body().awemeDetail.videoData.NoWatermark.urlData.get(0).toString());
                        downloadUtils.setContext(getActivity());
                        downloadUtils.setNAME("["+response.body().awemeDetail.userProfil.nickname+"] "+response.body().awemeDetail.videoId+" No Watermark.mp4");
                        Toast toast = Toast.makeText(dialog.getContext(), "Downloading video from "+response.body().awemeDetail.userProfil.nickname+ " No Watermark", Toast.LENGTH_LONG);
                        downloadUtils.StartDownload();
                        toast.show();
                    }
                });

                btnW.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DownloadUtils downloadUtils = new DownloadUtils();
                        downloadUtils.setTITLE_DOWNLOAD("Downloading video from " + response.body().awemeDetail.userProfil.nickname + " With Watermark");
                        downloadUtils.setURL(response.body().awemeDetail.videoData.withWatermark.urlData.get(0).toString());
                        downloadUtils.setContext(getActivity());
                        downloadUtils.setNAME("["+response.body().awemeDetail.userProfil.nickname+"] "+response.body().awemeDetail.videoId+" Watermark.mp4");
                        Toast toast = Toast.makeText(dialog.getContext(), "Downloading video from "+response.body().awemeDetail.userProfil.nickname+ " With Watermark", Toast.LENGTH_LONG);
                        downloadUtils.StartDownload();
                        toast.show();
                    }
                });

                btnM.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DownloadUtils downloadUtils = new DownloadUtils();
                        downloadUtils.setTITLE_DOWNLOAD("Downloading music in video " + response.body().awemeDetail.musicData.titleMusic);
                        downloadUtils.setURL(response.body().awemeDetail.musicData.listMusic.url);
                        downloadUtils.setContext(getActivity());
                        downloadUtils.setNAME(""+response.body().awemeDetail.musicData.titleMusic+" Original.mp3");
                        Toast toast = Toast.makeText(dialog.getContext(), "Downloading music in video " + response.body().awemeDetail.musicData.titleMusic, Toast.LENGTH_LONG);
                        downloadUtils.StartDownload();
                        toast.show();
                    }
                });
            }else{
                Log.d("DATA VIDEO", "DATA NULL");
                try {
                    getVideoData();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onFailure(Call<VideoModel> call, Throwable t) {
            t.printStackTrace();
        }
    };


}
