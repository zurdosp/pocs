package stonegateway;

import java.util.ArrayList;
import java.util.UUID;

import Client.GatewayServiceClient;
import DataContracts.CreditCardTransaction.CreditCard;
import DataContracts.CreditCardTransaction.CreditCardTransaction;
import DataContracts.CreditCardTransaction.CreditCardTransactionOptions;
import DataContracts.Order.Order;
import DataContracts.Sale.CreateSaleRequest;
import DataContracts.Sale.CreateSaleResponse;
import EnumTypes.CreditCardBrandEnum;
import EnumTypes.CreditCardOperationEnum;
import Utility.HttpResponseGenerics;

public class TesteStone {

	public static void main(String[] args) throws Exception {
		new TesteStone().buildAndSendTransaction();
	}
	
	private void buildAndSendTransaction() throws Exception{
		// Define loja
		UUID merchantKey = UUID.fromString("f2a1f485-cfd4-49f5-8862-0ebc438ae923"); // Chave da Loja - MerchantKey
											
		// Cria um cartão de crédito e define endereço de cobrança
		CreditCard creditCard = new CreditCard();
		creditCard.setCreditCardBrand(CreditCardBrandEnum.Visa);
		creditCard.setCreditCardNumber("4111111111111111");
		creditCard.setExpMonth(10);
		creditCard.setExpYear(22);
		creditCard.setHolderName("LUKE SKYWALKER");
		creditCard.setSecurityCode("123");

		// Cria a transação de cartão de crédito e define cartão criado anteriormente
		CreditCardTransaction creditCardTransaction = new CreditCardTransaction();
		creditCardTransaction.setAmountInCents(10000L);
		creditCardTransaction.setCreditCard(creditCard);
		creditCardTransaction.setInstallmentCount(1);
		creditCardTransaction.setCreditCardOperation(CreditCardOperationEnum.AuthAndCapture);
		CreditCardTransactionOptions creditCardTransactionOptions = new CreditCardTransactionOptions();
		creditCardTransactionOptions.setPaymentMethodCode(1);
		creditCardTransaction.setOptions(creditCardTransactionOptions);

		// Cria o objeto order para adicionar o Order Reference
		Order order = new Order();
		order.setOrderReference("NumeroDoPedido");

		// Cria o Sale Request para enviar o objeto de request
		CreateSaleRequest createSaleRequest = new CreateSaleRequest();
		createSaleRequest.setCreditCardTransactionCollection(new ArrayList<>());
		createSaleRequest.getCreditCardTransactionCollection().add(creditCardTransaction);
		createSaleRequest.setOrder(order);

		// Cria o cliente que vai enviar a transação
		GatewayServiceClient serviceClient = new GatewayServiceClient(merchantKey, "https://transaction.stone.com.br"); 

		// Submete a transação e retorna a resposta do gateway
		HttpResponseGenerics<CreateSaleResponse, CreateSaleRequest> httpResponse = serviceClient.getSale().Create(createSaleRequest);
		System.out.println(httpResponse.getRawResponse());
	}

}
