package opet.aulatds171a.utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static final String PADRAO_DATA = "dd/MM/yyyy EEE";
	
	public static Date formataData(String dataFormatoString) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(PADRAO_DATA);
		return sdf.parse(dataFormatoString);
	}
	
	public static String formataData(Date dataFormatoString) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(PADRAO_DATA);
		return new SimpleDateFormat(PADRAO_DATA).format(dataFormatoString);
	} 

}
