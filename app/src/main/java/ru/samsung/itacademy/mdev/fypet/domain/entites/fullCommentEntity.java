package ru.samsung.itacademy.mdev.fypet.domain.entites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class fullCommentEntity {
    @NonNull
    private final String id;
    @Nullable
    private final String content;
    @NonNull
    private final String form_id;
    @NonNull
    private final String user_id;

    public fullCommentEntity(@NonNull String id, @Nullable String content, @NonNull String formId, @NonNull String userId) {
        this.id = id;
        this.content = content;
        form_id = formId;
        user_id = userId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @Nullable
    public String getContent() {
        return content;
    }

    @NonNull
    public String getForm_id() {
        return form_id;
    }

    @NonNull
    public String getUser_id() {
        return user_id;
    }
}
