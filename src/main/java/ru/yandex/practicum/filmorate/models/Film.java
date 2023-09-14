package ru.yandex.practicum.filmorate.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import ru.yandex.practicum.filmorate.models.validations.DateFutureDateSerialize;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.time.LocalDate;

@Entity
@Data
public class Film {
    private Integer id;
    @NotBlank(message = "Название фильма не может быть пустым")
    private String name;
    @Length(max = 200, message = "Максимальная длина описания — 200 символов")
    private String description;
    @NotBlank(message = "Релизная дата формата yyyy-mm-dd не может быть пустой")
    @JsonSerialize(using = DateFutureDateSerialize.class)
    private LocalDate releaseDate;
    @Min(value = 0, message = "Продолжительность фильма должна быть положительной")
    private Duration duration;
}
