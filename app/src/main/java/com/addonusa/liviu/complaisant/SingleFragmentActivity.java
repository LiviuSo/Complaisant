package com.addonusa.liviu.complaisant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lsoco_user on 1/22/2016.
 * acvity that holds a single fragment
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment createFragment(int id);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContacts);
        if(fragment == null) {
            fragment = createFragment(R.id.fragmentContacts);
        }
        fm.beginTransaction()
                .add(R.id.fragmentContacts, fragment)
                .commit();
    }

}
