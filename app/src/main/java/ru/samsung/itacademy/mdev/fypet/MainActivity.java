package ru.samsung.itacademy.mdev.fypet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toolbar toolbar_main = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu_3, menu);
        getMenuInflater().inflate(R.menu.toolbar_menu_2, menu);

        MenuItem customMenuItem_2 = menu.findItem(R.id.action_custom2);
        View customMenuView_2 = customMenuItem_2.getActionView();

        ImageButton btnLeft_2 = customMenuView_2.findViewById(R.id.btn_left_2);
        ImageButton btnCenter_2 = customMenuView_2.findViewById(R.id.btn_center_2);
        ImageButton btnRight_2 = customMenuView_2.findViewById(R.id.btn_right_2);

        btnLeft_2.setOnClickListener(v -> {

        });

        btnCenter_2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent);
        });

        btnRight_2.setOnClickListener(v -> {
            // Handle right button click for customMenuItem_2
        });


        MenuItem customMenuItem = menu.findItem(R.id.action_custom);
        View customMenuView = customMenuItem.getActionView();

        ImageButton btnLeft = customMenuView.findViewById(R.id.btn_left);
        ImageButton btnCenter = customMenuView.findViewById(R.id.btn_center);
        ImageButton btnRight = customMenuView.findViewById(R.id.btn_right);

        btnLeft.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        btnCenter.setOnClickListener(v -> {
            // Handle center button click
        });

        btnRight.setOnClickListener(v -> {
            // Handle right button click
        });



        return true;
    }
}