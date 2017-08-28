package opet.aulatds171a.pessoa;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Classe para representar Pessoa
 * @author troli
 *
 */
public class Pessoa {

	private String nome = "";
	private String sexo = "";
	private Date dataNascimento;
	/**
	 * @deprecated
	 */
	public Pessoa()
	{
		
	}
	/**
	 *  Cria pessoa 
	 * @param nome
	 * @param sexo
	 * @param dataNascimento
	 */
	public Pessoa(String nome, String sexo, Date dataNascimento)
	{
		this.setNome(nome);
		this.setSexo(sexo);
		this.setDataNascimento(dataNascimento);
	}
	/**
	 * Retorna o nome 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Seta o nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/*
	 * Retorna o sexo
	 * @return string
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Seta o sexo da pessoa 
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Retorna a data de nascimento da pessoa 
	 * @return 
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * Seta a data de nascimento
	 * @param dataNascimento
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
