package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.modelos.Aluno;
import ifpr.pgua.eic.trabbim.modelos.Curso;
import ifpr.pgua.eic.trabbim.modelos.Professor;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Listas {

    @FXML
    private ListView<Aluno> lstAlunos;

    @FXML
    private ListView<Professor> lstProfessores;

    @FXML
    private ListView<Curso> lstCursos;

    Escola escola;

    public Listas(Escola escola){
        this.escola = escola;
    }

    public void initialize(){
        
        lstAlunos.getItems().addAll(escola.listarAlunos());
        lstProfessores.getItems().addAll(escola.listarProfessores());
        lstCursos.getItems().addAll(escola.listarCursos());
    }

}
