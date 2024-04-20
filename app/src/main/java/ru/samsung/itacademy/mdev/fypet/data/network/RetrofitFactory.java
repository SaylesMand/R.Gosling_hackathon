package ru.samsung.itacademy.mdev.fypet.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.samsung.itacademy.mdev.fypet.data.source.UserApi;
import ru.samsung.itacademy.mdev.fypet.data.source.FormApi;
import ru.samsung.itacademy.mdev.fypet.data.source.CommentApi;

public class RetrofitFactory {
    private static RetrofitFactory INSTANCE;

    private RetrofitFactory() {}

    public static synchronized RetrofitFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitFactory();
        }
        return INSTANCE;
    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/") //TODO
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public UserApi getUserApi() {
        return retrofit.create(UserApi.class);
    }
    public FormApi getFormApi() {
        return retrofit.create(FormApi.class);
    }
    public CommentApi getCommentApi() {
        return retrofit.create(CommentApi.class);
    }
}
