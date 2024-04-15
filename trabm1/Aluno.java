//Aluno: Erik Gervasi

package trabm1;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String endereco;
    private List<Turma> turmas;

    public Aluno(String nome, String endereco) {
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


    public List<Turma> getTurmas() {
        return turmas;
    }
    public void adicionarTurma(Turma turma) {
        if (!turmas.contains(turma)) {
            turmas.add(turma);
        }
    }


}
