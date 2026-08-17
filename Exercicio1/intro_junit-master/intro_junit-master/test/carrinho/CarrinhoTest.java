package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produtoMock1;
    private Produto produtoMock2;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
        
        // Criando Mocks de Produto para isolar os testes do Carrinho
        produtoMock1 = mock(Produto.class);
        when(produtoMock1.getPreco()).thenReturn(10.0);
        
        produtoMock2 = mock(Produto.class);
        when(produtoMock2.getPreco()).thenReturn(20.5);
    }

    @Test
    @DisplayName("Deve calcular o valor total dos itens adicionados ao carrinho")
    void testGetValorTotal() {
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
        
        carrinho.addItem(produtoMock1);
        carrinho.addItem(produtoMock2);
        
        assertEquals(30.5, carrinho.getValorTotal(), 0.001);
    }

    @Test
    @DisplayName("Deve adicionar itens e atualizar a quantidade corretamente")
    void testAddEGetQtdeItems() {
        assertEquals(0, carrinho.getQtdeItems());
        
        carrinho.addItem(produtoMock1);
        assertEquals(1, carrinho.getQtdeItems());
        
        carrinho.addItem(produtoMock2);
        assertEquals(2, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve remover um item existente do carrinho")
    void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produtoMock1);
        carrinho.removeItem(produtoMock1);
        
        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    @DisplayName("Deve lançar ProdutoNaoEncontradoException ao tentar remover item inexistente")
    void testRemoveItemInexistente() {
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produtoMock1));
    }

    @Test
    @DisplayName("Deve esvaziar completamente o carrinho")
    void testEsvazia() {
        carrinho.addItem(produtoMock1);
        carrinho.addItem(produtoMock2);
        
        carrinho.esvazia();
        
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }
}