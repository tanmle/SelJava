package page;

import org.openqa.selenium.WebDriver;
import common.Common;
import HearingFusion.Interfaces;

public class BillingPage extends AbstractPage {

	public BillingPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	
	/**
	 * click Credi tCard
	 */
	public void clickCreditCard(){
		waitForControl(driver, Interfaces.BillingPage.CREDIT_CARD_LINK, timeWait);
		click(driver, Interfaces.BillingPage.CREDIT_CARD_LINK);
	}
	/**
	 * 
	 */
	public void clickAddNewCreditCard(){
		waitForControl(driver, Interfaces.BillingPage.ADD_NEW_CREDIT_CARD_LINK, timeWait);
		click(driver, Interfaces.BillingPage.ADD_NEW_CREDIT_CARD_LINK);
	}
	/**
	 * check Add New Credit Card Displays
	 * @return
	 */
	public boolean isAddNewCreditCardFormDisplays(){
		waitForControl(driver, Interfaces.BillingPage.ADD_NEW_CREDIT_CARD_FORM, timeWait);
		return isControlDisplayed(driver, Interfaces.BillingPage.ADD_NEW_CREDIT_CARD_FORM);
	}
	
	/**
	 * check Patient Balance Sale Correctly
	 * @return
	 */
	public boolean isPatientBalanceSaleCorrectly(String price){
		waitForControl(driver, Interfaces.BillingPage.PAITENT_BLANCE_PRICE, timeWait);
		String pr = getText(driver, Interfaces.BillingPage.PAITENT_BLANCE_PRICE);
		if (pr.equals(price)) {
			return true;
		}
		else
			return false;
	}
	/**
	 * enter Credit Card Details
	 * @param creditCardType
	 * @param creditCardNumber
	 * @param creditCardName
	 * @param month
	 * @param year
	 */
	public void enterCreditCardDetails(String creditCardType,String creditCardNumber,String creditCardName,String month,String year)
	{
		waitForControl(driver, Interfaces.BillingPage.CREDIT_CARD_TYPE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.BillingPage.CREDIT_CARD_TYPE_COMBOBOX, creditCardType);
		type(driver, Interfaces.BillingPage.CREDIT_CARD_NUMBER, creditCardNumber);
		type(driver, Interfaces.BillingPage.CREDIT_CARD_NAME, creditCardName);
		selectItemComboxbox(driver, Interfaces.BillingPage.CREDIT_CARD_MONTH, month);
		selectItemComboxbox(driver, Interfaces.BillingPage.CREDIT_CARD_YEAR, year);
	}
	/**
	 * enter Credit Billing Address
	 * @param address
	 * @param city
	 * @param state
	 * @param zipCode
	 */
	public void enterCreditBillingAddress(String address,String city,String state,String zipCode){
		waitForControl(driver, Interfaces.BillingPage.BILLING_ADDRESS_TEXTBOX, timeWait);
		type(driver, Interfaces.BillingPage.BILLING_ADDRESS_TEXTBOX, address);
		type(driver, Interfaces.BillingPage.BILLING_ADDRESS_CITY_TEXTBOX, city);
		selectItemComboxbox(driver, Interfaces.BillingPage.BILLING_ADDRESS_STATE_COMBOBOX, state);
		type(driver, Interfaces.BillingPage.BILLING_ADDRESS_ZIPCODE_TEXTBOX, zipCode);
	}
	/**
	 * enter Transaction Details
	 * @param totalAmount
	 * @param refNumber
	 * @param remark
	 */
	public void enterTransactionDetails(String totalAmount,String refNumber,String remark){
		waitForControl(driver, Interfaces.BillingPage.TRANSACTION_TOTAL_AMOUNT_TEXTBOX, timeWait);
		type(driver, Interfaces.BillingPage.TRANSACTION_TOTAL_AMOUNT_TEXTBOX, totalAmount);
		type(driver, Interfaces.BillingPage.TRANSACTION_REFERENCE_NUMBER_TEXTBOX, refNumber);
		type(driver, Interfaces.BillingPage.TRANSACTION_REMARK_TEXTBOX, remark);
	}
	/**
	 * click On Apply Change
	 */
	public void clickOnApplyChange(){
		waitForControl(driver, Interfaces.BillingPage.APPLY_CHANGE_BUTTON, timeWait);
		click(driver, Interfaces.BillingPage.APPLY_CHANGE_BUTTON);
	}
	/**
	 * back Sales Order
	 */
	public SalesPage backSalesOrder(){
		waitForControl(driver, Interfaces.BillingPage.BACK_SALES_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.BillingPage.BACK_SALES_ORDER_BUTTON);
		waitForControlNotDisplayed(driver, Interfaces.BillingPage.BACK_SALES_ORDER_BUTTON, timeWait);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * check Patient Balance Displays Correct
	 * @param balancePrice
	 * @return
	 */
	public boolean isPatientBalanceDisplaysCorrect(String balancePrice){
		waitForControl(driver, Interfaces.BillingPage.PATIENT_BALANCE_SALE_LABEL, timeWait);
		String tmp = getText(driver, Interfaces.BillingPage.PATIENT_BALANCE_SALE_LABEL);
		
		tmp = tmp.substring(1, tmp.length());
		String arrTotal[] = tmp.split(",");
		tmp = arrTotal[0]+arrTotal[1];
		
		if(tmp.contains(balancePrice))
			return true;
		return false;
	}
	/**
	 * 
	 * @param method
	 * @return
	 */
	public void selectPaymentsMethod(String method)
	{
		waitForControl(driver, Interfaces.BillingPage.PAYMENT_METHOD_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.BillingPage.PAYMENT_METHOD_COMBOBOX, method);
	}
	/**
	 * enter Check Number
	 * @param number
	 */
	public void enterCheckNumber(String number){
		waitForControl(driver, Interfaces.BillingPage.PAYMENT_CHECK_TEXTBOX, timeWait);
		type(driver, Interfaces.BillingPage.PAYMENT_CHECK_TEXTBOX, number);
	}
	/**
	 * enter Payment Amount
	 * @param amount
	 */
	public void enterPaymentAmount(String amount){
		waitForControl(driver, Interfaces.BillingPage.PAYMENT_AMOUNT_TEXTBOX, timeWait);
		type(driver, Interfaces.BillingPage.PAYMENT_AMOUNT_TEXTBOX, amount);
	}
	/**
	 * enter Payment Remark
	 * @param remark
	 */
	public void enterPaymentRemark(String remark){
		waitForControl(driver, Interfaces.BillingPage.PAYMENT_REMARK_TEXTBOX, timeWait);
		type(driver, Interfaces.BillingPage.PAYMENT_REMARK_TEXTBOX, remark);
	}
	/**
	 * click On Save
	 */
	public void clickOnSave(){
		waitForControl(driver, Interfaces.BillingPage.SAVE_BUTTON, timeWait);
		click(driver, Interfaces.BillingPage.SAVE_BUTTON);
	}
	/**
	 * click On Back Sales Order
	 * @return
	 */
	public SalesPage clickOnBackSalesOrder(){
		waitForControl(driver, Interfaces.BillingPage.BACK_SALE_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.BillingPage.BACK_SALE_ORDER_BUTTON);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * get Patient Blance
	 * @return
	 */
	public String getPatientBlance(){
		waitForControl(driver, Interfaces.BillingPage.PATIENT_BLANCE_FOR_SALE, timeWait);
		return getText(driver, Interfaces.BillingPage.PATIENT_BLANCE_FOR_SALE);
	}
	/**
	 * select Billing Tab
	 * @param tab
	 */
	public void selectBillingTab(String tab){
		waitForControl(driver, Interfaces.BillingPage.BILLING_TAB_LINK_DYNAMIC,tab, timeWait);
		click(driver, Interfaces.BillingPage.BILLING_TAB_LINK_DYNAMIC,tab);
	}
	/**
	 * enter Change Date
	 * @param date
	 */
	public void enterChangeDate(String date){
		waitForControl(driver, Interfaces.BillingPage.CHANGE_DATE_TEXBOX, timeWait);
		type(driver, Interfaces.BillingPage.CHANGE_DATE_TEXBOX, date);
	}
	/**
	 * enter Amount
	 * @param amount
	 */
	public void enterAmount(String amount){
		waitForControl(driver, Interfaces.BillingPage.AMOUNT_TEXBOX, timeWait);
		type(driver, Interfaces.BillingPage.AMOUNT_TEXBOX, amount);
	}
	/**
	 * click On Search Button
	 */
	public void clickOnSearchButton(){
		waitForControl(driver, Interfaces.BillingPage.SEARCH_BUTTON, timeWait);
		click(driver, Interfaces.BillingPage.SEARCH_BUTTON);
	}
	/**
	 * select Transaction By Credit Card Name
	 * @param cardName
	 */
	public void selectTransactionByCreditCardName(String cardName){
		waitForControl(driver, Interfaces.BillingPage.TRANSACTION_ITEM_BY_CREDIT_CARD_LINK,cardName, timeWait);
		click(driver, Interfaces.BillingPage.TRANSACTION_ITEM_BY_CREDIT_CARD_LINK,cardName);
	}
	/**
	 * click On Refurd Button
	 */
	public void clickOnRefurdButton(){
		waitForControl(driver, Interfaces.BillingPage.REFUND_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.BillingPage.REFUND_BUTTON);
	}
	/**
	 * enter Tota lAmount
	 */
	public void enterChangeTotalAmount(String amount){
		waitForControl(driver, Interfaces.BillingPage.CHANGE_AMOUNT_TEXBOX, timeWait);
		type(driver, Interfaces.BillingPage.CHANGE_AMOUNT_TEXBOX, Common.getCommon().formatNumber(amount) - 10 + "");
	}
	
	/**
	 * get Payment refund
	 * @return
	 */
	public String getRefundPayment(){
		waitForControl(driver, Interfaces.BillingPage.REFUND_PAYMENT_LABEL, timeWait);
		return getText(driver, Interfaces.BillingPage.REFUND_PAYMENT_LABEL);
	}
	/**
	 * get Total Amount
	 * @return
	 */
	public String getTotalAmount(){
		waitForControl(driver, Interfaces.BillingPage.TOTAL_AMOUNT_PAYMENT_LABEL, timeWait);
//		return getText(driver, Interfaces.BillingPage.TOTAL_AMOUNT_PAYMENT_LABEL);
		return getAttributeValue(driver, Interfaces.BillingPage.TOTAL_AMOUNT_PAYMENT_LABEL, "value");
	}
	/**
	 * select Refund Method
	 * @param method
	 */
	public void selectRefundMethod(String method){
		waitForControl(driver, Interfaces.BillingPage.REFUND_METHOD_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.BillingPage.REFUND_METHOD_COMBOBOX, method);
	}
	/**
	 * 
	 * @param amount
	 */
	public void enterRefundAmount(String amount){
		waitForControl(driver, Interfaces.BillingPage.REFUND_AMOUNT_TEXTBOX, timeWait);
		double tmp = Common.getCommon().formatNumber(amount)/2;
		type(driver, Interfaces.BillingPage.REFUND_AMOUNT_TEXTBOX, tmp+"");
	}
	
	/**
	 * enter Remark Sales Order Refund
	 */
	public void enterRemarkSalesOrderRefund(String remark){
		waitForControl(driver, Interfaces.BillingPage.REMARK_SALE_ORDER_REFUND_TEXTBOX, timeWait);
		type(driver, Interfaces.BillingPage.REMARK_SALE_ORDER_REFUND_TEXTBOX, remark);
	}
	
	/**
	 * click On Save Button
	 */
	public void clickOnSaveButton() {
		waitForControl(driver, Interfaces.BillingPage.SAVE_BUTTON, timeWait);
		click(driver, Interfaces.BillingPage.SAVE_BUTTON);
		sleep();
	}
	
	/**
	 * click On Back Sale Order
	 */
	public SalesPage clickOnBackSaleOrder(){
		waitForControl(driver, Interfaces.BillingPage.BACK_SALE_ORDER_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.BillingPage.BACK_SALE_ORDER_BUTTON);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * enter Name Card
	 * @param name
	 */
	public void enterNameCard(String name){
		waitForControl(driver, Interfaces.BillingPage.CREDIT_CARD_NAME_TEXTBOX, timeWait);
		type(driver, Interfaces.BillingPage.CREDIT_CARD_NAME_TEXTBOX, name);
	}
	private WebDriver driver;
	private String ipClient;
}