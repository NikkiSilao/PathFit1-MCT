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

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonCategoryViewHolder> {

    private List<LessonModel> lessonList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public LessonAdapter(List<LessonModel> lessonList) {
        this.lessonList = lessonList;
    }



    @NonNull
    @Override
    public LessonCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_button_lesson, parent, false);
        return new LessonAdapter.LessonCategoryViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonCategoryViewHolder holder, int position) {
        LessonModel currentCategory = lessonList.get(position);
        holder.lessonNumber.setText(currentCategory.getNumberResId());  // assuming a number field exists
        holder.lessonTitle.setText(currentCategory.getTitleResId());
        holder.lessonSubtitle.setText(currentCategory.getSubtitleResId());  // assuming a subtitle field exists
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public static class LessonCategoryViewHolder extends RecyclerView.ViewHolder {

        public TextView lessonNumber;    // Add these variables to match the first code
        public TextView lessonTitle;
        public TextView lessonSubtitle;

        public LessonCategoryViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            lessonNumber = itemView.findViewById(R.id.lesson_number);    // Assuming IDs exist in layout
            lessonTitle = itemView.findViewById(R.id.lesson_title);
            lessonSubtitle = itemView.findViewById(R.id.lesson_subtitle);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
