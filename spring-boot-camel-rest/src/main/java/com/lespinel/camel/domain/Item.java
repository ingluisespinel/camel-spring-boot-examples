package com.lespinel.camel.domain;

import lombok.*;

@Builder
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String name;
    private double amount;
}
