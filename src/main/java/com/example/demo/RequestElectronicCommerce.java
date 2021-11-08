package com.example.demo;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RequestElectronicCommerce
 */
@Validated
public class RequestElectronicCommerce {
	@JsonProperty("panToken")
	private String panToken = null;

	@JsonProperty("operationId")
	private String operationId = null;

	@JsonProperty("merchantName")
	private String merchantName = null;

	@JsonProperty("purchaseAmount")
	private String purchaseAmount = null;

	@JsonProperty("purchaseCurrency")
	private String purchaseCurrency = null;

	public RequestElectronicCommerce panToken(String panToken) {
		this.panToken = panToken;
		return this;
	}

	/**
	 * Pan token.
	 * 
	 * @return panToken
	 **/

	public String getPanToken() {
		return panToken;
	}

	public void setPanToken(String panToken) {
		this.panToken = panToken;
	}

	public RequestElectronicCommerce operationId(String operationId) {
		this.operationId = operationId;
		return this;
	}

	/**
	 * REDSYS unique identification.
	 * 
	 * @return operationId
	 **/

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public RequestElectronicCommerce merchantName(String merchantName) {
		this.merchantName = merchantName;
		return this;
	}

	/**
	 * Name merchant.
	 * 
	 * @return merchantName
	 **/

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public RequestElectronicCommerce purchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
		return this;
	}

	/**
	 * Purchase amount.
	 * 
	 * @return purchaseAmount
	 **/

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public RequestElectronicCommerce purchaseCurrency(String purchaseCurrency) {
		this.purchaseCurrency = purchaseCurrency;
		return this;
	}

	/**
	 * Purchase currency.
	 * 
	 * @return purchaseCurrency
	 **/

	public String getPurchaseCurrency() {
		return purchaseCurrency;
	}

	public void setPurchaseCurrency(String purchaseCurrency) {
		this.purchaseCurrency = purchaseCurrency;
	}

	@Override
	public String toString() {
		return "RequestElectronicCommerce [panToken=" + panToken + ", operationId=" + operationId + ", merchantName="
				+ merchantName + ", purchaseAmount=" + purchaseAmount + ", purchaseCurrency=" + purchaseCurrency + "]";
	}

}
