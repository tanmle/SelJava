package page;

import org.openqa.selenium.WebDriver;
import HearingFusion.Interfaces;

public class InventoryPage extends AbstractPage {

	public InventoryPage(WebDriver driver, String ipClient) {
		control.setPage(this.getClass().getSimpleName());
		this.driver = driver;
		this.ipClient = ipClient;
	}
	/**
	 * check List Inventory Tab Displas Correct
	 * @return
	 */
	public boolean isListInventoryTabDisplasCorrect(){
		waitForControl(driver, Interfaces.InventoryPage.INVENTORY_LIST_LINK, timeWait);
		int n = countElement(driver, Interfaces.InventoryPage.INVENTORY_LIST_LINK);
		if(n == 9)
			return true;
		else
			return false;
	}
	/**
	 * check Inventory Tab Link Displays
	 */
	public boolean isInventoryTabLinkDisplays(String inventoryLink){
		waitForControl(driver, Interfaces.InventoryPage.INVENTORY_TAB_LINK,inventoryLink, timeWait);
		return isControlDisplayed(driver, Interfaces.InventoryPage.INVENTORY_TAB_LINK,inventoryLink);
	}

	/**
	 * select Office Search Hearing
	 * @param office
	 */
	public void selectOfficeSearchOrder(String office){
		waitForControl(driver, Interfaces.InventoryPage.OFFICE_SEARCH_ORDER_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.OFFICE_SEARCH_ORDER_COMBOBOX, office);
	}
	/**
	 * enter Patient Last Name Search Hearing
	 * @param lastName
	 */
	public void enterPatientLastNameSearchOrder(String lastName){
		waitForControl(driver, Interfaces.InventoryPage.PATIENT_LAST_NAME_SEARCH_HEARING_AID_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.PATIENT_LAST_NAME_SEARCH_HEARING_AID_TEXTBOX, lastName);
	}
	/**
	 * enter Sales Order ID Search Hearing
	 */
	public void enterSalesOrderIDSearchOrder(String saleID){
		waitForControl(driver, Interfaces.InventoryPage.SALE_ORDER_ID_SEARCH_HEARING_AID_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.SALE_ORDER_ID_SEARCH_HEARING_AID_TEXTBOX, saleID);
	}
	/**
	 * click On Search Button
	 */
	public void clickOnSearchButton(){
		waitForControl(driver, Interfaces.InventoryPage.SEARCH_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.SEARCH_BUTTON);
	}
	/**
	 * check Hearing Aid Orders Item Displays
	 * @param saleID
	 */
	public boolean isHearingAidOrdersItemDisplays(String saleID){
		waitForControl(driver, Interfaces.InventoryPage.HEARING_AID_SALE_ORDER_ITEM_OPEN_LINK,saleID, timeWait);
		return isControlDisplayed(driver, Interfaces.InventoryPage.HEARING_AID_SALE_ORDER_ITEM_OPEN_LINK,saleID);
	}
	/**
	 * select Hearing Aid Order Item
	 * @param saleID
	 */
	public void selectHearingAidOrderItem(String saleID){
		waitForControl(driver, Interfaces.InventoryPage.HEARING_AID_SALE_ORDER_ITEM_OPEN_LINK,saleID, timeWait);
		click(driver, Interfaces.InventoryPage.HEARING_AID_SALE_ORDER_ITEM_OPEN_LINK, saleID);
		waitForControlNotDisplayed(driver,Interfaces.InventoryPage.HEARING_AID_SALE_ORDER_ITEM_OPEN_LINK, saleID, timeWait);
	}
	/**
	 * enter Invoice Date Inventory Hearing
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterInvoiceDateInventoryOrder(int month, int day, int year){
		waitForControl(driver, Interfaces.InventoryPage.INVOICE_DATE_INVENTORY_ORDER_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.INVOICE_DATE_INVENTORY_ORDER_TEXTBOX, month+"/"+day+"/"+year);
	}
	/**
	 * enter Manufacturer Invoice Inventory Hearing
	 * @param id
	 */
	public void enterManufacturerInvoiceInventoryOrder(String id){
		waitForControl(driver, Interfaces.InventoryPage.MANUFACTURER_INVOICE_INVENTORY_ORDER_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.MANUFACTURER_INVOICE_INVENTORY_ORDER_TEXTBOX, id);
	}
	/**
	 * enter Serial Order Item Ear Left
	 */
	public void enterSerialHearingOrderItemEarLeft(String id){
		waitForControl(driver, Interfaces.InventoryPage.SERIAL_HEARING_ORDER_ITEM_EAR_LEFT, timeWait);
		type(driver, Interfaces.InventoryPage.SERIAL_HEARING_ORDER_ITEM_EAR_LEFT, id);
	}
	/**
	 * enter Serial Hearing Order Item Ear Right
	 * @param id
	 */
	public void enterSerialHearingOrderItemEarRight(String id){
		waitForControl(driver, Interfaces.InventoryPage.SERIAL_HEARING_ORDER_ITEM_EAR_RIGHT, timeWait);
		type(driver, Interfaces.InventoryPage.SERIAL_HEARING_ORDER_ITEM_EAR_RIGHT, id);
	}
	/**
	 * enter Manufacturer Warranty Ear Right
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterManufacturerWarrantyEarRight(int month,int day,int year){
		waitForControl(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_EAR_RIGHT_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_EAR_RIGHT_TEXTBOX, month+"/"+day+"/"+year);
	}
	/**
	 * enter Manufacturer Warranty Ear Left
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterManufacturerWarrantyEarLeft(int month,int day,int year){
		waitForControl(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_EAR_LEFT_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_EAR_LEFT_TEXTBOX, month+"/"+day+"/"+year);
	}
	
	/**
	 * select Order Status Inventory Hearing Aid
	 * @param order
	 */
	public void selectOrderStatusInventoryOrder(String order){
		waitForControl(driver, Interfaces.InventoryPage.ORDER_STATUS_INVENTORY_ORDER, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.ORDER_STATUS_INVENTORY_ORDER, order);
	}
	/**
	 * click On Save Button
	 */
	public void clickOnSaveButton(){
		waitForControl(driver, Interfaces.InventoryPage.SAVE_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.InventoryPage.SAVE_BUTTON);
	}
	/**
	 * enter Loss and Damage Ear Right
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterLossDamageEarLeft(int month,int day,int year){
		waitForControl(driver, Interfaces.InventoryPage.LOSS_DAMEGE_EAR_LEFT_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.LOSS_DAMEGE_EAR_LEFT_TEXTBOX, month+"/"+day+"/"+year);
	}

	/**
	 * enter Loss and Damage Ear Right
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterLossDamageEarRight(int month,int day,int year){
		waitForControl(driver, Interfaces.InventoryPage.LOSS_DAMEGE_EAR_RIGHT_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.LOSS_DAMEGE_EAR_RIGHT_TEXTBOX, month+"/"+day+"/"+year);
	}
	/**
	 * Verify Warning Proceed Order Displays
	 * @return Received
	 */
	public boolean isWarningProceedOrderToReceivedDisplays(){
		waitForControl(driver, Interfaces.InventoryPage.PROCESS_TO_RECEIVED_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.InventoryPage.PROCESS_TO_RECEIVED_MESSAGE);
	}
	/**
	 * select Yes Proceed Order Received Button
	 */
	public void selectYesProceedOrderReceivedButton(){
		waitForControl(driver, Interfaces.InventoryPage.YES_BUTTON, timeWait);
		sleep();
		click(driver, Interfaces.InventoryPage.YES_BUTTON);
	}
	/**
	 * Verify Waning Message Duplicate Serial Displays
	 * @return
	 */
	public boolean isWaningMessageDuplicateSerialDisplays(){
		waitForControl(driver, Interfaces.InventoryPage.ERROR_MESSAGE_DUPLICATE_SERIAL, timeWait);
		return isControlDisplayed(driver, Interfaces.InventoryPage.ERROR_MESSAGE_DUPLICATE_SERIAL);
	}
	/**
	 * Verify Order Status Label Correctly
	 * @param status
	 * @return
	 */
	public boolean isOrderStatusLabelCorrectly(String status){
		waitForControl(driver, Interfaces.InventoryPage.INVENTORY_ORDER_STATUS_LABEL, status, timeWait);
		return isControlDisplayed(driver, Interfaces.InventoryPage.INVENTORY_ORDER_STATUS_LABEL, status);
	}
	/**
	 * open Hearing Aid Sale Order
	 */
	public SalesPage openInventorySaleOrder(){
		waitForControl(driver, Interfaces.InventoryPage.INVENTORY_SALES_ORDER_LINK, timeWait);
		click(driver, Interfaces.InventoryPage.INVENTORY_SALES_ORDER_LINK);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * open Inventory Tab
	 * @param tab
	 */
	public void openInventoryTab(String tab){
		waitForControl(driver, Interfaces.InventoryPage.INVENTORY_TAB_LINK,tab, timeWait);
		click(driver, Interfaces.InventoryPage.INVENTORY_TAB_LINK,tab);
	}
	/**
	 * select Gadget Order Item
	 */
	public void selectGadgetOrderItem(String saleID){
		waitForControl(driver, Interfaces.InventoryPage.INVENTORY_GAGET_ORDER_ITEM,saleID, timeWait);
		click(driver, Interfaces.InventoryPage.INVENTORY_GAGET_ORDER_ITEM,saleID);
	}
	/**
	 * 
	 * @param serial
	 */
	public void enterSerialOrderItemGadget(String serial){
		waitForControl(driver, Interfaces.InventoryPage.INVENTORY_SERIAL_ORDER_GEDGET, timeWait);
		type(driver, Interfaces.InventoryPage.INVENTORY_SERIAL_ORDER_GEDGET,serial);
	}
	/**
	 * enter Loss Damage Gadget
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterLossDamageGadget(int month,int day,int year){
		waitForControl(driver, Interfaces.InventoryPage.LOSS_DAMEGE_GADGET_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.LOSS_DAMEGE_GADGET_TEXTBOX, month+"/"+day+"/"+year);
	}
	/**
	 * enter Manufacturer Warranty Gadget
	 * @param month
	 * @param day
	 * @param year
	 */
	public void enterManufacturerWarrantyGadget(int month,int day,int year){
		waitForControl(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_GADGET_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_GADGET_TEXTBOX, month+"/"+day+"/"+year);
	}
	/**
	 * click On New Button
	 */
	public void clickOnNewButton(){
		waitForControl(driver, Interfaces.InventoryPage.NEW_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.NEW_BUTTON);
	}
	/**
	 * select Office Serialized Details
	 * @param office
	 */
	public void selectOfficeSerializedDetails(String office){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_OFFICE_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_OFFICE_COMBOBOX, office);
	}
	/**
	 * select Product Category Serial Details
	 * @param product
	 */
	public void selectProductCategorySerialDetails(String product){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_CATEGORY_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_CATEGORY_COMBOBOX, product);
	}
	/**
	 * select Manufacturer Category Serial Details
	 * @param manufac
	 */
	public void selectManufacturerCategorySerialDetails(String manufac){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_MANUFACTURER_CATEGORY_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_MANUFACTURER_CATEGORY_COMBOBOX, manufac);
	}
	/**
	 * 
	 */
	public void selectProductSerialDetails(String type){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_COMBOBOX, type);
	}
	/**
	 * select Inventory Type Serial Details
	 * @param type
	 */
	public void selectInventoryTypeSerialDetails(String type){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_INVENTORY_TYPE_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_INVENTORY_TYPE_COMBOBOX, type);
	}
	/**
	 * enter Serial Details
	 * @param serial
	 */
	public void enterSerialDetails(String serial){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_SERIAL_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.SERIALIZED_SERIAL_TEXTBOX, serial);
	}
	/**
	 * select Product Type Details
	 * @param type
	 */
	public void selectProductTypeDetails(String type){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_TYPE_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_TYPE_COMBOBOX, type);
	}
	/**
	 * click On Save And Add New Button
	 */
	public void clickOnSaveAndAddNewButton(){
		waitForControl(driver, Interfaces.InventoryPage.SAVE_AND_ADD_NEW_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.SAVE_AND_ADD_NEW_BUTTON);
	}
	/**
	 * select Office Serialized Item
	 */
	public void selectOfficeSerializedItem(String office){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_OFFICE_SEARCH_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_OFFICE_SEARCH_COMBOBOX, office);
	}
	/**
	 * select Inventory Type Serialized Item
	 * @param type
	 */
	public void selectInventoryTypeSerializedItem(String type){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_INVENTORY_TYPE_SEARCH_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_INVENTORY_TYPE_SEARCH_COMBOBOX, type);
	}
	/**
	 * click On Search Serialized Button
	 */
	public void clickOnSearchSerializedButton(){
		waitForControl(driver, Interfaces.InventoryPage.SEARCH_SERIALIZED_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.SEARCH_SERIALIZED_BUTTON);
	}
	/**
	 * Verify Search Serialized Item Displays
	 * @return
	 */
	public boolean isSearchSerializedItemDisplays(){
		waitForControl(driver, Interfaces.InventoryPage.SEARCH_SERIALIZED_TABLE, timeWait);
		return isControlDisplayed(driver, Interfaces.InventoryPage.SEARCH_SERIALIZED_TABLE);
	}
	
	/**
	 * select Product Category Serialized Item
	 * @param product
	 */
	public void selectProductCategorySerializedItem(String product){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_CATEGORY_SEARCH_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_PRODUCT_CATEGORY_SEARCH_COMBOBOX, product);
	}
	/**
	 * select Manufacturer Serialized Item
	 * @param manu
	 */
	public void selectManufacturerSerializedItem(String manu){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_MANUFACTURER_SEARCH_COMBOBOX, timeWait);
		sleep();
		selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_MANUFACTURER_SEARCH_COMBOBOX, manu);
		sleep();
	}
	/**
	 * enter Serial Serialized Item
	 * @param serial
	 */
	public void enterSerialSerializedItem(String serial){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_SERIAL_SEARCH_TEXTBOX, timeWait);
		sleep();
		type(driver, Interfaces.InventoryPage.SERIALIZED_SERIAL_SEARCH_TEXTBOX, serial);
	}
	/**
	 * open Stock Inventory Item
	 * @param serial
	 */
	public void openStockInventoryItem(String serial){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_ITEM_LINK, serial, timeWait);
		click(driver, Interfaces.InventoryPage.SERIALIZED_ITEM_LINK, serial);
	}
	/**
	 * check Stock Inventory Item Displays
	 * @return
	 */
	public boolean isStockInventoryItemDisplays(String serial){
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_SERIAL_TEXTBOX, serial, timeWait);
		String current  = getAttributeValue(driver, Interfaces.InventoryPage.SERIALIZED_SERIAL_TEXTBOX, "value");
		if(current.equals(serial)){
			return true;
		}
		return false;
	}
	/**
	 * open Repairs Item
	 * @param salesOrderID
	 */
	public void openRepairsItem(String salesOrderID){
		waitForControl(driver, Interfaces.InventoryPage.REPAIR_SALE_ORDER_ITEM, salesOrderID, timeWait);
		click(driver, Interfaces.InventoryPage.REPAIR_SALE_ORDER_ITEM, salesOrderID);
	}
	/**
	 * select Order Status Inventory Repair
	 * @param item
	 */
	public void selectOrderStatusInventoryRepair(String item){
		waitForControl(driver, Interfaces.InventoryPage.ORDER_STATUS_INVENTORY_REPAIR_COMBOBOX, item, timeWait);
		selectItemComboxbox(driver, Interfaces.InventoryPage.ORDER_STATUS_INVENTORY_REPAIR_COMBOBOX, item);
	}
	/**
	 * enter Manufacturer Warranty Repair
	 * @param remark
	 */
	public void enterManufacturerWarrantyRepair(int month,int day,int year){
		waitForControl(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_REPAIR_TEXTBOX,timeWait);
		type(driver, Interfaces.InventoryPage.MANUFACTURER_WARRANTY_REPAIR_TEXTBOX, month+"/"+day+"/"+year);
	}
	/**
	 * open Sale Order Repairs
	 */
	public SalesPage openSaleOrderRepairs(){
		waitForControl(driver, Interfaces.InventoryPage.SALE_ORDER_ITEM_LINK,timeWait);
		click(driver, Interfaces.InventoryPage.SALE_ORDER_ITEM_LINK);
		return PageFactory.getSalesPage(driver, ipClient);
	}
	/**
	 * check Record Saved Successfully
	 * @return
	 */
	public boolean isRecordSavedSuccessfully(){
		waitForControl(driver, Interfaces.InventoryPage.RECORD_SAVED_MESSAGE, timeWait);
		return isControlDisplayed(driver, Interfaces.InventoryPage.RECORD_SAVED_MESSAGE);
	}
	/**
	 * Input Serialized Item
	 * @param office
	 * @param productCategory
	 * @param manufacturer
	 * @param productType
	 * @param product
	 * @param serial
	 * @param inventoryType
	 * @param cost
	 */
	public void inputSerializedItem(String office, String productCategory, String manufacturer,
			String productType, String product, String serial, String inventoryType)
	{
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_OFFICE_COMBOBOX, timeWait);
		if(!office.isEmpty())
		{
			selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_OFFICE_COMBOBOX, office);
			sleep(5);
		}
		if(!productCategory.isEmpty())
		{
			selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_PRODUCT_CATEGORY_COMBOBOX, productCategory);
			sleep(5);
		}
		if(!manufacturer.isEmpty())
		{
			selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_MANUFACTURER_COMBOBOX, manufacturer);
			sleep(5);
		}
		if(!productType.isEmpty())
		{
			selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_PRODUCT_TYPE_COMBOBOX, productType);
			sleep(5);
		}
		if(!product.isEmpty())
		{
			selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_PRODUCT_COMBOBOX, product);
			sleep(5);
		}
		if(!serial.isEmpty())
		{
			type(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_SERIAL_TEXTBOX, serial);
		}
		if(!inventoryType.isEmpty())
		{
			selectItemComboxbox(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_INVENTORY_TYPE_COMBOBOX, inventoryType);
		}
		
	}
	/**
	 * Click Serialized Items Detail Save button
	 */
	public void clickSerializedItemsDetailSaveButton()
	{
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_DETAIL_SAVE_BUTTON);
	}
	/**
	 * Click Dynamic Inventory link
	 */
	public void clickDynamicInventoryLink(String linkText)
	{
		waitForControl(driver, Interfaces.InventoryPage.DYNAMIC_INVENTORY_LINK,linkText, timeWait);
		click(driver, Interfaces.InventoryPage.DYNAMIC_INVENTORY_LINK,linkText);
	}
	/**
	 * Click Serialized Items New button
	 */
	public void clickSerializedItemsNewButton()
	{
		waitForControl(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_NEW_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.SERIALIZED_ITEMS_NEW_BUTTON);
	}
	/**
	 * Click Repair Orders Search button
	 */
	public void clickRepairOrdersSearchButton()
	{
		waitForControl(driver, Interfaces.InventoryPage.REPAIR_ORDERS_SEARCH_SEARCH_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.REPAIR_ORDERS_SEARCH_SEARCH_BUTTON);
	}
	/**
	 * Input Repair Order Sales Order ID
	 * @param id
	 */
	public void inputRepairOrdersSalesOrderID(String id)
	{
		waitForControl(driver, Interfaces.InventoryPage.REPAIR_ORDERS_SEARCH_SALES_ORDER_TEXTBOX, timeWait);
		type(driver, Interfaces.InventoryPage.REPAIR_ORDERS_SEARCH_SALES_ORDER_TEXTBOX, id);
	}
	/**
	 * Select Repair Order Detail Status
	 * @param status
	 */
	public void selectRepairOrderDetailStatus(String status)
	{
		waitForControl(driver, Interfaces.InventoryPage.REPAIR_ORDERS_DETAIL_ORDER_STATUS_COMBOBOX, timeWait);
		selectItemComboxbox(driver, Interfaces.InventoryPage.REPAIR_ORDERS_DETAIL_ORDER_STATUS_COMBOBOX, status);
		sleep();
	}
	/**
	 * Click Repair Order Detail Save button
	 */
	public void clickRepairOrderDetailSaveButton()
	{
		waitForControl(driver, Interfaces.InventoryPage.REPAIR_ORDERS_DETAIL_SAVE_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.REPAIR_ORDERS_DETAIL_SAVE_BUTTON);
	}
	/**
	 * Click Repair Orders Search Detail link
	 * @param index
	 */
	public void clickRepairOrderSearchDetailLink(String index)
	{
		waitForControl(driver, Interfaces.InventoryPage.DYNAMIC_REPAIR_ORDER_SEARCH_DETAIL_LINK, index,timeWait);
		click(driver, Interfaces.InventoryPage.DYNAMIC_REPAIR_ORDER_SEARCH_DETAIL_LINK,index);
	}
	/**
	 * Click Repair Order Detail Go To Sales Order button
	 */
	public void clickRepairOrderDetailGoToSalesOrderButton()
	{
		waitForControl(driver, Interfaces.InventoryPage.REPAIR_ORDERS_DETAIL_GO_TO_SALES_ORDER_BUTTON, timeWait);
		click(driver, Interfaces.InventoryPage.REPAIR_ORDERS_DETAIL_GO_TO_SALES_ORDER_BUTTON);
	}
	private WebDriver driver;
	private String ipClient;
}