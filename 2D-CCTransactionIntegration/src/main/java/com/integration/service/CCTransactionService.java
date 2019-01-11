package com.integration.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.integration.bean.CCTransaction;

public interface CCTransactionService {
	public String creditCardTransaction(CCTransaction transaction) throws ClientProtocolException, IOException;
	public CCTransaction getTransactionDetailsByMarchantTxnId(int marchantId);
}