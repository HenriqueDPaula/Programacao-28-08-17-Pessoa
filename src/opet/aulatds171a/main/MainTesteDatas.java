package opet.aulatds171a.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import java.util.Calendar;
//import sun.util.calendar.LocalGregorianCalendar.Date;
import java.util.Date;

public class MainTesteDatas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale localeBrasil = new Locale("pt", "BR") ;
		Locale localeUSA = Locale.US;
		Locale localeItalia = Locale.ITALIAN;
		
		
		DateFormat df = null;
		Date dataAtual = new Date();
		
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		df = DateFormat.getDateInstance(DateFormat.FULL, localeBrasil);
		System.out.println(df.format(dataAtual));
		df = DateFormat.getDateInstance(DateFormat.FULL, localeUSA);
		System.out.println(df.format(dataAtual));
		df = DateFormat.getDateInstance(DateFormat.FULL, localeItalia);
		System.out.println(df.format(dataAtual));
		
	}

}
