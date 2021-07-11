package com.example.qno1p18arid2982.ui.Fragments;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qno1p18arid2982.R;
import com.example.qno1p18arid2982.ui.DBHelper.Student;
import com.example.qno1p18arid2982.ui.modelsAdapters.ClassAdapter;
import com.example.qno1p18arid2982.ui.modelsAdapters.StudentAdapter;
import com.example.qno1p18arid2982.ui.modelsAdapters.StudentModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static ArrayList<StudentModel> data;
    private static RecyclerView.Adapter adapter;
    private StudentViewModel viewModel;
    View root;
    RecyclerView mobilesRecycle;
    TextView classTitle;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    private ArrayMap<Integer, Boolean> attendanceList;
    private Button showSummery;
    private View summery;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        if(root != null){
            return root;
        }
        root = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<String> classNames = new ArrayList<>(Arrays.asList("BSSE", "BSCS", "MSBS", "BSMT", "BSIT", "BSMS"));

        // Categories
        recyclerView = root.findViewById(R.id.catRecyclerView);

        showSummery = root.findViewById(R.id.show_summery);
        showSummery.setOnClickListener(this);
        summery = root.findViewById(R.id.summery);

        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ClassAdapter customAdapter = new ClassAdapter(classNames, this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        classTitle = root.findViewById(R.id.showcase_title);

//Mobile Recycle View

        mobilesRecycle = root.findViewById(R.id.mobilesRecyclerView);
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mobilesRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false){
                @Override
                public boolean canScrollHorizontally() {
                    return true;
                }
                @Override
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {

                    final LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {

                        @Override
                        public PointF computeScrollVectorForPosition(int targetPosition) {
                            return super.computeScrollVectorForPosition(targetPosition);
                        }

                        @Override
                        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                            return 100f / displayMetrics.densityDpi;
                        }
                    };
                    linearSmoothScroller.setTargetPosition(position);
                    startSmoothScroll(linearSmoothScroller);
                }

            });

        } else {
            mobilesRecycle.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        data = new ArrayList<StudentModel>();
        adapter = new StudentAdapter(data, this);
        mobilesRecycle.setAdapter(adapter);
        mobilesRecycle.setItemAnimator(new SlideInLeftAnimator());

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
        this.attendanceList = new ArrayMap<>();
    }

    public void onClassChange(View v, ArrayList categoryNames, int position){
        Toast.makeText(v.getContext(),"Showing students for "+categoryNames.get(position),Toast.LENGTH_SHORT).show();
        classTitle.setText(categoryNames.get(position) + " Students List");
        for(int childCount = recyclerView.getChildCount(), i = 0; i < childCount; i++){
            final RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
            if(i==position){
                continue;
            }
            if(holder.itemView.findViewById(R.id.item) != null) {
                holder.itemView.findViewById(R.id.item).setBackgroundColor(Color.TRANSPARENT);
            }
        }

        List<Student> students = viewModel.getStudentList();
        data = new ArrayList<>();
        if(students != null) {
            for (int i = 0; i < students.size(); i++) {
                if(students.get(i).degree.compareToIgnoreCase(categoryNames.get(position).toString()) == 0) {
                    data.add(new StudentModel(
                            students.get(i).uid,
                            students.get(i).name,
                            students.get(i).regNumber,
                            students.get(i).semester,
                            students.get(i).degree
                    ));
                }
            }
        }

        viewModel.setSelectedClassPos(position);
        viewModel.setTotalPresent(0);
        viewModel.setTotalAbsent(0);

        this.attendanceList.clear();

        adapter = new StudentAdapter(data, this);
        mobilesRecycle.setAdapter(adapter);
    }

    public void scrollTo(int pos){
        mobilesRecycle.smoothScrollToPosition(pos);
    }

    public void markAttendance(int position, boolean attendance){
        if(this.attendanceList.containsKey(position)){
            if(this.attendanceList.get(position) != attendance){
                this.attendanceList.put(position, attendance);
                if(attendance){
                    viewModel.setTotalPresent(viewModel.getTotalPresent() + 1);
                    viewModel.setTotalAbsent(viewModel.getTotalAbsent() - 1);
                }
                else {
                    viewModel.setTotalAbsent(viewModel.getTotalAbsent() + 1);
                    viewModel.setTotalPresent(viewModel.getTotalPresent() - 1);
                }
            }
        }
        else{
            this.attendanceList.put(position, attendance);
            if(attendance){
                viewModel.setTotalPresent(viewModel.getTotalPresent() + 1);
            }
            else {
                viewModel.setTotalAbsent(viewModel.getTotalAbsent() + 1);
            }
        }

        if(data.size() == viewModel.getTotalPresent() + viewModel.getTotalAbsent() || position == data.size() - 1){
            showSummery.setVisibility(View.VISIBLE);
        }
        else{
            showSummery.setVisibility(View.INVISIBLE);
        }
        summery.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        summery.setVisibility(View.VISIBLE);
        TextView totalStudents = (TextView) summery.findViewById(R.id.total_students);
        TextView totalAbsent = (TextView) summery.findViewById(R.id.total_absent);
        TextView totalPresent = (TextView) summery.findViewById(R.id.total_present);

        totalStudents.setText("Total students are " + data.size());
        totalPresent.setText("Total present are " + viewModel.getTotalPresent());
        totalAbsent.setText("Total absent are " + viewModel.getTotalAbsent());

    }
}