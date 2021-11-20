package com.example.file_json;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.file_json.databinding.ActivityMainBinding;
import com.example.file_json.utils.FileUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public String readFromAssets(String name) throws IOException {
        InputStream inputStream = getAssets().open(name);
        return FileUtils.readStream(inputStream);
        try {
            String book = readFromAssets("abook.json");
            JSONObject bookItem = new JSONObject(book);
            String text = "제목: "+ bookItem.getString("title") +
                    ", 가격" + bookItem.getInt("price") + "\n" +
                    "책 이미지 url: " + bookItem.getString("image");
            binding.text.setText(text);
        } catch (IOException e) {

        }
    }

}
