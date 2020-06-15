package com.szymonharabasz.RedisRepository.model;

import java.io.Serializable;

public class Item implements Serializable {
    private String id;
    private String ingredientId;
    private Double quantity;
    private String unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String id) {
        this.ingredientId = id;
    }

}
