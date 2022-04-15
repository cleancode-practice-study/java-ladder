package main.java.model;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) { // 사람수 - 1 만큼
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        Random random = new Random();
        int count = 0;
        while (count < countOfPerson - 1) {
            int idx = random.nextInt(2);
            RandomBoolean randomBoolean = RandomBoolean.getRandomBoolean(idx);
            this.points.add(randomBoolean.getBoolean());
            count++;
        }

        for (int i = 0; i < points.size(); i++) {
            if (i != points.size() - 1 && points.get(i)) {
                if (points.get(i + 1))
                    points.set(i + 1, RandomBoolean.FALSE.getBoolean());
            }
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
