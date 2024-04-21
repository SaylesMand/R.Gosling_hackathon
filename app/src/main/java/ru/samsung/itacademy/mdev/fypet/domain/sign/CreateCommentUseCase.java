package ru.samsung.itacademy.mdev.fypet.domain.sign;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;

public class CreateCommentUseCase {
    private final SignCommentRepository repo;

    public CreateCommentUseCase(SignCommentRepository repo) {this.repo = repo;}

    public void execute(
            @NonNull String content,
            @NonNull String form_id,
            @NonNull String user_id,
            Consumer<Status<Void>> callback
    ) {
        repo.createComment(content, form_id, user_id, callback);
    }
}
