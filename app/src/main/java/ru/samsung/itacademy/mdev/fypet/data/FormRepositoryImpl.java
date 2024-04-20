package ru.samsung.itacademy.mdev.fypet.data;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

import ru.samsung.itacademy.mdev.fypet.data.network.RetrofitFactory;
import ru.samsung.itacademy.mdev.fypet.data.source.FormApi;
import ru.samsung.itacademy.mdev.fypet.data.utils.CallToConsumer;
import ru.samsung.itacademy.mdev.fypet.domain.FormRepository;
import ru.samsung.itacademy.mdev.fypet.domain.entites.FullFormEntity;
import ru.samsung.itacademy.mdev.fypet.domain.entites.Status;


public class FormRepositoryImpl implements FormRepository {
    private static FormRepositoryImpl INSTANCE;
    private final FormApi FormApi = RetrofitFactory.getInstance().getFormApi();
    private FormRepositoryImpl() {}

    public static synchronized FormRepositoryImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FormRepositoryImpl();
        }
        return INSTANCE;
    }
    @Override
    public void getForm(@NonNull String id, @NonNull Consumer<Status<FullFormEntity>> callback) {
        FormApi.getById(id).enqueue(new CallToConsumer<>(
                callback,
                form -> {
                    final String resultId = form.id;
                    final String name = form.type;
                    final String breed = form.breed;
                    final String user_id = form.user_id;
                    if (resultId != null && name != null && breed != null && user_id != null) {
                        return new FullFormEntity(
                                resultId,
                                name,
                                breed,
                                user_id,
                                form.address,
                                form.description,
                                form.is_muted
                        );
                    } else {
                        return null;
                    }
                }
        ));

    }
}