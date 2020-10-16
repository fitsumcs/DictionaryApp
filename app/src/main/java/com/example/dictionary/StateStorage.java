package com.example.dictionary;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class StateStorage {



    public  static  void  saveStae(Activity activity, String key , String value)
    {
        SharedPreferences sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key,value);

        editor.commit();
    }


    public static String getState(Activity activity,String key)
    {


        SharedPreferences sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);

        String result = sharedPreferences.getString(key,null);

        return  result;

    }
}
