package com.lespinel.camel.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Builder
@AllArgsConstructor
@Data
public class Order {
    private long id;
    @NotBlank(message = "Owner must be defined.")
    private String owner;
    @NotNull
    private List<Item> items;

    public Order(){
        items = new ArrayList<>();
    }

    public double getTotal(){
        return items.stream().mapToDouble(Item::getAmount).sum();
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
