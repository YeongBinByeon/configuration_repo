package com.example.redisinitconfiguration.repository;

import com.example.redisinitconfiguration.data.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserCacheRepository {
    private final RedisTemplate<String, User> userRedisTemplate;
    // 레디스에 저장되는 시간 3일 지정
    private final static Duration USER_CACHE_TTL = Duration.ofDays(3);

    public void setUser(User user){
        String key = getKey(user.getName());
        log.info("Set User to Redis {}, {}", key, user);
        userRedisTemplate.opsForValue().set(key, user, USER_CACHE_TTL);
    }

    public Optional<User> getUser(String userName){
        String key = getKey(userName);
        User user = userRedisTemplate.opsForValue().get(key);
        log.info("Get data from Redis {}, {}", key, user);
        return Optional.ofNullable(user);
    }

    // 레디스에서 데이터 식별자 추가 붙이기 위해 "USER:" 붙임
    private String getKey(String userName){
        return "USER:" + userName;
    }
}