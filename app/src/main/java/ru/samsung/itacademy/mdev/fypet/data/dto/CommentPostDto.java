package ru.samsung.itacademy.mdev.fypet.data.dto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class CommentPostDto {
    @Nullable
    @SerializedName("content")
    public String content;
    @NonNull
    @SerializedName("form_id")
    public String form_id;
    @NonNull
    @SerializedName("user_id")
    public String user_id;

    public CommentPostDto(@NonNull String content, @NonNull String form_id, @NonNull String user_id) {
        this.content = content;
        this.form_id = form_id;
        this.user_id = user_id;
    }
}
