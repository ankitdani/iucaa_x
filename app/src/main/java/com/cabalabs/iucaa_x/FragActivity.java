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
import com.cabalabs.iucaa_x.DQR.QuadPropFragment;
import com.cabalabs.iucaa_x.DQR.TenFragment;
import com.cabalabs.iucaa_x.DQR.OneFragment;
import com.cabalabs.iucaa_x.DQR.SevenFragment;
import com.cabalabs.iucaa_x.DQR.SixFragment;
import com.cabalabs.iucaa_x.DQR.ThreeFragment;
import com.cabalabs.iucaa_x.DQR.TwoFragment;

import java.util.ArrayList;
import java.util.List;


/***
 * This Activity is used to control the fragments used to fetch the Astrosat DQRs
 */
public class FragActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);


        /***
         * Checks if the phone has active Internet Connection
         * If yes then setup the view Pager
         * else show a toast of No connection
         */
        if(isOnline()) {
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);

            //To hide Tool Bar
            this.getSupportActionBar().hide();
        }
        else
        {
            Toast.makeText(FragActivity.this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
        }
    }


    /***
     * Checks the Internet Connection and returns the status of connectivity
     * @return True if the Device has an active Internet connection
     */
    public boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }


    /**
     * Function is used to set up the fragments to be used to display the DQR parametrs
     * @param viewPager object to be set for each page(fragments)
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Observation Info");
        adapter.addFrag(new TwoFragment(), "Basic Stats");
        adapter.addFrag(new ThreeFragment(), "L1 Data Integrity");
        adapter.addFrag(new FourFragment(), "Data Saturation");
        adapter.addFrag(new FiveFragment(), "Noise Dominated Fraction");
        adapter.addFrag(new SixFragment(), "Top Noisy Pixels");
        adapter.addFrag(new QuadPropFragment(), "Top Noisy Pixels - Quadrant");
        adapter.addFrag(new SevenFragment(), "Detector Plane Histogram");
        adapter.addFrag(new EightFragment(), "Count Rate Plots");
        adapter.addFrag(new TenFragment(), "Housekeeping Plots");
        viewPager.setAdapter(adapter);
    }

    /**
     * Contains the Properties of the View Pager Adapter to set Up new Fragments
     */

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        /***
         * Finds out the  Fragment From the Selected Position
         * @param position selected position
         * @return Selected fragment is returned
         */
        @Override
        public Fragment getItem(int position) {
            Log.e("POSITION",String.valueOf(mFragmentList.get(position)));
            return mFragmentList.get(position);
        }

        /**
         * Getting the count of the total fragments
         * @return
         */

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        /**
         * Adds the fragment to the list
         * @param fragment Contains the Fragment to be added
         * @param title Contains the title of the Fragment
         */

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