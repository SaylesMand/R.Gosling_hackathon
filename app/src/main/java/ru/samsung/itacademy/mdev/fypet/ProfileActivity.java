package ru.samsung.itacademy.mdev.fypet;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RVAForm rvaForm;
    private List<Form> formList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        formList = new ArrayList<>();
        formList.add(new Form("Джесси", "2 года", "Той терьер", R.drawable.dog));
        formList.add(new Form("Джесси", "2 года", "Той терьер", R.drawable.dog));
        formList.add(new Form("Джесси", "2 года", "Той терьер", R.drawable.dog));

        rvaForm = new RVAForm(formList);
        recyclerView.setAdapter(rvaForm);
    }
}