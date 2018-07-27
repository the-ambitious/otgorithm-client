package com.ambit.otgorithm.views;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ambit.otgorithm.R;
import com.ambit.otgorithm.adapters.SortieViewPagerAdapter;
import com.ambit.otgorithm.fragments.PantsFragment;
import com.bumptech.glide.Glide;

public class SortieActivity extends AppCompatActivity {

    // 툴바 변수 선언
    private DrawerLayout mDrawerLayout;

    // 변수 선언
    FragmentManager fm;
    FragmentTransaction tran;
    Button btn4;
    PantsFragment pantsFragment;
    ViewPager viewPager;
    ImageView advertisement;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sortie);

        tv = (TextView) findViewById(R.id.toolbar_title);
        Toolbar galleryToolbar = (Toolbar) findViewById(R.id.toolbar_basic);
        setSupportActionBar(galleryToolbar);    // 액션바와 같게 만들어줌

        tv.setText("출격 명령");
        tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tv.setTextColor(Color.WHITE);

        // 기본 타이틀을 보여줄 지 말 지 설정
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // 뒤로가기 버튼, Default로 true만 해도 Back 버튼이 생김
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
//        actionBar.setDisplayHomeAsUpEnabled(true);

        /*ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 0);
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();*/


        SortieViewPagerAdapter pagerAdapter = new SortieViewPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout mTab = findViewById(R.id.tabs);
        mTab.setupWithViewPager(viewPager);


        advertisement = findViewById(R.id.advertisement);
        Glide.with(this).load(R.drawable.advertisement).into(advertisement);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_fragment);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_item_closet:
                        Log.d("nav test: ", "1");
                        break;

                    case R.id.nav_item_favorites:
                        Log.d("nav test: ", "2");
                        break;

                    case R.id.nav_item_letterbox:
                        Log.d("nav test: ", "31");
                        break;

                    case R.id.nav_contact_notice:
                        Log.d("nav test: ", "31");
                        break;

                    case R.id.nav_contact_commentary:
                        Log.d("nav test: ", "31");
                        break;

                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                // mDrawerLayout.openDrawer(GravityCompat.START);
                finish();
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if (intent == null) {
            intent = new Intent();
        }
        super.startActivityForResult(intent, requestCode);
    }

}
