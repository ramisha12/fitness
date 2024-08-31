package np.com.fitness;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class start_program extends AppCompatActivity {




    private CircularProgressIndicator circularProgressBar;
    private TextView timerText;
    private ImageView pauseButton;
    private ImageView quitButton;  // Assuming the quit button is imageView5
    private CountDownTimer countDownTimer;
    private boolean isPaused = false;
    private long timeRemaining = 60000;  // 60 seconds in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_program);


//next page ma jana lai
        ImageView imageView23 = findViewById(R.id.imageView23);
        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(start_program.this, squat.class);
                startActivity(intent);
            }
        });
        circularProgressBar = findViewById(R.id.circularProgressBar);
        timerText = findViewById(R.id.timerText);
        pauseButton = findViewById(R.id.imageView15);
        quitButton = findViewById(R.id.imageView5);  // Reference to your quit ImageView

        startCountdownTimer();

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPaused) {
                    // Resume the timer
                    startCountdownTimer();
                    pauseButton.setImageResource(android.R.drawable.ic_media_pause);
                    isPaused = false;
                } else {
                    // Pause the timer
                    pauseTimer();
                    pauseButton.setImageResource(android.R.drawable.ic_media_play); // Change icon to play
                    isPaused = true;
                }
            }
        });

        // Handle the quit button click to show the popup
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showQuitDialog();  // Show the quit confirmation popup
            }
        });
    }

    private void startCountdownTimer() {
        countDownTimer = new CountDownTimer(timeRemaining, 1000) {  // Start with the remaining time

            public void onTick(long millisUntilFinished) {
                timeRemaining = millisUntilFinished;
                int secondsRemaining = (int) millisUntilFinished / 1000;

                // Update the circular progress and text
                circularProgressBar.setProgress(secondsRemaining);
                timerText.setText(String.valueOf(secondsRemaining));
            }

            public void onFinish() {
                // Reset progress and display 0
                circularProgressBar.setProgress(0);
                timerText.setText("0");
            }
        }.start();
    }

    private void pauseTimer() {
        countDownTimer.cancel();  // Cancel the current timer
    }

    //cancel garni wala
    private void showQuitDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Are you sure you want to quit?")
                .setMessage("Finishing is always better than quitting.")
                .setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();  // Quit the activity
                    }
                })
                .setNegativeButton("CANCEL", null)  // Simply dismiss the dialog
                .show();
    }

}
