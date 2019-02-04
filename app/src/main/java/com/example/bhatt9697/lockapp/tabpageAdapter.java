package com.example.bhatt9697.lockapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by bhatt9697 on 2/11/2018.
 */

public class tabpageAdapter extends FragmentStatePagerAdapter


{

    String[] tabarray=new String[]{"Apps","LOCKED"};
    Integer tabnumber=2;

    public tabpageAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {

       switch(position)
       {

           case 0:
               apps app1=new apps();
               return app1;
           case 1:
               locked lockapp=new locked();
               return lockapp;





















       }













        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
