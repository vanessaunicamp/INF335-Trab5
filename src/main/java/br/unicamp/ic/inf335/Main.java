package br.unicamp.ic.inf335;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        // Criando produtos
        ProdutoBean produto1 = new ProdutoBean("001", "Produto 1", "Descrição 1", 100.0, "Novo");
        ProdutoBean produto2 = new ProdutoBean("002", "Produto 2", "Descrição 2", 200.0, "Usado");

        // Criando anúncios com produtos e descontos
        ArrayList<URL> fotosAnuncio1 = new ArrayList<>();
        fotosAnuncio1.add(new URL("http://example.com/foto1"));
        AnuncioBean anuncio1 = new AnuncioBean(produto1, fotosAnuncio1, 0.1);

        ArrayList<URL> fotosAnuncio2 = new ArrayList<>();
        fotosAnuncio2.add(new URL("http://example.com/foto2"));
        AnuncioBean anuncio2 = new AnuncioBean(produto2, fotosAnuncio2, 0.2);

        // Criando anunciante com anúncios
        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(anuncio1);
        anuncios.add(anuncio2);

        AnuncianteBean anunciante = new AnuncianteBean("João", "12345678901", anuncios);

        // Testando métodos de AnuncianteBean
        System.out.println("Nome do anunciante: " + anunciante.getNome());
        System.out.println("CPF do anunciante: " + anunciante.getCPF());
        System.out.println("Anúncios do anunciante:");
        for (AnuncioBean anuncio : anunciante.getAnuncios()) {
            System.out.println("- Produto: " + anuncio.getProduto().getNome());
            System.out.println("  Valor com desconto: R$ " + anuncio.getValor());
        }

        System.out.println("Valor médio dos anúncios: R$ " + anunciante.valorMedioAnuncios());
    }
}
