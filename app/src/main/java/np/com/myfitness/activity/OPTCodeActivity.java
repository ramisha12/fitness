package np.com.myfitness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import np.com.myfitness.R;

public class OPTCodeActivity extends AppCompatActivity {

    private Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_optcode);

        verify =findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(OPTCodeActivity.this,ConfrimPasswordActivity.class);
                startActivity(intent);
            }
        });



    }
}