package com.severstal.test.build.demofirstservice.repository;

import com.severstal.test.build.demofirstservice.domain.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceEntityRepository extends CrudRepository<ServiceEntity, String> {
}
