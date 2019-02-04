package com.example.bhatt9697.lockapp;

import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class GestureActivity extends AppCompatActivity {
    private GestureLibrary gLib;
    private static final String TAG = "GestureActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        openOptionsMenu();
        gLib = GestureLibraries.fromFile(getExternalFilesDir(null) + "/" + "gesture.txt");
        gLib.load();

        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(handleGestureListener);
        gestures.setGestureStrokeAngleThreshold(90.0f);

    }

    /**
     * our gesture.txt listener
     */
    private OnGesturePerformedListener handleGestureListener = new OnGesturePerformedListener() {
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
                    Toast.makeText(GestureActivity.this, prediction.name,
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(GestureActivity.this, homeactivity.class);
                  //  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }
            }


        }
    };
}