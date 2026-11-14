
package grupoexitop;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelArbol extends JPanel {
    private ArbolBinarioBusqueda arbol;

    public PanelArbol(ArbolBinarioBusqueda arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar(g, arbol.getRaiz(), getWidth() / 2, 40, getWidth() / 4);
    }

    private void dibujar(Graphics g, Nodo n, int x, int y, int dx) {
        if (n == null) return;

        if (n.getIzq() != null) {
            g.setColor(Color.GRAY);
            g.drawLine(x, y, x - dx, y + 70);
            dibujar(g, n.getIzq(), x - dx, y + 70, dx / 2);
        }

        if (n.getDer() != null) {
            g.setColor(Color.GRAY);
            g.drawLine(x, y, x + dx, y + 70);
            dibujar(g, n.getDer(), x + dx, y + 70, dx / 2);
        }

        g.setColor(new Color(11, 44, 90));
        g.fillOval(x - 45, y - 15, 90, 30); 

        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(n.getDato().getCedula()), x - 40, y + 5);
    }
}