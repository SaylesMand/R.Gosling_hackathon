package ru.samsung.itacademy.mdev.fypet.domain.entites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FullFormEntity {
    @NonNull
    private final String id;
    @NonNull
    private final String type;
    @NonNull
    private final String breed;
    @NonNull
    private final String user_id;
    @Nullable
    private final String address;
    @Nullable
    private final String description;
    @Nullable
    private final boolean is_muted;

    public FullFormEntity(@NonNull String id,
                          @NonNull String type,
                          @NonNull String breed,
                          @NonNull String user_id,
                          @Nullable String address,
                          @Nullable String description,
                          @Nullable boolean is_muted)
    {
        this.id = id;
        this.type = type;
        this.breed = breed;
        this.user_id = user_id;
        this.address = address;
        this.description = description;
        this.is_muted = is_muted;
    }
    @NonNull
    public String getId() {
        return id;
    }

    @Nullable
    public String getAddress() {
        return address;
    }

    @NonNull
    public String getType() {
        return type;
    }

    @NonNull
    public String getBreed() {
        return breed;
    }

    @Nullable
    public boolean isIs_muted() {
        return is_muted;
    }

    @NonNull
    public String getUser_id() {
        return user_id;
    }

    @Nullable
    public String getDescription() {
        return description;
    }
}
