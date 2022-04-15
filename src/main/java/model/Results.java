package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private final List<Result> results = new ArrayList<>();

    public Results(String[] names) {
        for (String name : names) {
            Result result = new Result(name);
            results.add(result);
        }
    }

    public List<Result> getResults() {
        return results;
    }

}
