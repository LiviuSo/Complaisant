package com.addonusa.liviu.complaisant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.addonusa.liviu.complaisant.model.Contact;
import com.addonusa.liviu.complaisant.model.TestContactsPool;

import java.util.List;

/**
 * Created by lsoco_user on 1/22/2016.
 */
public class ContactsFragment extends Fragment {

    private RecyclerView mContactsRecyclerView;
    private List<Contact> mContacts;
    private ContactAdapter mAdapter;
    private Callbacks mDetailLauncher;

    ///////////////////////////////////////////////////////////////////////////
    public static ContactsFragment newInstance() {
        return new ContactsFragment();
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        mDetailLauncher = (Callbacks)context;
//    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mDetailLauncher = (Callbacks)activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);
        mContactsRecyclerView = (RecyclerView)view.findViewById(R.id.contacts_recycler_view);
        mContactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        loadContacts();

        return view;
    }

    /**
     * Helper
     */
    private void loadContacts() {
        mContacts = TestContactsPool.getInstance().getContacts();
        if(mAdapter == null) {
            mAdapter = new ContactAdapter(mContacts);
            mContactsRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setContacts(mContacts);
            mAdapter.notifyDataSetChanged();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    private class ContactHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private TextView mTextViewContactHeader;
        private Contact mContact;

        ///////////////////////////////////////////////////////////////////////
        public ContactHolder(View itemView) {
            super(itemView);
            mTextViewContactHeader = (TextView)itemView.findViewById(R.id.textView_contact);
            itemView.setOnClickListener(this);
        }

        public void bindContact(Contact contact) {
            mContact = contact;
            mTextViewContactHeader.setText(contact.toString());
        }

        @Override
        public void onClick(View v) {
            // Launch ContactDetailActivity
            mDetailLauncher.onContactSelected(mContact);
//            Toast.makeText(getActivity(), mContact.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    private class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {
        List<Contact> mContacts;

        public ContactAdapter(List<Contact> mContacts) {
            this.mContacts = mContacts;
        }

        @Override
        public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_contact, parent, false);
            return new ContactHolder(view);
        }

        @Override
        public void onBindViewHolder(ContactHolder holder, int position) {
            Contact contact = mContacts.get(position);
            holder.bindContact(contact);
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }

        public void setContacts(List<Contact> contacts) {
            mContacts = contacts;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    public interface Callbacks {
        public void onContactSelected( Contact contact );
    }

} // end class ContactFragment
