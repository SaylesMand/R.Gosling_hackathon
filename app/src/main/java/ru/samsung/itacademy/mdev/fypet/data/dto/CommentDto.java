package ru.samsung.itacademy.mdev.fypet.data.dto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class FormDto {
    @NonNull
    @SerializedName("ID")
    public String id;
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
    @SerializedName("is_muted")
    public boolean is_muted;
    @NonNull
    @SerializedName("user_id")
    public String user_id;
    @Nullable
    @SerializedName("description")
    public String description;
}
