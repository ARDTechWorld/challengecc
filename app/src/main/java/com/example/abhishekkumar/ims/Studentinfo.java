package com.example.abhishekkumar.ims;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Studentinfo extends Fragment {

    View view;

    Button btn_insertStudent,btn_createGroup,btn_insertNotice;
    public Studentinfo() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.studentinfo, container ,false);
        btn_insertNotice = (Button) view.findViewById(R.id.btn_insNotic);
        btn_createGroup = (Button) view.findViewById(R.id.btn_createGrp);
        btn_insertStudent =(Button) view.findViewById(R.id.btn_insnewSt);
        btn_createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), creategroup.class);
                startActivity(intent);
            }
        });
        btn_insertStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), addStudentForm.class);
                startActivity(intent);
            }
        });
        btn_insertNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), insertNotice.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
