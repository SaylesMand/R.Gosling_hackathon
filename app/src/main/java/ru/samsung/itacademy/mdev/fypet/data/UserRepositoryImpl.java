package ru.samsung.itacademy.mdev.fypet.data;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.data.dto.AccountDto;
import ru.samsung.itacademy.mdev.fypet.data.network.RetrofitFactory;
import ru.samsung.itacademy.mdev.fypet.data.source.CredentialsDataSource;
import ru.samsung.itacademy.mdev.fypet.data.source.UserApi;
import ru.samsung.itacademy.mdev.fypet.domain.UserRepository;
import ru.samsung.itacademy.mdev.fypet.domain.entites.FullUserEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;
import ru.samsung.itacademy.mdev.fypet.data.utils.CallToConsumer;
import ru.samsung.itacademy.mdev.fypet.domain.sign.SignUserRepository;


public class UserRepositoryImpl implements UserRepository, SignUserRepository {
    private static UserRepositoryImpl INSTANCE;
    private UserApi userApi = RetrofitFactory.getInstance().getUserApi();
    private final CredentialsDataSource credentialsDataSource = CredentialsDataSource.getInstance();

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
//                    final String password = user.password;
                    if (resultId != null && name != null && surname != null) {
                        return new FullUserEntity(
                                resultId,
                                name,
                                surname,
//                                password,
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

    @Override
    public void isExistUser(@NonNull String login, Consumer<Status<Void>> callback) {
        userApi.isExist(login).enqueue(new CallToConsumer<>(
                callback,
                dto -> null
        ));
    }

    @Override
    public void createAccount(@NonNull String login, @NonNull String password, Consumer<Status<Void>> callback) {
        userApi.register(new AccountDto(login, password)).enqueue(new CallToConsumer<>(
                callback,
                dto -> null
        ));
    }

    @Override
    public void login(@NonNull String login, @NonNull String password, Consumer<Status<Void>> callback) {
        credentialsDataSource.updateLogin(login, password);
        userApi = RetrofitFactory.getInstance().getUserApi();
        userApi.login().enqueue(new CallToConsumer<>(
                callback,
                dto -> null
        ));
    }

    @Override
    public void logout() {
        credentialsDataSource.logout();
    }
}