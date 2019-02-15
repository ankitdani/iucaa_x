package com.cabalabs.iucaa_x;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.cabalabs.iucaa_x.DQR.EightFragment;
import com.cabalabs.iucaa_x.DQR.FiveFragment;
import com.cabalabs.iucaa_x.DQR.FourFragment;
import com.cabalabs.iucaa_x.DQR.TenFragment;
import com.cabalabs.iucaa_x.DQR.OneFragment;
import com.cabalabs.iucaa_x.DQR.SevenFragment;
import com.cabalabs.iucaa_x.DQR.SixFragment;
import com.cabalabs.iucaa_x.DQR.ThreeFragment;
import com.cabalabs.iucaa_x.DQR.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class FragActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);

        if(isOnline()) {
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);

            this.getSupportActionBar().hide();
        }
        else
        {
            Toast.makeText(FragActivity.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Observation Info");
        adapter.addFrag(new TwoFragment(), "Basic Stats");
        adapter.addFrag(new ThreeFragment(), "L1 Data Integrity");
        adapter.addFrag(new FourFragment(), "Data Saturation");
        adapter.addFrag(new FiveFragment(), "Noise Dominated Fraction");
        adapter.addFrag(new SixFragment(), "Top Noisy Pixels");
        adapter.addFrag(new SevenFragment(), "Detector Plane Histogram");
        adapter.addFrag(new EightFragment(), "Count Rate Plots");
        adapter.addFrag(new TenFragment(), "Housekeeping Plots");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            Log.e("POSITION",String.valueOf(mFragmentList.get(position)));
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}