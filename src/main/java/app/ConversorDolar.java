package app;

import controller.CotacaoController;

import java.util.Locale;

public class ConversorDolar {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        CotacaoController controller = new CotacaoController();
        controller.inicializar();

    }
}
