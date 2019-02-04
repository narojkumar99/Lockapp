package com.example.bhatt9697.lockapp.services;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.gesture.Gesture;
import android.os.Build;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.bhatt9697.lockapp.Gesture2;
import com.example.bhatt9697.lockapp.GestureActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TimerTask;
import java.util.TreeMap;

import static android.content.Context.MODE_PRIVATE;

public class AppLockTimerTask extends TimerTask {
	public static final String TAG = "AppLockTimerTask";
	private Context mContext;
	String testPackageName;
	private SharedPreferences prefs;private SharedPreferences.Editor editor;
	public static final String MyPREFERENCES = "MyUserChoice";
	String testClassName = "com.android.contacts.activities.PeopleActivity";
	private static final String DATABASE_TABLE = "ProtectedApplications";
	private SQLiteDatabase mDatabase;
	ArrayList<String> selectedItems = new ArrayList<String>();
	private ArrayList<Object> mItemList;




	private ActivityManager mActivityManager;

	public AppLockTimerTask(Context context) {
		mContext = context;
		mActivityManager = (ActivityManager) mContext
				.getSystemService("Context.ACTIVITY_SERVICE");
		Toast.makeText(mContext, "TimerTask", Toast.LENGTH_SHORT).show();
		prefs = mContext.getSharedPreferences( MyPREFERENCES, MODE_PRIVATE);
		testPackageName="";
		testPackageName =prefs.getString("MyUserChoice","");
		System.out.println("testpackageName is: "+ testPackageName);



	}





	/*private void LoadSelections() {
// if the selections were previously saved load them

		ApplicationItem app_item = new ApplicationItem(mContext);


		selectedItems.addAll(Arrays.asList(savedItems.split(",")));


		String check="";
		for (int i = 0; i < mItemList.size(); i++) {
			 ImageView mImgViewHolder;
			 TextView mTextViewTitle;
			 CheckBox mAppCheckBox;
			 TextView mTextViewHiddenPackageName;



			app_item.setTitle(mHolder.mTextViewTitle.getText().toString());
			app_item.setPackageName(mHolder.mTextViewHiddenPackageName.getText().toString());
			//set.add(appItem.getPackageName());

			if (((ApplicationItem) mItemList.get(i)).getItemChecked()) {

				app_item.setPackageName(mHolder.mTextViewHiddenPackageName.getText().toString());
				check+=app_item.getPackageName();



			}
			if (selectedItems.contains(check)) {

			} else {

			}

		}

	}*/
	@Override
	public void run() {


		// TODO Auto-generated method stub

//		ComponentName topActivity = mActivityManager.getRunningTasks(1).get(0).topActivity;
		String packageName ="";
		String className ="";

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			packageName = getTopActivtyFromLolipopOnwards();
			//className= getTopActivtyFromLolipopOnwards();;
		}

		//for debug
		//Log.v(TAG, "packageName: " + packageName);
		//System.out.println("packageName is: "+ packageName);
		//Log.v(TAG, "\nclassName: " + className);
		//System.out.println("className is: " + className);


		if (testPackageName.equals(packageName)
				) {
			//Intent intent = new Intent();
			Intent intent = new Intent(mContext,Gesture2.class);
		//	intent.setClassName("com.example.bhatt9697.lockapp",
		//		"com.example.bhatt9697.lockapp.Gesture2");
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mContext.startActivity(intent);
		}
		if (packageName.equals("com.example.bhatt9697.lockapp")){



		}

	}


	String  getTopActivtyFromLolipopOnwards() {
		String topPackageName="";
		String classname="";
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			UsageStatsManager mUsageStatsManager = (UsageStatsManager) mContext.getSystemService(Context.USAGE_STATS_SERVICE);
			long time = System.currentTimeMillis();
			// We get usage stats for the last 10 seconds
			List< UsageStats > appList = mUsageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, time - 1000 * 10, time);
			// Sort the stats by the last time used
			if (appList != null) {
				SortedMap< Long, UsageStats > mySortedMap = new TreeMap< Long, UsageStats >();
				for (UsageStats usageStats: appList) {
					mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
				}
				if (mySortedMap != null && !mySortedMap.isEmpty()) {
					topPackageName = mySortedMap.get(mySortedMap.lastKey()).getPackageName();
					//classname=mySortedMap.get(mySortedMap.lastKey()).getTotalTimeInForeground();

					Log.e("TopPackage Name", topPackageName);
				}
			}
		}
		return topPackageName;
	}


}
