package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Immobile;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Propose;

import java.util.LinkedHashMap;

public class WarrantyFactory implements Factory{
    @Override
    public void execute(LinkedHashMap<String, Propose> proposalsMappedById, String[] list) {
        if (list[2].equals("added")) {
            Propose propose = proposalsMappedById.get(list[4]);
            String id = list[5];
            Float value = Float.parseFloat(list[6]);
            String province = list[7];
            propose.addImmobile(id, province, value);
        }
        if (list[2].equals("update")) {
            Propose propose = proposalsMappedById.get(list[4]);
            String id = list[5];
            Float value = Float.parseFloat(list[6]);
            String province = list[7];
            Immobile immobile = propose.getImmobile(id);
            immobile.value = value;
            immobile.province = province;
        }
        if (list[2].equals("removed")) {
            Propose propose = proposalsMappedById.get(list[4]);
            String id = list[5];
            propose.removeImmobile(id);

        }
    }
}
