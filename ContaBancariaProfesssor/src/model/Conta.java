package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(of = "numero")
@ToString(of = "numero")
public class Conta {

	private IntegerProperty numero;
	private ObjectProperty<Cliente> cliente;
	private ObjectProperty<Agencia> agencia;

	public Conta() {
		numero = new SimpleIntegerProperty();
		cliente = new SimpleObjectProperty<>();
		agencia = new SimpleObjectProperty<>();
	}

	public IntegerProperty getNumeroProperty() {
		return numero;
	}

	public ObjectProperty<Cliente> getClienteProperty() {
		return cliente;
	}

	public ObjectProperty<Agencia> getAgenciaProperty() {
		return agencia;
	}

	public Integer getNumero() {
		return numero.get();
	}

	public void setNumero(Integer numero) {
		this.numero.set(numero);
	}

	public Cliente getCliente() {
		return cliente.get();
	}

	public void setCliente(Cliente cliente) {
		this.cliente.set(cliente);
	}

	public Agencia getAgencia() {
		return agencia.get();
	}

	public void setAgencia(Agencia agencia) {
		this.agencia.set(agencia);
	}

}