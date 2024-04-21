package ru.samsung.itacademy.mdev.fypet.domain;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.FullUserEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;

public class GetUserByNameUseCase {
    private final UserRepository repo;

    public GetUserByNameUseCase(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(@NonNull String name, @NonNull Consumer<Status<FullUserEntity>> callback) {
        repo.getUserByName(name, callback);
    }
}
