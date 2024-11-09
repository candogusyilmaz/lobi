package dev.canverse.server.application.services;

import dev.canverse.server.application.dto.Hello;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {
    public Hello.Response sayHello(Hello.Request request) {
        return new Hello.Response("Hello, " + request.name());
    }
}
