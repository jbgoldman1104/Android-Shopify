package com.example.nextapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        com.google.android.material.textfield.TextInputLayout tfUser_, tfPass_;
        TextView tvForget_Pass, tvNew_User;
        Button btnSign_In;
        DatabaseReference referance2;
        referance2 = FirebaseDatabase.getInstance().getReference("users");

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        tfPass_ = findViewById(R.id.tfPass_);
        tfUser_ = findViewById(R.id.tfUser_);
        tvForget_Pass = findViewById(R.id.tvForget_Pass);
        btnSign_In = findViewById(R.id.btnSign_In);
        tvNew_User = findViewById(R.id.tvNew_User);


        tvForget_Pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSign_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = tfUser_.getEditText().getText().toString();
                String password = tfPass_.getEditText().getText().toString();
                if (tfPass_.getEditText().getText().toString().isEmpty() ||
                        tfUser_.getEditText().getText().toString().isEmpty()) {
                    Toast.makeText(login.this, " Enter All Fields ! ", Toast.LENGTH_SHORT).show();
                } else {
                   // Query checkUser = referance2.orderByChild("userName").equalTo(user);


                    referance2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(user)) {
                                String getPass = snapshot.child(user).child("password").getValue(String.class);
                               System.out.println(getPass);
                               // System.out.println(password);

                                if (getPass.equals(password)) {
                                    Toast.makeText(login.this, "loggd in successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(com.example.nextapp.login.this, com.example.nextapp.home.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(login.this, "wrong password", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(login.this, "username doesn't exist", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) {

                        }
                    });


                }

            }
        });

    }
    //public boolean isUser(){}

    public void signup(View view) {
        startActivity(new Intent(login.this, sign_up.class));
    }


}

