package com.victor.material;import android.content.Intent;import android.net.Uri;import android.os.Bundle;import android.support.v7.app.ActionBar;import android.support.v7.app.AppCompatActivity;import android.support.v7.widget.Toolbar;import android.view.KeyEvent;import android.view.Menu;import android.view.MenuInflater;import android.view.MenuItem;import android.view.View;import android.widget.Toast;import com.github.clans.fab.FloatingActionButton;import com.github.clans.fab.FloatingActionMenu;public class FloatActivity extends AppCompatActivity implements View.OnClickListener{    private Toolbar toolbar;    private FloatingActionMenu mFamMenu;    private FloatingActionButton mFabScan,mFabAdd;    private boolean isFavourite;    // 收藏按钮图片    private int iconFavorite[] = {R.mipmap.ic_favorite_border_white_24dp, R.mipmap.ic_favorite_white_24dp};    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_float);        initialize();    }    private void initialize () {        toolbar = (Toolbar) findViewById(R.id.toolbar);        setSupportActionBar(toolbar);        // 返回按钮        ActionBar actionBar = getSupportActionBar();        if (actionBar != null) {            actionBar.setDisplayHomeAsUpEnabled(true);        }        setTitle("从你的全世界路过");        mFamMenu = (FloatingActionMenu) findViewById(R.id.fam_menu);        mFamMenu.setClosedOnTouchOutside(true);        mFabScan = (FloatingActionButton) findViewById(R.id.fab_scan);        mFabAdd = (FloatingActionButton) findViewById(R.id.fab_add);        mFabScan.setOnClickListener(this);        mFabAdd.setOnClickListener(this);    }    @Override    public void onClick(View v) {        switch (v.getId()) {            case R.id.fab_scan:                mFamMenu.close(true);                Toast.makeText(getApplicationContext(),"you touch scanner!",Toast.LENGTH_SHORT).show();                break;            case R.id.fab_add:                mFamMenu.close(true);                Toast.makeText(getApplicationContext(),"you touch add!",Toast.LENGTH_SHORT).show();                break;        }    }    @Override    public boolean onOptionsItemSelected(MenuItem item) {        switch (item.getItemId()) {            case android.R.id.home:                //左上角返回按钮//                startActivity(new Intent(this, MaterialActivity.class));                finish();                return true;            case R.id.action_favorite:                Toast.makeText(getApplicationContext(),"you touch favorite!",Toast.LENGTH_SHORT).show();                invalidateOptionsMenu();                return true;            case R.id.action_browser:                Intent intent = new Intent(Intent.ACTION_VIEW);                intent.setData(Uri.parse("http://www.baidu.com"));                startActivity(intent);                return true;            default:                return super.onOptionsItemSelected(item);        }    }    @Override    public boolean onCreateOptionsMenu(Menu menu) {        MenuInflater inflater = getMenuInflater();        inflater.inflate(R.menu.book_info_menu, menu);        return true;    }    @Override    public boolean onPrepareOptionsMenu(Menu menu) {        MenuItem menuItem = menu.findItem(R.id.action_favorite);        menuItem.setIcon(iconFavorite[isFavourite ? 1 : 0]);        isFavourite = !isFavourite;        return super.onPrepareOptionsMenu(menu);    }    @Override    public boolean onKeyDown(int keyCode, KeyEvent event) {        if (keyCode == KeyEvent.KEYCODE_BACK) {            finish();            return true;        } else {            return super.onKeyDown(keyCode, event);        }    }}