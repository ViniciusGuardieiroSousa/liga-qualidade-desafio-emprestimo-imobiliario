package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Propose;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.factory.EventFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Solucao {

    private static LinkedHashMap<String, Propose> proposalsMappedById = new LinkedHashMap<>();
    private static EventFactory eventFactory = new EventFactory();

    public static String processMessages(List<String> messages) {
        for (int i = 0; i < messages.size(); i++) {
            String proposal = messages.get(i);
            String[] list = proposal.split(",");
            eventFactory.execute(proposalsMappedById, list);
        }

        StringBuilder result = new StringBuilder();
        ArrayList<Propose> array = new ArrayList<Propose>(proposalsMappedById.values());
        for (int i = 0; i < array.size(); i++) {
            Propose propose = array.get(i);
            if (propose.isValid()) {
                if (result.length() > 0) {
                    result.append(",");
                }
                result.append(propose.getId());
            }
        }
        return result.toString();
    }
}