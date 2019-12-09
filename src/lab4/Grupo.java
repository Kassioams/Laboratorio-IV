package lab4;

import util.Validador;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Representação da criação dos grupos de estudos.
 * Será o local onde os grupos dos alunos ficará.
 *
 * @author Kassio Silva - 119210551
 */

public class Grupo {

    private Validador validador;

    /**
     * Representação dos grupos dos alunos.
     * Os grupos ficarão em um conjunto para posteriormente serem utilizados.
     *
     */

    private HashSet<Aluno> grupo;

    /**
     * Representação do nome do grupo de estudos a ser criado.
     *
     */

    private String nomeDoGrupo;

    /**
     * Constrói o grupo de estudo com seu referido nome.
     *
     * @param nomeDoGrupo o nome do grupo para a criação.
     */

    public Grupo(String nomeDoGrupo){
        this.validador = new Validador();
        this.validador.valida(nomeDoGrupo, "Nome do Grupo ");
        this.nomeDoGrupo = nomeDoGrupo;
        this.grupo = new HashSet<>();
    }
    /**
     * Representação da adição do aluno dentro de um grupo.
     *
     * @param aluno o aluno a ser colocado no grupo.
     */

    public void guardaAluno(Aluno aluno){
        this.validador.validaAluno(aluno, "Aluno ");
        this.grupo.add(aluno);
    }

    /**
     * Representação da exibição dos alunos do grupo.
     * Será montada uma sequemcia com os alunos que estão participando do grupo.
     *
     * @return os alunos participantes do grupo.
     */

    public String toString(){
        String retorno = "";
        Iterator<Aluno> itr = grupo.iterator();
        while (itr.hasNext()) {
            retorno += "* " + itr.next().toString();
        }
        return retorno;
    }
}
