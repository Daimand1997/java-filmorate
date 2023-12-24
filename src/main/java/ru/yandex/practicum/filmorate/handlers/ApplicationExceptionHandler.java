package ru.yandex.practicum.filmorate.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yandex.practicum.filmorate.exceptions.ValidationException;
import ru.yandex.practicum.filmorate.models.api.ResponseApi;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseApi> handleException(Exception e) {
        String errorMessage = String.format("Ошибка работы приложения: %s", e);
        log.error(errorMessage);
        return ResponseEntity.ok(new ResponseApi(errorMessage, HttpStatus.SERVICE_UNAVAILABLE));
    }

    @ExceptionHandler
    public ResponseEntity<ResponseApi> handleValidationException(ValidationException e) {
        String errorMessage = String.format("Ошибка валидации: %s", e);
        log.error(errorMessage);
        return ResponseEntity.ok(new ResponseApi(errorMessage, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler
    public ResponseEntity<ResponseApi> handleVMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = String.format("Ошибка валидации на уровне Spring: %s", e);
        log.error(errorMessage);
        return ResponseEntity.ok(new ResponseApi(errorMessage, HttpStatus.BAD_REQUEST));
    }
}
