package com.fty1.example.log.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMockServiceTest {

    @Autowired
    private UserMockService userMockService;

    @Test
    void mock() {
        userMockService.mock();
    }


}