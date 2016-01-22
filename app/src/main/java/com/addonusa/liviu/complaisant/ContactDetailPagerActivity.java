package com.addonusa.liviu.complaisant;

import android.support.v4.app.Fragment;

/**
 * Created by lsoco_user on 1/22/2016.
 */
public class ContactDetailPagerActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment(int id) {
        return ContactDetailFragment.newInstance();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contacts;
    }

} // end class ContactDetailPagerActivity
