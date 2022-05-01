package model;

public class Convert {
    public static final String COMMA = ",";

    public static String[] splitNames(String names) {
        return names.split(COMMA);
    }
}
