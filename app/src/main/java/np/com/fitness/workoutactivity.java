package np.com.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class workoutactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workout);
        ImageView workoutImage1 = findViewById(R.id.workout_image_1);
        ImageView workoutImage2 = findViewById(R.id.workout_image_2);
        ImageView workoutImage3 = findViewById(R.id.workout_image_3);
        ImageView workoutImage4 = findViewById(R.id.workout_image_4);

        // Set click listeners for each ImageView
        View.OnClickListener startWorkoutListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the StartWorkoutActivity
                Intent intent = new Intent(workoutactivity.this, start_workout.class);
                startActivity(intent);
            }
        };

        // Assign the listener to each ImageView
        workoutImage1.setOnClickListener(startWorkoutListener);
        workoutImage2.setOnClickListener(startWorkoutListener);
        workoutImage3.setOnClickListener(startWorkoutListener);
        workoutImage4.setOnClickListener(startWorkoutListener);
    }
}
