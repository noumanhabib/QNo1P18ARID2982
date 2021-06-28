package com.example.mobiwhat.ui.Fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiwhat.R;
import com.example.mobiwhat.ui.modelsAdapters.BrandAdapter;
import com.example.mobiwhat.ui.modelsAdapters.BrandsModel;
import com.example.mobiwhat.ui.modelsAdapters.MobileAdapter;
import com.example.mobiwhat.ui.modelsAdapters.MobileModel;

import java.util.ArrayList;

public class BrandsFragment extends Fragment {
    private static ArrayList<BrandsModel> data;
    private static RecyclerView.Adapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_brands, container, false);
        String[] nameArray = {"Samsung", "Huawei", "Oppo", "Apple", "Xiaomi","Vivo"};
        Integer[] drawableArray = {
                R.drawable.samsung, R.drawable.huawei, R.drawable.oppo,
                R.drawable.apple, R.drawable.xiaomi, R.drawable.vivo
        };

        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.brandsRecyclerView);

        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        else{
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }

        data = new ArrayList<BrandsModel>();

        for (int i = 0; i < drawableArray.length; i++) {
            data.add(new BrandsModel(
                    drawableArray[i],
                    nameArray[i]
            ));
        }

        adapter=new BrandAdapter(data);
        recyclerView.setAdapter(adapter);

        return root;
    }
}