package com.example.qno1p18arid2982.ui.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qno1p18arid2982.R;
import com.example.qno1p18arid2982.ui.DBHelper.AppDatabase;
import com.example.qno1p18arid2982.ui.DBHelper.Student;
import com.example.qno1p18arid2982.ui.DBHelper.StudentDao;

public class ComparisonFragment extends Fragment implements View.OnClickListener {
    EditText editName;
    EditText editReg;
    EditText editDegree;
    EditText editSemester;
    private StudentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_comparison, container, false);
        editName = (EditText) root.findViewById(R.id.editName);
        editReg = (EditText) root.findViewById(R.id.editReg);
        editDegree = (EditText) root.findViewById(R.id.editDegree);
        editSemester = (EditText) root.findViewById(R.id.editSemester);

        Button saveBtn = (Button) root.findViewById(R.id.saveInsertDataBtn);
        saveBtn.setOnClickListener(this);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
    }

    @Override
    public void onClick(View v) {
        String name = editName.getText().toString();
        String reg = editReg.getText().toString();
        String degree = editDegree.getText().toString();
        int semester = 1;
        try {
            semester = Integer.parseInt(editSemester.getText().toString());
            if(semester < 1){
                throw new NumberFormatException();
            }
        }
        catch(Exception e){
            editSemester.setError("Please enter valid input");
            return;
        }

        if(name.length() < 2){
            editName.setError("Minimum 2 character name is required");
            return;
        }
        if(reg.length() < 8){
            editReg.setError("Minimum 8 character registration number is required");
            return;
        }
        if(degree.length() < 2){
            editDegree.setError("Minimum 2 character degree is required");
            return;
        }

        Student stu = new Student();
        stu.name = name;
        stu.regNumber = reg;
        stu.degree = degree;
        stu.semester = semester;

        try {
            AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),
                    AppDatabase.class, "studentlms").allowMainThreadQueries().build();

            StudentDao studentDao = db.studentDao();
            studentDao.insert(stu);
            viewModel.addAll(studentDao.getAll());
            Toast.makeText(getActivity(), "Date saved successfully", Toast.LENGTH_LONG).show();
            editDegree.setText("");
            editName.setText("");
            editReg.setText("");
            editSemester.setText("");

        }
        catch(Exception e){
            Log.d("ERRORDB", e.getLocalizedMessage() + e.getMessage());
            Toast.makeText(getActivity(), "Some database error occured! Try again", Toast.LENGTH_SHORT).show();
        }
    }
}