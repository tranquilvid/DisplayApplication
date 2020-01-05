package com.ndz.displayapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SharedPreferenceHelper {
    Context mCurrentContext;
    private static SharedPreferenceHelper mInstance;

    private SharedPreferenceHelper() {

        mCurrentContext = SampleApplication.getContext();
    }

    public static SharedPreferenceHelper getInstance() {
        if (mInstance == null) {
            mInstance = new SharedPreferenceHelper();
        }
        return mInstance;

    }

    public void putInt(String key, int value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt(key, value);
        edit.commit();


    }

    public int getInt(String key, int _default) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        return preferences.getInt(key, _default);

    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public boolean getBoolean(String key, boolean _default) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        return preferences.getBoolean(key, _default);

    }

    public void putString(String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public String getString(String key, String _default) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        return preferences.getString(key, _default);

    }

    public void putLong(String key, long value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putLong(key, value);
        edit.commit();


    }

    public long getLong(String key, long _default) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        return preferences.getLong(key, _default);

    }

    public void putFloat(String key, float value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putFloat(key, value);
        edit.commit();


    }

    public float getFloat(String key, float _default) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        return preferences.getFloat(key, _default);

    }

    public void clearPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCurrentContext);
        preferences.edit().clear().commit();
    }


}
