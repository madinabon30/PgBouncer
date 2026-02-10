package com.example.pgbouncer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class PgBouncerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PgBouncerApplication.class, args);
//
//        List<String> urls = List.of(
//                "http:127.0.0.1:8080/users"
//        );
//
//        ExecutorService executor = Executors.newFixedThreadPool(20); // max 5 concurrent
//        HttpClient client = HttpClient.newBuilder()
//                .executor(executor)
//                .connectTimeout(Duration.ofSeconds(2))
//                .build();
//
//        List<CompletableFuture<String>> futures = urls.stream()
//                .map(url -> CompletableFuture.supplyAsync(() -> {
//                    try {
//                        HttpResponse<String> resp = client.send(
//                                HttpRequest.newBuilder(URI.create(url))
//                                        .GET()
//                                        .timeout(Duration.ofSeconds(3))
//                                        .build(),
//                                HttpResponse.BodyHandlers.ofString()
//                        );
//                        return resp.body();
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                }, executor))
//                .toList();
//
//        List<String> results = futures.stream()
//                .map(CompletableFuture::join)
//                .toList();
//
//        executor.shutdown();
    }

}
