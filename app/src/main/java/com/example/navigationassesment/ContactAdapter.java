package com.example.navigationassesment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{
    Context mcontext;
    List<Contact> ContactList;

    public ContactAdapter( List<Contact> contactList) {

        this.ContactList = contactList;
    }



    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fragment_tools,parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
Contact contact= ContactList.get(position);
holder.imgprofile.setImageResource(contact.getImageId());
holder.tvname.setText(contact.getName());
holder.tvphoneNo.setText(contact.getPhoneNo());
    }

    @Override
    public int getItemCount() {
        return ContactList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
ImageView imgprofile;
TextView tvname, tvphoneNo;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            imgprofile=itemView.findViewById(R.id.imageView);
            tvname=itemView.findViewById(R.id.tvname);
            tvphoneNo=itemView.findViewById(R.id.tvphoneNo);
        }
    }
}
