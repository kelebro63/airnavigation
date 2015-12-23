package com.example.airnavigate.Views.Main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.airnavigate.Modules.MainActivityModule;
import com.example.airnavigate.MyApplication;
import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseActivity;
import com.example.airnavigate.Views.Drawer.DrawerNavigator;
import com.example.airnavigate.Views.Drawer.NavDrawerFragment;
import com.example.airnavigate.Views.Drawer.NavigationConstants;

public class MainActivity extends BaseActivity implements DrawerNavigator
{

    NavDrawerFragment drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setupActivityComponent();
        drawer = (NavDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.drawer);
        if (savedInstanceState == null) {
            int initialId = getIntent().getIntExtra("initialId", NavigationConstants.DRAWER_NEWS);
            //noinspection ResourceType
            drawer.openItem(initialId);
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setupActivityComponent() {
        //Uncomment those lines do measure dependencies creation time
        //Debug.startMethodTracing("SplashTrace");
        MyApplication.get(this)
                .getAppComponent()
                .initMainActivityComponent(new MainActivityModule(this))
                .inject(this);
        //Debug.stopMethodTracing();
    }


    @Override
    public void navigateTo(@NavigationConstants.MenuItemId int menuItemId) {
        String test = "";
    }
}
