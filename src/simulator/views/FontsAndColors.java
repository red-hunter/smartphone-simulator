package simulator.views;

import java.awt.*;

public class FontsAndColors{
    Font someFont = new Font(Font.SERIF,Font.BOLD,12);
    static Font nameFont = new Font(Font.MONOSPACED,Font.BOLD,14);
    static Color topPanelColor = new Color(98,0,238);
    static Color bottomPanelColor = new Color(158,71,255);
    static Color hoverContactColor = new Color(4,0,186);
    static Color transparent = new Color(127,168,235,10);
    static Color buttonTransparent = new Color(127,168,235);

    public static Color getTopPanelColor() {
        return topPanelColor;
    }

    public static Color getBottomPanelColor() {
        return bottomPanelColor;
    }

    public static Color getHoverContactColor() {
        return hoverContactColor;
    }

    public static Font getNameFont() {
        return nameFont;
    }
}
