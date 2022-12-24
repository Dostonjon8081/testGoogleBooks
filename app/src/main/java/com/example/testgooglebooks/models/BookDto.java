package com.example.testgooglebooks.models;

import java.util.List;

public class BookDto {
    private String kind;
    private int totalItems;
    private List<ItemsDto> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<ItemsDto> getItems() {
        return items;
    }

    public void setItems(List<ItemsDto> items) {
        this.items = items;
    }

    public BookDto(String kind, int totalItems, List<ItemsDto> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "kind='" + kind + '\'' +
                ", totalItems=" + totalItems +
                ", items=" + items +
                '}';
    }
}
