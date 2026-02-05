package com.example.pgbouncer;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    private final JdbcTemplate jdbc;

    public Controller(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/db")
    public Map<String, Object> db() {
        // proves we're going through pgBouncer into Postgres
        return jdbc.queryForMap("select now() as now, current_database() as db, current_user as user");
    }
}
