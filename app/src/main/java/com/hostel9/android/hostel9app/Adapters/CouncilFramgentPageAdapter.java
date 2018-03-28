package com.hostel9.android.hostel9app.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hostel9.android.hostel9app.ComputerFragment;
import com.hostel9.android.hostel9app.CulturalFragment;
import com.hostel9.android.hostel9app.HeadFragment;
import com.hostel9.android.hostel9app.MaintenanceFragment;
import com.hostel9.android.hostel9app.MessCFragment;
import com.hostel9.android.hostel9app.OfficeFragment;
import com.hostel9.android.hostel9app.SportsFragment;
import com.hostel9.android.hostel9app.TechnicalFragment;

/**
 * Created by owais on 25/03/18.
 */

public class CouncilFramgentPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = CouncilFramgentPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 8;
    public CouncilFramgentPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HeadFragment();
            case 1:
                return new ComputerFragment();
            case 2:
                return new MessCFragment();
            case 3:
                return new MaintenanceFragment();
            case 4:
                return new CulturalFragment();
            case 5:
                return new TechnicalFragment();
            case 6:
                return new SportsFragment();
            case 7:
                return new OfficeFragment();
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
                return "Head";
            case 1:
                return "Computer";
            case 2:
                return "Mess";
            case 3:
                return "Maintenance";
            case 4:
                return "Cultural";
            case 5:
                return "Technical";
            case 6:
                return "Sports";
            case 7:
                return "Office";
        }
        return null;
    }
}
