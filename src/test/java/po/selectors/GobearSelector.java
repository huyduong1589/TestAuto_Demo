package po.selectors;

public class GobearSelector {
	public static String Insurance_Secion = "//a[@href='#Insurance']";
	public static String Travel_Secion = "//a[@href='#Travel']";
	public static String Show_My_Result_Button = "//button[text()='Show my results']";
	//Insurance Page
	public static String Insurance_Card = "//div[@class='col-sm-4 card-full']";
	public static String Insurance_Name = "//div[@class='col-sm-4 card-full']//h4[contains(text(),'<InsurerName>')]";
	public static String Insurance_Price = "//div[@class='policy-price']/span[@class='value']";
	//Left Side Bar
	public static String SEE_MORE_Tab = "//a[contains(text(),'SEE MORE')]";
	public static String Category_Lable = "//div[@class='sidebar-inner-wrapper']//h5[contains(text(),'<CategoryName>')]";
	public static String Insurer_CheckBox = "//label[contains(text(),'Insurers')]/following::label[contains(text(),'<InsurerName>')]";
	public static String Sort_Price_High_To_Low_Radio = "//label[contains(text(),'Price: High to low ')]";
	public static String Range_Option = "//label[contains(text(),'Medical expenses while traveling')]/following::div[@class='slider-track'][1]";
	public static String Insurance_Type_Max_Value = "//p[contains(text(),'Medical expenses while traveling')]/following::span[1]";
	public static String Min_Option = "//*[contains(text(),'Medical expenses while traveling')]/following::div[@class='slider-handle min-slider-handle round']";
	public static String Max_Option = "//*[contains(text(),'Medical expenses while traveling')]/following::div[@class='slider-handle max-slider-handle round']";
	public static String Max_Option_Value = "//label[contains(text(),'Medical expenses while traveling')]/following::b[2]";
	public static String Destination_Dropdown = "//label[contains(text(),'DESTINATION')]/following::button[1]";
	public static String Destination_To_Select = "//label[contains(text(),'DESTINATION')]/following::span[text()='<Destination>'][1]";
	public static String Date_From_Option = "//label[contains(text(),'TRAVEL START DATE')]/following::div[@class='date-from'][1]";
	public static String Date_To_Option = "//label[contains(text(),'TRAVEL END DATE')]/following::div[@class='date-to'][1]";
	public static String Date_To_Select = "//div[@class='datepicker-days']//td[text()='<Date>']";
	public static String Date_Picker_Days_Switch = "//div[@class='datepicker-days']//th[@class='datepicker-switch']";
	public static String Date_Picker_Months_Switch = "//div[@class='datepicker-months']//th[@class='datepicker-switch']";
	public static String Month_To_Select = "//span[contains(@class,'month')][text()='<Month>']";
	public static String Year_To_Select = "//span[@class='year'][text()='<Year>']";
	//Top Side Bar
	public static String Top_Side_Message = "//div[@data-gb-name='travel-nav-data']//small";
}
