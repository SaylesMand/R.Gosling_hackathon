package ru.samsung.itacademy.mdev.fypet;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import ru.samsung.itacademy.mdev.fypet.data.CommentRepositoryImpl;
import ru.samsung.itacademy.mdev.fypet.data.UserRepositoryImpl;
import ru.samsung.itacademy.mdev.fypet.data.dto.CommentPostDto;
import ru.samsung.itacademy.mdev.fypet.data.source.CredentialsDataSource;
import ru.samsung.itacademy.mdev.fypet.data.source.DecodeLogin;
import ru.samsung.itacademy.mdev.fypet.domain.GetUserByNameUseCase;
import ru.samsung.itacademy.mdev.fypet.domain.sign.CreateCommentUseCase;

public class InfoActivity extends AppCompatActivity {
    public final CreateCommentUseCase createCommentUseCase = new CreateCommentUseCase(
            CommentRepositoryImpl.getInstance()
    );

    public final GetUserByNameUseCase getUserByNameUseCase = new GetUserByNameUseCase(
            UserRepositoryImpl.getInstance()
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);

        String id = getIntent().getStringExtra("formId");
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        EditText editText = (EditText) findViewById(R.id.editText);
        ImageButton commentBtn = (ImageButton) findViewById(R.id.commentButton);
        commentBtn.setOnClickListener(v -> {
            getUserByNameUseCase.execute(DecodeLogin.decodeLogin(), status -> {
                if (status.getStatusCode() == 200 && status.getErrors() == null) {
                    createCommentUseCase.execute(
                            editText.getText().toString(),
                            id,
                            status.getValue().getId(),
                            status1 -> {
                                if (status.getStatusCode() == 200 && status.getErrors() == null) {
                                    editText.setText("");
                                } else {
                                    Log.i("InfoActivity",
                                            String.format(
                                                    "Comment not created (Error) - %s",
                                                    status.getErrors().toString()));
                                    Toast.makeText(this, "Something went wrong, sorry", Toast.LENGTH_SHORT).show();
                                }
                            });
            } else {
                    Toast.makeText(this, "Login to leave comments", Toast.LENGTH_SHORT).show();
                }
            });
        });

        ImageButton returnBtn = (ImageButton) findViewById(R.id.returnButton);
        returnBtn.setOnClickListener(v -> {
            this.finish();
        });

    }
}