package com.example.bhatt9697.lockapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    LinearLayout l1,l2;
    private GestureLibrary gLib;
    Button btnsub;
    Button btnsub1;
    Animation uptodown,downtoup;
    private static String MY_PREFS_NAME = "PatternLock";

    private String codeString2;
    private static String PATTERN_KEY;
    private static String encoded;
    private SharedPreferences.Editor editor;
    SharedPreferences prefs;
    SharedPreferences prefs11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        PATTERN_KEY = prefs.getString("PatternLock", "invalid");
        btnsub = (Button)findViewById(R.id.buttonsub);
        btnsub1 = (Button)findViewById(R.id.buttonsub1);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
    }
    private boolean ispass1() {
        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        return prefs.getBoolean("pass", true);
    }

    protected void onStart() {
        super.onStart();
        gLib = GestureLibraries.fromFile(getExternalFilesDir(null) + "/" + "gesture.txt");
        gLib.load();
        if (PATTERN_KEY.equals("invalid") && !gLib.load()) {
            setContentView(R.layout.activity_main);







        } else if(gLib.load()){

            Intent intent = new Intent(MainActivity.this, GestureActivity.class);
            startActivity(intent);

        }
        else
        {


         /*   byte[] byteArray = getIntent().getByteArrayExtra("image");
            final Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            ImageView iv=(ImageView) findViewById(R.id.imageView1);
            iv.setImageBitmap(bmp);*/

            Intent intent = new Intent(MainActivity.this, lockactivity.class);
            startActivity(intent);

        }












    }





    public void button1(View v)
    {
        Intent intent = new Intent(MainActivity.this,setimagepattern.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);




    }



    public void button2(View v)
    {
        Intent intent = new Intent(MainActivity.this,GestureListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);




    }

    private boolean isPass() {
        SharedPreferences prefs = getSharedPreferences("PASS_CODE", MODE_PRIVATE);
        return prefs.getBoolean("is_pass", false);
    }


}
