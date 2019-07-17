package com.github.mrbean355.android.navigation.navdrawer;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import java.util.Set;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class NavDrawerActivity_Java extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfig;
    private NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        setSupportActionBar(this.<Toolbar>findViewById(R.id.toolbar));
        drawerLayout = findViewById(R.id.drawer_layout);

        final Set<Integer> topLevelDestinations = new ArraySet<>();
        topLevelDestinations.add(R.id.nav_home);
        topLevelDestinations.add(R.id.nav_gallery);
        topLevelDestinations.add(R.id.nav_slideshow);
        topLevelDestinations.add(R.id.nav_tools);
        topLevelDestinations.add(R.id.nav_share);
        topLevelDestinations.add(R.id.nav_send);

        appBarConfig = new AppBarConfiguration.Builder(topLevelDestinations)
                .setDrawerLayout(drawerLayout)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        NavigationUI.setupWithNavController(this.<NavigationView>findViewById(R.id.nav_view), navController);
    }

    /**
     * Ask the NavController to handle "navigate up" events.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfig) || super.onSupportNavigateUp();
    }

    /**
     * Close the drawer when hardware back is pressed.
     */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
