package ifpr.pgua.eic.trabbim.modelos;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    
    public Pessoa(String cpf, String nome, String email, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone(){
        return telefone;
    }

    public String toString(){
        return " CPF: "+cpf+
        "\n Nome: "+nome + 
        "\n Email: "+email+
        "\n Telefone: "+telefone;
    }

    public String paraTexto(){
        return " CPF:"+cpf+
        "; Nome:"+nome + 
        "; Email:"+email+
        "; Telefone:"+telefone; 
    }
}
