package ifpr.pgua.eic.trabbim.modelos;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable{

    private Double salario;

    public Professor(String cpf,  String nome, String email, String telefone, Double salario){
        super(cpf, nome, email, telefone);
        this.salario = salario;
        
    }

    
    public void setsalario(Double salario){
        this.salario = salario;
    }

    public Double getsalario(){
        return salario;
    }

    public String toString(){
        return super.toString()+"\n Salário: "+salario;
    }

    public String paraTexto(){
        return super.paraTexto()+"; Salário:"+salario;
    }
}
