package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Propose;

import java.util.LinkedHashMap;

public interface Factory {
    public void execute(LinkedHashMap<String, Propose> proposalsMappedById, String[] list);
}
