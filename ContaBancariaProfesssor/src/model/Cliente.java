package model;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente {

	private StringProperty cpf;
	private StringProperty nome;
	private ObjectProperty<LocalDate> dataNascimento;
	private StringProperty sexo;

	public Cliente() {
		cpf = new SimpleStringProperty();
		nome = new SimpleStringProperty();
		dataNascimento = new SimpleObjectProperty<>();
		sexo = new SimpleStringProperty();
	}

	public String getCpf() {
		return cpf.get();
	}

	public void setCpf(String cpf) {
		this.cpf.set(cpf);
	}

	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public LocalDate getDataNascimento() {
		return dataNascimento.get();
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento.set(dataNascimento);
	}

	public String getSexo() {
		return sexo.get();
	}

	public void setSexo(String sexo) {
		this.sexo.set(sexo);
	}

	public StringProperty getCpfProperty() {
		return cpf;
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public ObjectProperty<LocalDate> getDataNascimentoProperty() {
		return dataNascimento;
	}

	public StringProperty getSexoProperty() {
		return sexo;
	}

	public StringProperty getDataNascimentoFormatada() {
		return new SimpleStringProperty(dataNascimento.get().format(ofPattern("dd/MM/yyyy")));
	}

}
