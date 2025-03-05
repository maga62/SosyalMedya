package com.maga.service;

import com.maga.dto.request.CreateUserRequestDto;
import com.maga.dto.request.RegisterRequestDto;
import com.maga.dto.response.LoginResponseDto;
import com.maga.entity.Auth;
import com.maga.manager.UserProfileManager;
import com.maga.repositoriy.AuthRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {
    private final AuthRepo authRepo;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
        Auth auth = authRepo.save(Auth.builder()
                            .userName(dto.getUserName())
                            .password(dto.getPassword())
                            .email(dto.getEmail())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                        .authId((long) auth.getId())
                        .email(dto.getEmail())
                        .username(dto.getUserName())
                .build());

        return auth;

    }

    public Boolean login(LoginResponseDto dto) {
        return authRepo.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
