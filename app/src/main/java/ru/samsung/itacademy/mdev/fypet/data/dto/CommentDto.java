package ru.samsung.itacademy.mdev.fypet.data.dto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class CommentDto {
    @NonNull
    @SerializedName("id")
    public String id;
    @Nullable
    @SerializedName("content")
    public String content;
    @NonNull
    @SerializedName("form_id")
    public String form_id;
    @NonNull
    @SerializedName("user_id")
    public String user_id;
}
