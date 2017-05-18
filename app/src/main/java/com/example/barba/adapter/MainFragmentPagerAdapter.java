package com.example.barba.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.barba.fragments.FragmentLocalization;
import com.example.barba.fragments.FragmentName;

/**
 * Created by Gilbertopapa013 on 30/03/2017.
 */
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;

    public MainFragmentPagerAdapter(FragmentManager fm, String[] mTabTitles) {
        super(fm);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentLocalization();
            case 1:
                return new FragmentName();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
