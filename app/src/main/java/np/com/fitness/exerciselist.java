package np.com.fitness;

import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.fitness.adapter.exerciselistadapter;
import np.com.fitness.model.exercise;

public class exerciselist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise);





        List<exercise> exerciseListMain = new ArrayList<>();
        exerciseListMain.add(new exercise("Squat", ""));
        exerciseListMain.add(new exercise("Burpees", ""));
        exerciseListMain.add(new exercise("Excercise NAme", "butt"));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));
        exerciseListMain.add(new exercise("Excercise NAme", ""));


        RecyclerView rvList = findViewById(R.id.rvexercise);

        exerciselistadapter adapter = new exerciselistadapter(this,exerciseListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);


    }
}