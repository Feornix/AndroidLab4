package com.example.androidlab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.androidlab4.databinding.ActivityMainBinding;
import com.example.androidlab4.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        String userInput = getIntent().getStringExtra("userInput");
        binding.textView.setText(userInput);
        View view = binding.getRoot();
        setContentView(view);
    }
}