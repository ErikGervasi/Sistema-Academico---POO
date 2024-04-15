//Aluno: Erik Gervasi

package trabm1;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int ano;
    private String semestre;
    private Curso curso;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private String nome;

    public Turma(int ano, String semestre, Curso curso, String nome) {
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        this.curso = curso;
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getNome() {
        return this.nome;
    }
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }


    public List<Aluno> getAlunos() {
        return alunos;
    }


    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
        professor.adicionarTurma(this);
    }

    public void removerProfessor(Professor professor) {
        professores.remove(professor);
        professor.removerTurma(this);
    }

    public List<Professor> getProfessores() {
        return professores;
    }

}
