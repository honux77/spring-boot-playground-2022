package net.honux.springbootdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LottoApiController {

    private final int NUM = 5;

    @GetMapping("/api/lotto")
    public ResponseEntity<Map<String, String>> generate() {

        Map<String, String> res = new HashMap<>();
        for (int i = 0; i < NUM; i++) {
            res.put("Lotto" + i, Lotto.generateRandom().toString());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
