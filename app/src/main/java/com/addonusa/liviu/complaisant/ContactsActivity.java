package com.addonusa.liviu.complaisant;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.addonusa.liviu.complaisant.model.Contact;

public class ContactsActivity extends SingleFragmentActivity
        implements ContactsFragment.Callbacks {
    @Override
    public Fragment createFragment(int id) {
        return ContactsFragment.newInstance();
    }

    @Override
    public void onContactSelected(Contact contact) {
        // launch ContactDetailPagerActivity
        Intent intent = new Intent(this, ContactDetailPagerActivity.class);
        startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_contacts;
    }

} // end class ContactsActivity

/*
STEP 1: commit 2: the RecyclerView
----------------------------------
- created a dummy Contact class
- modified this activity so that it holds a RecyclerView
: the RecyclerView contains the contacts

STEP 2: commit 3: the ViewPager
-------------------------------
: a click on a contact will launch another activity (a ViewPager with Fragments)
  it will display the details of the contact

STEP 3: commit 4:
-------------------------------

...
 */