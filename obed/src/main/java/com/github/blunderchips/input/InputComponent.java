package com.github.blunderchips.input;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

/**
 *
 */
public abstract class InputComponent extends JPanel {

    /**
     * {@link Field} to be edited.
     */
    private final Field field;

    /**
     * @param field {@link Field} to be edited.
     */
    public InputComponent(Field field) {
        this.field = field;

        super.setLayout(new GridLayout());
        // super.add(new JLabel(field.getName()));
    }

    /**
     * @param obj {@link Object} to be edited.
     * @throws IllegalAccessException if this {@code Field} object is enforcing Java language access control and the
     *                                underlying field is either inaccessible or final.
     */
    public void save(Object obj) throws IllegalAccessException {
        getField().set(obj, getInput());
    }

    protected abstract Object getInput();

    protected Field getField() {
        return this.field;
    }

    /**
     * @return True, assume that the input is valid
     */
    protected boolean isInputValid() {
        return true;
    }
}
