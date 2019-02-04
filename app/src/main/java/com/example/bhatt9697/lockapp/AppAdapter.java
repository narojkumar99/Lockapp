package com.example.bhatt9697.lockapp;

/**
 * Created by bhatt9697 on 2/17/2018.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class AppAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<AppList> listStorage;
    private Activity mContext;
    private SharedPreferences prefs;private SharedPreferences.Editor editor;
    public static final String MyPREFERENCES = "MyUserChoice";

    public AppAdapter(Activity context, List<AppList> customizedListView) {
        super();
        mContext = context;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;





    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return listStorage.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      final   ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.installed_app_list, parent, false);

            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.list_app_name);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.app_icon);

            listViewHolder.mAppCheckBox = ( CheckBox)convertView.findViewById(R.id.checkBox);
            listViewHolder.mTextViewHiddenPackageName = (TextView) convertView.findViewById(R.id.text_hidden_package_name);



            listViewHolder.mAppCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked) {
                        AppList app_item = new AppList(mContext);


                        String h="";
                        //	app_item.setItemChecked(true);
                        //app_item.addValueToDatabase();
                        for (int i = 0; i < listStorage.size(); i++) {
                            app_item.setTitle(listViewHolder.textInListView.getText().toString());
                            app_item.setPackageName(listViewHolder.textInListView.getText().toString());
                            //set.add(appItem.getPackageName());

                            if (((AppList) listStorage.get(i)).getItemChecked()) {
                                app_item.setPackageName(listViewHolder.mTextViewHiddenPackageName.getText().toString());








                            }


                        }

                        h+=app_item.getPackageName();


                        Toast.makeText(mContext, app_item.getPackageName(), Toast.LENGTH_SHORT).show();

                        prefs = mContext.getSharedPreferences( MyPREFERENCES, MODE_PRIVATE);
                        editor = mContext.getSharedPreferences( MyPREFERENCES, MODE_PRIVATE).edit();

                        System.out.println("Checking list while adding:"+h);
                     //   Intent intent = new Intent(mContext,lockedAdapter.class);
                        editor.putString("MyUserChoice",h);
                        editor.commit();

                        //	intent.putExtra("value",app_item.getPackageName());
                        app_item.setName( listViewHolder.textInListView.getText().toString());





                    }
                }

            });






            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        AppList app_item = (AppList) listStorage.get(position);
        listViewHolder.textInListView.setText(listStorage.get(position).getName());
        listViewHolder.imageInListView.setImageDrawable(listStorage.get(position).getIcon());
        listViewHolder.mTextViewHiddenPackageName.setText(listStorage.get(position).getPackageName());

        return convertView;
    }

    static class ViewHolder{

        TextView textInListView;
        ImageView imageInListView;
         CheckBox mAppCheckBox;
        private TextView mTextViewHiddenPackageName;
    }
}
