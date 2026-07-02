package UTIL;

import javax.swing.*;
import javax.swing.text.*;

public class LimiteCaracteres extends DocumentFilter {

    private final int limite;

    public LimiteCaracteres(int limite) {
        this.limite = limite;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {

        if (fb.getDocument().getLength() + string.length() <= limite) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {

        int nuevoTam = fb.getDocument().getLength() - length + text.length();

        if (nuevoTam <= limite) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}