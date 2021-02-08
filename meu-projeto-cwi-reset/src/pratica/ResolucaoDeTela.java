package pratica;

import java.awt.*;

public class ResolucaoDeTela {
    public static void main(String[] args) {
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension screenSize = tool.getScreenSize();
        System.out.println("A minha resolução de tela é: " + screenSize.width + "x" + screenSize.height);
    }
}
