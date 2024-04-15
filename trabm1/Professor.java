//Aluno: Erik Gervasi

package trabm1;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String endereco;
    private List<Turma> turmas;

    public Professor(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        turmas.remove(turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

}
