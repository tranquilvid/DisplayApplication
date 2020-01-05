package com.ndz.displayapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by Vrindak on 3/1/20.
 */
public class SampleApplication extends Application {
    public static Context context;

    public static Context getContext() {
        return context;
    }
}
