package ru.samsung.itacademy.mdev.fypet.domain.entites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FullCommentEntity {
    @NonNull
    private final String id;
    @Nullable
    private final String content;
    @NonNull
    private final String form_id;
    @NonNull
    private final String user_id;

    public FullCommentEntity(@NonNull String id,
                             @NonNull String form_id,
                             @NonNull String user_id,
                             @Nullable String content) {
        this.id = id;
        this.form_id = form_id;
        this.user_id = user_id;
        this.content = content;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getForm_id() {
        return form_id;
    }

    @NonNull
    public String getUser_id() {
        return user_id;
    }

    @Nullable
    public String getContent() {
        return content;
    }
}
