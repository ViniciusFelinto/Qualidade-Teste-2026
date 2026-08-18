package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(1, 1);		
		Assertions.assertEquals(2, soma);		
	};
	
	@DisplayName("Testa a subtracao de dois n�meros")
	@Test
	public void testSubtraiDoisNumeros() {
		int sub = calc.subtracao(1, 1);		
		Assertions.assertEquals(0, sub);		
	}
	
	@DisplayName("Testa a multiplicacao de dois n�meros")
	@Test
	public void testMultDoisNumeros() {
		int mult = calc.multiplicacao(1, 1);		
		Assertions.assertEquals(1, mult);		
	}

}
