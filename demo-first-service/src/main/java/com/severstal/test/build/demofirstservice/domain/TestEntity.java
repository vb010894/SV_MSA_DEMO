package com.severstal.test.build.demofirstservice.domain;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestEntity {

    @NotNull(message = "Поле id не должно быть null")
    Long id;

    @NotBlank(message = "Поле 1 должно быть заполненно")
    String field;

    @Min(1)
    @Max(10)
    Integer number1;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Не корректный email")
    String email;
}
