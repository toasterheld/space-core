package engine.component.basic;

import engine.component.Component;
import engine.entity.Entity;
import engine.io.graphics.Renderer;

/**
 * Represents a text component that can be attached to an entity.
 * This component allows displaying text with configurable font size, family, and alignment.
 */
public class Text extends Component {

    private String text = "";
    private int fontSize = 20;
    private String fontFamily = "Arial";
    private int alignment = 0;

    /**
     * Constructs a Text component associated with the specified parent entity.
     * The text is initially set to an empty string.
     *
     * @param parent the parent entity to which this text component belongs
     */
    public Text(Entity parent) {
        super(parent);
    }

    /**
     * Constructs a Text component with the specified text and parent entity.
     * The font size is set to the default value (20), and the font family is set to "Arial".
     *
     * @param text   the text to display
     * @param parent the parent entity to which this text component belongs
     */
    public Text(String text, Entity parent) {
        super(parent);
        this.text = text;
    }

    /**
     * Renders the text at the current position with the specified font size, font family, and alignment.
     * The rendering is handled by the Renderer utility.
     */
    @Override
    public void render() {
        Renderer.drawText(text, getPos(), fontSize, fontFamily, alignment);
    }

    // Getter and Setter methods

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
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
}
