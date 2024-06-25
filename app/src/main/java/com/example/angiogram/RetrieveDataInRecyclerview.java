package com.example.angiogram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.angiogram.Adapter.Angiogram1Adapter;
import com.example.angiogram.Model.Angiogram1Model;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class RetrieveDataInRecyclerview extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    RecyclerView recyclerView;
    Angiogram1Adapter angiogram1Adpter;
    Angiogram1Adapter angiogram1Adapter;
    List<Angiogram1Model> angiogram1List1;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data_in_recyclerview);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Angiogram1");
        mStorage = FirebaseStorage.getInstance();
        recyclerView = findViewById(R.id.userList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        angiogram1List1 = new ArrayList<Angiogram1Model>();
        angiogram1Adpter = new Angiogram1Adapter(RetrieveDataInRecyclerview.this, angiogram1List1);
        recyclerView.setAdapter(angiogram1Adpter);

        searchView = findViewById(R.id.searchView);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Angiogram1Model angiogram1 = snapshot.getValue(Angiogram1Model.class);
                angiogram1List1.add(angiogram1);
                angiogram1Adpter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        if (searchView != null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }

    }

    private void search(String str)
    {
        ArrayList<Angiogram1Model> myList = new ArrayList<>();
        for (Angiogram1Model object : angiogram1List1)
        {
            if (object.getUserId().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);
            }
        }
        angiogram1Adapter = new Angiogram1Adapter(this, myList);
        recyclerView.setAdapter(angiogram1Adapter);
    }
}