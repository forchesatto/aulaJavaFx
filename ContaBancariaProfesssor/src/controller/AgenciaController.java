package controller;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Agencia;
import view.componente.Alerta;

public class AgenciaController {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnNovo;

	@FXML
	private TextField tfNumero;

	@FXML
	private TextField tfNome;

	@FXML
	private TableView<Agencia> tblAgencia;

	@FXML
	private TableColumn<Agencia, Number> tbcNumero;

	@FXML
	private TableColumn<Agencia, String> tbcNome;

	private ObservableList<Agencia> agenciaList = FXCollections.observableArrayList();

	private Optional<Agencia> agencia = Optional.empty();

	@FXML
	private void initialize() {
		tbcNome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		tbcNumero.setCellValueFactory(c -> c.getValue().getNumeroProperty());
		tblAgencia.setItems(agenciaList);

		tblAgencia.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> populaText(newValue));
	}

	@FXML
	private void onActionCancelar(ActionEvent event) {
		limparCampos();
	}

	@FXML
	private void onActionSalvar(ActionEvent event) {
		boolean editar = this.agencia.isPresent();
		Agencia agencia = this.agencia.orElse(new Agencia());
		agencia.setNome(tfNome.getText());
		agencia.setNumero(Integer.valueOf(tfNumero.getText()));
		if (!editar) {
			agenciaList.add(agencia);
		}
		limparCampos();
	}

	@FXML
	public void onActionNovo(ActionEvent e) {
		this.agencia = Optional.empty();
		limparCampos();
	}

	@FXML
	public void onActionExcluir(ActionEvent e) {
		if (new Alerta().excluir()) {
			int posicaoTabela = tblAgencia.getSelectionModel().getSelectedIndex();
			tblAgencia.getItems().remove(posicaoTabela);
		}
	}

	private void limparCampos() {
		tfNome.setText("");
		tfNumero.setText("");
	}

	private void populaText(Agencia agencia) {
		this.agencia = Optional.ofNullable(agencia);
		if (this.agencia.isPresent()) {
			tfNome.setText(agencia.getNome());
			tfNumero.setText(agencia.getNumero().toString());
		}
	}

}
