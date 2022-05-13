package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.helloworld.databinding.ActivityDetailsBinding;
import com.example.helloworld.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;
    Integer position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        Intent intent = getIntent();
        if (intent != null) {
            String data = intent.getStringExtra("number");
            position = intent.getIntExtra("position", -1);
            binding.plainText.setText(data);
        }

        binding.btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("number", Integer.parseInt(String.valueOf(binding.plainText.getText())));
                intent.putExtra("position", position);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}