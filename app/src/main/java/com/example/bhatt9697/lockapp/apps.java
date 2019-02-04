package com.example.bhatt9697.lockapp;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class apps extends Fragment {
    ListView lv;
    //RecyclerView recyclerView;

    public apps() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_apps, container, false);

        // Inflate the layout for this fragment
        //lv=(ListView) getActivity().findViewById(R.id.recycler_view);
        ListView  lv = (ListView)rootView.findViewById(R.id.installed_app_list);
        List<AppList> installedApps = getInstalledApps();
        AppAdapter installedAppAdapter = new AppAdapter(getActivity(), installedApps);
        lv.setAdapter(installedAppAdapter);


        return rootView;
        }

    private List<AppList> getInstalledApps() {
        PackageManager packageManager = getActivity().getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<AppList> res = new ArrayList<AppList>();

        List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            if ((isSystemPackage(p) == false)) {
                String appName = p.applicationInfo.loadLabel( getActivity().getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon( getActivity().getPackageManager());
                String packageName= p.applicationInfo.packageName;
                res.add(new AppList(packageName, icon));

            }
        }
        return res;




    }


    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true : false;
    }


}



