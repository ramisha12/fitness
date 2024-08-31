package np.com.myfitness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import np.com.myfitness.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button send_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);

        send_code =findViewById(R.id.send_code);
        send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ForgetPasswordActivity.this,OPTCodeActivity.class);
                startActivity(intent);

            }
        });

    }
}