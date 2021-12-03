package ifpr.pgua.eic.trabbim.telas;


import ifpr.pgua.eic.trabbim.modelos.Professor;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroCurso {

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfCargaHoraria;

    @FXML
    private ComboBox<Professor> cbProfessor;


    private Escola escola;


    public CadastroCurso(Escola escola){
        this.escola = escola;
    }

    @FXML
    public void initialize() {
        cbProfessor.getItems().clear();
        cbProfessor.getItems().addAll(escola.listarProfessores());

    }

    @FXML
    void cadastrar(ActionEvent event) {
        String codigo = tfCodigo.getText();
        String nome = tfNome.getText();
        String descricao = tfDescricao.getText();
        String cargaHoraria = tfCargaHoraria.getText();
        Professor professor = cbProfessor.getSelectionModel().getSelectedItem();

        int cod;
        int cargaH;
        cod =  Integer.parseInt(codigo);
        cargaH =  Integer.parseInt(cargaHoraria);

        boolean flag = true;
        String msg = "";

        if(codigo.isEmpty() || codigo.isBlank()){
            msg += "\nCódigo não pode ser vazio!";
            flag = false;
        }

        if(nome.isEmpty() || nome.isBlank()){
            msg = "Nome não pode ser vazio!";
            flag = false;
        }

        if(descricao.isEmpty() || descricao.isBlank()){
            msg += "\nDescrição não pode ser vazio!";
            flag = false;
        }

        if(cargaHoraria.isEmpty() || cargaHoraria.isBlank()){
            msg += "\nCarga horaria não pode ser vazio!";
            flag = false;
        }

        if(professor==null){
            msg += "\nProfessor não pode ser vazio!";
            flag = false;
        }
        

        if(flag){
            boolean ret = escola.cadastrarCurso(cod, nome, descricao, cargaH, professor);
            if(ret){
                System.out.println(escola.listarCursos());
                
                limpar(null);

                msg = "Curso cadastrado!";
            }else{
                msg = "Curso não cadastrado! Nome repetido!";
            }

            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void limpar(ActionEvent event) {
        tfCodigo.setText("");
        tfNome.setText("");
        tfDescricao.setText("");
        tfCargaHoraria.setText("");
        cbProfessor.setValue(null);
    }

}


