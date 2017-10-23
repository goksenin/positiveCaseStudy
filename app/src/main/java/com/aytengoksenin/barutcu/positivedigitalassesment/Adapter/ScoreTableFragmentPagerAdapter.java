package com.aytengoksenin.barutcu.positivedigitalassesment.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aytengoksenin.barutcu.positivedigitalassesment.Fragment.TeamListFragment;


/**
 * Created by goksenin.barutcu on 21/10/2017.
 * This class holds a view pager having 2 page. Page 1 opens Super Lig and Page 2 opens Premiere Lig.
 */

public class ScoreTableFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String tabTitles[] = new String[] { "SÜPER LİG", "İNGİLTERE PREMİER LİGİ" };
    public ScoreTableFragmentPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }



    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            TeamListFragment teamListFragment = TeamListFragment.newInstance(1);
            return teamListFragment;
        }else{
            TeamListFragment teamListFragment = TeamListFragment.newInstance(2);
            return teamListFragment;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
