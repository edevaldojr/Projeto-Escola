package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.modelos.Aluno;
import ifpr.pgua.eic.trabbim.modelos.Curso;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;

public class MatriculaAluno {

    @FXML
    private ComboBox<Aluno> cbAluno;

    @FXML
    private ComboBox<Curso> cbCurso;

    private Escola escola;

    public MatriculaAluno(Escola escola){
        this.escola = escola;
    }

    @FXML
    void initialize() {
        cbAluno.getItems().clear();
        cbAluno.getItems().addAll(escola.listarAlunos());

        cbCurso.getItems().clear();
        cbCurso.getItems().addAll(escola.listarCursos());

    }


    @FXML
    void matricular(ActionEvent event) {
        Aluno aluno = cbAluno.getSelectionModel().getSelectedItem();
        Curso curso = cbCurso.getSelectionModel().getSelectedItem();


        boolean flag = true;
        String msg = "";

        

        if(aluno==null){
            msg += "\nAluno não pode ser vazio!";
            flag = false;
        }

        if(curso==null){
            msg += "\nCurso não pode ser vazio!";
            flag = false;
        }
        

        if(flag){
            boolean ret = escola.matricularAluno(aluno, curso);
            if(ret){
                System.out.println(escola.listarCursos());
                
                limpar(null);

                msg = "Aluno matriculado!";
            }else{
                msg = "Aluno não matriculado! Aluno repetido!";
            }

            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void desmatricular(ActionEvent event) {
        Aluno aluno = cbAluno.getSelectionModel().getSelectedItem();
        Curso curso = cbCurso.getSelectionModel().getSelectedItem();


        boolean flag = true;
        String msg = "";

        

        if(aluno==null){
            msg += "\nAluno não pode ser vazio!";
            flag = false;
        }

        if(curso==null){
            msg += "\nCurso não pode ser vazio!";
            flag = false;
        }
        

        if(flag){
            boolean ret = escola.desmatricular(aluno, curso);
            if(ret){
                System.out.println(escola.listarAlunosMatriculados(curso));
                
                limpar(null);

                msg = "Aluno desmatriculado!";
            }else{
                msg = "Aluno não matriculado! Aluno repetido!";
            }

            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
        }
    }



    @FXML
    void limpar(ActionEvent event) {
        cbAluno.setValue(null);
        cbCurso.setValue(null);
    }

}




