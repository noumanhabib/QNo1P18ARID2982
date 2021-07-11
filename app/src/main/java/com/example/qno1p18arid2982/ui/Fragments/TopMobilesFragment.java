package com.example.qno1p18arid2982.ui.Fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qno1p18arid2982.R;
import com.example.qno1p18arid2982.ui.modelsAdapters.TopMobileAdapter;
import com.example.qno1p18arid2982.ui.modelsAdapters.TopMobileModel;

import java.util.ArrayList;

public class TopMobilesFragment extends Fragment {

    private static ArrayList<TopMobileModel> data;
    private static RecyclerView.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mobiles, container, false);
        String[] nameArray = {"IPhone 12 Pro", "Itel S15 Pro", "Lenovo K8 Note", "LG G8S", "Motorola Moto", "Xiaomi Redmi Note 9", "Nokia 7 Plus","One Plus Pro", "Oppo A15", "Samsung S20", "Sony Xperia2","Vivo X60 Pro"};
        String[] descArray = {
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
        };

        Integer[] drawableArray = {
                R.drawable.iphone12, R.drawable.itel, R.drawable.lenovo,
                R.drawable.lg, R.drawable.motorola, R.drawable.xiaomiredmi,
                R.drawable.nokia7plus, R.drawable.onepluspro, R.drawable.oppoa15,
                R.drawable.samsungs20, R.drawable.sonyxperia2, R.drawable.vivopro
        };

        Integer[] priceArray = {
                100,300,200,400,600,700,100,300,200,400,600,700
        };

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.MobRecyclerView);

        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        }
        else{
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }

        data = new ArrayList<TopMobileModel>();

        for (int i = 0; i < priceArray.length; i++) {
            data.add(new TopMobileModel(
                    drawableArray[i],
                    nameArray[i],
                    descArray[i],
                    priceArray[i]
            ));
        }
        adapter=new TopMobileAdapter(data);
        recyclerView.setAdapter(adapter);
        return root;
    }
}