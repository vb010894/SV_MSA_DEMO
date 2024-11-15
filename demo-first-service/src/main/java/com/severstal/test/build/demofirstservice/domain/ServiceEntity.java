package com.severstal.test.build.demofirstservice.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("ServiceEntity")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceEntity {

    @Id
    String id;

    String name;
}
