package com.example.bhatt9697.lockapp;

/**
 * Created by bhatt9697 on 2/17/2018.
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

public class AppList {

    private String name;
    Drawable icon;
    private String sTitle;
    private String sPackageName;
    private Drawable mImage;
    private Context mContext;
    private long  mItemId;
    private boolean  mItemId1;
    private boolean mShowCheckBox = false;
    private boolean mItemChecked = false;

    public AppList(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public AppList(Activity mContext) {
    }
    public boolean getItemChecked() {
        return mItemChecked;
    }

    public void setShowCheckBox(boolean showCheckBox) {
        mShowCheckBox = showCheckBox;
    }

    public boolean getShowCheckBox() {
        return mShowCheckBox;
    }

    public String getTitle() {
        return sTitle;
    }

    public void setTitle(String title) {
        sTitle = title;
    }

    public String getPackageName() {
        return sPackageName;
    }

    public void setPackageName(String packageName) {
        sPackageName = packageName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name1) {
        name =name1;
    }




    public Drawable getIcon() {
        return icon;
    }
}