package com.addonusa.liviu.complaisant.model;

/**
 * Created by lsoco_user on 1/22/2016.
 */
public class Contact {
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    // and an UUID eventually

    public Contact(String mFirstName, String mLastName, String mEmail) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mEmail = mEmail;
    }

    public Contact() {
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(getFirstName());
        sb.append(' ');
        sb.append(getLastName());
        sb.append('\n');
        sb.append(getEmail());
        return sb.toString();
    }

} // end Contact class
