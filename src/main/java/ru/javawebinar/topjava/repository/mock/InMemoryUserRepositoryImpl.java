package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

    static final int USER_ID = 1;
    static final int ADMIN_ID = 2;

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return Collections.emptyList();
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }
}
