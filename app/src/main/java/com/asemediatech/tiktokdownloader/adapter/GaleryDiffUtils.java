package com.asemediatech.tiktokdownloader.adapter;

import androidx.recyclerview.widget.DiffUtil;

import java.io.File;
import java.util.List;

public class GaleryDiffUtils extends DiffUtil.Callback {
    List<File> fileNew;
    List<File> fileOld;

    public GaleryDiffUtils(List<File> fileNew, List<File> fileOld) {
        this.fileNew = fileNew;
        this.fileOld = fileOld;
    }

    @Override
    public int getOldListSize() {
        return fileOld.size();
    }

    @Override
    public int getNewListSize() {
        return fileNew.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return fileNew.get(newItemPosition).getAbsolutePath() == fileOld.get(oldItemPosition).getAbsolutePath();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return fileNew.get(newItemPosition).getName().equals(fileOld.get(oldItemPosition).getName());
    }

}
