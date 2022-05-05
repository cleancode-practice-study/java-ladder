package domain;

import java.util.Random;

public class RandomRootCreator implements RootCreator{
    private static final Random random = new Random();

    public boolean createRoot() {
        return random.nextBoolean();
    }
}
