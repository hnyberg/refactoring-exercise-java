package com.greatersum.rental.model;

public class Movie {
    private final String title;
    private final Category category;

    public enum Category {
        REGULAR("Regular"),
        CHILDRENS("Childrens"),
        NEW("New");

        private String category;

        Category(String category){
            this.category = category;
        }

        String getCode(){
            return category;
        }
    }

    public Movie(String title, Category category) {

        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }
}
