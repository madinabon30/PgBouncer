package com.example.pgbouncer;

import org.springframework.boot.SpringApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        List<String> urls = List.of(
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users",
                "localhost:8080/users"
        );

        List<String> results;

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<String>> futures = urls.stream()
                    .map(url -> executor.submit(() -> {
                        HttpResponse<String> resp = HttpClient.newHttpClient().send(
                                HttpRequest.newBuilder(URI.create(url)).GET().build(),
                                HttpResponse.BodyHandlers.ofString()
                        );
                        return resp.body();
                    }))
                    .toList();

            results = futures.stream()
                    .map(f -> { try { return f.get(); } catch (Exception e) { return null; } })
                    .toList();
        }

    }
}
