package com.twins.osama.retrofittest.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.twins.osama.retrofittest.Models.WorcipeAppItem;
import com.twins.osama.retrofittest.R;
import com.twins.osama.retrofittest.Remote.OnDrawerItemClickListener;

import java.util.ArrayList;

/**
 * Created by Osama on 9/22/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<WorcipeAppItem> item = new ArrayList<>();
    private Context context;
    private final OnDrawerItemClickListener listener;
    String URL_Image = "http://www.wsfah.com/app/worcipe/upload/";


    public MenuAdapter(Context context, ArrayList originlIitem, OnDrawerItemClickListener listener) {
        this.context = context;
        this.item = originlIitem;
        this.listener = listener;
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.temp_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder holder, final int position) {
        holder.text_main.setText(item.get(position).getCategoryName());
        if (item.get(position).getCategoryImage() != null) {
            Glide.with(context).load(URL_Image + item.get(position).getCategoryImage()).into(holder.img_hom_recview);
        }
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public void addItem(WorcipeAppItem menu) {
        item.add(menu);
        notifyItemInserted(item.size());
    }

    public void removeItem(int position) {
        item.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, item.size());
    }
    public void updateAnswers(ArrayList<WorcipeAppItem> items) {
        item = items;
        notifyDataSetChanged();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_hom_recview;
        TextView text_main;
        CardView cv;

        public ViewHolder(View view) {
            super(view);
            cv = (CardView) itemView.findViewById(R.id.cardView_home);
            img_hom_recview = (ImageView) view.findViewById(R.id.img_hom_recview);
            text_main = (TextView) view.findViewById(R.id.text_main);
        }
    }

}