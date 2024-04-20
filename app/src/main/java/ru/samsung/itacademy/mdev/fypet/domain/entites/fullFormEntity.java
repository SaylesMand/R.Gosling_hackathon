package ru.samsung.itacademy.mdev.fypet.domain.entites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class fullFormEntity {
    @NonNull
    private final String id;
    @Nullable
    private final String address;
    @NonNull
    private final String type;
    @NonNull
    private final String breed;
    @NonNull
    private final boolean is_muted;
    @NonNull
    private final String user_id;
    @Nullable
    private final String description;

    public fullFormEntity(@NonNull String id,
                          @Nullable String address,
                          @NonNull String type,
                          @NonNull String breed,
                          boolean isMuted,
                          @NonNull String userId,
                          @Nullable String description)
    {
        this.id = id;
        this.address = address;
        this.type = type;
        this.breed = breed;
        is_muted = isMuted;
        user_id = userId;
        this.description = description;
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
