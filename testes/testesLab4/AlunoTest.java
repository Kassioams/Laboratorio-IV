package testesLab4;

import lab4.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno alunoTestes;

    @Test
    void testToString() {
        Aluno novoAluno = new Aluno("12345", "augusto", "engenharia");
        assertEquals("12345 - augusto - engenharia", novoAluno.toString());
    }

    @Test
    void testaAlunoMatriculaVazia() {
        assertThrows(IllegalArgumentException.class, () -> this.alunoTestes = new Aluno("   ", "Pedro", "Frances"));
    }

    @Test
    void testaAlunoMatriculaNulo() {
        assertThrows(NullPointerException.class, () -> this.alunoTestes = new Aluno(null, "Pedro", "Fraces"));
    }

    @Test
    void testaAlunoNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.alunoTestes = new Aluno("41369", "   ", "Engenharia"));
    }

    @Test
    void testaAlunoNomeNulo() {
        assertThrows(NullPointerException.class, () -> this.alunoTestes = new Aluno("73391", null, " Ingles"));
    }

    @Test
    void testaAlunoCursoVazio() {
        assertThrows(IllegalArgumentException.class, () -> this.alunoTestes = new Aluno("40139", "Cesar", "   "));
    }

    @Test
    void testaAlunoCursoNulo() {
        assertThrows(NullPointerException.class, () -> this.alunoTestes = new Aluno("65423", "Fabiano", null));
    }

    @Test
    void testaEqualsAluno() {
        Aluno primeiroAluno = new Aluno("428913", "andre", "Letras");
        Aluno segundoAluno = new Aluno("428913", "andre", "Letras");
        assertTrue(primeiroAluno.equals(segundoAluno));
    }

    @Test
    void testaHashCode() {
        Aluno primeiroAluno = new Aluno("552190", "wesley", "Administração");
        Aluno segundoAluno = new Aluno("552190", "wesley", "Administração");
        assertEquals(primeiroAluno.hashCode(), segundoAluno.hashCode());
    }
}