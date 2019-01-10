package com.integration.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.integration.bean.CCTransaction;
import com.integration.dao.CCTransactionDAO;

@Service
public class CCTransactionImpl implements CCTransactionService {
	@Autowired
	private CCTransactionDAO dao;

	@Value("${serviceURL}")
	private String url;

	private String responseString;

	public String creditCardTransaction(CCTransaction transaction) throws ClientProtocolException, IOException {

		int marchantTxnId = dao.saveCCTransactionDetails(transaction);
		transaction.setMerchant_txnId(marchantTxnId);

		JSONObject json = new JSONObject(transaction);

		DefaultHttpClient httpClient = new DefaultHttpClient();

		HttpPost postRequest = new HttpPost(url);
		postRequest.setHeader("Accept", "application/json");

		StringEntity userEntity = new StringEntity(json.toString(), "UTF-8");
		userEntity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		postRequest.setEntity(userEntity);

		HttpResponse response = httpClient.execute(postRequest);

		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			HttpEntity entity = response.getEntity();

			responseString = EntityUtils.toString(entity, "UTF-8");

			JSONObject obj = new JSONObject(responseString);
			Long supplierTxnId = obj.getLong("supplierTxnId");
			transaction.setSupplierTxnId(supplierTxnId);

			String status = obj.getString("status");
			transaction.setStatus(status);
			dao.saveSupplierResponseCCTransactionData(transaction);

		}

		return responseString;

	}

	public List<CCTransaction> getTransactionDetailsByMarchantTxnId(int marchantId) {
		return dao.getTransactionDetailsByMarchantTxnId(marchantId);

	}

}
