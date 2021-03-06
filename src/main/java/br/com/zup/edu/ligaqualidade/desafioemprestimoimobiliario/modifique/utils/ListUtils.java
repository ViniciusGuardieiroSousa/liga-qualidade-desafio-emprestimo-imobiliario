package br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.utils;

import br.com.zup.edu.ligaqualidade.desafioemprestimoimobiliario.modifique.data.Valid;

import java.util.List;

public final class ListUtils {

    public static boolean isAllElementsValid(List<Valid> array){
        for (Valid valid : array) {
            if (!valid.isValid()) {
                return false;
            }
        }
        return true;
    }
}
