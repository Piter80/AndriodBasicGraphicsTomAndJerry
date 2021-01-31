package ru.petrzimin.tomandjerry;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView tomImageView;
    private Object lock = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tomImageView = findViewById(R.id.tomImageView);
        tomImageView.

        tomImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                synchronized (lock) {
                    tomImageView.animate().alpha(0).setDuration(3000);
                    try {
                        lock.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tomImageView.setImageResource(R.drawable.jerry_mouse);
                    tomImageView.animate().alpha(1).setDuration(3000);
                    try {
                        lock.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}