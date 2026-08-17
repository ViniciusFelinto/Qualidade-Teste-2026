package jokenpo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JokempoTest {

	Jokenpo jokenpo;
	
	@BeforeEach
	public void inicializa() {
		jokenpo = new Jokenpo();
	}
	
	@Test
    public void testJogadorNzero() {
		int jogador1 = 1;
		int jogador2 = 2;

		Assertions.assertNotEquals(jogador1,0);
		Assertions.assertNotEquals(jogador2,0);

		jokenpo.jogar(jogador1,jogador2);
    }
}
