package ipglobal.launchersuiteapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import ipglobal.launchersuiteapp.Activities.MainActivity;

/**
 * Created by oscarcid on 20/04/2017.
 */
public class LauncherSuiteApp extends Application{

    //Create Vars
    private static boolean sIsScreenLarge;
    private static float sScreenDensity;
    private static int sLongPressTimeout = 300;
    private static LauncherSuiteApp mInstance;
    private static Context context;
    private static Context contextActivity;
    public static final String TAG = "LauncherSuiteApp";

    @Override
    public void onCreate() {
        super.onCreate();
        sIsScreenLarge = getResources().getBoolean(R.bool.is_large_screen);
        sScreenDensity = getResources().getDisplayMetrics().density;

        LauncherSuiteApp.context = getApplicationContext();
        mInstance = this;
    }

    public static synchronized LauncherSuiteApp getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return context;
    }

    public static Context getActivityContext() {
        return contextActivity;
    }

    public static void setActivityContext(Context context) {
        contextActivity = context;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate(){
        System.runFinalization();
        System.gc();
        super.onTerminate();
    }




}//End Class
