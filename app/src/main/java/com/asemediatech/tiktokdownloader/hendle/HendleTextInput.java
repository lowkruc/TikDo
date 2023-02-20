package com.asemediatech.tiktokdownloader.hendle;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.asemediatech.tiktokdownloader.utils.SystemUtils;

import java.util.regex.Pattern;

public class HendleTextInput implements TextWatcher {
    private Pattern uriRegex = Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]tiktok+)\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$");
    private View view;
    private Context context;
    private SystemUtils systemUtils = new SystemUtils();
    private Activity activity;
    private FragmentManager fm;

    public HendleTextInput(View view, Activity activity, FragmentManager fm){
        this.view = view;
        this.context = view.getContext();
        this.activity = activity;
        this.fm = fm;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(count > 2){
            if(uriRegex.matcher(s).matches()){

            }else{
                Toast.makeText(context, "Incorrect video link", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}
