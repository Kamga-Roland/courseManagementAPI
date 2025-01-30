package com.group21.tpw.Service;

import com.group21.tpw.Entity.UserEntity;
import java.util.List;

public interface UserService {
    UserEntity getById(Long id);
    UserEntity save(UserEntity user);
    List<UserEntity> getAll();
    UserEntity update(UserEntity user);
    void deleteUser(Long id);
}