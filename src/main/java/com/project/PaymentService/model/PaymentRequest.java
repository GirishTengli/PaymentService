package com.project.PaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {

	private long orderId;
	private long amount;
	private String referanceNumber;
	private PaymentMode paymentMode;
}
