package com.asemediatech.tiktokdownloader.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.asemediatech.tiktokdownloader.R;
import com.asemediatech.tiktokdownloader.utils.SystemUtils;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class GaleryAdapter extends ListAdapter<File, GaleryAdapter.ViewHolder> {
    private Context context;
    private SystemUtils systemUtils = new SystemUtils();
    private MediaPlayer mediaPlayer;

    public GaleryAdapter(Context context) {
        super(DIFF_CALBACK);
//        this.context = context;
    }

    private static final DiffUtil.ItemCallback<File> DIFF_CALBACK = new DiffUtil.ItemCallback<File>(){

        @Override
        public boolean areItemsTheSame(@NonNull File oldItem, @NonNull File newItem) {
            Log.d("areItemsTheSame", String.valueOf((oldItem == newItem)));
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull File oldItem, @NonNull File newItem) {
            Log.d("areItemsTheSame", String.valueOf(oldItem.getName().equals(newItem.getName())));
            return oldItem.getName().equals(newItem.getName());
        }
    };


    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView fileName, fileSize;
        private ImageView cover;
        private RelativeLayout itemList;
        private ImageButton fileButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fileName = itemView.findViewById(R.id.fileName);
            fileSize = itemView.findViewById(R.id.fileInfo);
            cover = itemView.findViewById(R.id.image);
            itemList = itemView.findViewById(R.id.item_list);
            fileButton = itemView.findViewById(R.id.playFile);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.galery_list_item, parent, false);
        ViewHolder VH = new ViewHolder(v);
        context = parent.getContext();
        return VH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String fn =  getItem(position).getName();
        final Date dateCreated = new Date(getItem(position).lastModified());
        final String size = systemUtils.humanReadableByteCountSI(getItem(position).length());
        holder.fileName.setText(fn);
        holder.fileSize.setText(size+" | "+ DateFormat.getDateInstance().format(dateCreated));
        Bitmap thumb = getThumb(getItem(position).getPath());
        if(thumb != null){
            holder.cover.setImageBitmap(thumb);
        }else{
            holder.cover.setImageResource(R.drawable.ic_back_music);
        }
        holder.fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Play Button", "Clicked");
                String type = systemUtils.getExtension(getItem(position).getAbsolutePath());
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setDataAndType(Uri.parse(getItem(position).getAbsolutePath()), "*/*");
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    context.startActivity(intent);
                }catch (ActivityNotFoundException e){
                    e.printStackTrace();
                }
//                if(getItem(position).getName().contains("mp3")){
//                    Dialog dialog = new Dialog(context);
//                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                    dialog.setContentView(R.layout.dialog_mp3);
//                    dialog.setCancelable(true);
//                    final Window window = dialog.getWindow();
//                    window.setLayout(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
//                    window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                    dialog.show();
//                    mediaPlayer = MediaPlayer.create(context, Uri.parse(getItem(position).getPath()));
//                }
            }
        });


    }

    private Bitmap getThumb(String file){
        try {
            Bitmap thumb = ThumbnailUtils.createVideoThumbnail(file, MediaStore.Images.Thumbnails.MINI_KIND);
            return thumb;
        }catch (UnsatisfiedLinkError e){
            e.printStackTrace();
            return null;
        }
    }

}
