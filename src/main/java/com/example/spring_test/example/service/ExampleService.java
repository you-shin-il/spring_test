package com.example.spring_test.example.service;

import com.example.spring_test.example.repository.ExampleRepository;
import com.example.spring_test.socket.CommonSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    public String socketReceive() {
        CommonSocket commonSocket = null;
        commonSocket = new CommonSocket("str1", "str2");
        String receive = commonSocket.receive();

        return receive;
    }

    public void setExampleRepositoryShow() {
        exampleRepository.show();
    }
}
