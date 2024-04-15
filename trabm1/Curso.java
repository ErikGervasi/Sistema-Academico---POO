//Aluno: Erik Gervasi

package trabm1;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String sigla;
    private List<Turma> turmas;

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

}
