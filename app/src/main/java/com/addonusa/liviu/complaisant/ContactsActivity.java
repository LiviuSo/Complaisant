package com.addonusa.liviu.complaisant;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactsActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment(int id) {
        return ContactsFragment.newInstance();
    }
}

/*
DAY 1: commit 2: the RecyclerView
----------------------------------
- modified this activity so that it holds a RecyclerView
: the RecyclerView contains the contacts
: a click on a contact will launch another activity (a ViewPager with Fragments)
  it will display the details of the contact
- created a dummy Contact class

 */