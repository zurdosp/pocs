package br.com.gateway;

import java.util.ArrayList;
import java.util.UUID;

import Client.GatewayServiceClient;
import DataContracts.CreditCardTransaction.CreditCard;
import DataContracts.CreditCardTransaction.CreditCardTransaction;
import DataContracts.CreditCardTransaction.CreditCardTransactionOptions;
import DataContracts.Order.Order;
import DataContracts.Sale.CreateSaleRequest;
import DataContracts.Sale.CreateSaleResponse;
import DataContracts.Sale.ManageSaleRequest;
import DataContracts.Sale.ManageSaleResponse;
import EnumTypes.CreditCardOperationEnum;
import EnumTypes.ManageOperationEnum;
import Utility.HttpResponseGenerics;

public class StoneOperations {

	
	private String endPoint;
	
	/**
	 * Metodo que cancela uma transacao
	 * @param merchanKey Chave da loja.
	 * @param orderKey Chave da orderm de Pedido
	 * @throws Exception
	 */
	public StoneOperationReturn canceltransaction(final String merchanKey,final String orderKey) throws Exception {
		// Define loja 
		UUID merchantKey = UUID.fromString(merchanKey); // Chave da Loja - MerchantKey

		// Cria o cliente que vai efetuar a operação
		GatewayServiceClient serviceClient = new GatewayServiceClient(merchantKey, endPoint);

		// Define a chave do pedido que será cancelado
		UUID uuidOrderKey = UUID.fromString(orderKey); // Chave do pedido

		// Submete a requisição de cancelamento
		StoneOperationReturn stoneOperationReturn = new StoneOperationReturn();
		stoneOperationReturn.setHttpResponseCancellation(serviceClient.getSale().Manage(ManageOperationEnum.Cancel, uuidOrderKey));
		
		return stoneOperationReturn;
	}

	/**
	 * Metodo que autoriza e captura uma transação.
	 * @param numeroDoPedido Numero do pedido.
	 * @param merchanKey Chave da loja.
	 * @param creditCard Objecto que representa os dados do cartao.
	 * @param cardOperationEnum Enum da operadora de cartao.
	 * @throws Exception
	 */
	public StoneOperationReturn processAuthAndCaptureTransaction(final String numeroDoPedido, final String merchanKey,
			final CreditCard creditCard, final CreditCardOperationEnum cardOperationEnum) throws Exception {
		CreditCardTransaction creditCardTransaction = buildTransaction(creditCard, cardOperationEnum);
		StoneOperationReturn stoneOperationReturn = new StoneOperationReturn();
		stoneOperationReturn.setResponseGenericsAuthAndCapture(sendTransaction(creditCardTransaction, numeroDoPedido, merchanKey));
		return stoneOperationReturn;
	}

	private HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> 
	sendTransaction(CreditCardTransaction creditCardTransaction, final String numeroDoPedido, 
			final String merchanKey) throws Exception{



		// Cria o objeto order para adicionar o Order Reference
		Order order = new Order();
		order.setOrderReference(numeroDoPedido);

		// Cria o Sale Request para enviar o objeto de request
		CreateSaleRequest createSaleRequest = new CreateSaleRequest();
		createSaleRequest.setCreditCardTransactionCollection(new ArrayList<CreditCardTransaction>());
		createSaleRequest.getCreditCardTransactionCollection().add(creditCardTransaction);
		createSaleRequest.setOrder(order);

		// Define loja
		UUID merchantKey = UUID.fromString(merchanKey); // Chave da Loja - MerchantKey

		// Cria o cliente que vai enviar a transação
		GatewayServiceClient serviceClient = new GatewayServiceClient(merchantKey, endPoint);

		// Submete a transação e retorna a resposta do gateway
		return serviceClient.getSale().Create(createSaleRequest);
	}


	private CreditCardTransaction buildTransaction(final CreditCard creditCard, final CreditCardOperationEnum cardOperationEnum) {

		// Cria a transação de cartão de crédito e define cartão criado anteriormente
		CreditCardTransaction creditCardTransaction = new CreditCardTransaction();
		creditCardTransaction.setAmountInCents(10000L);
		creditCardTransaction.setCreditCard(creditCard);
		creditCardTransaction.setInstallmentCount(1);
		creditCardTransaction.setCreditCardOperation(cardOperationEnum);
		CreditCardTransactionOptions creditCardTransactionOptions = new CreditCardTransactionOptions();
		creditCardTransactionOptions.setPaymentMethodCode(1);
		creditCardTransaction.setOptions(creditCardTransactionOptions);
		return creditCardTransaction;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	
	
}
