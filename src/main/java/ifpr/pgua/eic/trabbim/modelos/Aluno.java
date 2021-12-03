package ifpr.pgua.eic.trabbim.modelos;

import java.io.Serializable;
import java.time.LocalDate;

public class Aluno extends Pessoa implements Serializable{

    private LocalDate dataMatricula;


    public Aluno(String cpf,  String nome, String email, String telefone, LocalDate dataMatricula){
        super(cpf, nome, email, telefone);
        this.dataMatricula = dataMatricula;
    }

    public void setDataMatricula(LocalDate datamatricula){
        this.dataMatricula = datamatricula;
    }

    public LocalDate getDataMatricula(){
        return dataMatricula;
    }

    public String toString(){
        return super.toString()+"\n Data de Matrícula: "+ dataMatricula;
    }

    public String paraTexto(){
        return super.paraTexto()+"; Data de Matricula:"+ dataMatricula;
    }

}
