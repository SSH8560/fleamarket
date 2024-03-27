package com.ssh8560.fleamarket.domain.userinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/userinfo")
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService service;

    @GetMapping
    public ResponseEntity<UserInfoResponse> getUserInfo(
        Authentication authentication
    ){
        UserInfoResponse userInfo = service.getUserInfo(authentication.getName());

        return ResponseEntity.ok(userInfo);
    }
}
