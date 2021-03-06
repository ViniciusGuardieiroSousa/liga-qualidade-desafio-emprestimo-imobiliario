package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Propose;

import java.util.LinkedHashMap;

public class ProponentFactory implements Factory {

    @Override
    public void execute(LinkedHashMap<String, Propose> proposalsMappedById, String[] list) {
        if (list[2].equals("added")) {
            Propose propose = proposalsMappedById.get(list[4]);
            String id = list[5];
            String name = list[6];
            int age = Integer.parseInt(list[7]);
            Float monthlyIncome = Float.parseFloat(list[8]);
            Boolean isMain = Boolean.parseBoolean(list[9]);
            propose.addProponent(age, id, name, monthlyIncome, isMain);
        }
    }
}
