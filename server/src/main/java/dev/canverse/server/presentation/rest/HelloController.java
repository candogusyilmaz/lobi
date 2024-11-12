package dev.canverse.server.presentation.rest;

import dev.canverse.server.application.dto.Hello;
import dev.canverse.server.application.service.HelloService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class HelloController {
    private final HelloService helloService;

    @GetMapping("/api/hello")
    Hello.Response hello(@Valid Hello.Request request) {
        return helloService.sayHello(request);
    }
}