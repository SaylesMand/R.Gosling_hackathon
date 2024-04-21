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

        ImageButton btn_info = findViewById(R.id.btn_info);
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu_2, menu);

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