package com.addonusa.liviu.complaisant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    ///////////////////////////////////////////////////////////////////////////
    public static ContactsFragment newInstance() {
        return new ContactsFragment();
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
    private class ContactHolder extends RecyclerView.ViewHolder {
        TextView mTextViewContactHeader;

        public ContactHolder(View itemView) {
            super(itemView);
            mTextViewContactHeader = (TextView)itemView.findViewById(R.id.textView_contact);
        }

        public void bindContact(Contact contact) {
            mTextViewContactHeader.setText(contact.toString());
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

} // end class ContactFragment
