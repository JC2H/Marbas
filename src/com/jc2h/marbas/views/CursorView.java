package com.jc2h.marbas.views;

import com.jc2h.marbas.models.Cursor;
import com.jc2h.mvc.View;
import com.jc2h.mvc.utils.ModelBind;
import processing.core.PConstants;
import processing.core.PGraphics;

public class CursorView extends BaseView<Cursor> {
    PGraphics cursor;
    final int width = 20;

    public CursorView(Cursor cursor) {
        super(cursor);
        this.cursor = getPApplet().createGraphics(width, width);
        createCursor();
    }

    private void createCursor() {
        cursor.beginDraw();
        cursor.clear();
        model.getStroke().stroke(cursor);
        model.getFill().fill(cursor);
        cursor.strokeWeight(2);
        cursor.smooth();
        cursor.beginShape();
        cursor.vertex(0, 0);
        cursor.vertex(width, width / 2.0f);
        cursor.vertex(width / 2.0f, width / 2.0f);
        cursor.vertex(width / 2.0f, width);
        cursor.endShape(PConstants.CLOSE);
        cursor.endDraw();
    }

    @Override
    public void drawFrame(PGraphics g) {
        g.imageMode(PConstants.CORNER);
        g.image(cursor, model.getPosition().x, model.getPosition().y);
    }
}
