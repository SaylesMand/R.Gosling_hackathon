package ru.samsung.itacademy.mdev.fypet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ru.samsung.itacademy.mdev.fypet.domain.entites.FullFormEntity;

public class MainActivity extends AppCompatActivity {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_screen_toolbar, menu);
        getMenuInflater().inflate(R.menu.info_main_toolbar, menu);

        MenuItem customMenuItem_2 = menu.findItem(R.id.action_custom2);
        View customMenuView_2 = customMenuItem_2.getActionView();

        ImageButton btnDislike = customMenuView_2.findViewById(R.id.btnDislike);
        ImageButton btnInfo = customMenuView_2.findViewById(R.id.btnInfo);
        ImageButton btnLike = customMenuView_2.findViewById(R.id.btnLike);

        btnDislike.setOnClickListener(v -> {

        });

        btnInfo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InfoActivity.class);
            //intent.putExtra("formId", formsPool.get(currentFormIndex).getId());
            startActivity(intent);
        });

        btnLike.setOnClickListener(v -> {
            // Handle right button click for customMenuItem_2
        });

        // action bar (dislike-info-like)
        //ActionMenuView infoToolbar = (ActionMenuView) findViewById(R.id.infoToolbar);
        //getMenuInflater().inflate(R.menu.info_main_toolbar, infoToolbar.getMenu());

        MenuItem customMenuItem = menu.findItem(R.id.action_custom);
        View customMenuView = customMenuItem.getActionView();

        ImageButton btnProfile = customMenuView.findViewById(R.id.btnProfile);
        ImageButton btnCenter = customMenuView.findViewById(R.id.btn_center);
        ImageButton btnMenu = customMenuView.findViewById(R.id.btnMenu);

        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        btnCenter.setOnClickListener(v -> {
            // Handle center button click
        });

        btnMenu.setOnClickListener(v -> {
            // Handle right button click
        });



        return true;
    }
}