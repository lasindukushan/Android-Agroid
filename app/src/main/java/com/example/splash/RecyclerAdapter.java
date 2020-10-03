package com.example.splash;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String Tag = "RecyclerView";
    private Context mcontext;
    private ArrayList<PlantingShedule> sheduleList;

    public RecyclerAdapter(Context mcontext, ArrayList<PlantingShedule> sheduleList) {
        this.mcontext = mcontext;
        this.sheduleList = sheduleList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plants_shedule,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text1.setText(sheduleList.get(position).getPlantName());
        holder.text2.setText(sheduleList.get(position).getDescription());

        Glide.with(mcontext).load(sheduleList.get(position).getUrl()).into(holder.imageview);

        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), PesticideCal.class);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sheduleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //define variables
        ImageView imageview;
        TextView text1,text2;
        Button next;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //take the id s of plants_shedule.xml
            imageview = itemView.findViewById(R.id.imageview);
            text1=itemView.findViewById(R.id.title);
            text2 = itemView.findViewById(R.id.desc);
            next = itemView.findViewById(R.id.btn_next);


        }

    }



}
