package com.addonusa.liviu.complaisant.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsoco_user on 1/22/2016.
 */
public class TestContactsPool {
    private List<Contact> mContacts;
    private static TestContactsPool mInstance;

    private TestContactsPool() {
        mContacts = new ArrayList<>();
        //todo: add dummy contacts
        mContacts.add(new Contact("Liviu", "Socolovici", "lvictor1979@gmail.com"));
        mContacts.add(new Contact("Alexa", "Socolovici", "asocolo@gmail.com"));
        mContacts.add(new Contact("John", "Dew", "jdew11@gmail.com"));
        mContacts.add(new Contact("Dean", "Trotter", "dtrotter@gmail.com"));
        mContacts.add(new Contact("Kyle", "Green", "kylegreen@gmail.com"));
        mContacts.add(new Contact("Fanny", "Reel", "reelfanny@gmail.com"));
        mContacts.add(new Contact("Elizabeta", "Muraru", "emuraru@gmail.com"));
        mContacts.add(new Contact("Govinda", "Jaya", "jgovinda@gmail.com"));

    }

    public static TestContactsPool getInstance() {
        if(mInstance == null) {
            mInstance = new TestContactsPool();
        }
        return mInstance;
    }

    public List<Contact> getContacts() {
        return mContacts;
    }

} // end class TestContactsPool
