package com.example.nextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class total extends AppCompatActivity {
    TextView tvCost;
    ImageView ivCost;
    String Total,img;
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_total);
        tvCost=findViewById(R.id.tvCost);
        ivCost=findViewById(R.id.ivCost);
        checkout= findViewById(R.id.checkout);
        img=getIntent().getStringExtra("image").toString();
        Total=getIntent().getStringExtra("totalCost").toString();
        tvCost.setText(Total);
        if(img.equals("h1"))
        {
            ivCost.setImageResource(R.drawable.h1);


        }
        else if(img.equals("h2"))
        {
            ivCost.setImageResource(R.drawable.h2);

        }
        else if(img.equals("h3"))
        {
            ivCost.setImageResource(R.drawable.h3);

        }
        else if(img.equals("h4"))
        {
            ivCost.setImageResource(R.drawable.h4);
        }
        else if(img.equals("h5"))
        {
            ivCost.setImageResource(R.drawable.h5);
        }
        else if(img.equals("h6"))
        {
            ivCost.setImageResource(R.drawable.h6);

        }
        else if(img.equals("h7"))
        {
            ivCost.setImageResource(R.drawable.h7);

        }
        else if(img.equals("h8"))
        {
            ivCost.setImageResource(R.drawable.h8);

        }
        else if(img.equals("h10"))
        {
            ivCost.setImageResource(R.drawable.h10);


        }else if(img.equals("h11"))
        {
            ivCost.setImageResource(R.drawable.h11);

        }
        else if(img.equals("h12"))
        {
            ivCost.setImageResource(R.drawable.h12);

        }
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(total.this, "Your order will be recevived soon! ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(total.this,home.class);
                startActivity(intent);
                finish();

            }
        });



    }
}