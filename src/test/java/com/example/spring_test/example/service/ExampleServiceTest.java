package com.example.spring_test.example.service;

import com.example.spring_test.socket.CommonSocket;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mock;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PrepareForTest({ExampleService.class})
public class ExampleServiceTest {
    @SpyBean
    private ExampleService exampleService;

    @Test
    public void socketReceive() throws Exception {
        CommonSocket commonSocket = mock(CommonSocket.class);

        PowerMockito.whenNew(CommonSocket.class).withArguments("str1", "str2").thenReturn(commonSocket);
        doReturn("mocking").when(commonSocket).receive();

        String result = exampleService.socketReceive();
        System.out.println("result : " + result);

        exampleService.setExampleRepositoryShow();

        Assert.assertEquals("mocking", result);
    }
}