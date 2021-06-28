package com.example.mobiwhat.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobiwhat.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class MobileDetailFragment extends Fragment {
    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3;
    Button descExpandBtn,specExpandBtn,buylinkExpandBtn;


    public MobileDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mobile_detail, container, false);
        descExpandBtn=(Button) view.findViewById(R.id.expandableButton1);
        specExpandBtn=(Button) view.findViewById(R.id.expandableButton2);
        buylinkExpandBtn=(Button) view.findViewById(R.id.expandableButton3);

        descExpandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout1);
                expandableLayout1.toggle();
            }
        });

        specExpandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout2 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout2);
                expandableLayout2.toggle();
            }
        });

        buylinkExpandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout3 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout3);
                expandableLayout3.toggle();
            }
        });
        return view;
    }
}