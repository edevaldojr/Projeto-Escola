package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroProfessor {

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSalario;

    @FXML
    private TextField tfTelefone;

    private Escola escola;

    public CadastroProfessor(Escola escola){
        this.escola = escola;
    }

    @FXML
    void cadastrar(ActionEvent event) {
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        String salario = tfSalario.getText();
        
        Double salary = Double.valueOf(salario).doubleValue();

        boolean flag = true;
        String msg = "";

        if(cpf.isEmpty() || cpf.isBlank()){
            msg += "\nCPF não pode ser vazio!";
            flag = false;
        }

        if(nome.isEmpty() || nome.isBlank()){
            msg = "Nome não pode ser vazio!";
            flag = false;
        }

        if(email.isEmpty() || email.isBlank()){
            msg += "\nEmail não pode ser vazio!";
            flag = false;
        }

        if(telefone.isEmpty() || telefone.isBlank()){
            msg += "\nTelefone não pode ser vazio!";
            flag = false;
        }

        if(salario.isEmpty() || salario.isBlank()){
            msg += "\nSalario não pode ser vazio!";
            flag = false;
        }
        

        if(flag){
            boolean ret = escola.cadastrarProfessor(cpf, nome, email, telefone, salary);
            if(ret){
                System.out.println(escola.listarProfessores());
                
                limpar(null);

                msg = "Professor cadastrado!";
            }else{
                msg = "Professor não cadastrado! CPF repetido!";
            }

            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void limpar(ActionEvent event) {
        tfNome.setText("");
        tfEmail.setText("");
        tfCpf.setText("");
        tfTelefone.setText("");
        tfSalario.setText("");
    }

}
