package ifpr.pgua.eic.trabbim.telas;

import java.time.LocalDate;

import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroAluno {

    @FXML
    private DatePicker dpDataMatricula;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;


    private Escola escola;

    
    public CadastroAluno(Escola escola){
        this.escola = escola;
    }

    @FXML
    void cadastrar(ActionEvent event) {
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        LocalDate dataMatricula = dpDataMatricula.getValue();
       

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

        if(dataMatricula==null){
            msg += "\nSalario não pode ser vazio!";
            flag = false;
        }
        

        if(flag){
            boolean ret = escola.cadastrarAluno(cpf, nome, email, telefone, dataMatricula);
            if(ret){
                System.out.println(escola.listarAlunos());
                
                limpar(null);

                msg = "Aluno cadastrado!";
            }else{
                msg = "Aluno não cadastrado! CPF repetido!";
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
        dpDataMatricula.setValue(null);;
    }

}
