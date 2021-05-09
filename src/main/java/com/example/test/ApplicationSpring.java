package com.example.test;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*@SpringBootApplication*/
public class ApplicationSpring {
    public static void main(String[] args) {
        //SpringApplication.run(TestApplication.class, args);

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(4);
        result.add(5);
        result.add(6);
        result.add(7);
        result.add(8);

        int sum = result.stream()
                .reduce((x,acc)->acc+x).orElse(0);

        System.out.println(sum);

        Map<Integer, Integer> resultMap = result.stream()
                .collect(Collectors.toMap(x->x, x->x));
        System.out.println(resultMap);

    }
}
