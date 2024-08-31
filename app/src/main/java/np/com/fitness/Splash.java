package np.com.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import np.com.fitness.model.programs;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.imageView);

        // Optionally, perform any additional setup on the ImageView
        // For example, setting a different image resource dynamically
        // imageView.setImageResource(R.drawable.another_image);

        // Delay for a few seconds and then start the main activity


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, programslist.class);
                startActivity(i);
                finish();
            }
        },3000);

}
    }
