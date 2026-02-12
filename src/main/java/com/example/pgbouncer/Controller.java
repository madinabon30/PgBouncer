package com.example.pgbouncer;


import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final JdbcTemplate jdbc;

    public Controller(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/user")
    public ResponseEntity<Void> user() {
        // proves we're going through pgBouncer into Postgres
        jdbc.update("insert into users (name, phone) values ('Adam', '918765432')");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user-add")
    public ResponseEntity<Void> add() {
        // proves we're going through pgBouncer into Postgres
        jdbc.update("insert into users (name, phone) values ('Maria', '918888432')");
        return ResponseEntity.noContent().build();
    }
}
