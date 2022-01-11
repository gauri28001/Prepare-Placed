package com.appdevelopers3a.prepareplaced;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private Context context;
    private ArrayList<CourseModel> courseModelArrayList;

    public CourseAdapter(Context context, ArrayList<CourseModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public CourseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.Viewholder holder, int position) {

        CourseModel model = courseModelArrayList.get(holder.getAdapterPosition());
        holder.CourseName.setText(model.getCourse_name());
        holder.CourseRating.setText("" + model.getCourse_rating());
        holder.CourseImage.setImageResource(model.getCourse_image());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent1;
                switch (courseModelArrayList.get(holder.getAdapterPosition()).getId().toString()){
                    case "dsa":
                        intent1 = new Intent(context.getApplicationContext(),dsa_courses.class);
                        intent1.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.getApplicationContext().startActivity(intent1);
                        break;

                    case "java":
                        intent1 = new Intent(context.getApplicationContext(),java_courses.class);
                        intent1.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.getApplicationContext().startActivity(intent1);
                        break;

                    case "cpp":
                        intent1 = new Intent(context.getApplicationContext(),cpp_courses.class);
                        intent1.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.getApplicationContext().startActivity(intent1);
                        break;

                    case "dbms":
                        intent1 = new Intent(context.getApplicationContext(),dbms_courses.class);
                        intent1.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.getApplicationContext().startActivity(intent1);
                        break;

                    case "cn":
                        intent1 = new Intent(context.getApplicationContext(),cn_courses.class);
                        intent1.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.getApplicationContext().startActivity(intent1);
                        break;

                    case "os":
                        intent1 = new Intent(context.getApplicationContext(),os_courses.class);
                        intent1.addFlags(FLAG_ACTIVITY_NEW_TASK);
                        context.getApplicationContext().startActivity(intent1);
                        break;

                    default:
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView CourseImage;
        private TextView CourseName , CourseRating;
        private RelativeLayout relativeLayout;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            CourseName = itemView.findViewById(R.id.CourseName);
            CourseImage = itemView.findViewById(R.id.CourseImage);
            CourseRating = itemView.findViewById(R.id.CourseRating);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }
}
