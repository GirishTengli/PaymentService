package com.project.PaymentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.PaymentService.model.PaymentRequest;
import com.project.PaymentService.model.PaymentResponse;
import com.project.PaymentService.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService service;

	@PutMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
		long paymentId = service.doPayment(paymentRequest);
		return new ResponseEntity<Long>(paymentId, HttpStatus.OK);
	}
	
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable String orderId){
		
		return new ResponseEntity<PaymentResponse>(service.getPaymentDetailsByOrderId(orderId), HttpStatus.OK); 
	}
}
