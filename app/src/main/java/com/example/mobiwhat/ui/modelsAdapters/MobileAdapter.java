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
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MobileHolder> {

    private ArrayList<MobileModel> dataSet;

    public MobileAdapter(ArrayList<MobileModel> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public MobileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_mobile_item, parent, false);
        MobileHolder holder=new MobileHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MobileHolder holder, int position) {
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

    public class MobileHolder extends RecyclerView.ViewHolder {
        TextView mobName;
        TextView mobDesc;
        ImageView mobImage;
        TextView  mobPrice;

        public MobileHolder(@NonNull View itemView) {
            super(itemView);
            this.mobName = (TextView) itemView.findViewById(R.id.mob_name);
            this.mobDesc = (TextView) itemView.findViewById(R.id.mob_desc);

            this.mobImage = (ImageView)itemView.findViewById(R.id.mob_image);
            this.mobPrice = (TextView) itemView.findViewById(R.id.mob_price);

        }
    }
}
