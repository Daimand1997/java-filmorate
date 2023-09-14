package ru.yandex.practicum.filmorate.controllers;

import ru.yandex.practicum.filmorate.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping()
    public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
        //TODO Подскажите как не дублировать эту проверку во всех метадах.
        // Если у меня будет 100000 запросов где надо name менять на логин, то мне 100000 раз это дублировать везде?
        // Хотел бы это как-то на уровне серилизации сделать, но там невозможно в метод передать другое поле класса
        if(user.getName().isBlank()) {
            user.setName(user.getLogin());
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody @Valid User user) {
        if(user.getName().isBlank()) {
            user.setName(user.getLogin());
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
