package com.project.PaymentService.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "ORDER_ID")
	private long orderId;

	@Column(name = "PAYMENT_MODE")
	private String paymentMode;

	@Column(name = "REFERANCE_NUMBER")
	private String referanceNumber;

	@Column(name = "ORDER_DATE")
	private Instant orderDate;

	@Column(name = "STATUS")
	private String paymentStatus;

	@Column(name = "AMOUNT")
	private long amount;

}
