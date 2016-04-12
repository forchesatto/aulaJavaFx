package controller;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Sexo;
import view.componente.Alerta;

public class ClienteController {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnNovo;

	@FXML
	private TextField tfCpf;

	@FXML
	private TextField tfNome;

	@FXML
	private TableView<Cliente> tblCliente;

	@FXML
	private TableColumn<Cliente, String> tbcCpf;

	@FXML
	private TableColumn<Cliente, String> tbcNome;

	@FXML
	private TableColumn<Cliente, String> tbcDataNascimento;

	private ObservableList<Cliente> clienteList = FXCollections.observableArrayList();

	private Optional<Cliente> cliente = Optional.empty();

	@FXML
	private DatePicker dpDataNascimento;

	@FXML
	private RadioButton rbMasculino;

	@FXML
	private RadioButton rbFeminino;

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		tbcCpf.setCellValueFactory(c -> c.getValue().getCpfProperty());
		tbcDataNascimento.setCellValueFactory(c -> c.getValue().getDataNascimentoFormatada());
		tblCliente.setItems(clienteList);
		tblCliente.getSelectionModel().selectedItemProperty()
				.addListener((observable, clienteAnterior, cliente) -> populaText(cliente));
	}

	@FXML
	private void onActionCancelar(ActionEvent event) {
		limparCampos();
	}

	@FXML
	private void onActionSalvar(ActionEvent event) {
		boolean editar = this.cliente.isPresent();
		Cliente cliente = this.cliente.orElse(new Cliente());
		cliente.setDataNascimento(dpDataNascimento.getValue());
		if (rbMasculino.isSelected()) {
			cliente.setSexo(Sexo.MASCULINO);
		} else {
			cliente.setSexo(Sexo.FEMININO);
		}
		cliente.setNome(tfNome.getText());
		cliente.setCpf(tfCpf.getText());
		if (!editar) {
			clienteList.add(cliente);
		}
		limparCampos();

	}

	@FXML
	public void onActionNovo(ActionEvent e) {
		this.cliente = Optional.empty();
		limparCampos();
	}

	@FXML
	public void onActionExcluir(ActionEvent e) {
		if (new Alerta().excluir()) {
			int posicaoTabela = tblCliente.getSelectionModel().getSelectedIndex();
			tblCliente.getItems().remove(posicaoTabela);
		}
	}

	private void limparCampos() {
		tfNome.setText("");
		tfCpf.setText("");
		rbMasculino.setSelected(false);
		rbFeminino.setSelected(false);
		dpDataNascimento.setValue(null);
	}

	private void populaText(Cliente cliente) {
		this.cliente = Optional.ofNullable(cliente);
		if (this.cliente.isPresent()) {
			tfNome.setText(cliente.getNome());
			tfCpf.setText(cliente.getCpf());
			rbMasculino.setSelected(cliente.getSexo().isMasculino());
			rbFeminino.setSelected(cliente.getSexo().isFeminino());
			dpDataNascimento.setValue(cliente.getDataNascimento());
		}
	}

}
