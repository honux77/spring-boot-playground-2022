package net.honux.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class WelcomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("hello/{id}")
    public User hello(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(()->(new ResponseStatusException(HttpStatus.NOT_FOUND, "No user")));
    }
}
