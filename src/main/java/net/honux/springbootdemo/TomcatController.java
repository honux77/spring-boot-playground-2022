package net.honux.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class TomcatController {

    @GetMapping("/hello")
    public String sayHello() {
		return "Hello v.0.2";
    }
}
