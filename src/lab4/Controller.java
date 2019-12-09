package lab4;

import util.Validador;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Representação do controlador das operções do sistema.
 * Lugar onde será execultado as funções do menu.
 */

public class Controller {

    /**
     * Representação do mapa onde os alunos serão matriculados e de onde ele serão usados.
     *
     */

    private HashMap<String, Aluno> mapaMatriculaAlunos;

    /**
     * Representação do mapa onde os grupos serão alocados e de onde eles serão usados.
     *
     */

    private HashMap<String, Grupo> mapaGruposAlunos;

    /**
     * Representação do array lista onde os alunos que responderam questões serão guardados
     *
     */

    private ArrayList listaResposta;

    /**
     * Representação do verificador das entradas de tratamento.
     *
     */

    private Validador validador;

    /**
     * Constrói as coleções a serem usados no controlador.
     *
     */

    public Controller() {
        this.validador = new Validador();
        this.mapaGruposAlunos = new HashMap<>();
        this.mapaMatriculaAlunos = new HashMap<>();
        this.listaResposta = new ArrayList();
    }

    /**
     * Representação do cadastramento do aluno.
     * Cada alundo terá sua matrícula, seu nome e o curso.
     * A matrícula vai ser a identificação do aluno no controle.
     *
     * @param matricula a matricula e identificador do aluno.
     * @param nome      o nome do aluno.
     * @param curso     o curso no qual está cursando.
     * @return a representação do cadastro do aluno.
     */

    public String cadastraAluno(String matricula, String nome, String curso) {
        this.validador.valida(matricula, "Matricula ");
        this.validador.valida(nome, "Aluno ");
        this.validador.valida(curso, "Curso ");
        String retorno = "MATRÍCULA JÁ CADASTRADA!";
        if (!mapaMatriculaAlunos.containsKey(matricula)) {
            Aluno aluno = new Aluno(matricula, nome, curso);
            mapaMatriculaAlunos.put(matricula, aluno);
            retorno = "CADASTRO REALIZADO!";
        }
        return retorno;
    }

    /**
     * Representação da exibição da consulta pelo aluno.
     * A partir da matrícula se mostrará o aluno a ela referido.
     *
     * @param matricula a matricula do aluno a ser consultada.
     * @return a representação do aluno consultado.
     */

    public String exibir(String matricula) {
        String retorno = "Aluno não cadastrado.";
        if (mapaMatriculaAlunos.containsKey(matricula)) {
            retorno = "Aluno: " + mapaMatriculaAlunos.get(matricula).toString();
        }
        return retorno;
    }

    /**
     * Representação da criação dos grupos de estudos dos alunos.
     * Cada grupo terá seu respectivo nome para posterior identificação.
     *
     * @param nome o nome do grupo a ser criado.
     * @return a representação se o grupo foi criado ou não.
     */

    public String novoGrupo(String nome) {
        this.validador.valida(nome, "Nome ");
        String retorno = "GRUPO JÁ CADASTRADO!";
        if (!mapaGruposAlunos.containsKey(nome)) {
            Grupo grupo = new Grupo(nome);
            mapaGruposAlunos.put(nome, grupo);
            retorno = "CADASTRO REALIZADO!";
        }
        return retorno;
    }

    /**
     * Representação da alocação dos alunos para os grupos
     *
     * @param nome o nome do grupo para a alocação.
     * @param matricula a matricula do aluno a ser alocado.
     * @return a representação  da alocação.
     */

    public String alocar(String nome, String matricula) {
        this.validador.valida(nome, "Nome ");
        this.validador.valida(matricula, "Matricula ");
        String retorno = "";
        if (!mapaGruposAlunos.containsKey(nome)) {
            retorno = "Grupo não cadastrado.";
        } else {
            if (mapaMatriculaAlunos.containsKey(matricula)) {
                Aluno aluno = mapaMatriculaAlunos.get(matricula);
                mapaGruposAlunos.get(nome).guardaAluno(aluno);
                retorno = "ALUNO ALOCADO!";
            } else {
                retorno = "Aluno não cadastrado.";
            }
        }
        return retorno;
    }

    /**
     * Representação da impressao dos integrantes do grupo.
     *
     * @param nome o nome do grupo para a impressão dos alunos.
     * @return a lista dos alunos do grupo referido.
     */

    public String imprimeGrupo(String nome) {
        this.validador.valida(nome, "Nome ");
        String retorno = "Grupo não cadastrado.";
        if (mapaGruposAlunos.containsKey(nome)) {
            retorno = "Alunos do grupo " + nome + ":\n" +
                    mapaGruposAlunos.get(nome).toString();
        }
        return retorno;
    }

    /**
     * Representação do cadastro dos alunos que responderam questões para o professor.
     *
     * @param matricula a matricula do aluno que respondeu.
     * @return a representação do cadastro do aluno.
     */

    public String responderam(String matricula) {
        this.validador.valida(matricula, "Matricula ");
        String retorno = "Aluno não cadastrado.";
        if (mapaMatriculaAlunos.containsKey(matricula)) {
            listaResposta.add(mapaMatriculaAlunos.get(matricula));
            retorno = "ALUNO REGISTRADO!";
        }
        return retorno;
    }

    /**
     * Representação da listagem dos alunos que responderam as questões.
     *
     * @return os alunos que responderam as perguntas.
     */

    public String alunosRespostas() {
        String retorno = "";
        for (int i = 0; i < listaResposta.size(); i++) {
            retorno += (i + 1) + ". " + listaResposta.get(i).toString();
        }
        return retorno;
    }
}

