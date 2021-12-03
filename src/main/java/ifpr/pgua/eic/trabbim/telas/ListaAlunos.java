package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.modelos.Aluno;
import ifpr.pgua.eic.trabbim.modelos.Curso;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class ListaAlunos {

    @FXML
    private ListView<Aluno> lstAlunos;

    @FXML
    private ComboBox<Curso> cbCurso;

    private Escola escola;

    public ListaAlunos(Escola escola){
        this.escola = escola;
    }

    @FXML
    void initialize(){
        cbCurso.getItems().clear();
        cbCurso.getItems().addAll(escola.listarCursos());
    }

    @FXML
    void buscar(ActionEvent event) {
        Curso curso = cbCurso.getSelectionModel().getSelectedItem();


        boolean flag = true;
        String msg = "";


        if(curso==null){
            msg += "\nCurso não pode ser vazio!";
            flag = false;
        }
        else{
            msg+= "\n Busca concluída!";
        }
        if(flag){
            lstAlunos.getItems().clear();
            lstAlunos.getItems().addAll(escola.listarAlunosMatriculados(curso));
            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
        }else{
            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
        }
        
    }

    @FXML
    void limpar(ActionEvent event) {
        lstAlunos.getItems().clear();
        cbCurso.setValue(null);
    }


    
}