package lab4;

import java.util.Scanner;

/**
 * Representação da exibição do menu da controle de alunos.
 * Todas as operações serão realizadas por esse menu.
 *
 * @author Kassio Silva - 119210551
 */

public class Menu {

    /**
     * Representação textual a ser exibida pelo menu ao usuário do sistema.
     *
     * @return o texto da exibição do menu.
     */

    private static String exibir() {
        String textos = "(C)adastrar aluno" + System.lineSeparator() +
                "(E)xibir Aluno" + System.lineSeparator() +
                "(N)ovo Grupo" + System.lineSeparator() +
                "(A)locar Aluno no Grupo e Imprimir Grupos" + System.lineSeparator() +
                "(R)egistrar Aluno que Respondeu" + System.lineSeparator() +
                "(I)mprimir Alunos que Responderam" + System.lineSeparator() +
                "(O)ra, vamos fechar o programa!" + System.lineSeparator() +
                "Opção> ";
        return textos;
    }

    /**
     * Representação das opções que o usuário tem a escolher para fazer o controle dos alunos.
     * Cada opção está interligada as outras classes que executarão o que lhe for exigido.
     * O usuário terá opções para operar sobre os alunos os manipulando da forma que for necessária.
     */
    public static void main(String[] args) {

        System.out.println(exibir());
        Scanner sc = new Scanner(System.in);
        String opcao = sc.nextLine().toUpperCase();
        Controller geral = new Controller();
        String nome;
        String curso;
        String nomeGrupo;

        do {
            switch (opcao) {
                case "C":
                    System.out.print("Matricula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Nome: ");
                    nome = sc.nextLine();

                    System.out.print("Curso: ");
                    curso = sc.nextLine();

                    System.out.println(geral.cadastraAluno(matricula, nome, curso));
                    System.out.println();
                    break;

                case "E":
                    System.out.print("Matricula: ");
                    matricula = sc.nextLine();

                    System.out.println(geral.exibir(matricula));
                    System.out.println();
                    break;

                case "N":
                    System.out.print("Grupo: ");
                    nomeGrupo = sc.nextLine();

                    System.out.println((geral.novoGrupo(nomeGrupo)));
                    System.out.println();
                    break;

                case "A":
                    System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
                    String acao = sc.nextLine().toUpperCase();
                    if (acao.equals("A")) {
                        System.out.print("Matricula: ");
                        matricula = sc.nextLine();
                        System.out.print("Grupo: ");
                        nomeGrupo = sc.nextLine();
                        System.out.println(geral.alocar(nomeGrupo, matricula));
                    } else {
                        System.out.print("Grupo: ");
                        nomeGrupo = sc.nextLine();
                        System.out.println(geral.imprimeGrupo(nomeGrupo));
                    }
                    System.out.println();
                    break;

                case "R":
                    System.out.println("Matricula: ");
                    matricula = sc.nextLine();
                    System.out.println(geral.responderam(matricula));
                    System.out.println();
                    break;

                case "I":
                    System.out.println(geral.alunosRespostas());
                    System.out.println();
                    break;

                default:
                    System.out.println("MATRÍCULA JÁ CADASTRADA!");
            }
            System.out.println(exibir());
            opcao = sc.nextLine().toUpperCase();
        } while (!"O".equals(opcao));
    }
}