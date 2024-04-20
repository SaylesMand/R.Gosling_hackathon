package ru.samsung.itacademy.mdev.fypet.domain;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.FullUserEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;


public interface UserRepository {
    void getUser(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback);
}
