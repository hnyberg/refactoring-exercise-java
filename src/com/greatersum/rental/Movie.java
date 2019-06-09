package com.greatersum.rental;

public class Movie {
    private final String title;
    private final Code code;

    public enum Code {
        REGULAR,
        CHILDRENS,
        NEW
    }

    public Movie(String title, Code code) {

        this.title = title;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public Code getCode() {
        return code;
    }
}
