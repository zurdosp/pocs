import org.junit.Test;

import DataContracts.CreditCardTransaction.CreditCard;
import EnumTypes.CreditCardBrandEnum;
import EnumTypes.CreditCardOperationEnum;
import br.com.gateway.StoneOperationReturn;
import br.com.gateway.StoneOperations;

import static org.junit.Assert.assertTrue;

/**
 * 
 * @author christian
 *
 */
public class OperacoeStoneTest {

	private StoneOperations operacoesStone = new StoneOperations();

	@Test
	public void cancellTest(){
		try {
			operacoesStone.setEndPoint("https://transaction.stone.com.br");
			final String merchanKey = "F2A1F485-CFD4-49F5-8862-0EBC438AE923";
			final String orderKey = "09e062a9-335f-4272-be96-bfa7f2aa1269";

			StoneOperationReturn operacoesStoneReturn = operacoesStone.canceltransaction(merchanKey, orderKey);
			assertTrue(operacoesStoneReturn.getHttpResponseCancellation().getHttpStatusCode().getReasonPhrase().equalsIgnoreCase("OK"));

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
	}
	
	@Test
	public void authorazeAndCpatureTest(){
		try {
			operacoesStone.setEndPoint("https://transaction.stone.com.br");

			final String merchanKey = "F2A1F485-CFD4-49F5-8862-0EBC438AE923";
			final String numeroDoPedido = "NumeroDoPedido";
			final CreditCardOperationEnum cardOperationEnum = CreditCardOperationEnum.AuthAndCapture;

			CreditCard creditCard = new CreditCard();
			creditCard.setCreditCardBrand(CreditCardBrandEnum.Visa);
			creditCard.setCreditCardNumber("4111111111111111");
			creditCard.setExpMonth(10);
			creditCard.setExpYear(22);
			creditCard.setHolderName("LUKE SKYWALKER");
			creditCard.setSecurityCode("123");

			StoneOperationReturn operacoesStoneReturn = operacoesStone.processAuthAndCaptureTransaction(numeroDoPedido, merchanKey, creditCard, cardOperationEnum);
			assertTrue(operacoesStoneReturn.getResponseGenericsAuthAndCapture().getHttpStatusCode().getReasonPhrase().equalsIgnoreCase("Created"));

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(Boolean.FALSE);
		}
	}

}
