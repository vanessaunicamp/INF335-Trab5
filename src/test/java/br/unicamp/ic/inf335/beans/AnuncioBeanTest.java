package br.unicamp.ic.inf335.beans;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AnuncioBeanTest {

    private AnuncioBean anuncio;
    private ProdutoBean produto;
    private ArrayList<URL> fotosUrl;

    @Before
    public void setUp() throws MalformedURLException {
        produto = new ProdutoBean("001", "Produto Teste", "Descrição Teste", 100.0, "Novo");
        fotosUrl = new ArrayList<>();
        fotosUrl.add(new URL("http://example.com/foto1"));
        fotosUrl.add(new URL("http://example.com/foto2"));
        anuncio = new AnuncioBean(produto, fotosUrl, 0.1);
    }

    @Test
    public void testGetProduto() {
        assertEquals(produto, anuncio.getProduto());
    }

    @Test
    public void testSetProduto() {
        ProdutoBean novoProduto = new ProdutoBean("002", "Outro Produto", "Outra Descrição", 200.0, "Usado");
        anuncio.setProduto(novoProduto);
        assertEquals(novoProduto, anuncio.getProduto());
    }

    @Test
    public void testGetFotosUrl() {
        assertEquals(fotosUrl, anuncio.getFotosUrl());
    }

    @Test
    public void testSetFotosUrl() throws MalformedURLException {
        ArrayList<URL> novasFotosUrl = new ArrayList<>();
        novasFotosUrl.add(new URL("http://example.com/foto3"));
        anuncio.setFotosUrl(novasFotosUrl);
        assertEquals(novasFotosUrl, anuncio.getFotosUrl());
    }

    @Test
    public void testGetDesconto() {
        assertEquals(Double.valueOf(0.1), anuncio.getDesconto());
    }

    @Test
    public void testSetDesconto() {
        anuncio.setDesconto(0.2);
        assertEquals(Double.valueOf(0.2), anuncio.getDesconto());
    }

    @Test
    public void testGetValor() {
        // Valor do produto = 100.0
        // Desconto = 0.1
        // Valor esperado = 100.0 - (100.0 * 0.1) = 90.0
        assertEquals(Double.valueOf(90.0), anuncio.getValor());
    }

    @Test
    public void testGetSerialversionuid() {
        assertEquals(1L, AnuncioBean.getSerialversionuid());
    }
}
