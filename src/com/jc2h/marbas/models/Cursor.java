package com.jc2h.marbas.models;

import com.jc2h.marbas.Configuration;
import com.jc2h.marbas.controllers.CursorController;
import com.jc2h.marbas.views.CursorView;
import com.jc2h.mvc.Model;
import com.jc2h.mvc.utils.Color;
import processing.core.PVector;

public class Cursor extends Model {
    PVector position;
    Color stroke;
    Color fill;

    public Color getFill() {
        return fill;
    }

    public Color getStroke() {
        return stroke;
    }

    public PVector getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.set(x,y);
    }

    public Cursor(Model parent) {
        super(parent);
        fill = Configuration.colors.get(Configuration.colors.size() - 1);
        stroke = Color.createRGB(0,0,0);
        position = new PVector();

        this.setView(new CursorView(this));
        this.setController(new CursorController(this));
    }

}
