package testesLab4;

import lab4.Aluno;
import lab4.Grupo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    private Grupo grupoTeste;

    @Test
    void testeGrupoGuardaAluno() {
       this.grupoTeste = new Grupo("Matemtica");
        Aluno novoAluno = new Aluno("1478536", "Gileade", "Ciencia da computação");
        grupoTeste.guardaAluno(novoAluno);
    }
    @Test
    void testaGrupoToString(){
        this.grupoTeste = new Grupo("Alemão");
        Aluno novoAluno = new Aluno("1478536", "Gileade", "Ciencia da computação");
        grupoTeste.guardaAluno(novoAluno);
        assertEquals("* 1478536 - Gileade - Ciencia da computação", grupoTeste.toString());
    }

    @Test
    void testaNomeGrupoVazio(){
        assertThrows(IllegalArgumentException.class, ()-> this.grupoTeste = new Grupo("   "));
    }

    @Test
    void testaNomeGrupoNulo(){
        assertThrows(NullPointerException.class, ()-> this.grupoTeste = new Grupo(null));
    }
}