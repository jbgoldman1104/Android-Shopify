package com.example.nextapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

 public class bs_Adapter extends RecyclerView.Adapter<bs_Adapter.itemViewHolder> {

    private ArrayList<items> itemslist;
    Context context;


     public bs_Adapter(Context context, ArrayList<items> itemslist) {
        this.itemslist = itemslist;
         this.context=context;

    }


    @Override
    public bs_Adapter.itemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bs_items, parent , false);
        return new itemViewHolder(v);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull  bs_Adapter.itemViewHolder holder, int position) {
        holder.itemView.setTag(itemslist.get(position));
       holder.tvdesc.setText(itemslist.get(position).getTvdesc());

        if(itemslist.get(position).getIvPref().equals("h1"))
        {
        holder.ivPref.setImageResource(R.drawable.h1);
       // holder.tvPrice.setText("60");
        }
        else if(itemslist.get(position).getIvPref().equals("h6")) {
            holder.ivPref.setImageResource(R.drawable.h6);
         //   holder.tvPrice.setText("50");
        }

        else if(itemslist.get(position).getIvPref().equals("h8"))
            {
            holder.ivPref.setImageResource(R.drawable.h8);
           //     holder.tvPrice.setText("85400");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),com.example.nextapp.description.class);
                intent.putExtra("desc",itemslist.get(position).getTvdesc());
                intent.putExtra("imageDet",itemslist.get(position).getIvPref());
             //   intent.putExtra("price",itemslist.get(position).getPrice());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemslist.size();
    }

    public class itemViewHolder extends RecyclerView.ViewHolder{
        ImageView ivPref;
        TextView tvdesc,tvPrice;

        public itemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ivPref = itemView.findViewById(R.id.ivPref);
            tvdesc =itemView.findViewById(R.id.tvdesc);
           // tvPrice=itemView.findViewById(R.id.tvPrice);


        }
    }
}
