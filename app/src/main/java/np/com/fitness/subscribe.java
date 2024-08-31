package np.com.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class subscribe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.subscribe);
        Button tickButton = findViewById(R.id.tick);

        // Set an onClick listener
        tickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a popup dialog
                new AlertDialog.Builder(subscribe.this)
                        .setTitle("Purchase Confirmation")
                        .setMessage("Are you sure you want to purchase the workout plans?")
                        .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                            // Show a toast message upon confirmation
                            Toast.makeText(subscribe.this, "You have successfully purchased workout plans", Toast.LENGTH_LONG).show();

                            // After displaying the toast, start a new activity
                            // The delay is introduced using a Handler so that the Toast is displayed for the correct duration before navigating away.
                            tickButton.postDelayed(() -> {
                                // Navigate to the next page (Replace NextActivity.class with your desired class)
                                Intent intent = new Intent(subscribe.this, weight.class);
                                startActivity(intent);
                                finish(); // Optionally finish the current activity if you don't want to return to it
                            }, Toast.LENGTH_LONG); // Use the duration of the Toast as the delay
                        })
                        .setNegativeButton(android.R.string.cancel, null)
                        .show();
            }
        });
    }
}
