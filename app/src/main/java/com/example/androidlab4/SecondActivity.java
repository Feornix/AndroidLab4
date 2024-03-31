package com.example.androidlab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.androidlab4.databinding.ActivityMainBinding;
import com.example.androidlab4.databinding.ActivitySecondBinding;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        String userInput = getIntent().getStringExtra("userInput");
        showDatePicker();
        binding.textView.setText(userInput);
        View view = binding.getRoot();
        setContentView(view);
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Обработка выбранной даты
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}