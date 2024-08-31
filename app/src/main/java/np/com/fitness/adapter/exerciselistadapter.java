package np.com.fitness.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import np.com.fitness.R;
import np.com.fitness.Excercse_details;
import np.com.fitness.model.exercise;



public class exerciselistadapter extends RecyclerView.Adapter<exerciselistadapter.ExerciseListViewHolder>{

    List<exercise> exerciseList;

    Context context;

    public exerciselistadapter(Context context,List<exercise> exerciseList){
        this.exerciseList = exerciseList;

    }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ExerciseListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exerciselist,parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvExerciseName.setText(exerciseList.get(position).getName());






        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Excercse_details.class);
                intent.putExtra("name",exerciseList.get(position).getName());

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public static class ExerciseListViewHolder extends RecyclerView.ViewHolder{

        //Doctor
        TextView tvExerciseName;
        ImageView ivExercise;

        public  ExerciseListViewHolder(@NonNull View itemView) {
            super(itemView);
            //doctor
            tvExerciseName = itemView.findViewById(R.id.tvExerciseName);
            ivExercise = itemView.findViewById(R.id.ivExercise);


        }
    }
}