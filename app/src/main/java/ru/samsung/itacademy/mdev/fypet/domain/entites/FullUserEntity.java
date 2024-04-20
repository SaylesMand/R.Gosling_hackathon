package ru.samsung.itacademy.mdev.fypet.domain.entites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FullUserEntity {
    @NonNull
    private final String id;
    @NonNull
    private final String name;
    @NonNull
    private final String surname;
    @NonNull
    private final String password;
    @Nullable
    private final String email;
    @Nullable
    private final String phone;
    @Nullable
    private final String address;

    public FullUserEntity(
            @NonNull String id,
            @NonNull String name,
            @NonNull String surname,
            @NonNull String password,
            @Nullable String email,
            @Nullable String phone,
            @Nullable String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }

    @NonNull
    public String getSurname() {
        return surname;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @Nullable
    public String getAddress() {
        return address;
    }
}
