package ru.samsung.itacademy.mdev.fypet.data;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.data.network.RetrofitFactory;
import ru.samsung.itacademy.mdev.fypet.data.source.CommentApi;
import ru.samsung.itacademy.mdev.fypet.data.utils.CallToConsumer;
import ru.samsung.itacademy.mdev.fypet.domain.CommentRepository;
import ru.samsung.itacademy.mdev.fypet.domain.entites.FullCommentEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;


public class CommentRepositoryImpl implements CommentRepository {
    private static CommentRepositoryImpl INSTANCE;
    private final CommentApi CommentApi = RetrofitFactory.getInstance().getCommentApi();
    private CommentRepositoryImpl() {}

    public static synchronized CommentRepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommentRepositoryImpl();
        }
        return INSTANCE;
    }
    @Override
    public void getComment(@NonNull String id, @NonNull Consumer<Status<FullCommentEntity>> callback) {
        CommentApi.getById(id).enqueue(new CallToConsumer<>(
                callback,
                comment -> {
                    final String resultId = comment.id;
                    final String form_id = comment.form_id;
                    final String user_id = comment.user_id;
                    if (resultId != null && form_id != null && user_id != null) {
                        return new FullCommentEntity(
                                resultId,
                                form_id,
                                user_id,
                                comment.content
                        );
                    } else {
                        return null;
                    }
                }
        ));

    }
}