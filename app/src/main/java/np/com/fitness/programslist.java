package np.com.fitness;

import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.fitness.adapter.exerciselistadapter;
import np.com.fitness.adapter.programsadapter;
import np.com.fitness.model.exercise;
import np.com.fitness.model.programs;

public class programslist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_programs);



        // Initialize the data
        List<programs> programList = new ArrayList<>();
        programList.add(new programs(R.drawable.butt, "smaller waist and thigh"));
        programList.add(new programs(R.drawable.butt, "Thick Thigh"));
        programList.add(new programs(R.drawable.belly, "Program 3"));
        // Add more programs as needed
        // Initialize RecyclerView
        RecyclerView programsRecyclerView = findViewById(R.id.rprograms);
        programsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set the adapter
        programsadapter adapter = new programsadapter(this, programList);
        programsRecyclerView.setAdapter(adapter);
    }
}