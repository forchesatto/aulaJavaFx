package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloWordController {

	@FXML
	private TextField tfNome;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Label lblMsgSalvar;

	@FXML
	void excluir(ActionEvent event) {

	}

	@FXML
	void salvar(ActionEvent event) {
		// Pega o valor digitado no textField
		String nome = tfNome.getText();
		String msg = "Salvo com sucesso o cadastro: ";
		// Seta no label a mensagem de salvo com sucesso
		lblMsgSalvar.setText(msg + nome);
		lblMsgSalvar.getStyleClass().add("msgSalvar");
	}

}
