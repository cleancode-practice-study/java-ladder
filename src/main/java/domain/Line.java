package domain;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> points = new ArrayList<>();

    public Line (int playerCount) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        // 사다리 넓이 (사람 수 - 1) 만큼 포문 돌면서 루트 추가 여부 결정
            // 랜덤으로 루트 추가 여부 결정 하되, 왼쪽 라인에 루트 있으면 루트 추가 안함. -> 왼쪽 라인 먼저 보고 추가 여부 결정하자
        addRoot(false);
        for (int i = 1 ; i < playerCount ; i++) {
            boolean previousRoot = points.get(i - 1);
            addRoot(previousRoot);
        }
    }

    private void addRoot(boolean previousRoot) {
        if (previousRoot) {
            points.add(false);
        }

        if (!previousRoot) {
            points.add(RandomRootCreator.getRandomRoot());
        }
    }

    public ArrayList<Boolean> getLine() {
        return points;
    }
}
