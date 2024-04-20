package ru.samsung.itacademy.mdev.fypet.domain;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.FullUserEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;

public class GetUserByIdUseCase {
    private final UserRepository repo;

    public GetUserByIdUseCase(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback) {
        repo.getUser(id, callback);
    }
}
