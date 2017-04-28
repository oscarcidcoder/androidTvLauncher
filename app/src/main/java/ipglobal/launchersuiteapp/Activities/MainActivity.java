package ipglobal.launchersuiteapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import ipglobal.launchersuiteapp.LauncherSuiteApp;
import ipglobal.launchersuiteapp.R;
import ipglobal.launchersuiteapp.Utils.LauncherFrame;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LauncherSuiteApp.setActivityContext(this);

        ImageView imgAllApps = (ImageView) findViewById(R.id.imbt_allapp);
        LauncherFrame imgAllApps2 = (LauncherFrame) findViewById(R.id.lout_allapp);
        ImageView imgNetflix = (ImageView) findViewById(R.id.imbt_netflix);
        LauncherFrame imgNetflix2 = (LauncherFrame) findViewById(R.id.lout_netflix);
        ImageView imgYoutube = (ImageView) findViewById(R.id.imbt_youtube);
        LauncherFrame imgYoutube2 = (LauncherFrame) findViewById(R.id.lout_youtube);
        ImageView imgSettings = (ImageView) findViewById(R.id.imbt_settings);
        LauncherFrame imgSettings2 = (LauncherFrame) findViewById(R.id.lout_settings);
        imgAllApps.setOnClickListener(this);
        imgNetflix.setOnClickListener(this);
        imgYoutube.setOnClickListener(this);
        imgSettings.setOnClickListener(this);
        imgAllApps2.setOnClickListener(this);
        imgNetflix2.setOnClickListener(this);
        imgYoutube2.setOnClickListener(this);
        imgSettings2.setOnClickListener(this);

    }


    @Override
    protected void onPause() {
        super.onPause();
        //if (this.isFinishing())
            //startActivity(new Intent(this,this.getClass()));
    }

    @Override
    public void onClick(View v) {
        Intent goTo = null;
        switch (v.getId()){
            case R.id.lout_allapp:
                goTo = new Intent(MainActivity.this,HomeScreen.class);
                break;
            case R.id.imbt_allapp:
                goTo = new Intent(MainActivity.this,HomeScreen.class);
                break;
            case R.id.imbt_netflix:
                goTo = new Intent (Intent.ACTION_VIEW);
                goTo.setClassName("com.netflix.mediaclient","com.netflix.mediaclient.ui.launch.UIWebViewActivity");
                break;
            case R.id.lout_netflix:
                goTo = new Intent (Intent.ACTION_VIEW);
                goTo.setClassName("com.netflix.mediaclient","com.netflix.mediaclient.ui.launch.UIWebViewActivity");
                break;
            case R.id.imbt_youtube:
                goTo = new Intent (Intent.ACTION_VIEW);
                goTo.setClassName("com.google.android.youtube","com.google.android.youtube.HomeActivity");
                break;
            case R.id.lout_youtube:
                goTo = new Intent (Intent.ACTION_VIEW);
                goTo.setClassName("com.google.android.youtube","com.google.android.youtube.HomeActivity");
                break;
            case R.id.imbt_settings:
                goTo = getPackageManager().getLaunchIntentForPackage("com.wyst.mboxsettings");
                break;
            case R.id.lout_settings:
                goTo = getPackageManager().getLaunchIntentForPackage("com.wyst.mboxsettings");
                break;
        }
        if (goTo!=null)
            startActivity(goTo);
    }
}
