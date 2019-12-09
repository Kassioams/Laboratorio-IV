package lab4;

import util.Validador;

import java.util.Objects;

/**
 * Representação da classe para a criação dos alunos.
 * Mostra a criação dos alunos que serão usados no sistema.
 *
 * @author Kassio Silva - 119210551
 */

public class Aluno {

    /**
     * Representação do verificador das entradas de tratamento.
     *
     */

    private Validador validador;

    /**
     * Representação textual da  matricula do aluno a ser cadastrado.
     *
     */

    private String matricula;

    /**
     * Representação textual do nome do aluno a ser cadastrado.
     *
     */

    private String nome;
    /**
     * Representação textual do curso do aluno a ser cadastrado.
     *
     */

    private String curso;

    /**
     * Constrói o Aluno com sua a sua matricula, o seu nome, e o curso no qual estuda.
     * Constrói o validador das entradas do programa.
     *
     * @param matricula a matricula do aluno.
     * @param nome o nome do aluno.
     * @param curso o curso do aluno.
     */


    public Aluno(String matricula, String nome, String curso) {
        this.validador = new Validador();
        this.validador.valida(matricula, "Matricula ");
        this.validador.valida(curso, "Curso ");
        this.validador.valida(nome, "Nome ");
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Retorna a representação textal para a exibição do menu.
     *
     */

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }

    /**
     * Realiza a comparação de dois objetos retorna se são iguais ou não.
     *
     * @return o valor boleano da comparação.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula.equals(aluno.matricula) &&
                nome.equals(aluno.nome) &&
                curso.equals(aluno.curso);
    }

    /**
     * Retorna um valor que indica a posição do objeto na memória.
     *
     * @return o valor da posição da matricula, do nome e do curso.
     */

    @Override
    public int hashCode() {
        return Objects.hash(matricula, nome, curso);
    }
}
