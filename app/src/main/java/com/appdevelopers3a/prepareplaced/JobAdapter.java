package com.appdevelopers3a.prepareplaced;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.CourseViewHolder> {

    List<JobModel> course_List ;

    private Context context ;

    public JobAdapter(List<JobModel> courseList , Context context ) {

        course_List = courseList;
        this.context = context;

    }

    @NonNull
    @Override
    public JobAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem,parent,false);
        CourseViewHolder courseViewHolder = new CourseViewHolder(view);
        return courseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JobAdapter.CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {

         holder.courseImage.setImageResource(course_List.get(position).imageId);
          holder.course.setText(course_List.get(position).name);
         holder.courseDesc.setText(course_List.get(position).description);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext() , WebView.class);
                intent.putExtra("url",course_List.get(position).url);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return course_List.size(); }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

         TextView course , courseDesc ;
         ImageView courseImage ;
        Button button ;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            course = itemView.findViewById(R.id.courseName);
           courseDesc = itemView.findViewById(R.id.courseDesc);
           courseImage = itemView.findViewById(R.id.courseImg);
            button = itemView.findViewById(R.id.viewMore);



        }
    }
}
