package com.hostel9.android.hostel9app.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hostel9.android.hostel9app.Fragments.CalenderFragment;
import com.hostel9.android.hostel9app.Fragments.EventsFragment;
import com.hostel9.android.hostel9app.Fragments.MessFragment;

/**
 * Created by owais on 13/01/18.
 */

public class CustomFragmentPageAdapter extends FragmentPagerAdapter{
    private static final String TAG = CustomFragmentPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 3;
    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MessFragment();
            case 1:
                return new EventsFragment();
            case 2:
                return new CalenderFragment();
        }
        return null;
    }
    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Mess";
            case 1:
                return "Events";
            case 2:
                return "Calender";
        }
        return null;
    }
}