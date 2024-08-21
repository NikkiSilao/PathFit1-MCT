package com.example.pathfit1mct.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pathfit1mct.Model.LessonModel;
import com.example.pathfit1mct.R;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {

    private final List<LessonModel> lessonList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int lessonNumber);
    }

    public LessonAdapter(List<LessonModel> lessonList, OnItemClickListener listener) {
        this.lessonList = lessonList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_button_lesson, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        LessonModel lesson = lessonList.get(position);
        holder.bind(lesson, position);
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public class LessonViewHolder extends RecyclerView.ViewHolder {
        private final TextView lessonNumber;
        private final TextView lessonTitle;
        private final TextView lessonSubtitle;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonNumber = itemView.findViewById(R.id.lesson_number);
            lessonTitle = itemView.findViewById(R.id.lesson_title);
            lessonSubtitle = itemView.findViewById(R.id.lesson_subtitle);
        }

        public void bind(final LessonModel lesson, final int position) {
            lessonNumber.setText(lesson.getNumberResId());
            lessonTitle.setText(lesson.getTitleResId());
            lessonSubtitle.setText(lesson.getSubtitleResId());

            itemView.setOnClickListener(v -> {
                listener.onItemClick(position + 1); // Lesson numbers start from 1
            });
        }
    }
}
