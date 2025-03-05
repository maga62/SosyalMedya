package com.maga.service;


import com.maga.document.UserProfile;
import com.maga.dto.request.CreateUserRequestDto;
import com.maga.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final CacheManager cacheManager;

    public void createUser(CreateUserRequestDto createUserRequestDto) {
        userProfileRepository.save(UserProfile.builder()
                                    .authId(createUserRequestDto.getAuthId())
                                    .userName(createUserRequestDto.getUsername())
                                    .email(createUserRequestDto.getEmail())
                .build());
    }

    public List<UserProfile> getAllUser() {
        return userProfileRepository.findAll();
    }

    @Cacheable("upper-case")
    public String upperName(String username) {
        String result = username.toUpperCase();
        try{
            Thread.sleep(3000L);
        }catch (Exception e){}
        return result;
    }

    public void clerarCache(){
        cacheManager.getCache("upper-case").clear();
    }
}
