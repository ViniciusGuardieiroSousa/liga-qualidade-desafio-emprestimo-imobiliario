package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Propose;

import java.util.LinkedHashMap;

public class ProposalFactory implements Factory{
    @Override
    public void execute(LinkedHashMap<String, Propose> proposalsMappedById, String[] list) {
        if (list[2].equals("created")) {
            String id = list[4];
            Float loanValue = Float.parseFloat(list[5]);
            int numberOfMouths = Integer.parseInt(list[6]);
            Propose propose = new Propose(id, loanValue, numberOfMouths);
            proposalsMappedById.put(id, propose);
        }
        if (list[2].equals("updated")) {
            String id = list[4];
            Float loanValue = Float.parseFloat(list[5]);
            int numberOfMouths = Integer.parseInt(list[6]);
            Propose propose = proposalsMappedById.get(id);
            propose.update(loanValue, numberOfMouths);

        }
        if (list[2].equals("deleted")) {
            String id = list[4];
            proposalsMappedById.remove(id);
        }
    }
}
