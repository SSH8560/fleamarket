package com.ssh8560.fleamarket.domain.user;

import com.ssh8560.fleamarket.entity.User;
import com.ssh8560.fleamarket.entity.UserInfo;
import com.ssh8560.fleamarket.repository.JpaUserInfoRepository;
import com.ssh8560.fleamarket.repository.JpaUserRepository;
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
