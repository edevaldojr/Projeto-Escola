package ifpr.pgua.eic.trabbim.repositorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import ifpr.pgua.eic.trabbim.modelos.Aluno;
import ifpr.pgua.eic.trabbim.modelos.Curso;
import ifpr.pgua.eic.trabbim.modelos.Professor;
import ifpr.pgua.eic.trabbim.telas.MatriculaAluno;

public class Escola {

    private String nome;
    private String telefone;

    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Curso> cursos;

    private static final String NOME_ARQUIVO_BIN = "dados.bin";
    private static final String NOME_ARQUIVO_TXT = "dados.txt";
    
    public Escola(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
    }


    public void povoa(){
        LocalDate localDate5 = LocalDate.of(2021, 11, 12);
        alunos.clear();
        alunos.add(new Aluno("101.138.829-12","ZeJunin","zeZ@teste.com","(41)98522-3066", localDate5));
        alunos.add(new Aluno("101.138.829-13","ZeJuni","zeZi@teste.com","(42)98522-3066", localDate5));
       // alunos.add(new Aluno("101.138.829-14","ZeJun","zeZin@teste.com","(43)98522-3066", localDate5));        
       // alunos.add(new Aluno("101.138.829-15","ZeJu","zeZinn@teste.com","(44)98522-3066", localDate5)); 

        professores.clear();
        professores.add(new Professor("101.138.829-12","ZeJunin","zeZ@teste.com","(41)98522-3066", 5000.0));
        professores.add(new Professor("101.138.829-13","ZeJuni","zeZ@teste.com","(42)98522-3066", 5000.0));
      //  professores.add(new Professor("101.138.829-14","ZeJun","zeZ@teste.com","(43)98522-3066", 5.000));
       // professores.add(new Professor("101.138.829-15","ZeJu","zeZ@teste.com","(44)98522-3066", 5.000));


        Professor profe = new Professor("101.138.829-15","ZeJu","zeZ@teste.com","(44)98522-3066", 5000.0);
        cursos.clear();
        cursos.add(new Curso(1,"TADS17","nada",60, profe));
        cursos.add(new Curso(2,"TADS18","nada",50, profe));
       // cursos.add(new Curso(3,"TADS19","nada",40, profe));
       // cursos.add(new Curso(4,"TADS20","nada",30, profe));



    }

    public Aluno buscarAlunoCpf(String cpf){
        return alunos.stream().filter(a -> a.getCpf().equals(cpf)).findAny().orElseGet(()->null);
    }

    public Professor buscarProfessorCpf(String cpf){
        return professores.stream().filter(a -> a.getCpf().equals(cpf)).findAny().orElseGet(()->null);
         
    }

    public Curso buscarCurso(String nome){
        return cursos.stream().filter(a -> a.getNome().equals(nome)).findAny().orElseGet(()->null);
    }

    public boolean cadastrarAluno(String cpf, String nome, String email, String telefone, LocalDate dataMatricula){
        Aluno aluno = new Aluno(cpf, nome, email, telefone, dataMatricula);

        if(buscarAlunoCpf(cpf)==null){
            alunos.add(aluno);
            return true;
        }
        return false;

    }

    public boolean cadastrarProfessor(String cpf, String nome, String email, String telefone, Double salario){
        Professor professor = new Professor(cpf, nome, email, telefone, salario);
        if(buscarAlunoCpf(cpf)==null){
            professores.add(professor);
            return true;
        }
        return false;

    }

    public boolean cadastrarCurso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor){
        Curso curso = new Curso(codigo, nome, descricao, cargaHoraria, professor);
        if(buscarCurso(nome)==null){
            cursos.add(curso);
            return true;
        }
        return false;
    }

    public boolean matricularAluno(Aluno aluno, Curso curso){
        curso.matricula(aluno);
        return true;
    }

    public boolean desmatricular(Aluno aluno, Curso curso){
        for (Aluno a : alunos) {
            if(a.getCpf().equals(aluno.getCpf())){
                curso.desmatricula(a.getCpf());
                return true;
            }
        }
        return false;  
    }

    public ArrayList<Aluno> listarAlunosMatriculados(Curso curso){
        return curso.getAlunos();
    }

    public ArrayList<Aluno> listarAlunos(){
        ArrayList<Aluno> alunoAux = new ArrayList<>();

        for(Aluno x: alunos){
            if(x instanceof Aluno){
                alunoAux.add((Aluno)x);
            }
        }
        return alunoAux;
    }

    public ArrayList<Professor> listarProfessores(){
        ArrayList<Professor> professorAux = new ArrayList<>();

        for(Professor x: professores){
            if(x instanceof Professor){
                professorAux.add((Professor)x);
            }
        }
        return professorAux;
    }

    public ArrayList<Curso> listarCursos(){
        ArrayList<Curso> cursoAux = new ArrayList<>();

        for(Curso x: cursos){
            if(x instanceof Curso){
                cursoAux.add((Curso)x);
            }
        }
        return cursoAux;
    }

    public void salvarArquivoBinario() throws IOException{
        File arq = new File(NOME_ARQUIVO_BIN);
        FileOutputStream fos = new FileOutputStream(arq);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(alunos);
        oos.writeObject(cursos);
        oos.writeObject(professores);

        oos.close();
        fos.close();
    }

    public void carregarAquivoBinario() throws IOException, ClassNotFoundException{

        File arq = new File(NOME_ARQUIVO_BIN);
        FileInputStream fis = new FileInputStream(arq);
        ObjectInputStream ois = new ObjectInputStream(fis);

        alunos = (ArrayList)ois.readObject();
        cursos = (ArrayList)ois.readObject();
        professores = (ArrayList) ois.readObject();


        ois.close();
        fis.close();

    }

    public void salvarArquivoTexto() throws IOException{

        File arq = new File(NOME_ARQUIVO_TXT);
        FileWriter fw = new FileWriter(arq);
        BufferedWriter bw = new BufferedWriter(fw);

        
        bw.write("[ALUNOS]\n");
        for(Aluno a:alunos){
            bw.write("\t" + a.paraTexto());
            bw.newLine();
        }

        bw.write("[PROFESSORES]\n");
        for(Professor p:professores){        
            bw.write("\t" + p.paraTexto());
            bw.newLine();
        }
        
        bw.write("[CURSOS]\n");
        for(Curso c:cursos){        
            bw.write("\t" + c.paraTexto());
            bw.newLine();
        }

        bw.write("[ALUNOS MATRICULADOS] \n");
        for(Curso m:cursos) {
            if(m.getAlunos().size() > 0){
                bw.write("\t"+m.paraTexto2());
                bw.newLine();
            }

        }

       
        bw.close();
        fw.close();
    }
    
    public void carregarArquivoTexto() throws IOException{
        File arq = new File(NOME_ARQUIVO_TXT);

        if(!arq.exists()){
            return;
        }

        FileReader fr = new FileReader(arq);
        BufferedReader br = new BufferedReader(fr);
        int tipo=0; //0 alunos; 1 prefessores; 2 cursos ; 3 alunos matriculados
        
        String linha;

        linha=br.readLine();

        while(linha!=null){
            System.out.println(linha);
            if(linha.contains("[ALUNOS]")){
                tipo = 0;
            }else if(linha.contains("[PROFESSORES]")){
                tipo = 1;
            }else if(linha.contains("[CURSOS]")){
                tipo = 2;
            }else if(linha.contains("[ALUNOS MATRICULADOS]")){
                tipo = 3;
            }
            
            System.out.println(tipo);
            if(!linha.contains("[")){
                linha = linha.replace("\t","");
                String[] pedacos = linha.split(";");

                
                if(tipo == 0){
                    String cpf = pedacos[0].split(":")[1];
                    String nome = pedacos[1].split(":")[1];
                    String email = pedacos[2].split(":")[1];
                    String telefone = pedacos[3].split(":")[1];
                    String data = pedacos[4].split(":")[1];
                    LocalDate localdate = LocalDate.parse(data);
                    

                    Aluno a = new Aluno(cpf, nome, email, telefone, localdate);
                    this.alunos.add(a);
                }else if(tipo == 1){
                    String cpf = pedacos[0].split(":")[1];
                    String nome = pedacos[1].split(":")[1];
                    String email = pedacos[2].split(":")[1];
                    String telefone = pedacos[3].split(":")[1];
                    String salario = pedacos[4].split(":")[1];
                    Double doubleSalario = Double.parseDouble(salario);
                    

                    Professor p = new Professor(cpf, nome, email, telefone, doubleSalario);
                    this.professores.add(p);
                }else if(tipo == 2){
                    String codigo = pedacos[0].split(":")[1];
                    String nome = pedacos[1].split(":")[1];
                    String descricao = pedacos[2].split(":")[1];
                    String cargaHoraria = pedacos[3].split(":")[1];
                    String cpf = pedacos[4].split(":")[1];
                    int cod = Integer.parseInt(codigo);
                    int cargaH = Integer.parseInt(cargaHoraria);
                    Professor professor = buscarProfessorCpf(cpf);
                    

                    Curso c = new Curso(cod, nome, descricao, cargaH, professor);
                    this.cursos.add(c);
                }else if(tipo == 3){
                    String nomeCurso = pedacos[0].split(":")[1];
                    String[] cpfAluno = pedacos[1].split(":")[1].split(",");
                    Curso curso = buscarCurso(nomeCurso);
                    ArrayList<Aluno> alunos = new ArrayList<>();
    
                    for (String string : cpfAluno){
                        Aluno aluno = buscarAlunoCpf(string);
                        alunos.add(aluno);
                        matricularAluno(aluno, curso);
                    }     
                }
                

            }

            linha = br.readLine();
        }
    }



}
