package pratica;

import java.util.Locale;

public class IdiomaDoSistema {
    public static void main(String[] args) {
        Locale localizacao = Locale.getDefault();
        System.out.println("O idioma do meu sistema operacional é: " + localizacao.getDisplayLanguage());
    }
}
