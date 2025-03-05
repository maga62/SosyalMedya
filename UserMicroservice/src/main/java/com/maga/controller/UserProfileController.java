package com.maga.controller;

import com.maga.document.UserProfile;
import com.maga.dto.request.CreateUserRequestDto;
import com.maga.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.maga.config.RestApis.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        userProfileService.createUser(createUserRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAllUsers() {
        System.out.println("getAllUsers Çalıştı");
        return ResponseEntity.ok(userProfileService.getAllUser());
    }

    @GetMapping("/upper-name")
    public ResponseEntity<String> upperName(String username) {
        return ResponseEntity.ok(userProfileService.upperName(username));
    }
}
