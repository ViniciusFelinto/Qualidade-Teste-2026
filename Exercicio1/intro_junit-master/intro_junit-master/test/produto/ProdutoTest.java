package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdu��o ao Teste de Software", 100.00);
	}
	
	@Test
    public void testBaseadoNoNome() {
        // Dois produtos com nomes iguais, mas preços diferentes
        Produto p1 = new Produto("Java Basico", 50.0);
        Produto p2 = new Produto("Java Basico", 100.0);
        
        assertEquals(p1, p2);
    }

    @Test
    public void testSetPreco() {
        // Testa se a alteração do preço reflete no objeto
        livro.setPreco(150.0);
        assertThat(livro.getPreco(), equalTo(150.0));
    }

}
