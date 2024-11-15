package com.severstal.test.build.demofirstservice.service;

import com.severstal.test.build.demofirstservice.domain.ServiceEntity;
import com.severstal.test.build.demofirstservice.repository.ServiceEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RedisService {

    ServiceEntityRepository repository;

    public void save(ServiceEntity entity) {
        repository.save(entity);
    }

    public Optional<ServiceEntity> get(String id) {
        return repository.findById(id);
    }
}
