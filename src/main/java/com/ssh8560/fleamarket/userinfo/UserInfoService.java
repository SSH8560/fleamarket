package com.ssh8560.fleamarket.userinfo;

import com.ssh8560.fleamarket.repository.JpaUserInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserInfoService {
    private final JpaUserInfoRepository repository;

    public UserInfoResponse getUserInfo(String id) {
        return new UserInfoResponse(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
