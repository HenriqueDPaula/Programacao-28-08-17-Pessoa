import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Classe responsavel por apresentar exemplos do tratamento de datas em java
 * utilizando: Date() DateFormat() SimpleDateFormat() Calendar() Locale()
 * 
 * @author Prof. Joao Andrei
 * @since 22 de mar de 2016
 * @version 1.0.0
 * @see java.text.DateFormat; java.text.ParseException;
 *      java.text.SimpleDateFormat; java.util.Calendar; java.util.Date;
 *      java.util.Locale;
 */
public class MainTrataDatas {

	public static final Locale PAIS_OPET = new Locale("pt", "BR");

	/**
	 * metodo responsavel por lançar o java application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// metodo para indicar que o formatador NAO deve tentar
		// ajusatar caso receba uma data invalida
		sdf.setLenient(false);

		// cria uma data pegando a data do sistema
		Date dataAtual = new Date();
		System.out.println("Data atual via new Date()");
		System.out.println(sdf.format(dataAtual));

		// cria uma data passando a data como parametro
		// como vimos na aula este metodo esta depreciado e
		// nao vai retornar a data esperada
		dataAtual = new Date("22/03/2016");
		System.out.println("Data construida com o construtor new Date(\"22/03/2016\")");
		System.out.println(sdf.format(dataAtual));

		try {
			// cria uma data utilizando o formatador
			System.out.println("Data via SimpleDateFormat");
			dataAtual = sdf.parse("22/03/2016");
			System.out.println(sdf.format(dataAtual));
		} catch (ParseException e) {
			e.printStackTrace();
			dataAtual = null;
		}

		try {
			// tenta criar uma data via formatador, como a data é invalida
			// deverá lançar uma exception
			System.out.println("Data via SimpleDateFormat para dar erro na formatacao");
			dataAtual = sdf.parse("22/13/2016");
			System.out.println(sdf.format(dataAtual));
		} catch (ParseException e) {
			e.printStackTrace();
			dataAtual = null;
		}

		try {
			// cria uma data utilizando o formatador
			dataAtual = sdf.parse("22/10/2016");
		} catch (ParseException e) {
			e.printStackTrace();
			dataAtual = null;
		}

		System.out.println("Data via SimpleDateFormat e formatando o dia da semana");

		// altera o formatador para apresentar o dia da semana
		sdf = new SimpleDateFormat("dd/MM/yyyy EEE");
		System.out.println(sdf.format(dataAtual));

		try {
			// tenta criar uma data (que aparentemente é valida) porem
			// nao esta no formato definido para o formatador: "dd/MM/yyyy EEE"
			// assim deverá lançar exception
			System.out.println("Data via SimpleDateFormat para fazer o parser e dar erro");
			dataAtual = sdf.parse("22/10/2016");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// altera o formatador para apresentar
		sdf = new SimpleDateFormat("dd/MM/yyyy");

		// vai iniciar o tratamento diferenciado por localidades

		// defini 3 localidades
		Locale localeBrasil = MainTrataDatas.PAIS_OPET;// new Locale("pt",
														// "BR");
		Locale localeItalia = Locale.ITALIAN;
		Locale localeUSA = Locale.US;

		try {
			// monta uma data via formatador
			dataAtual = sdf.parse("22/10/2016");

			// apresenta a mesma data em formatos diferentes conoforme a
			// localidade
			DateFormat df = null;
			System.out.println("Data utilizando locate - Brasil");
			df = DateFormat.getDateInstance(DateFormat.FULL, localeBrasil);
			System.out.println(df.format(dataAtual));

			System.out.println("Data utilizando locate - USA");
			df = DateFormat.getDateInstance(DateFormat.FULL, localeUSA);
			System.out.println(df.format(dataAtual));

			System.out.println("Data utilizando locate - Italia");
			df = DateFormat.getDateInstance(DateFormat.FULL, localeItalia);
			System.out.println(df.format(dataAtual));

		} catch (ParseException e) {
			e.printStackTrace();
			dataAtual = null;
		}

		// vai mostar como utilizar a classe Calendar para tratar datas.
		// essa classe é utilizada em conjunto com a Date e a SimpleDateFormat e
		// a DateFormat

		// recupera um calendario/data do sistema
		Calendar calendar = Calendar.getInstance();
		// seta para NAO permitir ajustes caso de datas inválidas
		calendar.setLenient(false);
		System.out.println("Data atual via Calendar.getInstance()");
		// transforma a data que está em calendar para um objeto do tipo Date()
		dataAtual = calendar.getTime();
		System.out.println(sdf.format(dataAtual));

		// vai setar uma data para o calendar
		// Atencao porque o mes (11 é dezembro) inicia em zero
		try {
			calendar.set(1999, Calendar.DECEMBER, 23);
		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("Data via Calendar e usando set");
		dataAtual = calendar.getTime();
		System.out.println(sdf.format(dataAtual));

		// outra forma de setar a data para o calendar
		calendar.set(Calendar.YEAR, 1998);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		System.out.println("Data via Calendar e usando sets separados");
		dataAtual = calendar.getTime();
		System.out.println(sdf.format(dataAtual));

		// vai usar gregorian
		
		System.out.println("Data via Calendar e usando calendario gregoriano");

		DateFormat dfg = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAniversario = null;
		try {
			dataAniversario = dfg.parse("01/12/1976");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar dataAniversarioViaGregorian = new GregorianCalendar();
		dataAniversarioViaGregorian.setTime(dataAniversario);

		// pega a data atual via calendar para fazer a comparacao

		Calendar today = Calendar.getInstance();

		if (today.after(dataAniversarioViaGregorian))
			System.out.println("nasceu antes de hoje");
		else
			System.out.println("nasceu antes de hoje");

		System.out.println(dfg.format(today.getTime()));
		System.out.println(dfg.format(dataAniversarioViaGregorian.getTime()));

	}
}