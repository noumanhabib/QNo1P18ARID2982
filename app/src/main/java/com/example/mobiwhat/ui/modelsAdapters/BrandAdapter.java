package com.example.mobiwhat.ui.modelsAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiwhat.R;

import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.BrandHolder> {
    private ArrayList<BrandsModel> dataSet;

    public BrandAdapter(ArrayList<BrandsModel> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public BrandAdapter.BrandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_brand_layout, parent, false);
        BrandHolder holder=new BrandHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrandAdapter.BrandHolder holder, int position) {
        holder.bImage.setImageResource(dataSet.get(position).getImage());
        holder.bName.setText(String.valueOf(dataSet.get(position).getName()));

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class BrandHolder extends RecyclerView.ViewHolder{
        TextView bName;
        ImageView bImage;


        public BrandHolder(@NonNull View itemView) {
            super(itemView);
            this.bName=(TextView) itemView.findViewById(R.id.t1);
            this.bImage=(ImageView) itemView.findViewById(R.id.img1);

        }

    }
}
