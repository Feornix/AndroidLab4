package com.example.androidlab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.androidlab4.databinding.ActivityMainBinding;
import com.example.androidlab4.databinding.ActivitySecondBinding;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    DatePickerDialog datePickerDialog;
    Intent resultIntent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        String userInput = getIntent().getStringExtra("userInput");
        showDatePicker();
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
            public void onDateSet(DatePicker view, int year, int month, int day) {
                resultIntent.putExtra("selectedYear", year);
                resultIntent.putExtra("selectedMonth", month);
                resultIntent.putExtra("selectedDay", day);
                setResult(Activity.RESULT_OK, resultIntent);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}