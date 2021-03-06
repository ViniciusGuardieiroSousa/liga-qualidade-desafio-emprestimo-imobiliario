package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data;

public class Proponent implements Valid {
    private int age;
    private String id;
    private String name;
    private Float monthlyIncome;
    private Boolean isMain;
    private Float installmentValue;

    public Proponent(int age, String id, String name, Float monthlyIncome, Boolean isMain, Float installmentValue) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.monthlyIncome = monthlyIncome;
        this.isMain = isMain;
        this.installmentValue = installmentValue;
    }

    public void update(Float installmentValue){
        this.installmentValue = installmentValue;
    }


    @Override
    public Boolean isValid() {
        return age >= 18;
    }
}
