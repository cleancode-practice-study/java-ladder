package domain;

import java.util.Random;

public class RandomRootCreator {
    private static final Random random = new Random();

    public static boolean getRandomRoot() {
        return random.nextBoolean();
    }
}
