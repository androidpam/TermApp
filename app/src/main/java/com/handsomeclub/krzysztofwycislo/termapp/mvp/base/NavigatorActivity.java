package com.handsomeclub.krzysztofwycislo.termapp.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.handsomeclub.krzysztofwycislo.termapp.R;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator.Navigator;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator.NavigatorListAdapter;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator.NavigatorConfiguration;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator.NavigatorItemModel;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline.TimelineActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KrzysztofWycislo on 1/7/2018.
 *
 */

public abstract class NavigatorActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.view_stub)
    FrameLayout view_stub;

    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawer;

    @BindView(R.id.navigation_menu)
    ListView list;

    private final NavigatorConfiguration.Config config = NavigatorConfiguration.getConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.navigation_activity);
        ButterKnife.bind(this);

        if(config != null) {
            initializeLayout();
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (view_stub != null) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            View stubView = inflater.inflate(layoutResID, view_stub, false);
            view_stub.addView(stubView, lp);
        }
    }

    private AdapterView.OnItemClickListener onItemClick() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                List<NavigatorItemModel> navigatorItems = config.getNavigatorItems();
                NavigatorItemModel item = navigatorItems.get(position);

                Navigator.navigateToDeclaredActivity(getApplicationContext(), item.getIntent());
            }
        };
    }

    private void initializeLayout(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<NavigatorItemModel> menuHeaders = config.getNavigatorItems();

        ListAdapter adapter = new NavigatorListAdapter(this, menuHeaders);

        list.setAdapter(adapter);
        list.setOnItemClickListener(onItemClick());
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }

        super.onBackPressed();
//        if(this.getClass() != TimelineActivity.class) {
//            Navigator.navigateToDefaultActivity(this);
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // todo nawigacja gdzie tam sie chce
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        return true;
    }
}