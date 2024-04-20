package ru.samsung.itacademy.mdev.fypet.data;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.data.network.RetrofitFactory;
import ru.samsung.itacademy.mdev.fypet.data.source.UserApi;
import ru.samsung.itacademy.mdev.fypet.domain.UserRepository;
import ru.samsung.itacademy.mdev.fypet.domain.entites.FullUserEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;
import ru.samsung.itacademy.mdev.fypet.data.utils.CallToConsumer;


public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl INSTANCE;
    private final UserApi userApi = RetrofitFactory.getInstance().getUserApi();
    private UserRepositoryImpl() {}

    public static synchronized UserRepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepositoryImpl();
        }
        return INSTANCE;
    }
    @Override
    public void getUser(@NonNull String id, @NonNull Consumer<Status<FullUserEntity>> callback) {
        userApi.getById(id).enqueue(new CallToConsumer<>(
                callback,
                user -> {
                    final String resultId = user.id;
                    final String name = user.name;
                    final String surname = user.surname;
                    final String password = user.password;
                    if (resultId != null && name != null && surname != null && password != null) {
                        return new FullUserEntity(
                                resultId,
                                name,
                                surname,
                                password,
                                user.email,
                                user.phone,
                                user.address
                        );
                    } else {
                        return null;
                    }
                }
        ));

    }
}