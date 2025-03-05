package com.maga.repositoriy;

import com.maga.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Auth,Long> {

    Boolean existsByUserNameAndPassword(String userName, String password);
}
