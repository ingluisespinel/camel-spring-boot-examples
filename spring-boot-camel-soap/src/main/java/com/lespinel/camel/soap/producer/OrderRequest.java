package com.lespinel.camel.soap.producer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class OrderRequest {
    private String id;
    private String owner;
    private double total;
}
