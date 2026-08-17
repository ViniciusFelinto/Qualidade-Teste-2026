package jokenpo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JokenpoTest {

    private Jokenpo jokenpo;

    @BeforeEach
    void setUp() {
        jokenpo = new Jokenpo();
    }

    @Test
    @DisplayName("Deve retornar 0 em caso de empate")
    void testEmpate() {
        assertEquals(0, jokenpo.jogar(1, 1)); // Papel vs Papel
        assertEquals(0, jokenpo.jogar(2, 2)); // Pedra vs Pedra
        assertEquals(0, jokenpo.jogar(3, 3)); // Tesoura vs Tesoura
    }

    @Test
    @DisplayName("Deve retornar 1 quando o Jogador 1 vence")
    void testJogador1Vence() {
        assertEquals(1, jokenpo.jogar(1, 2)); // Papel vence Pedra
        assertEquals(1, jokenpo.jogar(2, 3)); // Pedra vence Tesoura
        assertEquals(1, jokenpo.jogar(3, 1)); // Tesoura vence Papel
    }

    @Test
    @DisplayName("Deve retornar 2 quando o Jogador 2 vence")
    void testJogador2Vence() {
        assertEquals(2, jokenpo.jogar(2, 1)); // Pedra perde para Papel
        assertEquals(2, jokenpo.jogar(3, 2)); // Tesoura perde para Pedra
        assertEquals(2, jokenpo.jogar(1, 3)); // Papel perde para Tesoura
    }

    @Test
    @DisplayName("Deve retornar -1 para entradas fora do escopo (1, 2 ou 3)")
    void testOpcoesInvalidas() {
        assertEquals(-1, jokenpo.jogar(0, 2)); // Jogador 1 menor que 1
        assertEquals(-1, jokenpo.jogar(1, 4)); // Jogador 2 maior que 3
        assertEquals(-1, jokenpo.jogar(5, 5)); // Ambos inválidos
    }
}