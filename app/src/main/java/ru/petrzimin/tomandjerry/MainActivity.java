package ru.petrzimin.tomandjerry;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView tomImageView;
    boolean isTom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tomImageView = findViewById(R.id.tomImageView);
        tomImageView.setOnClickListener(v -> {
            if (tomImageView.getAlpha() > 0) {
                tomImageView.animate().alpha(0).setDuration(3000);
            } else {
                if (isTom) {
                    tomImageView.setImageResource(R.drawable.jerry_mouse);
                    isTom = false;
                } else {
                    tomImageView.setImageResource(R.drawable.tom_cat);
                    isTom = true;
                }
                tomImageView.animate().alpha(1).setDuration(3000);
            }
        });


    }
}