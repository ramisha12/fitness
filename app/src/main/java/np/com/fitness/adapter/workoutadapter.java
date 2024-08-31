
package np.com.fitness.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.fitness.R;
import np.com.fitness.model.Workout;

public class workoutadapter extends RecyclerView.Adapter<workoutadapter.WorkoutViewHolder> {

    private List<Workout> workoutList;
    private Context context;

    public workoutadapter(Context context, List<Workout> workoutList) {
        this.context = context;
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public workoutadapter.WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new WorkoutViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_item,parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout workout = workoutList.get(position);
        holder.exerciseName.setText(workout.getName());
        holder.duration.setText(workout.getDuration());
        holder.exerciseImage.setImageResource(workout.getImageResId());
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        ImageView exerciseImage;
        TextView exerciseName;
        TextView duration;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseImage = itemView.findViewById(R.id.vExercise);
            exerciseName = itemView.findViewById(R.id.vExerciseName);
            duration = itemView.findViewById(R.id.v30second);
        }
    }
}
