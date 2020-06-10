package com.jc2h.mvc;

import com.jc2h.marbas.core.tree.Node;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class View extends Node<View> {
    private PGraphics canvas;
    private PApplet pApplet;
    boolean refresh;

    public PApplet getPApplet(){
        return pApplet;
    }

    public View(PApplet pApplet){
        super();
        this.canvas = pApplet.createGraphics(pApplet.width,pApplet.height);
        this.pApplet = pApplet;
    }

    public View(View view){
        super();
        this.pApplet = view.pApplet;
        this.canvas = pApplet.createGraphics(pApplet.width, pApplet.height);
        view.addChild(this);
    }

    public void refresh(){
        this.refresh = true;
        if(!isRoot()){
            this.parent.refresh();
        }
    }

    public void drawFrame(PGraphics g){

    }

    public void draw(){
        if(this.refresh) {
            canvas.beginDraw();
            canvas.clear();
            canvas.imageMode(PConstants.CORNER);
            drawFrame(canvas);
            for (View child : children) {
                canvas.push();
                child.draw();
                canvas.pop();
                canvas.image(child.canvas, 0,0);
            }
            canvas.endDraw();

            this.refresh = false;
        }
        if(isRoot()) {
            pApplet.imageMode(PConstants.CORNER);
            pApplet.image(canvas, 0, 0);
        }
    }
}
