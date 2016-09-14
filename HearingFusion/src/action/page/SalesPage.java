package page;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Common;
import HearingFusion.Interfaces;

public class SalesPage extends AbstractPage {

	public SalesPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	
	/**
	 * click On Deliver Button
	 */
	public void clickOnDeliverButton() {
		waitForControl(driver, Interfaces.SalesPage.DELIVER_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.DELIVER_BUTTON);
		sleep(1);
	}
	
	/**
	 * Switch driver to iFrame
	 * @return driver
	 */
	public WebDriver switchToDeliverFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.SalesPage.DELIVER_FRAME, timeWait);
		sleep();
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.SalesPage.DELIVER_FRAME)));
		return driver;
	}
	
	/**
	 * input Delivery Date On Deliver Dialog
	 */
	public void inputDeliveryDateOnDeliverDialog(String deliveryDate) {
		waitForControl(driver, Interfaces.SalesPage.DELIVERY_DATE_ON_DELIVER, timeWait);
		click(driver, Interfaces.SalesPage.DELIVERY_DATE_ON_DELIVER);
		type(driver, Interfaces.SalesPage.DELIVERY_DATE_ON_DELIVER, deliveryDate);
		sleep(1);
	}
	
	/**
	 * input Shipped With On Deliver Dialog
	 */
	public void inputShippedWithOnDeliverDialog(String shippedWith) {
		waitForControl(driver, Interfaces.SalesPage.SHIPPED_WITH_ON_DELIVER, timeWait);
		click(driver, Interfaces.SalesPage.SHIPPED_WITH_ON_DELIVER);
		type(driver, Interfaces.SalesPage.SHIPPED_WITH_ON_DELIVER, shippedWith);
		sleep(1);
	}
	
	/**
	 * input Tracking # On Deliver Dialog
	 */
	public void inputTrackingNumberOnDeliverDialog(String trackingNumber) {
		waitForControl(driver, Interfaces.SalesPage.TRACKING_NUMBER_ON_DELIVER, timeWait);
		click(driver, Interfaces.SalesPage.TRACKING_NUMBER_ON_DELIVER);
		type(driver, Interfaces.SalesPage.TRACKING_NUMBER_ON_DELIVER, trackingNumber);
		sleep(1);
	}
	
	/**
	 * select Delivery Method On Deliver Dialog
	 */
	public void selectDeliveryMethodOnDeliverDialog(String method) {
		waitForControl(driver, Interfaces.SalesPage.DELIVERY_METHOD_ON_DELIVER, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.DELIVERY_METHOD_ON_DELIVER, method);
		sleep(1);
	}
	
	/**
	 * click Save Button On Deliver Dialog
	 */
	public void clickSaveButtonOnDeliverDialog() {
		waitForControl(driver, Interfaces.SalesPage.SAVE_ON_DELIVER, timeWait);
		click(driver, Interfaces.SalesPage.SAVE_ON_DELIVER);
		sleep(1);
	}
	
	/**
	 * click Cancel Button On Deliver Dialog
	 */
	public void clickCancelButtonOnDeliverDialog() {
		waitForControl(driver, Interfaces.SalesPage.CANCEL_ON_DELIVER, timeWait);
		click(driver, Interfaces.SalesPage.CANCEL_ON_DELIVER);
		sleep(1);
	}
	
	/**
	 * check Message Display On Deliver Dialog
	 */
	public boolean isMessageDisplayOnDeliverDialog(String content) {
		waitForControl(driver, Interfaces.SalesPage.MESSAGE_ON_DELIVER, content, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.MESSAGE_ON_DELIVER, content);
	}
	
	/**
	 * add Item In Create Sales Order
	 */
	public void addItemInCreateSalesOrder(String item) {
		waitForControl(driver, Interfaces.SalesPage.ADD_ITEM_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.ADD_ITEM_BUTTON);
		click(driver, Interfaces.SalesPage.DYNAMIC_CREATE_SALE_ORDER_ITEM, item);
		sleep(1);
	}
	
	/**
	 * select Manufacturer For Left Air
	 */
	public void selectManufacturerForLeftAir(String manufacturer) {
		waitForControl(driver, Interfaces.SalesPage.MANUFACTURER_FOR_LEFT_AIR, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.MANUFACTURER_FOR_LEFT_AIR, manufacturer);
		sleep(1);
	}
	
	/**
	 * select Manufacturer For Right Air
	 */
	public void selectManufacturerForRightAir(String manufacturer) {
		waitForControl(driver, Interfaces.SalesPage.MANUFACTURER_FOR_RIGHT_AIR, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.MANUFACTURER_FOR_RIGHT_AIR, manufacturer);
		sleep(1);
	}
	
	/**
	 * get all Options In Type Left Air
	 */
	public int getAllOptionsInTypeLeftAir() {
		waitForControl(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_TYPE_LEFT_AIR, timeWait);
		int optionNumber = countElement(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_TYPE_LEFT_AIR);
		return optionNumber-1;
	}
	
	/**
	 * get all Options In Type Right Air
	 */
	public int getAllOptionsInTypeRightAir() {
		waitForControl(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_TYPE_RIGHT_AIR, timeWait);
		int optionNumber = countElement(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_TYPE_RIGHT_AIR);
		return optionNumber-1;
	}
	
	/**
	 * get all Options In Manufacturer Left Air
	 */
	public int getAllOptionsInManufacturerLeftAir() {
		waitForControl(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_MANUFACTURER_LEFT_AIR, timeWait);
		int optionNumber = countElement(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_MANUFACTURER_LEFT_AIR);
		return optionNumber-1;
	}
	
	/**
	 * get all Options In Manufacturer Right Air
	 */
	public int getAllOptionsInManufacturerRightAir() {
		waitForControl(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_MANUFACTURER_RIGHT_AIR, timeWait);
		int optionNumber = countElement(driver, Interfaces.SalesPage.ALL_OPTIONS_OF_MANUFACTURER_RIGHT_AIR);
		return optionNumber-1;
	}
	
	/**
	 * input Left Ear Information
	 */
	public void inputLeftEarInformation(String manufacturer, String type, String model) {
		selectManufacturerForLeftAir(manufacturer);
		selectItemComboxbox(driver, Interfaces.SalesPage.TYPE_FOR_LEFT_EAR, type);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SalesPage.MODEL_FOR_LEFT_EAR, model);
		sleep(1);
	}
	
	/**
	 * input Right Ear Information
	 */
	public void inputRightEarInformation(String manufacturer, String type, String model) {
		selectManufacturerForRightAir(manufacturer);
		selectItemComboxbox(driver, Interfaces.SalesPage.TYPE_FOR_RIGHT_EAR, type);
		sleep(1);
		selectItemComboxbox(driver, Interfaces.SalesPage.MODEL_FOR_RIGHT_EAR, model);
		sleep(1);
	}
	
	/**
	 * input Basic Warranty For Left Ear
	 */
	public void inputBasicWarrantyForLeftEar(String manufacturerWarranty, String lossDammage) {
		waitForControl(driver, Interfaces.SalesPage.MANUFACTURER_WARRANTY_FOR_LEFT_EAR, timeWait);
		click(driver, Interfaces.SalesPage.MANUFACTURER_WARRANTY_FOR_LEFT_EAR);
		type(driver, Interfaces.SalesPage.MANUFACTURER_WARRANTY_FOR_LEFT_EAR, manufacturerWarranty);
		sleep(1);
		click(driver, Interfaces.SalesPage.LOSS_DAMAGE_FOR_LEFT_EAR);
		type(driver, Interfaces.SalesPage.LOSS_DAMAGE_FOR_LEFT_EAR, lossDammage);
		sleep(1);
	}
	
	/**
	 * input Basic Warranty For Right Ear
	 */
	public void inputBasicWarrantyForRightEar(String manufacturerWarranty, String lossDammage) {
		waitForControl(driver, Interfaces.SalesPage.MANUFACTURER_WARRANTY_FOR_RIGHT_EAR, timeWait);
		click(driver, Interfaces.SalesPage.MANUFACTURER_WARRANTY_FOR_RIGHT_EAR);
		type(driver, Interfaces.SalesPage.MANUFACTURER_WARRANTY_FOR_RIGHT_EAR, manufacturerWarranty);
		sleep(1);
		click(driver, Interfaces.SalesPage.LOSS_DAMAGE_FOR_RIGHT_EAR);
		type(driver, Interfaces.SalesPage.LOSS_DAMAGE_FOR_RIGHT_EAR, lossDammage);
		sleep(1);
	}
	
	/**
	 * input Pricing For Left Ear
	 */
	public void inputPricingForLeftEar(String discountType, String discount) {
		waitForControl(driver, Interfaces.SalesPage.DISCOUNT_TYPE_FOR_LEFT_EAR, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.DISCOUNT_TYPE_FOR_LEFT_EAR, discountType);
		sleep(1);
		click(driver, Interfaces.SalesPage.DISCOUNT_FOR_LEFT_EAR);
		type(driver, Interfaces.SalesPage.DISCOUNT_FOR_LEFT_EAR, discount);
		sleep(1);
		click(driver, Interfaces.SalesPage.TOTAL_LABEL_FOR_LEFT_EAR);
		sleep(1);
	}
	
	/**
	 * input Pricing For Right Ear
	 */
	public void inputPricingForRightEar(String discountType, String discount) {
		waitForControl(driver, Interfaces.SalesPage.DISCOUNT_TYPE_FOR_RIGHT_EAR, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.DISCOUNT_TYPE_FOR_RIGHT_EAR, discountType);
		sleep(1);
		click(driver, Interfaces.SalesPage.DISCOUNT_FOR_RIGHT_EAR);
		type(driver, Interfaces.SalesPage.DISCOUNT_FOR_RIGHT_EAR, discount);
		sleep(1);
		click(driver, Interfaces.SalesPage.TOTAL_LABEL_FOR_RIGHT_EAR);
		sleep(1);
	}
	
	/**
	 * get Total Price For Left Ear
	 */
	public String getTotalPriceForLeftEar() {
		waitForControl(driver, Interfaces.SalesPage.TOTAL_PRICE_FOR_LEFT_EAR, timeWait);
		return getText(driver, Interfaces.SalesPage.TOTAL_PRICE_FOR_LEFT_EAR);
	}
	
	/**
	 * get Total Price For Right Ear
	 */
	public String getTotalPriceForRightEar() {
		waitForControl(driver, Interfaces.SalesPage.TOTAL_PRICE_FOR_RIGHT_EAR, timeWait);
		return getText(driver, Interfaces.SalesPage.TOTAL_PRICE_FOR_RIGHT_EAR);
	}
	
	/**
	 * get Sales Orders Id
	 */
	public String getSalesOrdersId() {
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_ID, timeWait);
		return getText(driver, Interfaces.SalesPage.SALES_ORDER_ID);
	}
	
	/**
	 * click On Save Button
	 */
	public void clickOnSaveButton() {
		waitForControl(driver, Interfaces.SalesPage.SAVE_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SAVE_BUTTON);
		sleep();
	}
	
	/**
	 * create Inventory Order
	 */
	public void createInventoryOrder() {
		waitForControl(driver, Interfaces.SalesPage.CREATE_INVENTORY_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.CREATE_INVENTORY_ORDER_BUTTON);
		sleep(3);//wait for pop up displays
		driver.switchTo().alert().accept();
		sleep(3);//wait for pop up close
	}
	
	/**
	 * click On Back Button
	 */
	public void clickOnBackButton() {
		waitForControl(driver, Interfaces.SalesPage.BACK_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.BACK_BUTTON);
		sleep();
	}
	
	/**
	 * click On Checkout Button
	 */
	public void clickOnCheckoutButton() {
		waitForControl(driver, Interfaces.SalesPage.CHECKOUT_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.CHECKOUT_BUTTON);
		sleep(3);//wait for pop up displays
		driver.switchTo().alert().accept();
		sleep(3);//wait for pop up close
	}
	
	/**
	 * click On Apply Credits Button
	 */
	public void clickOnApplyCreditsButton() {
		waitForControl(driver, Interfaces.SalesPage.APPLY_CREDITS_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.APPLY_CREDITS_BUTTON);
		sleep();
	}
	
	/**
	 * select Invoices Sales Orders item by number
	 */
	public void selectInvoicesSalesOrders(String number) {
		
	}
	
	/**
	 * click Save And Apply Credits Button
	 */
	public void clickSaveAndApplyCreditsButton() {
		waitForControl(driver, Interfaces.SalesPage.SAVE_AND_APPLY_CREDITS_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SAVE_AND_APPLY_CREDITS_BUTTON);
		sleep();
	}
	
	/**
	 * check Apply Credits Save Successfully
	 */
	public boolean isApplyCreditsSaveSuccessfully() {
		waitForControl(driver, Interfaces.SalesPage.SAVE_SUCCESSFULLY_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.SAVE_SUCCESSFULLY_MESSAGE);
	}
	/**
	 * check Add New Sales Link Display
	 * @return
	 */
	public boolean isAddNewSalesLinkDisplays(){
		waitForControl(driver, Interfaces.SalesPage.ADD_NEW_BUTTON, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.ADD_NEW_BUTTON);
	}
	/**
	 * check Create Sales Order Displays
	 * @return
	 */
	public boolean isCreateSalesOrderDisplays(){
		waitForControl(driver, Interfaces.SalesPage.CREATE_SALES_ORDER_PAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.CREATE_SALES_ORDER_PAGE);
	}
	/**
	 * click On New Button
	 */
	public void clickOnNewButton(){
		waitForControl(driver, Interfaces.SalesPage.ADD_NEW_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.ADD_NEW_BUTTON);
	}
	/**
	 * select Patient
	 * @param patient
	 */
	public void selectPatient(String patient){
		waitForControl(driver, Interfaces.SalesPage.PATIENT_TEXTBOX, timeWait);
		sleep(1);
		click(driver, Interfaces.SalesPage.PATIENT_TEXTBOX);
		type(driver, Interfaces.SalesPage.PATIENT_TEXTBOX, patient);
		sleep();
		if(isControlDisplayed(driver, Interfaces.SalesPage.SEARCH_OTHER_OFFICE_BUTTON)){
			click(driver, Interfaces.SalesPage.SEARCH_OTHER_OFFICE_BUTTON);
		}
		
		sleep();
		if(isControlDisplayed(driver, Interfaces.SalesPage.DYNAMIC_PATIENT_ITEM, patient)){
			click(driver, Interfaces.SalesPage.DYNAMIC_PATIENT_ITEM, patient);
		}
		//Common.getCommon().sendkey(KeyEvent.VK_ENTER);
		sleep();
	}
	/**
	 * select Provider
	 * @param provider
	 */
	public void selectProvider(String provider){
		waitForControl(driver, Interfaces.SalesPage.PROVIDER_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.PROVIDER_COMBOBOX, provider);
	}
	/**
	 * Check Record Saved Successfully
	 * @return
	 */
	public boolean isRecordSavedSuccessfully(){
		waitForControl(driver, Interfaces.SalesPage.RECORD_SAVED_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.RECORD_SAVED_MESSAGE);
	}
	/**
	 * 
	 * @param manufacturer
	 * @param type
	 * @param model
	 * @param battery
	 */
	public void enterHearingAidDetailsLeftEar(String manufacturer, String type, String model,String battery){
		waitForControl(driver, Interfaces.SalesPage.LEFT_MANUFACTURER_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_MANUFACTURER_COMBOBOX, manufacturer);
		sleep(5);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_TYPE_COMBOBOX, type);
		sleep(5);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_MODEL_COMBOBOX, model);
		sleep(5);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_SERIAL_COMBOBOX, model);
		sleep(5);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_BATTERY_COMBOBOX, battery);
		sleep(5);
	}
	/**
	 * 
	 * @param manufacturer
	 * @param type
	 * @param model
	 * @param serial
	 * @param battery
	 */
	public void enterHearingAidDetailsLeftEar(String manufacturer, String type, String model,String serial,String battery){
		waitForControl(driver, Interfaces.SalesPage.LEFT_MANUFACTURER_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_MANUFACTURER_COMBOBOX, manufacturer);
		sleep(5);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_TYPE_COMBOBOX, type);
		sleep(5);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_MODEL_COMBOBOX, model);
		sleep(5);
		if(!serial.isEmpty())
		{
			selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_SERIAL_COMBOBOX, serial);
			sleep(5);
		}
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_BATTERY_COMBOBOX, battery);
		sleep(5);
	}
	/**
	 * select Princing Discount Type
	 */
	public void selectPrincingDiscountType(String discount){
		
		waitForControl(driver, Interfaces.SalesPage.LEFT_DISCOUNT_TYPE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_DISCOUNT_TYPE_COMBOBOX, discount);
		
	}
	/**
	 * enter Pricing CPTHCPCS Code
	 * @param code
	 */
	public void selectPricingCPTHCPCSCode(String code){
		waitForControl(driver, Interfaces.SalesPage.LEFT_CPT_CODE, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.LEFT_CPT_CODE, code);
		
	}
	/**
	 * click On Binaural Button
	 */
	public void clickOnBinauralButton(){
		click(driver, Interfaces.SalesPage.BINAURAL_BUTTON);
		sleep(4);
	}
	/**
	 * enter Princing Discount
	 * @param discount
	 */
	public void enterPrincingDiscount(String discount)
	{
		waitForControl(driver, Interfaces.SalesPage.LEFT_DISCOUNT_TEXTBOX, timeWait);
		type(driver, Interfaces.SalesPage.LEFT_DISCOUNT_TEXTBOX, discount);
	}
	/**
	 * check Right Ear Over write Left Ear
	 * @param manufacturer
	 * @param type
	 * @param model
	 * @param battery
	 * @param discountType
	 * @param discount
	 * @return
	 */
	public boolean isRightEarOverwriteLeftEar(String manufacturer,String type,String model,String battery,String discountType){
		waitForControl(driver, Interfaces.SalesPage.RIGHT_MANUFACTURER_COMBOBOX, timeWait);
		
		String tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.RIGHT_MANUFACTURER_COMBOBOX);
		if(!tmp.equals(manufacturer))
			return false;
		
		tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.RIGHT_TYPE_COMBOBOX);
		if(!tmp.equals(type))
			return false;
		
		tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.RIGHT_MODEL_COMBOBOX);
		if(!tmp.equals(model))
			return false;
		
		tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.RIGHT_BATTERY_COMBOBOX);
		if(!tmp.equals(battery))
			return false;
		
		tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.RIGHT_DISCOUNT_TYPE_COMBOBOX);
		if(!tmp.equals(discountType))
			return false;

		return true;
	}
	/**
	 * check Create Inventory Order Button Displays
	 * @return
	 */
	public boolean isCreateInventoryOrderButtonDisplays(){
		waitForControl(driver,  Interfaces.SalesPage.CREATE_INVENTORY_ORDER_BUTTON, timeWait);
		return isControlDisplayed(driver,  Interfaces.SalesPage.CREATE_INVENTORY_ORDER_BUTTON);
	}
	/**
	 * click On Create Inventory Order Button
	 */
	public void clickOnCreateInventoryOrderButton(){
		waitForControl(driver,  Interfaces.SalesPage.CREATE_INVENTORY_ORDER_BUTTON, timeWait);
		click(driver,  Interfaces.SalesPage.CREATE_INVENTORY_ORDER_BUTTON);
		sleep();
	}
	/**
	 * check Inventory Order Saved
	 */
	public boolean isInventoryOrderSaved(String manufacturer,String type,String model,String battery,String discountType,String discount){
		waitForControl(driver, Interfaces.SalesPage.RIGHT_MANUFACTURER_LABEL, timeWait);
		
		String tmp = getText(driver, Interfaces.SalesPage.RIGHT_MANUFACTURER_LABEL);
		if(!tmp.equals(manufacturer))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.RIGHT_TYPE_LABEL);
		if(!tmp.equals(type))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.RIGHT_MODEL_LABEL);
		if(!model.contains(tmp))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.RIGHT_BATTERY_LABEL);
		if(!tmp.equals(battery))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.RIGHT_DISCOUNT_TYPE_LABEL);
		if(!tmp.equals(discountType))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.LEFT_DISCOUNT_LABEL);
		if(!tmp.contains(discount))
			return false;

		tmp = getText(driver, Interfaces.SalesPage.LEFT_MANUFACTURER_LABEL);
		if(!tmp.equals(manufacturer))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.LEFT_TYPE_LABEL);
		if(!tmp.equals(type))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.LEFT_MODEL_LABEL);
		if(!tmp.equals(model))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.LEFT_BATTERY_LABEL);
		if(!tmp.equals(battery))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.LEFT_DISCOUNT_TYPE_LABEL);
		if(!tmp.equals(discountType))
			return false;
		
		
		tmp = getText(driver, Interfaces.SalesPage.LEFT_DISCOUNT_LABEL);
		if(!tmp.contains(discount))
			return false;
		
		return true;
	}
	/**
	 * 
	 * @return
	 */
	public String getListPrice(){
		waitForControl(driver, Interfaces.SalesPage.LIST_PRICE_LABEL, timeWait);
		return getText(driver, Interfaces.SalesPage.LIST_PRICE_LABEL);
	}
	/**
	 * check Order Items Displays
	 * @return
	 */
	public boolean isOrderItemsDisplays(String type, String item,String status, String listprice){
		waitForControl(driver, Interfaces.SalesPage.TABLE_ORDER_ITEMS, timeWait);
		
		String tmp = getText(driver, Interfaces.SalesPage.ITEM_ODER_TYPE,item);
		if(tmp == null)
			tmp = "";
		if(!tmp.equals(type))
			return false;
		
		tmp = getText(driver, Interfaces.SalesPage.ITEM_ODER_STATUS,item);
		if(tmp == null)
			tmp = "";
		if(!tmp.equals(status))
			return false;
		
		tmp = getAttributeValue(driver, Interfaces.SalesPage.ITEM_ODER_LIST_PRICE,item,"value");
		if(tmp == null)
			tmp = "$0.00";
		if(!tmp.equals(listprice))
			return false;
		
		return true;
	}
	/**
	 * select Order Item For Remove
	 * @param item
	 */
	public void selectOrderItemForRemove(String item){
		click(driver, Interfaces.SalesPage.ITEM_ODER_REMOVE_CHECKBOX,item);
	}
	/**
	 * click On Check Out Button
	 */
	public void clickOnCheckOutButton(){
		waitForControl(driver, Interfaces.SalesPage.CHECK_OUT_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.SalesPage.CHECK_OUT_BUTTON);
		sleep();
	}

	/**
	 * enter Gadget Items Info
	 */
	public void enterGadgetItemsInfo(String manufacturer,String type,String part,String cDiscount,String eDiscount){
		waitForControl(driver, Interfaces.SalesPage.MANUFACTURER_GADGET_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.MANUFACTURER_GADGET_COMBOBOX, manufacturer);
		sleep();
		selectItemComboxbox(driver, Interfaces.SalesPage.TYPE_GAGET_COMBOBOX, type);
		sleep();
		selectItemComboxbox(driver, Interfaces.SalesPage.PART_GAGET_COMBOBOX, part);
		sleep();
		selectItemComboxbox(driver, Interfaces.SalesPage.CHOOSE_DISCOUNT_GAGET_COMBOBOX, cDiscount);
		type(driver, Interfaces.SalesPage.ENTER_DISCOUNT_GAGET_TEXTBOX, eDiscount);
	}
	/**
	 * check Warning Message Displays
	 * @param msg
	 * @return
	 */
	public boolean isWarningMessageDisplays(String msg){
		waitForControl(driver, Interfaces.SalesPage.ERROR_WARNING_MESSAGE, msg, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.ERROR_WARNING_MESSAGE, msg);
	}
	/**
	 * click Create Gadget Order
	 */
	public void clickCreateGadgetOrder(){
		waitForControl(driver, Interfaces.SalesPage.CREATE_GADGET_ORDER, timeWait);
		click(driver, Interfaces.SalesPage.CREATE_GADGET_ORDER);
		sleep();
	}
	/**
	 * click On Save Return Sale Order
	 */
	public void clickOnSaveReturnSaleOrder(){
		waitForControl(driver, Interfaces.SalesPage.SAVE_RETURN_SALE_ORDER, timeWait);
		click(driver, Interfaces.SalesPage.SAVE_RETURN_SALE_ORDER);
	}
	/**
	 * 
	 */
	public void clickOnSearchButton(){
		waitForControl(driver, Interfaces.SalesPage.SEARCH_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SEARCH_BUTTON);
	}
	/**
	 * check Order Exists In List
	 * @param saleID
	 * @return
	 */
	public boolean isOrderExistsInList(String saleID){
		waitForControl(driver, Interfaces.SalesPage.TABLE_LIST_ORDERS, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.OPEN_ITEM_LIST_ORDER_LINK,saleID);
	}
	/**
	 * check Sales Order Type Correctly
	 * @param saleID
	 * @param type
	 * @return
	 */
	public boolean isSalesOrderTypeCorrectly(String saleID, String type){
		waitForControl(driver, Interfaces.SalesPage.TABLE_LIST_ORDERS, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.SALE_ORDER_TYPE_ITEM_LIST_ORDER,saleID,type);
	}
	/**
	 * open List Order Item
	 * @param saleID
	 */
	public void openListOrderItem(String saleID){
		waitForControl(driver, Interfaces.SalesPage.TABLE_LIST_ORDERS, timeWait);
		click(driver, Interfaces.SalesPage.OPEN_ITEM_LIST_ORDER_LINK,saleID);
	}
	/**
	 * open Order Item
	 * @param item
	 */
	public void openOrderItem(String item){
		waitForControl(driver, Interfaces.SalesPage.OPEN_ITEM_ODER_LINK,item, timeWait);
		click(driver, Interfaces.SalesPage.OPEN_ITEM_ODER_LINK,item);
	}
	/**
	 * check Craete Sales Order Page Displays
	 * @return
	 */
	public boolean isCraeteSalesOrderPageDisplays(){
		waitForControl(driver, Interfaces.SalesPage.CREATE_SALES_ORDER_PAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.CREATE_SALES_ORDER_PAGE);
	}
	/**
	 * click List Order Button
	 */
	public void clickListOrderButton(){
		waitForControl(driver, Interfaces.SalesPage.LIST_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.LIST_ORDER_BUTTON);
	}
	/**
	 * check Sales Order Type Correctly
	 * @param saleID
	 * @param status
	 * @return
	 */
	public boolean isStatusOrderCorrectly(String saleID, String status){
		waitForControl(driver, Interfaces.SalesPage.TABLE_LIST_ORDERS, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.STATUS_SALE_ORDER_LIST_ITEMS,saleID,status);
	}
	/**
	 * search Order Item
	 * @param id
	 */
	public void searchOrderItem(String id){
		waitForControl(driver, Interfaces.SalesPage.SEARCH_SALES_ORDER_ITEM_TEXTBOX, timeWait);
		click(driver, Interfaces.SalesPage.SEARCH_SALES_ORDER_ITEM_TEXTBOX);
		type(driver, Interfaces.SalesPage.SEARCH_SALES_ORDER_ITEM_TEXTBOX, id);
		clickOnSearchButton();
		sleep();
	}
	/**
	 * get Sales Order Total Price
	 * @return
	 */
	public String getTotalPrice(){
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_TOTAL_PRICE, timeWait);
		
		return getText(driver, Interfaces.SalesPage.SALES_ORDER_TOTAL_PRICE);
	}
	/**
	 * click On Collect CC Payments
	 */
	public BillingPage clickOnCollectCCPayments(){
		waitForControl(driver, Interfaces.SalesPage.COLLECT_CC_PAYMENT_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.COLLECT_CC_PAYMENT_BUTTON);
		waitForControlNotDisplayed(driver, Interfaces.SalesPage.COLLECT_CC_PAYMENT_BUTTON, timeWait);
		return PageFactory.getBillingPage(driver, ipClient);
	}
	/**
	 * get Balance Price
	 * @param totalPrice
	 * @param totalAmount
	 * @return
	 */
	public String getBalancePrice(String totalPrice,String totalAmount){
		String strTotal = totalPrice.substring(1, totalPrice.length());
		String arrTotal[] = strTotal.split(",");
		strTotal = arrTotal[0]+arrTotal[1];
		
		if(totalAmount.contains("$"));
			totalAmount = totalAmount.substring(1, totalAmount.length());
		String arrAmount[] = totalAmount.split(",");
		totalAmount = arrAmount[0]+arrAmount[1];
		
//		Float flTotal = Float.parseFloat(strTotal);
//		Float flAmount = Float.parseFloat(totalAmount);
		
		double dbTotal = Double.parseDouble(strTotal);
		double dbAmount = Double.parseDouble(totalAmount);

		return dbTotal - dbAmount + "";
	}
	/**
	 * check Payments Adjustmen Exists
	 * @param remark
	 * @return
	 */
	public boolean isPaymentsAdjustmenExists(String remark){
		waitForControl(driver, Interfaces.SalesPage.REMARK_ORDER_ITEM_LABEL, remark, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.REMARK_ORDER_ITEM_LABEL, remark);
	}
	/**
	 * check Paid Displays Correct
	 * @param paid
	 * @return
	 */
	public boolean isPaidDisplaysCorrect(String paid){
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_PAID, timeWait);
		String tmp = getText(driver, Interfaces.SalesPage.SALES_ORDER_PAID);
		if(tmp.contains(paid))
			return true;
		return false;
	}
	/**
	 * check Balance Displays Correct
	 * @param balance
	 * @return
	 */
	public boolean isBalanceDisplaysCorrect(String balance){
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_BALANCE_LABEL, timeWait);
		String tmp = getText(driver, Interfaces.SalesPage.SALES_ORDER_BALANCE_LABEL);
		tmp = tmp.substring(1, tmp.length());
		if(tmp.contains(",")){
			String arrTotal[] = tmp.split(",");
			tmp = arrTotal[0]+arrTotal[1];
		}
		
		if(balance.contains("$"))
			balance = balance.substring(1, balance.length());
		if(balance.contains(",")){
			String arrTotal[] = balance.split(",");
			balance = arrTotal[0]+arrTotal[1];
		}
		if(tmp.contains(balance))
			return true;
		return false;
	}
	/**
	 * select Check-In Tab
	 */
	public PatientsPage selectCheckInTab(){
		waitForControl(driver, Interfaces.SalesPage.CHECK_IN_TAB_LINK, timeWait);
		click(driver,  Interfaces.SalesPage.CHECK_IN_TAB_LINK);
		return PageFactory.getPatientsPage(driver, ipClient);
	}
	/**
	 * click On Check Cash Payment Button
	 */
	public BillingPage clickOnCheckCashPaymentButton(){
		waitForControl(driver, Interfaces.SalesPage.CHECK_CASH_PAYMENTS_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.CHECK_CASH_PAYMENTS_BUTTON);
		return PageFactory.getBillingPage(driver, ipClient);
	}
	/**
	 * Verify Sales Order Items Displays
	 * @param serial
	 * @return
	 */
	public boolean isSalesOrderItemsDisplays(String serial){
		waitForControl(driver, Interfaces.SalesPage.LINE_ITEM_ORDER, serial, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.LINE_ITEM_ORDER, serial);
	}
	/**
	 * Verify Sales Order Items Displays
	 * @param serial
	 * @param status
	 * @return
	 */
	public boolean isSalesOrderItemsDisplays(String serial, String status){
		waitForControl(driver, Interfaces.SalesPage.STATUS_LINE_ITEM_ORDER, serial,status, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.STATUS_LINE_ITEM_ORDER, serial, status);
	}
	/**
	 * check Inventory Number Displays
	 * @return
	 */
	public boolean isLeftInventoryNumberDisplays(){
		waitForControl(driver, Interfaces.SalesPage.LEFT_INVENTORY_NUMBER_LABEL, timeWait);
		int tmp = Integer.parseInt(getText(driver, Interfaces.SalesPage.LEFT_INVENTORY_NUMBER_LABEL));
		if(tmp>0)
			return true;
		return false;
		
	}
	/**
	 * click On Return Button
	 */
	public void clickOnReturnButton(){
		waitForControl(driver, Interfaces.SalesPage.RETURN_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.RETURN_BUTTON);
	}
	/**
	 * select Sale Order Return To
	 * @param item
	 * @param rtOption
	 */
	public void selectSaleOrderReturnTo(String item, String rtOption ){
		waitForControl(driver, Interfaces.SalesPage.ORDERED_ITEM_RETURN_TO_COMBOBOX, item, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.ORDERED_ITEM_RETURN_TO_COMBOBOX, item, rtOption);
	}
	/***
	 * click On Save Return Button
	 */
	public void clickOnSaveReturnButton(){
		waitForControl(driver, Interfaces.SalesPage.SAVE_RETURN_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SAVE_RETURN_BUTTON);
		sleep();
		if(isControlDisplayed(driver, Interfaces.SalesPage.YES_BUTTON))
			click(driver, Interfaces.SalesPage.YES_BUTTON);
			
	}
	
	/**
	 * click On Create Invoice Button
	 */
	public void clickOnCreateInvoiceButton(){
		waitForControl(driver, Interfaces.SalesPage.CREATE_INVOICE_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.CREATE_INVOICE_BUTTON);
	}
	/**
	 * check Create Invoice Success
	 * @return
	 */
	public boolean isCreateInvoiceSuccess(){
		waitForControl(driver, Interfaces.SalesPage.INVOICE_PATIENT_CREDIT_LABEL, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.INVOICE_PATIENT_CREDIT_LABEL);
	}
	/**
	 * click On From Stock Button
	 */
	public void clickOnFromStockButton(){
		waitForControl(driver, Interfaces.SalesPage.LEFT_FROM_STOCK_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.LEFT_FROM_STOCK_BUTTON);
	}

	/**
	 * Switch driver to From Stock Frame
	 * @return driver
	 */
	public WebDriver switchToLeftFromStockFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.SalesPage.LEFT_FROM_STOCK_FRAME, timeWait);
		sleep(5);
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.SalesPage.LEFT_FROM_STOCK_FRAME)));
		return driver;
	}
	/**
	 * select Serial Stock
	 */
	public void selectSerialStock(String serial){
		waitForControl(driver, Interfaces.SalesPage.SERIAL_LEFT_FROM_STOCK_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.SERIAL_LEFT_FROM_STOCK_COMBOBOX, serial);
	}
	/**
	 * click On Select Button
	 */
	public void clickOnSelectButton(){
		waitForControl(driver, Interfaces.SalesPage.SELECT_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SELECT_BUTTON);
	}
	/**
	 * Verify Stock Enter Left Ear correctly
	 * @param manufacturer
	 * @param type
	 * @param model
	 * @param newSerialInStock
	 * @return
	 */
	public boolean isStockEnterLeftEar(String manufacturer,String type,String model,String serialInStock){
		waitForControl(driver, Interfaces.SalesPage.LEFT_MANUFACTURER_COMBOBOX, timeWait);
		sleep(4);
		
		String tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.LEFT_MANUFACTURER_COMBOBOX);
		if(!tmp.equals(manufacturer))
			return false;
		
		tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.LEFT_TYPE_COMBOBOX);
		if(!tmp.equals(type))
			return false;
		
		tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.LEFT_MODEL_COMBOBOX);
		if(!tmp.equals(model))
			return false;
		
		tmp = getItemSelectedCombobox(driver, Interfaces.SalesPage.LEFT_SERIAL_FROM_STOCK_COMBOBOX);
		if(!tmp.equals(serialInStock))
			return false;

		return true;
	}
	/**
	 * Verify Check Out Sale Order Success
	 * @return
	 */
	public boolean isCheckOutSaleOrderSuccess(){
		waitForControl(driver, Interfaces.SalesPage.CHECK_OUT_SALE_ORDER_PAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.SalesPage.CHECK_OUT_SALE_ORDER_PAGE);
	}
	/**
	 * check Delivery Date Correct
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public boolean isDeliveryDateCorrect(int month, int day, int year){
		waitForControl(driver, Interfaces.SalesPage.DELIVERY_DATE_ON_DELIVER, timeWait);
		String tmp = getAttributeValue(driver, Interfaces.SalesPage.DELIVERY_DATE_ON_DELIVER, "value");
		if(tmp.equals(month+"/"+day+"/"+year))
			return true;
		return false;
	}
	
	/**
	 * select Item Sales Order Repair
	 * @param item
	 */
	public void selectItemSalesOrderRepair(String item){
		waitForControl(driver, Interfaces.SalesPage.ITEM_SALES_ORDER_REPAIR_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.SalesPage.ITEM_SALES_ORDER_REPAIR_COMBOBOX, item);
	}
	/**
	 * select Manufacturer Sales Order Repair
	 * @param manu
	 */
	public void selectManufacturerSalesOrderRepair(String manu){
		waitForControl(driver, Interfaces.SalesPage.MANUFACTURER_SALE_ORDER_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.SalesPage.MANUFACTURER_SALE_ORDER_COMBOBOX, manu);
		sleep(5);
	}
	/**
	 * select Warranty Sales Order Repair
	 * @param warranty
	 */
	public void selectWarrantySalesOrderRepair(String warranty){
		waitForControl(driver, Interfaces.SalesPage.WARRANTY_SALE_ORDER_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.SalesPage.WARRANTY_SALE_ORDER_COMBOBOX, warranty);
		sleep(5);
	}
	/**
	 * select Repair Sales Order Repair
	 * @param repair
	 */
	public void selectRepairSalesOrderRepair(String repair){
		waitForControl(driver, Interfaces.SalesPage.REPAIR_SALE_ORDER_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.SalesPage.REPAIR_SALE_ORDER_COMBOBOX, repair);
		sleep(5);
	}
	/**
	 * enter Remark Sales Order Repair
	 */
	public void enterRemarkSalesOrderRepair(String remark){
		waitForControl(driver, Interfaces.SalesPage.REMARK_SALE_ORDER_TEXTBOX, timeWait);
		sleep();
		type(driver,  Interfaces.SalesPage.REMARK_SALE_ORDER_TEXTBOX, remark);
	}
	/**
	 * click On Create Repair Order
	 */
	public void clickOnCreateRepairOrder(){
		waitForControl(driver, Interfaces.SalesPage.CREATE_REPAIR_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.CREATE_REPAIR_ORDER_BUTTON);
		sleep(5);
	}
	/**
	 * click On Exchange Button
	 */
	public void clickOnExchangeButton(){
		waitForControl(driver, Interfaces.SalesPage.EXCHANGE_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.EXCHANGE_BUTTON);
	}
	/**
	 * click On Save Select New Hearing Aid Button
	 */
	public void clickOnSaveSelectNewHearingAidButton(){
		waitForControl(driver, Interfaces.SalesPage.SAVE_SELECT_NEW_HEARING_AID_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SAVE_SELECT_NEW_HEARING_AID_BUTTON);
		sleep();
		if(isControlDisplayed(driver, Interfaces.SalesPage.YES_BUTTON))
			click(driver, Interfaces.SalesPage.YES_BUTTON);
	}
	/**
	 * select Exchange Order
	 * @param id
	 */
	public void selectExchangeOrder(String id){
		waitForControl(driver, Interfaces.SalesPage.EXCHANGE_ORDER_ITEM,id, timeWait);
		click(driver, Interfaces.SalesPage.EXCHANGE_ORDER_ITEM, id);
	}
	/**
	 * ge Exchange Item Price
	 * @return
	 */
	public String getExchangeItemPrice(String id){
		waitForControl(driver, Interfaces.SalesPage.PRICE_EXCHANGE_ORDER_ITEM,id, timeWait);
		return getText(driver, Interfaces.SalesPage.PRICE_EXCHANGE_ORDER_ITEM,id);
	}
	/**
	 * check Balance Displays Correct
	 * @param balance
	 * @return
	 */
	public boolean isPatientBalanceDisplaysCorrectly(String balance){
		waitForControl(driver, Interfaces.SalesPage.PATIENT_ACCOUNT_BALANCE_LABEL, timeWait);
		String tmp = getText(driver, Interfaces.SalesPage.PATIENT_ACCOUNT_BALANCE_LABEL);
		tmp = tmp.substring(1, tmp.length());
		if(tmp.contains(",")){
			String arrTotal[] = tmp.split(",");
			tmp = arrTotal[0]+arrTotal[1];
		}
		if(tmp.contains(balance))
			return true;
		return false;
	}
	/**
	 * click On Back Sale Order
	 */
	public void clickOnBackSaleOrder(){
		waitForControl(driver, Interfaces.SalesPage.BACK_SALE_ORDER_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.SalesPage.BACK_SALE_ORDER_BUTTON);
	}
	
	/**
	 * get Check Out Sales Orders Id
	 * @return
	 */
	public String getCheckOutSalesOrdersId(){
		waitForControl(driver, Interfaces.SalesPage.CHECK_OUT_SALES_ORDER_ID, timeWait);
		return getText(driver, Interfaces.SalesPage.CHECK_OUT_SALES_ORDER_ID);
	}
	/**
	 * check Appointment Displays Correctly
	 * @param label
	 * @return
	 */
	public boolean isAppointmentDisplaysCorrectly(String label){
		waitForControl(driver, Interfaces.SalesPage.APPOINTMENT_LABEL, timeWait);
		String tmp = getText(driver, Interfaces.SalesPage.APPOINTMENT_LABEL);
		if(tmp.contains(label))
			return true;
		return false;
		
	}
	/**
	 * select Apointment
	 * @param appoint
	 */
	public void selectApointment(String appoint){
		waitForControl(driver, Interfaces.SalesPage.APOINTMENT_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.APOINTMENT_COMBOBOX, appoint);
	}
	/**
	 * select Hearing Aid Loss Damage
	 * @param Hearing Aid ID
	 */
	public void selectHearingAidLossDamage(String HAID){
		waitForControl(driver, Interfaces.SalesPage.HEARING_AID_LOSS_DAMAGE_ITEM_CHECKBOX,HAID, timeWait);
		click(driver, Interfaces.SalesPage.HEARING_AID_LOSS_DAMAGE_ITEM_CHECKBOX,HAID);
		sleep();
	}
	/**
	 * click On Next Button
	 */
	public void clickOnNextButton(){
		waitForControl(driver, Interfaces.SalesPage.NEXT_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.NEXT_BUTTON);
		sleep();
	}
	/**
	 * select Service In Patient Service
	 * @param service
	 */
	public void selectServiceInPatientService(String service){
		waitForControl(driver, Interfaces.SalesPage.SERVICE_IN_PATIENT_SERVICE_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.SERVICE_IN_PATIENT_SERVICE_COMBOBOX, service);
		sleep();
	}
	/**
	 * enter List Price In Patient Service
	 * @param price
	 */
	public void enterListPriceInPatientService(String price){
		waitForControl(driver, Interfaces.SalesPage.LIST_PRICE_PATIENT_SERVICE_TEXTBOX, timeWait);
		type(driver, Interfaces.SalesPage.LIST_PRICE_PATIENT_SERVICE_TEXTBOX, price);
	}
	
	/**
	 * select Status Order Item
	 * @param orderName
	 */
	public InventoryPage selectStatusOrderItem(String orderName){
		waitForControl(driver, Interfaces.SalesPage.STATUS_SALE_ODER_ITEM_LINK,orderName, timeWait);
		click(driver, Interfaces.SalesPage.STATUS_SALE_ODER_ITEM_LINK, orderName);
		return PageFactory.getInventoryPage(driver, ipClient);
	}
	/**
	 * click On Patient Name
	 */
	public PatientsPage clickOnPatientName(){
		waitForControl(driver, Interfaces.SalesPage.PATIENT_NAME_LINK,timeWait);
		click(driver, Interfaces.SalesPage.PATIENT_NAME_LINK);
		return PageFactory.getPatientsPage(driver, ipClient);
	}
	/**
	 * click On Refund Button
	 */
	public BillingPage clickOnRefundButton(){
		waitForControl(driver, Interfaces.SalesPage.REFUND_BUTTON,timeWait);
		click(driver, Interfaces.SalesPage.REFUND_BUTTON);
		return PageFactory.getBillingPage(driver, ipClient);
	}
	/**
	 * select Refund Method
	 * @param method
	 */
	public void selectRefundMethod(String method){
		waitForControl(driver, Interfaces.SalesPage.REFUND_METHOD_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.REFUND_METHOD_COMBOBOX, method);
	}
	/**
	 * get Payment refund
	 * @return
	 */
	public String getRefundPayment(){
		waitForControl(driver, Interfaces.SalesPage.REFUND_PAYMENT_LABEL, timeWait);
		return getText(driver, Interfaces.SalesPage.REFUND_PAYMENT_LABEL);
	}
	/**
	 * 
	 * @param amount
	 */
	public void enterRefundAmount(String amount){
		waitForControl(driver, Interfaces.SalesPage.REFUND_AMOUNT_TEXTBOX, timeWait);
		type(driver, Interfaces.SalesPage.REFUND_AMOUNT_TEXTBOX, amount);
	}
	/**
	 * enter Remark Sales Order Refund
	 */
	public void enterRemarkSalesOrderRefund(String remark){
		waitForControl(driver, Interfaces.SalesPage.REMARK_SALE_ORDER_REFUND_TEXTBOX, timeWait);
		type(driver, Interfaces.SalesPage.REMARK_SALE_ORDER_REFUND_TEXTBOX, remark);
	}
	
	/**
	 * check Payment Item Displays
	 * @param remark
	 * @return
	 */
	public boolean isPaymentItemDisplays(String remark){
		waitForControl(driver, Interfaces.SalesPage.PAYMENT_ITEM_REMARK_LABEL, timeWait);
		return isControlDisplayed( 	driver, Interfaces.SalesPage.PAYMENT_ITEM_REMARK_LABEL, remark);
	}
	/**
	 * get Credit Amount
	 * @return
	 */
	public String getCreditAmount(){
		waitForControl(driver, Interfaces.SalesPage.PATIENT_ACCOUNT_BALANCE_LABEL, timeWait);
		String tmp = getText(driver, Interfaces.SalesPage.PATIENT_ACCOUNT_BALANCE_LABEL);
		return tmp;
	}
	/**
	 * Select item in repair manufacturer combobox
	 * @param manufacturer
	 */
	public void selectRepairManufacturer(String manufacturer)
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_MANUFACTURER_COMBOBOX_OPTION,manufacturer, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_MANUFACTURER_COMBOBOX_OPTION,manufacturer);
		sleep();
	}
	/**
	 * Select item in repair warranty combobox
	 * @param warranty
	 */
	public void selectRepairWarranty(String warranty)
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_WARRANTY_COMBOBOX_OPTION,warranty, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_WARRANTY_COMBOBOX_OPTION,warranty);
		sleep();
	}
	/**
	 * Select item in repair repair combobox
	 * @param repair
	 */
	public void selectRepairRepair(String repair)
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_REPAIR_COMBOBOX_OPTION,repair, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_REPAIR_COMBOBOX_OPTION,repair);
		sleep();
	}
	/**
	 * Click Repair Save button
	 */
	public void clickRepairSaveButton()
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_SAVE_BUTTON);
	}
	/**
	 * Click Repair Create/View Repair Order button
	 */
	public void clickRepairCreateRepairOrderButton()
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_CREATE_VIEW_REPAIR_ORDER_BUTTON, timeWait);
		click(driver,Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_CREATE_VIEW_REPAIR_ORDER_BUTTON);
	}
	/**
	 * Click Repair Go To Sales Order page button
	 */
	public void clickRepairGoToSalesOrderButton()
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_GO_TO_SALES_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_NEW_REPAIR_GO_TO_SALES_ORDER_BUTTON);
	}
	/**
	 * Click Sales Order Check Out button
	 */
	public void clickSalesOrderCheckOutButton()
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_SALES_ORDER_CHECK_OUT_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_SALES_ORDER_CHECK_OUT_BUTTON);
	}
	/**
	 * Check if Sales Order ID displays or not
	 * @return
	 */
	public boolean isSalesOrderIDDisplays()
	{
		waitForControl(driver,Interfaces.SalesPage.SALES_ORDER_SALES_ORDER_SALES_ORDER_ID_SPAN,timeWait);
		return isControlDisplayed(driver,Interfaces.SalesPage.SALES_ORDER_SALES_ORDER_SALES_ORDER_ID_SPAN);
	}
	/**
	 * Get Sales Order ID
	 * @return
	 */
	public String getSalesOrderID()
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_SALES_ORDER_SALES_ORDER_ID_SPAN, timeWait);
		return getText(driver, Interfaces.SalesPage.SALES_ORDER_SALES_ORDER_SALES_ORDER_ID_SPAN);
	}
	/**
	 * Get Status of Order Item based on Index
	 * @param index
	 * @return
	 */
	public String getStatusOfOrderItem(String index)
	{
		waitForControl(driver, Interfaces.SalesPage.DYNAMIC_ORDER_ITEM_STATUS,index, timeWait);
		return getText(driver, Interfaces.SalesPage.DYNAMIC_ORDER_ITEM_STATUS,index);
	}
	/**
	 * Switch driver to iFrame
	 * @return driver
	 */
	public WebDriver switchDeliverFrame(WebDriver driver) {
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_DELIVER_IFRAME, timeWait);
		sleep();
		driver = driver.switchTo().frame(driver.findElement(By.xpath(Interfaces.SalesPage.SALES_ORDER_DELIVER_IFRAME)));
		return driver;
	}
	/**
	 * Click Deliver button
	 */
	public void clickDeliverButton()
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_DELIVER_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_DELIVER_BUTTON);
	}
	/**
	 * Select Delivery method
	 * @param deliveryMethod
	 */
	public void selectDeliveryMethod(String deliveryMethod)
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_DELIVER_DELIVERY_METHOD_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.SALES_ORDER_DELIVER_DELIVERY_METHOD_COMBOBOX, deliveryMethod);
	}
	/**
	 * Select return to option
	 * @param option
	 */
	public void selectReturnToOption(String option)
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_RETURN_TO_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.SalesPage.SALES_ORDER_RETURN_TO_COMBOBOX, option);
	}
	/**
	 * Click Save and Select New button
	 */
	public void clickSaveAndSelectNewButton()
	{
		waitForControl(driver, Interfaces.SalesPage.SALES_ORDER_SAVE_AND_SELECT_NEW_BUTTON, timeWait);
		click(driver, Interfaces.SalesPage.SALES_ORDER_SAVE_AND_SELECT_NEW_BUTTON);
	}
	private WebDriver driver;
	private String ipClient;
}