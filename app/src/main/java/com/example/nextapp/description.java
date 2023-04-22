package com.example.nextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class description extends AppCompatActivity {
    ImageView iv_,plus,minus;
    TextView tv_desc , tvPriceDesc,tvCounter;
    Button btBuy;
    String image,desc,howMeny;
    int quantaty=0,counter=0;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_description);
        iv_ = findViewById(R.id.iv_);
        tv_desc = findViewById(R.id.tv_desc);
        tvPriceDesc = findViewById(R.id.tvPriceDesc);
        tvCounter=findViewById(R.id.tvCounter);
        btBuy = findViewById(R.id.btBuy);
        plus=findViewById(R.id.pluse);
        minus=findViewById(R.id.minus);
        desc=getIntent().getStringExtra("desc").toString();
        tv_desc.setText(desc);

        image=getIntent().getStringExtra("imageDet").toString();
        if(image.equals("h1"))
        {
            iv_.setImageResource(R.drawable.h1);
            tvPriceDesc.setText("60");

        }
        else if(image.equals("h2"))
        {
            iv_.setImageResource(R.drawable.h2);
            tvPriceDesc.setText("75");
        }
        else if(image.equals("h3"))
        {
            iv_.setImageResource(R.drawable.h3);
            tvPriceDesc.setText("60");
        }
        else if(image.equals("h4"))
        {
            iv_.setImageResource(R.drawable.h4);
        }
        else if(image.equals("h5"))
        {
            iv_.setImageResource(R.drawable.h5);
        }
        else if(image.equals("h6"))
        {
            iv_.setImageResource(R.drawable.h6);
            tvPriceDesc.setText("50");
        }
        else if(image.equals("h7"))
        {
            iv_.setImageResource(R.drawable.h7);
            tvPriceDesc.setText("30000");
        }
        else if(image.equals("h8"))
        {
            iv_.setImageResource(R.drawable.h8);
            tvPriceDesc.setText("85400");
        }
        else if(image.equals("h10"))
        {
            iv_.setImageResource(R.drawable.h10);
            tvPriceDesc.setText("6000");

        }else if(image.equals("h11"))
        {
            iv_.setImageResource(R.drawable.h11);
            tvPriceDesc.setText("4500");
        }
        else if(image.equals("h12"))
        {
            iv_.setImageResource(R.drawable.h12);
            tvPriceDesc.setText("26000 ");
        }

    plus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(counter<20)
            {
                counter++;
                tvCounter.setText(String.valueOf(counter));
            }
            quantaty+=Integer.parseInt(tvPriceDesc.getText().toString());
            howMeny= String.valueOf(quantaty);


        }
    });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter<20)
                {
                    counter--;
                    tvCounter.setText(String.valueOf(counter));
                }

                quantaty-=Integer.parseInt(tvPriceDesc.getText().toString());
                howMeny= String.valueOf(quantaty);

            }
        });
        btBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(description.this,com.example.nextapp.total.class);
                intent.putExtra("image",image);
                intent.putExtra("totalCost",howMeny);
                startActivity(intent);
                finish();
            }
        });
    }
}