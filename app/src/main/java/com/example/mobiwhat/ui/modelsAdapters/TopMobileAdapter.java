package com.example.mobiwhat.ui.modelsAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiwhat.R;

import java.util.ArrayList;

public class TopMobileAdapter extends RecyclerView.Adapter<TopMobileAdapter.TopMobileHolder>  {
    private ArrayList<TopMobileModel> dataSet;

    public TopMobileAdapter(ArrayList<TopMobileModel> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public TopMobileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_top_mobile_item, parent, false);
        TopMobileHolder holder=new TopMobileHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopMobileHolder holder, int position) {
        TextView mobileName = holder.mobName;
        TextView mobileDesc = holder.mobDesc;
        TextView mobilePrice = holder.mobPrice;

        ImageView mobileImage=holder.mobImage;

        mobileName.setText(dataSet.get(position).getName());
        mobileDesc.setText(dataSet.get(position).getDesc());
        mobilePrice.setText(String.valueOf(dataSet.get(position).getPrice()));

        mobileImage.setImageResource(dataSet.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.nav_mobile_detail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class TopMobileHolder extends RecyclerView.ViewHolder {
        TextView mobName;
        TextView mobDesc;
        ImageView mobImage;
        TextView  mobPrice;

        public TopMobileHolder(@NonNull View itemView) {
            super(itemView);

            this.mobName = (TextView) itemView.findViewById(R.id.mob_name);
            this.mobDesc = (TextView) itemView.findViewById(R.id.mob_desc);
            this.mobImage = (ImageView)itemView.findViewById(R.id.mob_image);
            this.mobPrice = (TextView) itemView.findViewById(R.id.mob_price);
        }
    }
}
