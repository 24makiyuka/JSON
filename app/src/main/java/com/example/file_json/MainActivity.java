package com.example.file_json;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.file_json.databinding.ActivityMainBinding;
import com.example.file_json.utils.FileUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final String saveFileName = "memo.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        try {
            String book = readFromAssets("abook.json");
            JSONObject bookItem = new JSONObject(book);
            String text = "제목: "+ bookItem.getString("title") +
                    ", 가격" + bookItem.getInt("price") + "\n" +
                    "책 이미지 url: " + bookItem.getString("image");
            binding.text.setText(text);
            Glide.with(this)
                    .load(bookItem.getString("image"))
                    .into(binding.image);
        } catch (IOException | JSONException e) {

        }

    }


    public String readFromAssets(String name) throws IOException {
        InputStream inputStream = getAssets().open(name);
        return FileUtils.readStream(inputStream);

    }


}
