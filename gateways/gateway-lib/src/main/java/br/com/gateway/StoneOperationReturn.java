package br.com.gateway;

import DataContracts.Sale.CreateSaleRequest;
import DataContracts.Sale.CreateSaleResponse;
import DataContracts.Sale.ManageSaleRequest;
import DataContracts.Sale.ManageSaleResponse;
import Utility.HttpResponseGenerics;

/**
 * Classe de retorno das operacoes de Cancelamento assim como de Autorizacao e Captura.
 * @author christian
 *
 */
public class StoneOperationReturn {

	HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> responseGenericsAuthAndCapture;
	
	HttpResponseGenerics<ManageSaleResponse, ManageSaleRequest> httpResponseCancellation;

	public HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> getResponseGenericsAuthAndCapture() {
		return responseGenericsAuthAndCapture;
	}

	public void setResponseGenericsAuthAndCapture(
			HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> responseGenericsAuthAndCapture) {
		this.responseGenericsAuthAndCapture = responseGenericsAuthAndCapture;
	}

	public HttpResponseGenerics<ManageSaleResponse, ManageSaleRequest> getHttpResponseCancellation() {
		return httpResponseCancellation;
	}

	public void setHttpResponseCancellation(
			HttpResponseGenerics<ManageSaleResponse, ManageSaleRequest> httpResponseCancellation) {
		this.httpResponseCancellation = httpResponseCancellation;
	}

	
	
}
