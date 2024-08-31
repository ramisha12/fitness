package np.com.myfitness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import np.com.myfitness.R;

public class ConfrimPasswordActivity extends AppCompatActivity {

    private Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confrim_password);

        Update =findViewById(R.id.Update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ConfrimPasswordActivity.this, PasswordUpdated.class);
                startActivity(intent);
            }
        });

    }
}