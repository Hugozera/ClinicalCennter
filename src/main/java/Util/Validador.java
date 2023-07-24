package Util;

public class Validador {
    public static boolean osDadosNaoSaovazios(String [] dados) {
        if (dados != null) {
            for (String dado:dados){
                if (dados==null && dado.length()<=0){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

}
