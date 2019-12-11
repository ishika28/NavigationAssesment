package com.example.navigationassesment.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationassesment.Contact;
import com.example.navigationassesment.ContactAdapter;
import com.example.navigationassesment.R;

import java.util.ArrayList;
import java.util.List;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView = root.findViewById(R.id.recyclerview);

        //creating a list of contacts to display

        List<Contact> ContactList = new ArrayList<>();

        ContactList.add(new Contact(" Name: William Mart","Contact: 9852131212",R.drawable.female));
        ContactList.add(new Contact(" Name: Jordon Lius","Contact: 9856321025",R.drawable.male));
        ContactList.add(new Contact(" Name: Tim Crooke","Contact: 9846235478",R.drawable.female));
        ContactList.add(new Contact(" Name: Minke Frankle","Contact: 9856423654",R.drawable.female));
        ContactList.add(new Contact(" Name: Stardam Kanter","Contact: 9756841230",R.drawable.noimage));



        ContactAdapter contactAdapter = new ContactAdapter(ContactList);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }
}