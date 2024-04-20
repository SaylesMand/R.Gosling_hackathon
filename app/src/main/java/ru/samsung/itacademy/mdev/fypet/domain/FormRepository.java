package ru.samsung.itacademy.mdev.fypet.domain;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.domain.entites.FullFormEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;

public interface FormRepository {
    void getForm(@NonNull String id, @NonNull Consumer<Status<FullFormEntity>> callback);
}
