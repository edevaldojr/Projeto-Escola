package ifpr.pgua.eic.trabbim.telas;

import ifpr.pgua.eic.trabbim.App;
import ifpr.pgua.eic.trabbim.repositorios.Escola;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Home {
    
    private Escola escola;
    
    @FXML
    private StackPane painelCentral;
    @FXML
    private BorderPane root;

    @FXML
    private ToggleButton btTema;

    private String tema = "light";


    public Home(Escola escola){
        this.escola = escola;
    }

    @FXML
    private void loadListas(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/listas.fxml", (o)->new Listas(escola)));
    }

    @FXML
    private void loadCadastroProfessor(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/cadastroProfessor.fxml", (o)->new CadastroProfessor(escola)));
    }

    @FXML
    private void loadCadastroAluno(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/cadastroAluno.fxml", (o)->new CadastroAluno(escola)));
    }

    @FXML
    private void loadCadastroCurso(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/cadastroCurso.fxml", (o)->new CadastroCurso(escola)));
    }

    @FXML
    private void loadMatriculaAluno(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/matricularAluno.fxml", (o)->new MatriculaAluno(escola)));
    }

    @FXML
    private void loadListarAlunos(){
        painelCentral.getChildren().clear();
        painelCentral.getChildren().add(App.loadTela("fxml/listaAlunos.fxml", (o)->new ListaAlunos(escola)));
    }

    @FXML
    private void mudaTema(){
        if(tema.equals("light")){
            tema = "dark";
            btTema.setText("Light Mode");
            root.getStylesheets().remove(App.class.getResource("css/estilo.css").toExternalForm());
            root.getStylesheets().add(App.class.getResource("css/estilo_dark.css").toExternalForm());
            
        }else{
            tema = "light";
            btTema.setText("Dark Mode");
            root.getStylesheets().add(App.class.getResource("css/estilo.css").toExternalForm());
            root.getStylesheets().remove(App.class.getResource("css/estilo_dark.css").toExternalForm());
        
        }
    }
}
