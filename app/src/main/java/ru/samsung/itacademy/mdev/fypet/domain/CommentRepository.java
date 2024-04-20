package ru.samsung.itacademy.mdev.fypet.domain;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.FullCommentEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;

public interface CommentRepository {
    void getComment(@NonNull String id, @NonNull Consumer<Status<FullCommentEntity>> callback);
}
