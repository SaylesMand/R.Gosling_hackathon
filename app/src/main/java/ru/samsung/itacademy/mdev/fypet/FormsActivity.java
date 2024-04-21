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

import java.util.ArrayList;

import ru.samsung.itacademy.mdev.fypet.data.source.CredentialsDataSource;
import ru.samsung.itacademy.mdev.fypet.domain.entites.FullFormEntity;

public class FormsActivity extends AppCompatActivity {
    ArrayList<FullFormEntity> formsPool;
    int currentFormIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        formsPool = new ArrayList<>();

        ImageButton btn_info = findViewById(R.id.btn_info);
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormsActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_screen_toolbar, menu);

        MenuItem customMenuItem = menu.findItem(R.id.action_custom);
        View customMenuView = customMenuItem.getActionView();

        ImageButton btnProfile = customMenuView.findViewById(R.id.btnProfile);
        ImageButton btnCenter = customMenuView.findViewById(R.id.btn_center);
        ImageButton btnMenu = customMenuView.findViewById(R.id.btnMenu);

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(FormsActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        btnCenter.setOnClickListener(v -> {
            // Handle center button click
        });

        btnMenu.setOnClickListener(v -> {
            // Handle right button click
        });

        // INFO "TOOLBAR" BUT IT IS NOT A TOOLBAR
        ImageButton btnDislike = (ImageButton) findViewById(R.id.btn_close);
        ImageButton btnInfo = (ImageButton) findViewById(R.id.btn_info);
        ImageButton btnLike = (ImageButton) findViewById(R.id.btn_like);

        btnDislike.setOnClickListener(v -> {

        });

        btnInfo.setOnClickListener(v -> {
            Intent intent = new Intent(FormsActivity.this, InfoActivity.class);
            //intent.putExtra("formId", formsPool.get(currentFormIndex).getId());
            startActivity(intent);
        });

        btnLike.setOnClickListener(v -> {
            // Handle right button click for customMenuItem_2
        });

        return true;
    }
}