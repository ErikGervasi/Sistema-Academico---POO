//Aluno: Erik Gervasi

package trabm1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaAcademico {
    private Scanner scanner;
    private List<Curso> cursos;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Turma> turmas;

    public SistemaAcademico() {
        scanner = new Scanner(System.in);
        cursos = new ArrayList<>();
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    private void exibirMenuPrincipal() {
        System.out.println(
                "                           _______                               _______\n" +
                "    //   / /   /|    / /     / /  ||   / /   // | |     / /        / /\n" +
                "   //   / /   //|   / /     / /   ||  / /   //__| |    / /        / /\n" +
                "  //   / /   // |  / /     / /    || / /   / ___  |   / /        / /\n" +
                " //   / /   //  | / /     / /     ||/ /   //    | |  / /        / /\n" +
                "((___/ /   //   |/ /   __/_/___   |  /   //     | | / /____//__/_/___\n" +
                "                         SISTEMA ACADEMICO\n                                     ");
        System.out.println("1. Gerenciar Cursos");
        System.out.println("2. Gerenciar Alunos");
        System.out.println("3. Gerenciar Turmas");
        System.out.println("4. Gerenciar Professores");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    gerenciarCursos();
                    break;
                case 2:
                    gerenciarAlunos();
                    break;
                case 3:
                    gerenciarTurmas();
                    break;
                case 4:
                    gerenciarProfessores();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void gerenciarCursos() {
        int escolha;
        do {
            System.out.println("\n--- Gerenciamento de Cursos ---");
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private void cadastrarCurso() {
        System.out.print("Nome do Curso: ");
        String nome = scanner.nextLine();
        System.out.print("Sigla do Curso: ");
        String sigla = scanner.nextLine();
        Curso novoCurso = new Curso(nome, sigla);
        cursos.add(novoCurso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Não há cursos cadastrados.");
            return;
        }
        System.out.println("\nLista de Cursos:");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            System.out.println((i + 1) + ". " + curso.getSigla() + " - " + curso.getNome());
        }
    }

    private void gerenciarAlunos() {
        int escolha;
        do {
            System.out.println("\n--- Gerenciamento de Alunos ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private void cadastrarAluno() {
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço do Aluno: ");
        String endereco = scanner.nextLine();
        Aluno novoAluno = new Aluno(nome, endereco);
        alunos.add(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }
        System.out.println("\nLista de Alunos:");
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            System.out.println((i + 1) + ". Nome: " + aluno.getNome() + ", Endereço: " + aluno.getEndereco());
        }
    }


    private void gerenciarTurmas(){
        int escolha;
        do {
            System.out.println("\n--- Gerenciamento de Turmas ---");
            System.out.println("1. Cadastrar Turma");
            System.out.println("2. Adicionar aluno a uma turma");
            System.out.println("3. Listar Turmas");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    cadastrarTurma();
                    break;
                case 2:
                    adicionarAlunoATurma();
                    break;
                case 3:
                    listarTurmas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private void cadastrarTurma() {
        System.out.print("Qual o ano? ");
        int ano = Integer.parseInt(scanner.nextLine());
        System.out.print("Qual o semestre? ");
        String semestre = scanner.nextLine();

        listarCursos();
        System.out.print("Escolha o número correspondente ao Curso desta turma: ");
        int indiceCurso = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceCurso < 0 || indiceCurso >= cursos.size()) {
            System.out.println("Índice de curso inválido!");
            return;
        }

        System.out.println("Qual o nome da turma?");
        String nomeTurma = scanner.nextLine();

        Curso curso = cursos.get(indiceCurso);

        Turma novaTurma = new Turma(ano, semestre, curso, nomeTurma);
        turmas.add(novaTurma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    private void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Não há turmas cadastradas, volte ao menu para cadastrar!");
            return;
        }

        System.out.println("\nLista de Turmas:");
        for (int i = 0; i < turmas.size(); i++) {
            Turma turma = turmas.get(i);
            System.out.println((i + 1) + ". Ano: " + turma.getAno() + "\nSemestre: " + turma.getSemestre() +
                    "\nCurso: " + turma.getCurso().getNome() + "\nNome da turma: " + turma.getNome() + "\n");
        }
    }
    private void adicionarAlunoATurma() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados no sistema.");
            return;
        }
        if (turmas.isEmpty()) {
            System.out.println("Não há turmas cadastradas no sistema.");
            return;
        }

        System.out.println("Selecione um aluno para adicionar à turma:");
        listarAlunos();
        System.out.print("Digite o número correspondente ao aluno: ");
        int indiceAluno;
        try {
            indiceAluno = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Erro: Você deve digitar um número. Tente novamente.");
            return;
        }

        if (indiceAluno < 0 || indiceAluno >= alunos.size()) {
            System.out.println("Índice de aluno inválido! Tente novamente.");
            return;
        }
        Aluno alunoSelecionado = alunos.get(indiceAluno);

        System.out.println("Selecione uma turma para adicionar o aluno:");
        listarTurmas();
        System.out.print("Digite o número correspondente à turma: ");
        int indiceTurma;
        try {
            indiceTurma = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Erro: Você deve digitar um número. Tente novamente.");
            return;
        }

        if (indiceTurma < 0 || indiceTurma >= turmas.size()) {
            System.out.println("Índice de turma inválido! Tente novamente.");
            return;
        }
        Turma turmaSelecionada = turmas.get(indiceTurma);

        turmaSelecionada.adicionarAluno(alunoSelecionado);
        alunoSelecionado.adicionarTurma(turmaSelecionada);

        System.out.println("Aluno adicionado à turma com sucesso!");
    }


    private void gerenciarProfessores(){
            int escolha;
            do {
                System.out.println("\n--- Gerenciamento de Professores ---");
                System.out.println("1. Cadastrar Professor");
                System.out.println("2. Listar Professores");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");
                escolha = Integer.parseInt(scanner.nextLine());

                switch (escolha) {
                    case 1:
                        cadastrarProfessor();
                        break;
                    case 2:
                        listarProfessores();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (escolha != 0);
    }

    private void cadastrarProfessor() {
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço do Professor: ");
        String endereco = scanner.nextLine();

        System.out.println("Turmas disponíveis:");
        listarTurmas();
        System.out.print("Selecione o número correspondente à turma: ");
        int indiceTurma = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceTurma < 0 || indiceTurma >= turmas.size()) {
            System.out.println("Índice de turma inválido!");
            return;
        }

        Turma turmaSelecionada = turmas.get(indiceTurma);

        Professor novoProfessor = new Professor(nome, endereco);
        novoProfessor.adicionarTurma(turmaSelecionada);
        professores.add(novoProfessor);
        System.out.println("Professor cadastrado com sucesso na turma: " + turmaSelecionada.getNome());
    }


    private void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Não há professores cadastrados.");
            return;
        }
        System.out.println("\nLista de Professores:");
        for (int i = 0; i < professores.size(); i++) {
            Professor professor = professores.get(i);
            System.out.print((i + 1) + ". Nome: " + professor.getNome() + ", Endereço: " + professor.getEndereco());

            List<Turma> turmasDoProfessor = professor.getTurmas();
            if (turmasDoProfessor.isEmpty()) {
                System.out.println(" - Este professor não está vinculado a nenhuma turma.");
            } else {
                System.out.print(" - Turmas: ");
                for (Turma turma : turmasDoProfessor) {
                    System.out.print(turma.getNome() + " ");
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();
        sistema.iniciar();
    }
}
