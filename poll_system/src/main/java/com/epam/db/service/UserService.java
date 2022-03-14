package com.epam.db.service;

import com.epam.db.model.Users;

import java.sql.Date;
import java.util.List;

public interface UserService<T> {
    List<T> getAll();

    T create(T obj);

    Users findById(long id);

    boolean existEmailAndPass(String email, String pass);

    T getByEmailAndPass(String email, String pass);

    void updateDate(int user_id, Date date);

    void updateResult(int user_id, String description);
}
