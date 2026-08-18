package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        // O carrinho precisa ser instanciado antes de cada teste
        carrinho = new Carrinho();
        
        // Instanciando os produtos reais
        produto1 = new Produto("Livro", 2.50);
        produto2 = new Produto("Relogio", 200.50);
    }

    @Test
    @DisplayName("Deve calcular o valor total dos itens adicionados ao carrinho")
    void testGetValorTotal() {
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
        
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        
        // Ajustado para a soma correta: 2.50 + 200.50 = 203.0
        assertEquals(203.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve adicionar itens e atualizar a quantidade corretamente")
    void testAddEGetQtdeItems() {
        assertEquals(0, carrinho.getQtdeItems());
        
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
        
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve remover um item existente do carrinho")
    void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.removeItem(produto1);
        
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve lançar ProdutoNaoEncontradoException ao tentar remover item inexistente")
    void testRemoveItemInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto1));
    }

    @Test
    @DisplayName("Deve esvaziar completamente o carrinho")
    void testEsvazia() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        
        carrinho.esvazia();
        
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }
}