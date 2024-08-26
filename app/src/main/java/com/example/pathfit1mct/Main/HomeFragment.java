package com.example.pathfit1mct.Main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.pathfit1mct.Model.LessonModel;
import com.example.pathfit1mct.Adapters.LessonAdapter;
import com.example.pathfit1mct.R;
import com.example.pathfit1mct.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<LessonModel> lessonList = new ArrayList<>();
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

        LessonAdapter adapter = new LessonAdapter(lessonList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {
            switch (position) {
                case 0:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;

                case 1:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;

                case 2:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;

                case 3:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;

                case 4:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;

                case 5:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;

                case 6:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;

                case 7:
                    NavHostFragment.findNavController(HomeFragment.this)
                            .navigate(R.id.action_homeFragment_to_lessonDetailFragment);
                    break;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
