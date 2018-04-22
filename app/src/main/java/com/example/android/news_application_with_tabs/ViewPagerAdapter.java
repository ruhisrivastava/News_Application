package com.example.android.news_application_with_tabs;

/**
 * Created by Ruhi on 1/30/2018.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

  /*public Fragment getItem(int position) {
      TabFragment fragment = new TabFragment();
      Bundle bundle = new Bundle();
      bundle.putInt("position", position);
      fragment.setArguments(bundle);
      return fragment;
  }*/

    @Override
    public Fragment getItem(int position) {

        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab "+position;
    }

}