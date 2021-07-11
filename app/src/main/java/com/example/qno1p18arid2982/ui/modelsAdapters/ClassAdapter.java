package com.example.qno1p18arid2982.ui.modelsAdapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qno1p18arid2982.R;
import com.example.qno1p18arid2982.ui.Fragments.HomeFragment;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.CategoryHolder> {
    ArrayList categoryNames;

    HomeFragment mainFragment;

    public ClassAdapter(ArrayList categoryNames, HomeFragment f) {
        this.categoryNames = categoryNames;
        mainFragment = f;
    }


    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.single_category_item, parent, false);
        return new CategoryHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

         holder.textView.setText(categoryNames.get(position).toString());
         holder.catItem.setBackgroundColor(Color.TRANSPARENT);
         holder.catItem.setOnClickListener(v -> {
             mainFragment.onClassChange(v, categoryNames, position);
             v.setBackgroundColor(Color.rgb(33, 150, 243));
         });
    }

    @Override
    public int getItemCount() {
        return categoryNames.size();
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public MaterialCardView catItem;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            this.textView=(TextView) itemView.findViewById(R.id.categoryName);
            this.catItem = (MaterialCardView) itemView.findViewById(R.id.item);
        }
    }
}
