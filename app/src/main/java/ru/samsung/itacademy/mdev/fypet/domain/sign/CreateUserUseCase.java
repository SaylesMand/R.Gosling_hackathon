package ru.samsung.itacademy.mdev.fypet.domain.sign;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;


public class CreateUserUseCase {
    private final SignUserRepository repo;

    public CreateUserUseCase(SignUserRepository repo) {
        this.repo = repo;
    }

    public void execute(
            @NonNull String login,
            @NonNull String password,
            Consumer<Status<Void>> callback
    ) {
        repo.createAccount(login, password, callback);
    }
}
