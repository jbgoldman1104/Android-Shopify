package com.example.nextapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class cart_Adapter extends RecyclerView.Adapter<cart_Adapter.itemViewHolder3> {

   private ArrayList<items> itemslist;
   Context context;


    public cart_Adapter(Context context, ArrayList<items> itemslist) {
       this.itemslist = itemslist;
        this.context=context;

   }


   @Override
   public cart_Adapter.itemViewHolder3 onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list, parent , false);
       return new itemViewHolder3(v);
   }

   @SuppressLint("RecyclerView")
   @Override
   public void onBindViewHolder(@NonNull  cart_Adapter.itemViewHolder3 holder, int position) {
       holder.itemView.setTag(itemslist.get(position));
      holder.tvdesc.setText(itemslist.get(position).getTvdesc());

       if(itemslist.get(position).getIvPref().equals("h2"))
       {
       holder.ivPref.setImageResource(R.drawable.h2);
       }

       else if(itemslist.get(position).getIvPref().equals("h1")) {
           holder.ivPref.setImageResource(R.drawable.h3);

       }
       else if(itemslist.get(position).getIvPref().equals("h3")) {
           holder.ivPref.setImageResource(R.drawable.h3);
       }
       else if(itemslist.get(position).getIvPref().equals("h4")) {
           holder.ivPref.setImageResource(R.drawable.h4);
       }

       else if(itemslist.get(position).getIvPref().equals("h10"))
           {
           holder.ivPref.setImageResource(R.drawable.h10);
       }

       else if(itemslist.get(position).getIvPref().equals("h11"))
       {
           holder.ivPref.setImageResource(R.drawable.h11);
       }
       else if(itemslist.get(position).getIvPref().equals("h12"))
       {
           holder.ivPref.setImageResource(R.drawable.h12);
       }

       /*holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(holder.itemView.getContext(), description.class);
               intent.putExtra("desc",itemslist.get(position).getTvdesc());
               intent.putExtra("imageDet",itemslist.get(position).getIvPref());
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               holder.itemView.getContext().startActivity(intent);
           }
       });*/
   }

   @Override
   public int getItemCount() {
       return itemslist.size();
   }

   public class itemViewHolder3 extends RecyclerView.ViewHolder{
       ImageView ivPref;
       TextView tvdesc;
       public itemViewHolder3(@NonNull @NotNull View itemView) {
           super(itemView);
           ivPref = itemView.findViewById(R.id.ivCart);
           tvdesc =itemView.findViewById(R.id.tvCart);

       }
   }
}
