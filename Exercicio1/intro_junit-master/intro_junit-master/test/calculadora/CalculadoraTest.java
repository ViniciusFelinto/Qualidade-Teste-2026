package calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Deve somar dois números corretamente")
    void testSoma() {
        assertEquals(5, calculadora.soma(2, 3));
        assertEquals(-1, calculadora.soma(-4, 3));
        assertEquals(0, calculadora.soma(0, 0));
    }

    @Test
    @DisplayName("Deve subtrair dois números corretamente")
    void testSubtracao() {
        assertEquals(1, calculadora.subtracao(4, 3));
        assertEquals(-7, calculadora.subtracao(-4, 3));
        assertEquals(0, calculadora.subtracao(5, 5));
    }

    @Test
    @DisplayName("Deve multiplicar dois números corretamente")
    void testMultiplicacao() {
        assertEquals(12, calculadora.multiplicacao(4, 3));
        assertEquals(-12, calculadora.multiplicacao(4, -3));
        assertEquals(0, calculadora.multiplicacao(4, 0));
    }

    @Test
    @DisplayName("Deve dividir dois números corretamente (divisão inteira)")
    void testDivisao() {
        assertEquals(2, calculadora.divisao(6, 3));
        assertEquals(2, calculadora.divisao(5, 2)); // O Java trunca casas decimais em int
    }

    @Test
    @DisplayName("Deve lançar ArithmeticException ao tentar dividir por zero")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(5, 0));
    }

    @Test
    @DisplayName("Deve calcular a somatória de 0 até n")
    void testSomatoria() {
        assertEquals(6, calculadora.somatoria(3)); // 3 + 2 + 1 + 0 = 6
        assertEquals(0, calculadora.somatoria(0));
        assertEquals(0, calculadora.somatoria(-5)); // Loop while(n >= 0) não executará
    }

    @Test
    @DisplayName("Deve verificar se um número é positivo")
    void testEhPositivo() {
        assertTrue(calculadora.ehPositivo(5));
        assertTrue(calculadora.ehPositivo(0));
        assertFalse(calculadora.ehPositivo(-1));
    }

    @Test
    @DisplayName("Deve comparar dois números corretamente")
    void testCompara() {
        assertEquals(0, calculadora.compara(5, 5)); // a == b
        assertEquals(1, calculadora.compara(6, 5)); // a > b
        assertEquals(-1, calculadora.compara(4, 5)); // a < b
    }
}