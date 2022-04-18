package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        Random random = new Random();

        int count = 0;
        while (count < countOfPerson - 1) {
            int idx = random.nextInt(2);
            RandomBoolean randomBoolean = RandomBoolean.getRandomBoolean(idx);
            points.add(randomBoolean.getBoolean());
            count++;
        }

        for (int i = 0; i < points.size(); i++) {
            if (i != points.size() - 1 && points.get(i) && points.get(i + 1))
                points.set(i + 1, RandomBoolean.FALSE.getBoolean());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
