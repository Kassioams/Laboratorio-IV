package testesLab4;

import lab4.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Controller controller;

    @BeforeEach
    void setUp() {
        this.controller = new Controller();
        controller.cadastraAluno("1268", "Renildo", "Psicologia");
        controller.novoGrupo("Matematica");
    }

    @Test
    void testeCadastraAlunoMatriculaVazia() {
        assertThrows(IllegalArgumentException.class, () -> this.controller.cadastraAluno("   ", "Japa", "Sociologia"));
    }

    @Test
    void testeCadastraAlunoMatriculaNula(){
        assertThrows(NullPointerException.class ,() -> this.controller.cadastraAluno(null, "Japa" , "Sociologia"));
    }

    @Test
    void testeCadastraAlunoNomeVazio(){
        assertThrows(IllegalArgumentException.class, () -> this.controller.cadastraAluno("743269", "  ", "Odonto"));
    }

    @Test
    void testeCadastraAlunoNomeNulo(){
        assertThrows(NullPointerException.class, ()-> this.controller.cadastraAluno("952652", null, "sla"));
    }

    @Test
    void testeCadastraAlunoCursoVazio(){
        assertThrows(IllegalArgumentException.class, ()-> this.controller.cadastraAluno("736149", "Kassio", "   "));
    }

    @Test
    void testeCadastraAlunoCursoNulo(){
        assertThrows(NullPointerException.class, ()-> this.controller.cadastraAluno("749836", "Augusto", null));
    }

    @Test
    void testeCadastraGrupoNomeVazio(){
        assertThrows(IllegalArgumentException.class, ()-> this.controller.novoGrupo("   "));
    }

    @Test
    void testeCadastraGrupoNomeNulo(){
        assertThrows(NullPointerException.class, () -> this.controller.novoGrupo(null));
    }

    @Test
    void testeAlocaAlunoNomeVazio(){
        assertThrows(IllegalArgumentException.class, ()-> this.controller.alocar("  ", "459687"));
    }

    @Test
    void testeAlocaAlunoNomeNulo(){
        assertThrows(NullPointerException.class, ()-> this.controller.alocar(null, "454154"));
    }

    @Test
    void testeAlocarAlunoMatriculaVazia(){
        assertThrows(IllegalArgumentException.class, ()-> this.controller.alocar("Ingles", "   "));
    }

    @Test
    void testeAlocarAlunoMatriculaNulo(){
        assertThrows(NullPointerException.class, ()-> this.controller.alocar("Espanhol", null));
    }

    @Test
    void testeImprimeGrupoNomeVazio(){
        assertThrows(IllegalArgumentException.class, ()-> this.controller.imprimeGrupo("  "));
    }

    @Test
    void testeImprimeGrupoNomeNull(){
        assertThrows(NullPointerException.class, ()-> this.controller.imprimeGrupo(null));
    }

    @Test
    void testaResponderamMatriculaVazia(){
        assertThrows(IllegalArgumentException.class, ()-> this.controller.responderam("   "));
    }

    @Test
    void testaResponderamMatriculaNula(){
        assertThrows(NullPointerException.class, ()-> this.controller.responderam(null));
    }
    @Test
    void cadastraAlunoValido() {
        assertEquals("CADASTRO REALIZADO!", controller.cadastraAluno("21369", "Joao", "Psicologia"));
    }

    @Test
    void cadastraAlunoInvalido() {
        controller.cadastraAluno("21369", "Joao", "Psicologia");
        assertEquals("MATRÍCULA JÁ CADASTRADA!", controller.cadastraAluno("21369", "Joao", "Psicologia"));
    }

    @Test
    void exibir() {
        controller.cadastraAluno("1268", "Renildo", "Psicologia");
        assertEquals("Aluno: 1268 - Renildo - Psicologia", controller.exibir("1268"));
    }

    @Test
    void novoGrupoValido() {
        assertEquals("CADASTRO REALIZADO!", controller.novoGrupo("Geografia"));
    }

    @Test
    void novoGrupoCadastrado() {
        controller.novoGrupo("Historia");
        assertEquals("GRUPO JÁ CADASTRADO!", controller.novoGrupo("Historia"));
    }

    @Test
    void alocarAlunoGrupo() {
        controller.novoGrupo("Portugues");
        controller.cadastraAluno("748562", "Rejane", "Pedagogia");
        assertEquals("ALUNO ALOCADO!", controller.alocar("Portugues", "748562"));
    }

    @Test
    void alocarAlunoGrupoInexistente() {
        controller.cadastraAluno("14862", "Victor", "Ingles");
        assertEquals("Grupo não cadastrado.", controller.alocar("Filosofia", "14862"));
    }

    @Test
    void alocarGrupoAlunoInexistente() {
        controller.novoGrupo("Ed.Fisica");
        assertEquals("Aluno não cadastrado.", controller.alocar("Ed.Fisica", "745834"));
    }

    @Test
    void imprimeGrupo() {
        controller.novoGrupo("Portugues");
        controller.cadastraAluno("748562", "Rejane", "Pedagogia");
        controller.alocar("Portugues", "748562");
        assertEquals("Alunos do grupo Portugues:" + System.lineSeparator() +
                "* 748562 - Rejane - Pedagogia", controller.imprimeGrupo("Portugues"));
    }

    @Test
    void alunosResponderam() {
        controller.cadastraAluno("400289", "Arthur", "Cinema");
        assertEquals("ALUNO REGISTRADO!", controller.responderam("400289"));
    }

    @Test
    void alunosRespostas() {
        controller.cadastraAluno("400289", "Arthur", "Cinema");
        controller.responderam("400289");
        assertEquals("1. 400289 - Arthur - Cinema", controller.alunosRespostas());
    }
}