package com.beautyClan.glamhub.data.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime timestamp;
    private BigDecimal amount;
    //    private TransactionType transactionType;
    private TransactionStatus status;
    //    private Long accountId;
    private String description;
    private String paymentMethod;
    private String category;
    private String reference;
    @ManyToOne
   private BeautyVendor beautyVendor;
    @ManyToOne
   private MakeupArtist makeupArtist;
    @ManyToOne
  private   Customer customer;
}
