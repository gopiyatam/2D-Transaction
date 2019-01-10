package com.integration.dao;

import java.util.List;

import com.integration.bean.CCTransaction;

public interface CCTransactionDAO {
	public int saveCCTransactionDetails(CCTransaction transaction);
	public void saveSupplierResponseCCTransactionData(CCTransaction transaction );
	public List<CCTransaction> getTransactionDetailsByMarchantTxnId(int marchantId);

}
