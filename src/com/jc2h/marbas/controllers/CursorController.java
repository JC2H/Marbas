package com.jc2h.marbas.controllers;

import com.jc2h.marbas.models.Cursor;
import processing.event.MouseEvent;

public class CursorController extends BaseController<Cursor>{
    public CursorController(Cursor cursor){
        super(cursor);
    }

    @Override
    public void handleMouseEvent(MouseEvent event) {
        super.handleMouseEvent(event);
        model.setPosition(event.getX(), event.getY());
        model.getView().refresh();
    }
}
