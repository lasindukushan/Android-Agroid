package com.example.splash;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static Context mContext;
    private List<marketprice> mData;

    public RecyclerViewAdapter(Context mContext, List<marketprice> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_vege.setText(mData.get(position).getName());
        holder.rs.setText(String.valueOf(mData.get(position).getPrice()));
        holder.img.setImageResource(mData.get(position).getThumb());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,earn.class);
                intent.putExtra("Price",String.valueOf(mData.get(position).getPrice()));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_vege,rs;
        ImageView img;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);

            tv_vege = (TextView) itemView.findViewById(R.id.vege);
            rs = (TextView) itemView.findViewById(R.id.rs);
            img = (ImageView) itemView.findViewById(R.id.img);
            /*Button btn = (Button) itemView.findViewById(R.id.btn);*/
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }


}
