package net.honux.springbootdemo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();
    private static List<Integer> allNumbers;
    private static Random r = new Random();

    static {
        allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
    }

    public int size() {
        return numbers.size();
    }

    public int sum() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static Lotto generateRandom() {
        Collections.shuffle(allNumbers);
        Lotto l = new Lotto();
        for (int i = 0; i < 6; i++) {
            l.numbers.add(allNumbers.get(i));
        }
        Collections.sort(l.numbers);
        return l;
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
    }
}
