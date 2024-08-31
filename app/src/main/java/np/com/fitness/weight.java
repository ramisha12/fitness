package np.com.fitness;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class weight extends AppCompatActivity {
    private ImageButton editWeightButton, editHeightButton, editDobButton;
    private TextView weightValue, heightValue,dateValue;  // TextView for showing weight and height values

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weight);

        // Initialize the TextViews for weight and height
        weightValue = findViewById(R.id.weightValue);
        heightValue = findViewById(R.id.heightValue);
        dateValue = findViewById(R.id.dateValue);


        // Weight button handler
        editWeightButton = findViewById(R.id.edit_weight);
        editWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWeightPickerDialog();
            }
        });

        // Height button handler
        editHeightButton = findViewById(R.id.edit_height);
        editHeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHeightPickerDialog();
            }
        });

        // Date of Birth button handler
        editDobButton = findViewById(R.id.edit_dob);
        editDobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDobPickerDialog();
            }
        });
    }

    // Function to show the weight picker dialog
    private void showWeightPickerDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.weight_picker);

        NumberPicker num1 = dialog.findViewById(R.id.num1);
        NumberPicker num2 = dialog.findViewById(R.id.num2);
        NumberPicker num3 = dialog.findViewById(R.id.num3);

        // Set default values for weight picker
        num1.setMinValue(0);
        num1.setMaxValue(9);
        num2.setMinValue(0);
        num2.setMaxValue(9);
        num3.setMinValue(0);
        num3.setMaxValue(9);

        Button saveButton = dialog.findViewById(R.id.saveButton);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);

        // Save button functionality
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = num1.getValue() * 100 + num2.getValue() * 10 + num3.getValue();
                // Update the weightValue TextView with the selected weight
                weightValue.setText(weight + " kg");
                dialog.dismiss();
            }
        });

        // Cancel button functionality
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    // Function to show the height picker dialog
    private void showHeightPickerDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.height_picker);

        NumberPicker feetPicker = dialog.findViewById(R.id.num4);
        NumberPicker inchesPicker = dialog.findViewById(R.id.num5);

        // Set default values for height picker
        feetPicker.setMinValue(3);
        feetPicker.setMaxValue(7);
        inchesPicker.setMinValue(0);
        inchesPicker.setMaxValue(11);

        Button saveButton = dialog.findViewById(R.id.saveButton);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);

        // Save button functionality
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int heightFeet = feetPicker.getValue();
                int heightInches = inchesPicker.getValue();
                // Update the heightValue TextView with the selected height
                heightValue.setText(heightFeet + "'" + heightInches + "\"");
                dialog.dismiss();
            }
        });

        // Cancel button functionality
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    // Function to show the DOB picker dialog (To be implemented)
    private void showDobPickerDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.date_picker);  // Assuming the XML layout is named dob_picker.xml

        NumberPicker dayPicker = dialog.findViewById(R.id.num7);
        NumberPicker monthPicker = dialog.findViewById(R.id.num8);
        NumberPicker yearPicker = dialog.findViewById(R.id.num9);

        // Set default values for day, month, and year pickers
        dayPicker.setMinValue(1);
        dayPicker.setMaxValue(31);
        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        yearPicker.setMinValue(1900);  // Adjust range as needed
        yearPicker.setMaxValue(2024);  // Assuming the current year

        Button saveButton = dialog.findViewById(R.id.saveButton);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);

        // Save button functionality
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dayPicker.getValue();
                int month = monthPicker.getValue();
                int year = yearPicker.getValue();
                // Update the dateValue TextView with the selected date
                dateValue.setText(day + "/" + month + "/" + year);
                dialog.dismiss();
            }
        });

        // Cancel button functionality
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
        // Implementation for DOB picker dialog


