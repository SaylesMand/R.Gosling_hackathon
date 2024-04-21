package ru.samsung.itacademy.mdev.fypet.domain.sign;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;

public interface SignCommentRepository {
    void createComment(
            @NonNull String content,
            @NonNull String form_id,
            @NonNull String user_id,
            Consumer<Status<Void>> callback
    );
}
