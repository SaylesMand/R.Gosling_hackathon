package ru.samsung.itacademy.mdev.fypet.data.source;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.samsung.itacademy.mdev.fypet.data.dto.CommentDto;
import ru.samsung.itacademy.mdev.fypet.data.dto.CommentPostDto;

public interface CommentApi {
    @GET("comment/{id}")
    Call<CommentDto> getById(@Path("id") String id);
    @POST("comment/post/")
    Call<CommentDto> postComment(@Body CommentPostDto dto);
}
