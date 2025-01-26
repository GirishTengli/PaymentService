package com.project.PaymentService.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;

import com.project.PaymentService.entity.TransactionDetails;
import com.project.PaymentService.model.PaymentMode;
import com.project.PaymentService.model.PaymentRequest;
import com.project.PaymentService.model.PaymentResponse;
import com.project.PaymentService.repository.TransactionDetailsRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private TransactionDetailsRepository repo;

	@Override
	public long doPayment(PaymentRequest paymentRequest) {
		log.info("Recording Payment Details: {}", paymentRequest);

		TransactionDetails transactionDetails = TransactionDetails.builder().orderDate(Instant.now())
				.paymentMode(paymentRequest.getPaymentMode().name()).paymentStatus("SUCCESS")
				.orderId(paymentRequest.getOrderId()).referanceNumber(paymentRequest.getReferanceNumber())
				.amount(paymentRequest.getAmount()).build();

		repo.save(transactionDetails);
		log.info("Transaction completed with Id {}", transactionDetails.getId());
		return transactionDetails.getId();
	}

	@Override
	public PaymentResponse getPaymentDetailsByOrderId(String orderId) {
		log.info("Getting payment details for orderId: {}" + orderId);
		TransactionDetails transactionDetails = repo.findByOrderId(Long.valueOf(orderId));
		
		PaymentResponse paymentResponse = PaymentResponse.builder()
				.paymentId(transactionDetails.getId())
				.paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
				.paymentDate(transactionDetails.getOrderDate())
				.status(transactionDetails.getPaymentStatus())
				.amount(transactionDetails.getAmount())
				.build();
		
		return paymentResponse;
	}

}
