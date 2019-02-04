package com.example.bhatt9697.lockapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bhatt9697.lockapp.services.AppLockTimerTask;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class Gesture2 extends AppCompatActivity {
    private GestureLibrary gLib;
    private static final String TAG = "GestureActivity";
    private Context mContext;
    String packageName;
    private SharedPreferences prefs;private SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyUserChoice";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture2);

        openOptionsMenu();
        gLib = GestureLibraries.fromFile(getExternalFilesDir(null) + "/" + "gesture.txt");
        gLib.load();

        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(handleGestureListener);
        gestures.setGestureStrokeAngleThreshold(90.0f);

        mContext = getApplicationContext();



    }

    /**
     * our gesture.txt listener
     */
    private GestureOverlayView.OnGesturePerformedListener handleGestureListener = new GestureOverlayView.OnGesturePerformedListener() {
        @Override
        public void onGesturePerformed(GestureOverlayView gestureView,
                                       Gesture gesture) {

            ArrayList<Prediction> predictions = gLib.recognize(gesture);
            Log.d(TAG, "recog thayu");
            //  Toast.makeText(GestureActivity.this, " recog",
            // Toast.LENGTH_SHORT).show();

            if (predictions.size() > 0) {
                Prediction prediction = predictions.get(0);
                // checking prediction
                if (prediction.score > 2.0) {
                    // and action



                    prefs = mContext.getSharedPreferences( MyPREFERENCES, MODE_PRIVATE);
                    packageName="";
                    packageName =prefs.getString("MyUserChoice","");
                    Toast.makeText(Gesture2.this, prediction.name,
                            Toast.LENGTH_SHORT).show();
                    PackageManager pm = mContext.getPackageManager();
                  //  Intent intent = new Intent(Intent.ACTION_MAIN);
                   Intent intent = pm.getLaunchIntentForPackage(packageName);

             //     intent.addCategory(Intent.CATEGORY_HOME);

               //     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        // Start the app
                   finish();
                   mContext.startActivity(intent);


                          //  Intent startMain = new Intent("com.google.android.gm.intent.action.Launch");

                    //startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 //   startActivity(startMain);



                }
            }


        }
    };
}
