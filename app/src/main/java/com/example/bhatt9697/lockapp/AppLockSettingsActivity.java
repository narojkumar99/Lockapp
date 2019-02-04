package com.example.bhatt9697.lockapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.provider.Settings;
import android.widget.Toast;
import com.example.bhatt9697.lockapp.services.AppLockService;

public class AppLockSettingsActivity extends PreferenceActivity implements
        OnPreferenceClickListener,
        OnPreferenceChangeListener {
    private final static String TAG = "AppLockSettingsActivity";

    private CheckBoxPreference mToogleLockPref;
    private Preference mSetPatternPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        startActivity(intent);
        mToogleLockPref = (CheckBoxPreference) findPreference("lock_status");
        mToogleLockPref.setOnPreferenceClickListener(this);
        mToogleLockPref.setOnPreferenceChangeListener(this);

    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        // TODO Auto-generated method stub
        //Intent i = new Intent(this, ChooseLockPattern.class);
        //startActivity(i);




        startService(new Intent(this, AppLockService.class));





        return true;
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        if (preference == mToogleLockPref) {
            mToogleLockPref.getKey();
            if (objValue.equals(true)) {
                Toast.makeText(getApplicationContext(), "Chage:Toogle " + "Background Service start", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {


                    startService(new Intent(this, AppLockService.class));
                }
                else {

                    startForegroundService(new Intent(this, AppLockService.class));


                }
            } else {
                Toast.makeText(getApplicationContext(), "Chage:Toogle " + "Background Service stop", Toast.LENGTH_SHORT).show();





                stopService(new Intent(this, AppLockService.class));



            }

        } else if (preference == mSetPatternPref) {
            Toast.makeText(getApplicationContext(), "Change:set pattern", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
