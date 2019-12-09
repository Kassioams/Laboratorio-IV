package util;

import lab4.Aluno;

/**
 * Representação da classe exclusiva para tratamento de excessões.
 *
 */

public class Validador {

    /**
     * Representação do método para o tratamento de entradas nulas.
     *
     * @param aluno o aluno cadastrado a ser validado.
     * @param msg   a mensagem definida.
     */

    public void validaAluno(Aluno aluno, String msg) {
        if (aluno == null) {
            throw new NullPointerException(msg + "nulo");
        }
    }

    /**
     * Representação do método para o tratamento de entradas nulas.
     *
     * @param dado o valor a ser conferido e validado.
     * @param msg  a mensagem do metodo referido,
     */

    public void valida(String dado, String msg) {
        this.validaVazio(dado, msg);
        this.validaNulo(dado, msg);
    }

    /**
     * Representação do método para o tratamento de entradas vazias.
     *
     * @param dado o valor a ser conferido e validadp.
     * @param msg  a mensagem do método referido,
     */

    private void validaVazio(String dado, String msg) {
        if (dado.trim().equals("")) {
            throw new IllegalArgumentException(msg + "vazio");
        }
    }

    /**
     * Representação do método para o tratamento de entradas nulas.
     *
     * @param dado o valor a ser conferido e validadp.
     * @param msg  a mensagem do método referido.
     */

    private void validaNulo(String dado, String msg) {
        if (dado == null) {
            throw new NullPointerException(msg + "nulo");
        }
    }
}
