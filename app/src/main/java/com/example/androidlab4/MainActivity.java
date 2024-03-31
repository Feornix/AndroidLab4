package com.example.androidlab4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;

import com.example.androidlab4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        int selectedYear = data.getIntExtra("selectedYear", 0);
                        int selectedMonth = data.getIntExtra("selectedMonth", 0)+1;
                        int selectedDay = data.getIntExtra("selectedDay", 0);

                        binding.textView4.setText(String.valueOf(selectedYear));
                        binding.textView3.setText(String.valueOf(selectedMonth));
                        binding.textView2.setText(String.valueOf(selectedDay));
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = binding.editTextText.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("userInput", userInput);
                Intent resintent = new Intent(MainActivity.this, SecondActivity.class);
                activityResultLauncher.launch(intent);
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps")));
            }
        });
        View view = binding.getRoot();
        setContentView(view);
    }

}