package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import model.Agencia;
import model.Cliente;
import model.Conta;

public class ContaController {

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private TextField tfNumero;

	@FXML
	private TableView<Conta> tblConta;

	@FXML
	private TableColumn<Conta, String> tbcCliente;

	@FXML
	private TableColumn<Conta, Integer> tbcNumero;

	@FXML
	private TableColumn<Conta, String> tbcAgencia;

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnExcluir;

	@FXML
	private ComboBox<Cliente> cbCliente;

	@FXML
	private ComboBox<Agencia> cbAgencia;
	private ObservableList<Agencia> agencias = FXCollections.observableArrayList();

	@FXML
	private void initialize() {
		Cliente cliente = new Cliente();
		cliente.setNome("Andre");

		cbCliente.getItems().addAll(cliente);

		// Define os valores que serão mostrados
		// quando o combobox e aberto
		cbCliente.setCellFactory((comboBox) -> {
			return new ListCell<Cliente>() {
				@Override
				protected void updateItem(Cliente item, boolean empty) {
					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.getNome());
					}
				}
			};
		});

		// Define valor que renderiza quando o item é selecionado
		cbCliente.setConverter(new StringConverter<Cliente>() {
			@Override
			public String toString(Cliente cliente) {
				if (cliente == null) {
					return null;
				} else {
					return cliente.getNome();
				}
			}

			@Override
			public Cliente fromString(String personString) {
				return null; // No conversion fromString needed.
			}
		});
	}

	@FXML
	void onActionCancelar(ActionEvent event) {

	}

	@FXML
	void onActionExcluir(ActionEvent event) {

	}

	@FXML
	void onActionNovo(ActionEvent event) {

	}

	@FXML
	void onActionSalvar(ActionEvent event) {

	}

}
