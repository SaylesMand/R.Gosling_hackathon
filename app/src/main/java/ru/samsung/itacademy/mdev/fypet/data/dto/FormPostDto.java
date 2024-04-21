package ru.samsung.itacademy.mdev.fypet.data.dto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class FormPostDto {
    @Nullable
    @SerializedName("address")
    public String address;
    @NonNull
    @SerializedName("type")
    public String type;
    @NonNull
    @SerializedName("breed")
    public String breed;
    @NonNull
    @SerializedName("user_id")
    public String user_id;
    @Nullable
    @SerializedName("description")
    public String description;

    public FormPostDto(@Nullable String address, @NonNull String type, @NonNull String breed, @NonNull String user_id, @Nullable String description) {
        this.address = address;
        this.type = type;
        this.breed = breed;
        this.user_id = user_id;
        this.description = description;
    }
}
