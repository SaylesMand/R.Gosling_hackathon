package ru.samsung.itacademy.mdev.fypet.data;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.data.dto.CommentPostDto;
import ru.samsung.itacademy.mdev.fypet.data.network.RetrofitFactory;
import ru.samsung.itacademy.mdev.fypet.data.source.CommentApi;
import ru.samsung.itacademy.mdev.fypet.data.utils.CallToConsumer;
import ru.samsung.itacademy.mdev.fypet.domain.CommentRepository;
import ru.samsung.itacademy.mdev.fypet.domain.entites.FullCommentEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;
import ru.samsung.itacademy.mdev.fypet.domain.sign.SignCommentRepository;


public class CommentRepositoryImpl implements CommentRepository, SignCommentRepository {
    private static CommentRepositoryImpl INSTANCE;
    private final CommentApi commentApi = RetrofitFactory.getInstance().getCommentApi();
    private CommentRepositoryImpl() {}

    public static synchronized CommentRepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommentRepositoryImpl();
        }
        return INSTANCE;
    }
    @Override
    public void getComment(@NonNull String id, @NonNull Consumer<Status<FullCommentEntity>> callback) {
        commentApi.getById(id).enqueue(new CallToConsumer<>(
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

    @Override
    public void createComment(@NonNull String content, @NonNull String form_id, @NonNull String user_id, Consumer<Status<Void>> callback) {
        /** CHECK FOR USER LOGIN **/
        commentApi.postComment(new CommentPostDto(content, form_id, user_id)).enqueue(new CallToConsumer<>(
                callback,
                dto -> null
        ));
    }
}