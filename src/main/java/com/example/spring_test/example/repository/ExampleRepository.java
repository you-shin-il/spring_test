package com.example.spring_test.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ExampleRepository {
    public void show() {
        System.out.println("ExampleRepository.show");
    }
}
