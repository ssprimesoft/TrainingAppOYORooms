package com.sagar.oyoroomstest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.RowHotelListLayoutBinding;
import com.sagar.oyoroomstest.delegate.OnItemClickListener;
import com.sagar.oyoroomstest.model.HotelListData;
import com.sagar.oyoroomstest.network.CustomVolleyRequest;

import java.util.List;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.MyViewHolder> {

    private final List<HotelListData> list;
    private final Context context;
    private final OnItemClickListener listener;

    public HotelListAdapter(Context context, List<HotelListData> list, OnItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_hotel_list_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.tvDescription.setText(list.get(position).getLocation());
        ImageLoader imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(list.get(position).getPoster(), ImageLoader.getImageListener(holder.binding.ivPoster, R.mipmap.ic_launcher, R.mipmap.ic_launcher));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        RowHotelListLayoutBinding binding;

        public MyViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            if (binding != null) {
                binding.cardViewHotel.setOnClickListener(v -> listener.onItemClick(v, getAdapterPosition()));
            }
        }
    }

}