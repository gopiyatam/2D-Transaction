package com.supplier.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

	private Long supplierTxnId=null;
	private JSONObject obj = null;

	@PostMapping(value = "/supplierCcTrans")
	@ResponseBody
	public String creditCardTransactionSupplier(HttpServletRequest request, @RequestBody String transactionDetails) {
		

		obj = new JSONObject(transactionDetails);
		double amount = obj.getDouble("amount");
		supplierTxnId = ThreadLocalRandom.current().nextLong(1000L, 910999999999L);
		

		if (amount >= 10) {
			String status = "Success";
		
			obj.put("supplierTxnId", supplierTxnId);
			obj.put("status", status);
			
		} else {
			obj.put("supplierTxnId", supplierTxnId);
			String status = "failed";
			obj.put("status", status);
			return obj.toString();
		}

		return obj.toString();

	}

}
