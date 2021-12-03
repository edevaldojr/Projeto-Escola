package ifpr.pgua.eic.trabbim.modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class Curso implements Serializable{
    private int codigo;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Curso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        alunos = new ArrayList<>();
    }

    

    public boolean matricula(Aluno aluno){
        for(Aluno a:alunos){
            if(a.getCpf().equals(aluno.getCpf())){
                return false;
            }
        }
        alunos.add(aluno);
        return true;
    }

    public boolean desmatricula(String cpf){
        for(Aluno a:alunos){
            if(a.getCpf().equals(cpf)){
                alunos.remove(a);
                return true;
            }
        }
        return false;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    public Professor getProfessor(){
        return professor;
    }

    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }  

    public void setAlunos(ArrayList<Aluno> alunos){
        this.alunos = alunos;
    }
    
    public String toString(){
        return " Código:"+codigo+
        "\n Nome: "+nome+
        "\n Descrição: "+descricao+
        "\n Carga horaria: "+cargaHoraria+
        "\n Professor: "+professor.getNome();
    }

    public String paraTexto(){
        return " Codigo:"+codigo+
        "; Nome:"+nome+
        "; Descricao:"+descricao+
        "; Carga horaria:"+cargaHoraria+
        "; Professor:"+professor.getCpf();
    }

    public String paraTexto2() {
        String cpfs = "";
        for(Aluno b:alunos){
                cpfs += b.getCpf() + ","; 
         }

        return "Nome:"+nome+
         "; Aluno(s):"+cpfs;

    }


}
