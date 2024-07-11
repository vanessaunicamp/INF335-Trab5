package br.unicamp.ic.inf335.beans;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AnuncianteBeanTest {

    private AnuncianteBean anunciante;
    private AnuncioBean anuncio1;
    private AnuncioBean anuncio2;

    @Before
    public void setUp() {
        anuncio1 = new AnuncioBean(new ProdutoBean("001", "Produto 1", "Descrição 1", 100.0, "Novo"), new ArrayList<>(), 0.1);
        anuncio2 = new AnuncioBean(new ProdutoBean("002", "Produto 2", "Descrição 2", 200.0, "Usado"), new ArrayList<>(), 0.2);

        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(anuncio1);
        anuncios.add(anuncio2);

        anunciante = new AnuncianteBean("João", "12345678901", anuncios);
    }

    @Test
    public void testGetNome() {
        assertEquals("João", anunciante.getNome());
    }

    @Test
    public void testSetNome() {
        anunciante.setNome("Maria");
        assertEquals("Maria", anunciante.getNome());
    }

    @Test
    public void testGetCPF() {
        assertEquals("12345678901", anunciante.getCPF());
    }

    @Test
    public void testSetCPF() {
        anunciante.setCPF("98765432100");
        assertEquals("98765432100", anunciante.getCPF());
    }

    @Test
    public void testGetAnuncios() {
        assertEquals(2, anunciante.getAnuncios().size());
        assertEquals(anuncio1, anunciante.getAnuncios().get(0));
        assertEquals(anuncio2, anunciante.getAnuncios().get(1));
    }

    @Test
    public void testSetAnuncios() {
        AnuncioBean anuncio3 = new AnuncioBean(new ProdutoBean("003", "Produto 3", "Descrição 3", 300.0, "Novo"), new ArrayList<>(), 0.3);
        ArrayList<AnuncioBean> novosAnuncios = new ArrayList<>();
        novosAnuncios.add(anuncio3);
        anunciante.setAnuncios(novosAnuncios);
        assertEquals(1, anunciante.getAnuncios().size());
        assertEquals(anuncio3, anunciante.getAnuncios().get(0));
    }

    @Test
    public void testAddAnuncio() {
        AnuncioBean anuncio3 = new AnuncioBean(new ProdutoBean("003", "Produto 3", "Descrição 3", 300.0, "Novo"), new ArrayList<>(), 0.3);
        anunciante.addAnuncio(anuncio3);
        assertEquals(3, anunciante.getAnuncios().size());
        assertEquals(anuncio3, anunciante.getAnuncios().get(2));
    }

    @Test
    public void testRemoveAnuncio() {
        anunciante.removeAnuncio(0);
        assertEquals(1, anunciante.getAnuncios().size());
        assertEquals(anuncio2, anunciante.getAnuncios().get(0));
    }

    @Test
    public void testValorMedioAnuncios() {
        // Valor esperado = (90.0 + 160.0) / 2 = 125.0
        // 100.0 - (100.0 * 0.1) = 90.0
        // 200.0 - (200.0 * 0.2) = 160.0
        assertEquals(Double.valueOf(125.0), anunciante.valorMedioAnuncios(), 0.01);
    }
}
