package ru.samsung.itacademy.mdev.fypet.domain.sign;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;

public interface SignFormRepository {
    void createForm(@Nullable String address,
    @NonNull String type,
    @NonNull String breed,
    @NonNull String user_id,
    @Nullable String description,
    Consumer<Status<Void>> callback);
}
