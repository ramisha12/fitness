package np.com.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.fitness.adapter.workoutadapter;
import np.com.fitness.model.Workout;

public class start_workout  extends AppCompatActivity {

    private RecyclerView recyclerView;
    private workoutadapter workoutAdapter;
    private List<Workout> workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_workout);


        Button startWorkoutButton = findViewById(R.id.start_workout_button);
        startWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(start_workout.this, start_program.class);
                startActivity(intent);
            }});
        ImageButton backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to WorkoutActivity
                Intent intent = new Intent(start_workout.this, workoutactivity.class);
                startActivity(intent);
            }
        });


        // recyclerview lai initialize garya
        recyclerView = findViewById(R.id.raexercise);

        // Initialize Workout list
        workoutList = new ArrayList<>();
        workoutList.add(new Workout("Squat", "30s", R.drawable.butt));
        workoutList.add(new Workout("Squat", "30s", R.drawable.belly));
        workoutList.add(new Workout("Squat", "30s", R.drawable.squat));
        workoutList.add(new Workout("Squat", "30s", R.drawable.squa));
        workoutList.add(new Workout("Squat", "30s", R.drawable.pink));
        workoutList.add(new Workout("Squat", "30s", R.drawable.squat));

        // Setup Adapter
        workoutAdapter = new workoutadapter(this, workoutList);
        recyclerView.setAdapter(workoutAdapter);

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
