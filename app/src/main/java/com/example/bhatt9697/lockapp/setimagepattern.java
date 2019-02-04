package com.example.bhatt9697.lockapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class setimagepattern extends AppCompatActivity {

    private static final String TRUE_CODE="";
    private static final int MAX_LENGHT = 4;
    private String codeString = "";
    private int count=0;
    private static String MY_PREFS_NAME = "PatternLock";
    private SharedPreferences prefs;private SharedPreferences.Editor editor;

    @BindViews({R.id.dot1, R.id.dot2, R.id.dot3, R.id.dot4})
    List<ImageView> dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setimagepattern);

        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();


      /* final  Bitmap bitmap = BitmapFactory.decodeByteArray(
                getIntent().getByteArrayExtra("image"),0,getIntent().getByteArrayExtra("image").length);*/
        ImageView iv=(ImageView) findViewById(R.id.image);
       // iv.setImageBitmap(bitmap);

        // Instance of ImageAdapter Class


        int densityDpi = getResources().getDisplayMetrics().densityDpi;

        switch (densityDpi)
        {
            case DisplayMetrics.DENSITY_LOW:
                // LDPI
                break;

            case DisplayMetrics.DENSITY_MEDIUM:
                // MDPI
                break;

            case DisplayMetrics.DENSITY_TV:
            case DisplayMetrics.DENSITY_HIGH:
                // HDPI
                break;

            case DisplayMetrics.DENSITY_XHIGH:
            case DisplayMetrics.DENSITY_280:
                 Toast.makeText(setimagepattern.this, "xhdpi", Toast.LENGTH_SHORT).show();
                // XHDPI
                iv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View iv, MotionEvent event) {


                        float x = (int) event.getX();
                        float y = (int) event.getY();


       /*      int selectedItem= event.getAction();
                switch (selectedItem) {
                    case 0:

                        //    Toast.makeText(MainActivity.this,"phone", Toast.LENGTH_SHORT).show();
                             String msg1 = "X=" + x + "\nY=" + y;
                            codeString+=msg1;
                            count++;

                        break;

                    case 1:

                          //  Toast.makeText(MainActivity.this,"coke", Toast.LENGTH_SHORT).show();
                             String msg2 = "X=" + x + "\nY=" + y;
                            codeString+=msg2;
                            count++;

                        break;
                    case 3:

                            Toast.makeText(MainActivity.this,"skateboard", Toast.LENGTH_SHORT).show();
                             String msg3 = "X=" + x + "\nY=" + y;
                            codeString+=msg3;
                            count++;

                        break;


                    case 4:

                            Toast.makeText(MainActivity.this,"suitcase", Toast.LENGTH_SHORT).show();
                             String msg4 = "X=" + x + "\nY=" + y;
                            codeString+=msg4;
                            count++;

                        break;


                    default:
                        break;
                }*/

           /* galalxy nexus     if(x>=315&&x<=340&&y<=600&&y>=540) {
                    // tv.setText(codeString);
                    //editor.putString("user", codeString);
                    Toast.makeText(MainActivity.this, "coke", Toast.LENGTH_SHORT).show();
                    codeString += "0";

                }*/



//if(count==5) {
                        //  tv.setText(codeString);

                        //
                        if(x>=236&&x<=256&&y<=600&&y>=575) {
                            // tv.setText(codeString);
                            //editor.putString("user", codeString);
                            Toast.makeText(setimagepattern.this,"football", Toast.LENGTH_SHORT).show();
                            codeString += "0";
                            count++;



                            //editor.commit();
                        }

                        if(x>=214&&x<=195&&y<465&&y>=445){
                            //  if(x>=315&&x<=340&&y<=600&&y>=540) {

                            Toast.makeText(setimagepattern.this,"Heart", Toast.LENGTH_SHORT).show();
                            codeString += "1";
                            count++;


                        }




                        if(x>=50&&x<=69&&y<532&&y>=512) {

                            Toast.makeText(setimagepattern.this,"tire", Toast.LENGTH_SHORT).show();
                            codeString += "2";
                            count++;

                        }



                        if(x>=445&&x<=450&&y<756&&y>=745) {

                            Toast.makeText(setimagepattern.this,"Buiscit", Toast.LENGTH_SHORT).show();
                            codeString += "3";
                            count++;

                        }










                        if (codeString.length() == 4) {

                            Toast.makeText(getApplicationContext(),
                                    "now confirm password!",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(setimagepattern.this,confirmpassword.class);
                            intent.putExtra("value", codeString);
                            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.id.image);
                           // ByteArrayOutputStream stream = new ByteArrayOutputStream();
                           // bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                            //intent.putExtra("Bitmap", stream.toByteArray());
                          /*  ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                            byte[] byteArray = stream.toByteArray();
                            intent.putExtra("image",byteArray);*/

                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);



                        } else if(codeString.length() > 4)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "not more than 3!",
                                    Toast.LENGTH_SHORT).show();
                            //reset the input code
                            codeString = "";
                            // getStringCode(button.getId());
                        }




                        // Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        //intent.putExtra("value", codeString);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        //startActivity(intent);


//}


                        //   Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();






                        return false;
                    }
                });
                        break;


            case DisplayMetrics.DENSITY_XXHIGH:
            case DisplayMetrics.DENSITY_360:
            case DisplayMetrics.DENSITY_400:
            case DisplayMetrics.DENSITY_420:
               Toast.makeText(setimagepattern.this, "xxhdpi", Toast.LENGTH_SHORT).show();
                iv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View iv, MotionEvent event) {


                        float x = (int) event.getX();
                        float y = (int) event.getY();


       /*      int selectedItem= event.getAction();
                switch (selectedItem) {
                    case 0:

                        //    Toast.makeText(MainActivity.this,"phone", Toast.LENGTH_SHORT).show();
                             String msg1 = "X=" + x + "\nY=" + y;
                            codeString+=msg1;
                            count++;

                        break;

                    case 1:

                          //  Toast.makeText(MainActivity.this,"coke", Toast.LENGTH_SHORT).show();
                             String msg2 = "X=" + x + "\nY=" + y;
                            codeString+=msg2;
                            count++;

                        break;
                    case 3:

                            Toast.makeText(MainActivity.this,"skateboard", Toast.LENGTH_SHORT).show();
                             String msg3 = "X=" + x + "\nY=" + y;
                            codeString+=msg3;
                            count++;

                        break;


                    case 4:

                            Toast.makeText(MainActivity.this,"suitcase", Toast.LENGTH_SHORT).show();
                             String msg4 = "X=" + x + "\nY=" + y;
                            codeString+=msg4;
                            count++;

                        break;


                    default:
                        break;
                }*/

           /* galalxy nexus     if(x>=315&&x<=340&&y<=600&&y>=540) {
                    // tv.setText(codeString);
                    //editor.putString("user", codeString);
                    Toast.makeText(MainActivity.this, "coke", Toast.LENGTH_SHORT).show();
                    codeString += "0";

                }*/



//if(count==5) {
                        //  tv.setText(codeString);

                        //
                        if(x>=364&&x<=394&&y<=828&&y>=800) {
                            // tv.setText(codeString);
                            //editor.putString("user", codeString);
                            Toast.makeText(setimagepattern.this,"football", Toast.LENGTH_SHORT).show();
                            codeString += "0";
                            count++;



                            //editor.commit();
                        }

                        if(x>=300&&x<=324&&y<622&&y>=600){
                            //  if(x>=315&&x<=340&&y<=600&&y>=540) {

                            Toast.makeText(setimagepattern.this,"Heart", Toast.LENGTH_SHORT).show();
                            codeString += "1";
                            count++;


                        }




                        if(x>=95&&x<=109&&y<697&&y>=677) {

                            Toast.makeText(setimagepattern.this,"tire", Toast.LENGTH_SHORT).show();
                            codeString += "2";
                            count++;

                        }



                        if(x>=345&&x<=355&&y<957&&y>=945) {

                            Toast.makeText(setimagepattern.this,"gun", Toast.LENGTH_SHORT).show();
                            codeString += "3";
                            count++;

                        }










                        if (codeString.length() == 4) {

                            Toast.makeText(getApplicationContext(),
                                    "now confirm password!",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(setimagepattern.this,confirmpassword.class);
                            intent.putExtra("value", codeString);
                            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.id.image);
                            // ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            // bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                            //intent.putExtra("Bitmap", stream.toByteArray());
                          /*  ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                            byte[] byteArray = stream.toByteArray();
                            intent.putExtra("image",byteArray);*/

                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);



                        } else if(codeString.length() > 4)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "not more than 3!",
                                    Toast.LENGTH_SHORT).show();
                            //reset the input code
                            codeString = "";
                            // getStringCode(button.getId());
                        }


                        return false;
                    }
                });
                break;

            case DisplayMetrics.DENSITY_XXXHIGH:
            case DisplayMetrics.DENSITY_560:
                // XXXHDPI
                break;
        }


            }














    }



