package com.lespinel.camel.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class Item {
    private String name;
    private double amount;
}
