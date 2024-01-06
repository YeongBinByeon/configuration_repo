package com.example.redisinitconfiguration.service;

import com.example.redisinitconfiguration.data.User;
import com.example.redisinitconfiguration.repository.UserCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final UserCacheRepository userCacheRepository;

    public String getUser(String name) {
        User user = userCacheRepository.getUser(name)
                .orElseThrow();
        return user.getName();
    }

    public void setUser(User user){
        userCacheRepository.setUser(user);
    }
}
