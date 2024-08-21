package com.example.pathfit1mct.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pathfit1mct.LessonDetailFragment;
import com.example.pathfit1mct.Model.LessonModel;
import com.example.pathfit1mct.Adapters.LessonAdapter;
import com.example.pathfit1mct.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<LessonModel> lessonList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the EditText by its ID and clear focus programmatically
        EditText searchBar = view.findViewById(R.id.search_bar);
        if (searchBar != null) {
            searchBar.clearFocus();
            searchBar.setText("");
        }

        // Initialize lesson data
        initializeLessonData();

        // Setup RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LessonAdapter lessonAdapter = new LessonAdapter(lessonList, this::startLessonActivity);
        recyclerView.setAdapter(lessonAdapter);

        return view;
    }

    private void initializeLessonData() {
        lessonList = new ArrayList<>();
        lessonList.add(new LessonModel(R.string.lesson_number1, R.string.lesson1_title, R.string.lesson1_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number2, R.string.lesson2_title, R.string.lesson2_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number3, R.string.lesson3_title, R.string.lesson3_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number4, R.string.lesson4_title, R.string.lesson4_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number5, R.string.lesson5_title, R.string.lesson5_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number6, R.string.lesson6_title, R.string.lesson6_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number7, R.string.lesson7_title, R.string.lesson7_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number8, R.string.lesson8_title, R.string.lesson8_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number9, R.string.lesson9_title, R.string.lesson9_subtitle));
        lessonList.add(new LessonModel(R.string.lesson_number10, R.string.lesson10_title, R.string.lesson10_subtitle));
    }

    private void startLessonActivity(int lessonNumber) {
        Intent intent = new Intent(getActivity(), LessonDetailFragment.class);
        intent.putExtra("lesson_number", lessonNumber);
        startActivity(intent);
    }
}
