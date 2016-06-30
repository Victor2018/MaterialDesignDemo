package com.victor.material;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class MaterialActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private FloatingActionMenu mFamMenu;
    private FloatingActionButton mFabScan,mFabAdd;

    private boolean isFavourite;
    // 收藏按钮图片
    private int iconFavorite[] = {R.mipmap.ic_favorite_border_white_24dp, R.mipmap.ic_favorite_white_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        initialize();
    }

    private void initialize () {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("从你的全世界路过");
        mFamMenu = (FloatingActionMenu) findViewById(R.id.fam_menu);
        mFamMenu.setClosedOnTouchOutside(true);
        mFabScan = (FloatingActionButton) findViewById(R.id.fab_scan);
        mFabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        mFabScan.setOnClickListener(this);
        mFabAdd.setOnClickListener(this);

        // 左上角 Menu 按钮
        drawer = (DrawerLayout) findViewById(R.id.dl_menu);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // 菜单
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_scan:
                mFamMenu.close(true);
                Toast.makeText(getApplicationContext(),"you touch scanner!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_add:
                mFamMenu.close(true);
                Toast.makeText(getApplicationContext(),"you touch add!",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_scanner:
                startActivity(new Intent(MaterialActivity.this,FloatActivity.class));
                break;
            case R.id.nav_search:
                break;
            case R.id.nav_add:
                break;
            case R.id.nav_about:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
