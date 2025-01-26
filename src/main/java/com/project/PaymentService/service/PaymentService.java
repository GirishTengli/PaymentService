package com.project.PaymentService.service;

import com.project.PaymentService.model.PaymentRequest;
import com.project.PaymentService.model.PaymentResponse;

public interface PaymentService {

	long doPayment(PaymentRequest paymentRequest);

	PaymentResponse getPaymentDetailsByOrderId(String orderId);

}
