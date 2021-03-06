package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Immobile;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Proponent;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Valid;
import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.utils.ListUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Propose implements Valid {

    private List<Valid> proponents = new ArrayList();
    private HashMap<String, Immobile> immobilesById = new HashMap<>();
    private String id;
    private Float loanValue = 0f;
    private int numberOfMouths = 0;
    private int numberOfPrincipalProponents = 0;

    public Propose(String id, Float loanValue, int numberOfMouths) {
        this.id = id;
        this.loanValue = loanValue;
        this.numberOfMouths = numberOfMouths;
    }

    public String getId() {
        return id;
    }


    public void update(Float loanValue, int numberOfMouths) {
        this.loanValue = loanValue;
        this.numberOfMouths = numberOfMouths;
        Float installmentValue = loanValue / numberOfMouths;
        for (int i = 0; i < proponents.size(); i++) {
            Proponent proponent = (Proponent) proponents.get(i);
            proponent.update(installmentValue);
        }
    }

    public void addProponent(int age, String id, String name, Float monthlyIncome, Boolean isMain) {
        if (isMain) {
            numberOfPrincipalProponents++;
        }
        Float installmentValue = loanValue / numberOfMouths;
        proponents.add(new Proponent(age, id, name, monthlyIncome, isMain, installmentValue));
    }

    public void addImmobile(String id, String province, Float value) {
        immobilesById.put(id, new Immobile(id, province, value));
    }

    public Immobile getImmobile(String id) {
        return immobilesById.get(id);
    }

    public void removeImmobile(String id) {
        immobilesById.remove(id);
    }

    @Override
    public Boolean isValid() {
        ArrayList<Valid> array = new ArrayList<>(immobilesById.values());
        return ListUtils.isAllElementsValid(array) && loanValueIsValid()
                && numberOfMouthsIsValid() && proponentsIsValid();
    }

    private boolean loanValueIsValid() {
        return loanValue >= 30000f && loanValue <= 3000000f;
    }

    private boolean numberOfMouthsIsValid() {
        return numberOfMouths >= 24 && numberOfMouths <= 180;
    }

    private boolean proponentsIsValid() {
        return ListUtils.isAllElementsValid(proponents) && numberOfPrincipalProponents == 1 && proponents.size() >= 2;
    }
}
