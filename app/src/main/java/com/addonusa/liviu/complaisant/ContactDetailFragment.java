package com.addonusa.liviu.complaisant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lsoco_user on 1/22/2016.
 */
public class ContactDetailFragment extends Fragment {

    public static ContactDetailFragment newInstance() {
        return new ContactDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_detail, container, false);
        return view;
    }

} // end ContactDetailFragment