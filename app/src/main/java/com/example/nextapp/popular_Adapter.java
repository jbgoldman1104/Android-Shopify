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

public class popular_Adapter extends RecyclerView.Adapter<popular_Adapter.itemViewHolder2> {

   private ArrayList<items> itemslist;
   Context context;


    public popular_Adapter(Context context, ArrayList<items> itemslist) {
       this.itemslist = itemslist;
        this.context=context;

   }


   @Override
   public popular_Adapter.itemViewHolder2 onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_items, parent , false);
       return new itemViewHolder2(v);
   }

   @SuppressLint("RecyclerView")
   @Override
   public void onBindViewHolder(@NonNull  popular_Adapter.itemViewHolder2 holder, int position) {
       holder.itemView.setTag(itemslist.get(position));
      holder.tvdesc.setText(itemslist.get(position).getTvdesc());

       if(itemslist.get(position).getIvPref().equals("h2"))
       {
       holder.ivPref.setImageResource(R.drawable.h2);
          // holder.tvPricePop.setText("75");
       }
       else if(itemslist.get(position).getIvPref().equals("h7")) {
           holder.ivPref.setImageResource(R.drawable.h7);
          // holder.tvPricePop.setText("30000");
       }

       else if(itemslist.get(position).getIvPref().equals("h10"))
           {
           holder.ivPref.setImageResource(R.drawable.h10);
              // holder.tvPricePop.setText("6000");
       }

       else if(itemslist.get(position).getIvPref().equals("h11"))
       {
           holder.ivPref.setImageResource(R.drawable.h11);
        //   holder.tvPricePop.setText("4500");
       }
       else if(itemslist.get(position).getIvPref().equals("h12"))
       {
           holder.ivPref.setImageResource(R.drawable.h12);
          // holder.tvPricePop.setText("26000");
       }

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(holder.itemView.getContext(), description.class);
               intent.putExtra("desc",itemslist.get(position).getTvdesc());
               intent.putExtra("imageDet",itemslist.get(position).getIvPref());
               //intent.putExtra("price",itemslist.get(position).getPrice());

               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               holder.itemView.getContext().startActivity(intent);
           }
       });
   }

   @Override
   public int getItemCount() {
       return itemslist.size();
   }

   public class itemViewHolder2 extends RecyclerView.ViewHolder{
       ImageView ivPref;
       TextView tvdesc,tvPricePop;

       public itemViewHolder2(@NonNull @NotNull View itemView) {
           super(itemView);
           ivPref = itemView.findViewById(R.id.iv_popular);
           tvdesc =itemView.findViewById(R.id.tv_popular);
           //tvPricePop=itemView.findViewById(R.id.tvPricePop);

       }
   }
}
