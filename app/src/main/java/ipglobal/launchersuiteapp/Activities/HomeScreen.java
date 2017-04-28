package ipglobal.launchersuiteapp.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import ipglobal.launchersuiteapp.LauncherSuiteApp;
import ipglobal.launchersuiteapp.R;

public class HomeScreen extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        LauncherSuiteApp.setActivityContext(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
