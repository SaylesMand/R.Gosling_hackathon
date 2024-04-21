package ru.samsung.itacademy.mdev.fypet.data.source;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.samsung.itacademy.mdev.fypet.data.dto.CommentDto;

public interface CommentApi {
    @GET("comment/{id}")
    Call<CommentDto> getById(@Path("id") String id);
}
