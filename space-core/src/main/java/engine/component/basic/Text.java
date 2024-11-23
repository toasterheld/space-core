package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;
import engine.util.Vector2D;

public class Text extends Component {

    private String text = "";
    private int fontSize = 20;
    private String fontFamily = "Arial";
    private int alignment = 0;



    public Text(Entity parent) {
        super(parent);
    }

    public Text(String text, Entity parent) {
        super(parent);
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAlignment(int alignment) {
        this.alignment = alignment;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getAlignment() {
        return alignment;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    @Override
    public void render() {
        Renderer.drawText(text, getPos(), fontSize, fontFamily, alignment);
    }
}
