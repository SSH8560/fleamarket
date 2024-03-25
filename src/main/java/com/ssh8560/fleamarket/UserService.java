package com.ssh8560.fleamarket;

import com.ssh8560.fleamarket.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final JpaUserRepository repository;
    private final JpaUserInfoRepository infoRepository;

    public void saveUser(UserPostRequest request) {
        UUID id = UUID.randomUUID();
        repository.save(new User(id, request.getUsername(), passwordEncoder.encode(request.getPassword())));
        infoRepository.save(new UserInfo(id, request.getNickname()));
    }
}
