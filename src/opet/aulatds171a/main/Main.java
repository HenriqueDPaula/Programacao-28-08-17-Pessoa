package opet.aulatds171a.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

import opet.aulatds171a.pessoa.Pessoa;
import opet.aulatds171a.utilitario.Leitor;
import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class Main {
	
	private static final int OPCAO_CADASTRAR = 1;
	private static final int OPCAO_LISTAR = 2;
	private static final int OPCAO_SAIR = 9;
	/**
	 * 
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args)  {
		
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		int opcao_menu = -1;
		
		while(opcao_menu != OPCAO_SAIR) {
		
			System.out.println("1) Cadastrar");
			System.out.println("2) Listar");
			System.out.println("9) Sair");
			opcao_menu = Leitor.readInt("Digite a opção desejada:");
			
			if(opcao_menu == OPCAO_CADASTRAR) {
				listaPessoas.add( montarPessoa() );
			}
			else if(opcao_menu == OPCAO_LISTAR) {
				// imprime cabeçalho
				preencherComZeros("Nome", 30);
				preencherComZeros("Sexo", 10);
				preencherComZeros("Data Nascimento", 50);
				for (Pessoa pessoa : listaPessoas) {
					System.out.print(preencherComZeros(pessoa.getNome(), 30) );
					System.out.print(preencherComZeros(pessoa.getSexo(), 10) );
					System.out.print( pessoa.getDataNascimento());
					System.out.println("");
				}
			}
		}
		
		System.out.println("Até mais!");
	}
	
	/**
	 * Função para criação de um objeto pessoa
	 * @throws ParseException 
	 */
	static Pessoa montarPessoa() 
	{
		String nome = Leitor.readString("Entre com o nome:");
		String sexo = Leitor.readString("Entre com o sexo:");
		//String dataNascimento = Leitor.readString("Entre com oa data de nascimento:");
		
		Date dtNascimento = null;
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
		try {
			dtNascimento = sdf.parse(Leitor.readString("Entre com oa data de nascimento:"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		Pessoa novaPessoa = new Pessoa(nome, sexo,
				dtNascimento );
		
		return novaPessoa;
	}
	
	/**
	 * Função para preencher uma string com zeros a direita
	 * @param str
	 * @param tamanho
	 * @return
	 */
	static String preencherComZeros(String str, int tamanho)
	{
		for(int i=str.length();i<tamanho;i++) {
			str = str + " ";
		}
		return str;
	}

}
