package com.learning.msaccount.client.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Card {

    private Long id;
    private Long accountId;
    private String cardNumber;
    private String cardType;
    private BigDecimal totalLimit;
    private BigDecimal availableAmount;
    private LocalDate createdAt;

}
