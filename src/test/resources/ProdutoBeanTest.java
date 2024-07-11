package br.unicamp.ic.inf335.beans;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoBeanTest {

    @Test
    public void testProdutoBeanDefaultConstructor() {
        ProdutoBean produto = new ProdutoBean();
        Assert.assertEquals("", produto.getCodigo());
        Assert.assertEquals("", produto.getNome());
        Assert.assertEquals("", produto.getDescricao());
        Assert.assertEquals(Double.valueOf(0.0), produto.getValor());
        Assert.assertEquals("", produto.getEstado());
    }

    @Test
    public void testProdutoBeanParameterizedConstructor() {
        ProdutoBean produto = new ProdutoBean("001", "Produto A", "Descricao A", 10.0, "Novo");
        Assert.assertEquals("001", produto.getCodigo());
        Assert.assertEquals("Produto A", produto.getNome());
        Assert.assertEquals("Descricao A", produto.getDescricao());
        Assert.assertEquals(Double.valueOf(10.0), produto.getValor());
        Assert.assertEquals("Novo", produto.getEstado());
    }

    @Test
    public void testSetAndGetMethods() {
        ProdutoBean produto = new ProdutoBean();
        produto.setCodigo("002");
        produto.setNome("Produto B");
        produto.setDescricao("Descricao B");
        produto.setValor(20.0);
        produto.setEstado("Usado");

        Assert.assertEquals("002", produto.getCodigo());
        Assert.assertEquals("Produto B", produto.getNome());
        Assert.assertEquals("Descricao B", produto.getDescricao());
        Assert.assertEquals(Double.valueOf(20.0), produto.getValor());
        Assert.assertEquals("Usado", produto.getEstado());
    }

    @Test
    public void testCompareTo() {
        ProdutoBean produto1 = new ProdutoBean("001", "Produto A", "Descricao A", 10.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("002", "Produto B", "Descricao B", 20.0, "Usado");

        Assert.assertTrue(produto1.compareTo(produto2) < 0);
        Assert.assertTrue(produto2.compareTo(produto1) > 0);
        Assert.assertTrue(produto1.compareTo(produto1) == 0);
    }
}
