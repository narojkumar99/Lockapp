package com.example.bhatt9697.lockapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class lockactivity extends AppCompatActivity {

    private static String MY_PREFS_NAME = "PatternLock";

    private SharedPreferences prefs;
    private static String PATTERN_KEY;
    private String codeString3 = "";
    private int count=0;
    private String codeString2;
    private SharedPreferences prefs11;private SharedPreferences.Editor editor11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockactivity);


        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

       /* byte[] byteArray = getIntent().getByteArrayExtra("image");
        final Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);*/

        ImageView iv=(ImageView) findViewById(R.id.imageView1);
      //  iv.setImageBitmap(bmp);






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
                Toast.makeText(lockactivity.this, "xhdpi", Toast.LENGTH_SHORT).show();

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
                            Toast.makeText(lockactivity.this,"football", Toast.LENGTH_SHORT).show();
                            codeString3 += "0";
                            count++;



                            //editor.commit();
                        }

                        if(x>=214&&x<=195&&y<465&&y>=445){
                            //  if(x>=315&&x<=340&&y<=600&&y>=540) {

                            Toast.makeText(lockactivity.this,"Heart", Toast.LENGTH_SHORT).show();
                            codeString3 += "1";
                            count++;


                        }




                        if(x>=50&&x<=69&&y<532&&y>=512) {

                            Toast.makeText(lockactivity.this,"tire", Toast.LENGTH_SHORT).show();
                            codeString3 += "2";
                            count++;

                        }



                        if(x>=445&&x<=450&&y<756&&y>=745) {

                            Toast.makeText(lockactivity.this,"Buiscit", Toast.LENGTH_SHORT).show();
                            codeString3 += "3";
                            count++;

                        }



                        PATTERN_KEY = prefs.getString("PatternLock","invalid");
                        if (codeString3.length() == 4){
                            if (codeString3.equals(PATTERN_KEY)) {

                                Toast.makeText(getApplicationContext(),
                                        " UNLOCKED!!!!",
                                        Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(lockactivity.this, homeactivity.class);
                               /* ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                bmp.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                                byte[] byteArray = stream.toByteArray();
                                intent.putExtra("image",byteArray);*/
                                startActivity(intent);


                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "wrong passcode!!!!",
                                        Toast.LENGTH_SHORT).show();
                                codeString3 = "";
                            }


                        }

                        else if(codeString3.length() > 4)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "password do not match!",
                                    Toast.LENGTH_SHORT).show();
                            //reset the input code
                            codeString3 = "";
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
                // XHDPI
                break;

            case DisplayMetrics.DENSITY_XXHIGH:
            case DisplayMetrics.DENSITY_360:
            case DisplayMetrics.DENSITY_400:
            case DisplayMetrics.DENSITY_420:
                //  Toast.makeText(MainActivity.this, "xxhdpi", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(lockactivity.this,"football", Toast.LENGTH_SHORT).show();
                            codeString3 += "0";
                            count++;



                            //editor.commit();
                        }

                        if(x>=300&&x<=324&&y<622&&y>=600){
                            //  if(x>=315&&x<=340&&y<=600&&y>=540) {

                            Toast.makeText(lockactivity.this,"Heart", Toast.LENGTH_SHORT).show();
                            codeString3 += "1";
                            count++;


                        }




                        if(x>=95&&x<=109&&y<697&&y>=677) {

                            Toast.makeText(lockactivity.this,"tire", Toast.LENGTH_SHORT).show();
                            codeString3 += "2";
                            count++;

                        }



                        if(x>=345&&x<=355&&y<957&&y>=945) {

                            Toast.makeText(lockactivity.this,"gun", Toast.LENGTH_SHORT).show();
                            codeString3 += "3";
                            count++;

                        }



                        PATTERN_KEY = prefs.getString("PatternLock","invalid");
                        if (codeString3.length() == 4){
                            if (codeString3.equals(PATTERN_KEY)) {

                                Toast.makeText(getApplicationContext(),
                                        " UNLOCKED!!!!",
                                        Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(lockactivity.this, homeactivity.class);
                               /* ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                bmp.compress(Bitmap.CompressFormat.JPEG, 50, stream);
                                byte[] byteArray = stream.toByteArray();
                                intent.putExtra("image",byteArray);*/
                                startActivity(intent);


                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "wrong passcode!!!!",
                                        Toast.LENGTH_SHORT).show();
                                codeString3 = "";
                            }


                        }

                        else if(codeString3.length() > 4)
                        {
                            Toast.makeText(getApplicationContext(),
                                    "password do not match!",
                                    Toast.LENGTH_SHORT).show();
                            //reset the input code
                            codeString3 = "";
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

            case DisplayMetrics.DENSITY_XXXHIGH:
            case DisplayMetrics.DENSITY_560:
                // XXXHDPI
                break;
        }



            }

        }




