package com.example.dictionary;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;


    MenuItem menuItemSetting;

    DictonrayFragment dictonrayFragment;
    BookmarkFragment bookmarkFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dictonrayFragment = new DictonrayFragment();
        bookmarkFragment = new BookmarkFragment();

        navigateFragment(dictonrayFragment,true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();


        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menuItemSetting = menu.findItem(R.id.action_settings);

        String theId = StateStorage.getState(this,"dic_type");
        if(theId != null)
        {
            onOptionsItemSelected(menu.findItem( Integer.valueOf(theId)));
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {

        int id = menuItem.getItemId();

        StateStorage.saveStae(this,"dic_type",String.valueOf(id));

        if(id == R.id.af_to_en)
        {
          menuItemSetting.setIcon(getDrawable(R.drawable.ic_baseline_home));
        }
        if(id == R.id.en_to_af)
        {
            menuItemSetting.setIcon(getDrawable(R.drawable.ic_baseline_help));

        }
        if(id == R.id.af_to_af)
        {
            menuItemSetting.setIcon(getDrawable(R.drawable.ic_baseline_rate_review));

        }


        return  super.onOptionsItemSelected(menuItem);
    }


   //navigate to a fragment
    public void navigateFragment(Fragment fragment , boolean isTop)
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        if(!isTop)
        {
            ft.addToBackStack(null);
        }
        ft.commit();

    }


}