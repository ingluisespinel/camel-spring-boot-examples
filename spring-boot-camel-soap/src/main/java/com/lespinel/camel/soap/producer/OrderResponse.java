package com.lespinel.camel.soap.producer;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderResponse {
    private String id;
}
