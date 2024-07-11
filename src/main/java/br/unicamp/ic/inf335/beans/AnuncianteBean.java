package br.unicamp.ic.inf335.beans;

import java.util.ArrayList;
/**
 * Classe que representa um anunciante, com respectivos dados e anúncios associados.
 */
public class AnuncianteBean {
    /**
     * Nome do anunciante
     */
    private String nome;
    /**
     * CPF do anunciante
     */
    private String CPF;
    /**
     * Lista de anúncios de um anunciante
     */
    private ArrayList<AnuncioBean> anuncios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public ArrayList<AnuncioBean> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(ArrayList<AnuncioBean> anuncios) {
        this.anuncios = anuncios;
    }

    /**
     * Construtor default.
     */
    public AnuncianteBean() {
        nome = new String();
        CPF = new String();
        anuncios = new ArrayList<AnuncioBean>();
    }

    /**
     * Construtor com parâmetros.
     *
     * @param nome
     * @param CPF
     * @param anuncios
     */
    public AnuncianteBean(String nome, String CPF, ArrayList<AnuncioBean> anuncios) {
        super();
        this.nome = nome;
        this.CPF = CPF;
        this.anuncios = anuncios;
    }

    /**
     * Inclui novo anúncio na lista de anúncios de um anunciante.
     *
     * @param nAnuncio Anúncio a ser incluído
     */
    public void addAnuncio(AnuncioBean nAnuncio) {
        anuncios.add(nAnuncio);
    }

    /**
     * Remove um anúncio da lista de anúncios de um anunciante.
     *
     * @param i Índice do anúncio a ser removido
     */
    public void removeAnuncio(int i) {
        if (i >= 0 && i < anuncios.size()) {
            anuncios.remove(i);
        } else {
            throw new IndexOutOfBoundsException("Índice fora do limite da lista de anúncios.");
        }
    }

    /**
     * Calcula o valor médio de anúncios de um anunciante.
     *
     * @return valor médio dos anúncios
     */
    public Double valorMedioAnuncios() {
        if (anuncios.isEmpty()) {
            return 0.0;
        }
        Double soma = 0.0;
        for (AnuncioBean an : anuncios) {
            soma += an.getValor();
        }
        return soma / anuncios.size();
    }
}