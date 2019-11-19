package control;

import java.util.Random;

public class ControlGame {

    public static void main(String[] args) {

    }

    public int gerarEnergiaMax(){

        int energiaMax = jogarD6 () + jogarD6 () + 12;
        return energiaMax;
    }

    public int gerarHabilidadeMax(){

        int habilidadeMax = jogarD6 () + 6;
        return habilidadeMax;
    }

    public int gerarSorte (){
        int sorte = jogarD6 () + 6;
        return sorte;
    }

    public int jogarD6(){

        Random gera = new Random ();
        int  resultDado = gera.nextInt(6)+1;
        System.out.println (resultDado);
        return resultDado;
    }
}
