package com.example.qno1p18arid2982.ui.modelsAdapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qno1p18arid2982.R;
import com.example.qno1p18arid2982.ui.Fragments.HomeFragment;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MobileHolder> {

    private ArrayList<StudentModel> dataSet;
    HomeFragment mainFragment;

    public StudentAdapter(ArrayList<StudentModel> dataSet, HomeFragment f) {
        this.dataSet = dataSet;
        mainFragment = f;
    }

    @NonNull
    @Override
    public MobileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_mobile_item, parent, false);
        MobileHolder holder = new MobileHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MobileHolder holder, int position) {
        TextView studentName = holder.studentName;
        TextView  studentReg = holder.studentReg;
        TextView studentSemester = holder.studentSemester;
        Button presentBtn = holder.presentBtn;
        Button absentBtn = holder.absentBtn;
        studentName.setText(dataSet.get(position).getName());
        studentReg.setText(dataSet.get(position).getRegNumber());
        studentSemester.setText(String.valueOf(dataSet.get(position).getSemester()));

        presentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentBtn.setBackgroundColor(Color.rgb(3, 169,244));
                absentBtn.setBackgroundColor(Color.TRANSPARENT);
                mainFragment.scrollTo(position + 1);
                mainFragment.markAttendance(position, true);
            }
        });
        absentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                absentBtn.setBackgroundColor(Color.rgb(230, 0,0));
                presentBtn.setBackgroundColor(Color.TRANSPARENT);
                mainFragment.scrollTo(position + 1);
                mainFragment.markAttendance(position, false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MobileHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        TextView  studentReg;
        TextView studentSemester;
        Button presentBtn;
        Button absentBtn;

        public MobileHolder(@NonNull View itemView) {
            super(itemView);
            this.studentName = (TextView) itemView.findViewById(R.id.student_name);
            this.studentReg = (TextView) itemView.findViewById(R.id.student_reg);
            this.studentSemester = (TextView) itemView.findViewById(R.id.student_smester);
            this.presentBtn = (Button) itemView.findViewById(R.id.mark_present_btn);
            this.absentBtn = (Button) itemView.findViewById(R.id.mark_absent_btn);
        }
    }
}
