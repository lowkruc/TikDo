package com.asemediatech.tiktokdownloader.utils;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.asemediatech.tiktokdownloader.fregment.Download;
import com.asemediatech.tiktokdownloader.fregment.Galery;


public class AdapterTab extends FragmentPagerAdapter {
    private int numOfTabs;
    public AdapterTab(FragmentManager fm, int numOfTabsx) {
        super(fm);
        this.numOfTabs = numOfTabsx;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            return  new Download();
            case 1:
            return  new Galery();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return numOfTabs;
    }
}
