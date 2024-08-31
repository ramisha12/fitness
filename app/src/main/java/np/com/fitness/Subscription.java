package np.com.fitness;
import android.view.View;
import android.widget.ImageView;

import android.app.Dialog;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Subscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subscription);
        ImageView imageView30 = findViewById(R.id.imageView30);
        imageView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the dialog
                Dialog dialog = new Dialog(Subscription.this);
                dialog.setContentView(R.layout.subscripe_dialog);
                dialog.show();
            }
        });
    }
}


