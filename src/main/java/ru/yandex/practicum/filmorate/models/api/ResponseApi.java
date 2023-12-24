package ru.yandex.practicum.filmorate.models.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseApi {

    private String message;
    private HttpStatus statusCode;
}
