package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.factory;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Propose;

import java.util.LinkedHashMap;

public class EventFactory implements Factory{
    private static ProposalFactory proposalFactory = new ProposalFactory();
    private static WarrantyFactory warrantyFactory = new WarrantyFactory();
    private static ProponentFactory proponentFactory = new ProponentFactory();

    @Override
    public void execute(LinkedHashMap<String, Propose> proposalsMappedById, String[] list) {
        if (list[1].equals("proposal")) {
            proposalFactory.execute(proposalsMappedById, list);
        }
        if (list[1].equals("warranty")) {
            warrantyFactory.execute(proposalsMappedById, list);
        }
        if (list[1].equals("proponent")) {
            proponentFactory.execute(proposalsMappedById, list);
        }
    }
}
