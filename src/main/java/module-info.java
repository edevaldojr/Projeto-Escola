module ifpr.pgua.eic.biblioteca {
    requires javafx.controls;
    requires javafx.fxml;

    opens ifpr.pgua.eic.trabbim.telas to javafx.fxml;
    exports ifpr.pgua.eic.trabbim;
}
