package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    public static final int BOUND = 2;
    private List<Boolean> points;

    public Line(int countOfPerson) {
        this.points = createLine(countOfPerson);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private List<Boolean> createLine(int countOfPerson) {
        Random random = new Random();
        List<Boolean> points = new ArrayList<>();

        int count = 0;
        while (count < countOfPerson - 1) {
            int idx = random.nextInt(BOUND);
            RandomBoolean randomBoolean = RandomBoolean.getRandomBoolean(idx);
            points.add(randomBoolean.getBoolean());
            count++;
        }

        return checkOneLine(points);
    }

    private List<Boolean> checkOneLine(List<Boolean> points) {
        for (int i = 0; i < points.size(); i++) {
            if (i != points.size() - 1 && points.get(i) && points.get(i + 1))
                points.set(i + 1, RandomBoolean.FALSE.getBoolean());
        }

        return points;
    }
}
