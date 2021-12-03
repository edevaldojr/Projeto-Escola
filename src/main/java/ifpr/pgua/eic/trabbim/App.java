package ifpr.pgua.eic.trabbim;

import java.io.IOException;

import ifpr.pgua.eic.trabbim.repositorios.Escola;
import ifpr.pgua.eic.trabbim.telas.Home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * JavaFX App
 */
public class App extends Application {  

    private Escola escola;
    
    @Override
    public void start(Stage stage) throws ClassNotFoundException, IOException {
        
        escola = new Escola("ESCOLA", "3424");
    
        //escola.povoa();
        escola.carregarAquivoBinario();
        escola.carregarArquivoTexto();

        Parent root = loadTela("fxml/home.fxml", (o)->new Home(escola));

        Scene scene = new Scene(root, 900, 600);
        
        stage.setScene(scene);
        stage.show();
    }

    
    public static Parent loadTela(String fxml, Callback controller){
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource(fxml));
            loader.setControllerFactory(controller);

            root = loader.load();
            
        }catch (Exception e){
            System.out.println("Problema no arquivo fxml. Está correto?? "+fxml);
        }
        return root;   
    }

    @Override
    public void stop() throws Exception {

        super.stop();
        escola.salvarArquivoBinario();
        escola.salvarArquivoTexto();
    }

    public static void main(String[] args) {
        launch();
    }

}