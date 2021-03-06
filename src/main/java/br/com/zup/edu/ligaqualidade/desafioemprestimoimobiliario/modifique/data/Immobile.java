package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data;

public class Immobile implements Valid {

    private String id;
    public String province;
    public Float value;

    public Immobile(String id, String province, Float value) {
        this.id = id;
        this.province = province;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    @Override
    public Boolean isValid() {
        return true;
    }
}
