package carrinho;
import produto.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;


public class CarrinhoTest {
	
	private Carrinho carrinho;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}	
	
	Produto prod = new Produto("Biscoito", 1.50);
	
	@DisplayName("Testa se o valor do carrinho eh maior que zero")
	@Test
	public void testvalorCarrinho(){
		carrinho.addItem(prod);
		Assertions.assertNotEquals(carrinho.getValorTotal(),0.0);
	};	
	Produto produto = new Produto("Biscoito2", 2.50);
	
	@DisplayName("Testa se o que se espera inserir no carrrinho estah correto")
	@Test
	public void testProdutoValido(){
		
		Assertions.assertNotNull(produto);
		carrinho.addItem(produto);
		;
	};	
}
