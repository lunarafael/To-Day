package com.example.today;

public class CategoryItem {
    private String categoryName;
    private int totalItems;

    public CategoryItem(String categoryName, int totalItems) {
        this.categoryName = categoryName;
        this.totalItems = totalItems;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getTotalItems() {
        return totalItems;
    }
}
