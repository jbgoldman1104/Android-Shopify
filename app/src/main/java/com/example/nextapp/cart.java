package com.example.nextapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class cart extends AppCompatActivity {
    RecyclerView rvCart ;
    RecyclerView.LayoutManager manage ;
    RecyclerView.Adapter myAdapter3 ;
    ArrayList<items> itemsArrayList;
    Context context;
    DatabaseReference database3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
       /* rvCart = findViewById(R.id.rvCart);
        rvCart.setHasFixedSize(true);
        manage = new LinearLayoutManager(this);
        rvCart.setLayoutManager(manage);
        ArrayList<items> itemsArrayList= new ArrayList<items>();
        myAdapter3 = new cart_Adapter( this,itemsArrayList);
        rvCart.setAdapter(myAdapter3);
        database3 = FirebaseDatabase.getInstance().getReference("Cart");
        database3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for ( DataSnapshot dataSnapshot : snapshot.getChildren()){
                    items item = dataSnapshot.getValue(items.class);
                    itemsArrayList.add(item);}
                myAdapter3.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
       }); */

       rvCart = findViewById(R.id.rvCart);
        rvCart.setHasFixedSize(true);
        manage = new LinearLayoutManager(this);
        rvCart.setLayoutManager(manage);
        itemsArrayList = new ArrayList<items>();
        myAdapter3 = new cart_Adapter(this , itemsArrayList );
        rvCart.setAdapter(myAdapter3);
        database3 = FirebaseDatabase.getInstance().getReference("Cart");
        database3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for ( DataSnapshot dataSnapshot : snapshot.getChildren()){
                    items item = dataSnapshot.getValue(items.class);
                    itemsArrayList.add(item);}
                myAdapter3.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
}}