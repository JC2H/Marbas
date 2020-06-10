package com.jc2h.mvc;

import com.jc2h.marbas.core.tree.Node;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class Controller extends Node<Controller> {
    protected boolean alt,shift,ctrl;

    public Controller(){
        super();
    }
    public Controller(Controller controller){
        super();
        controller.addChild(this);
    }

    protected void mouseMove(PVector mouse){

    }
    protected void rigthClick(PVector mouse){

    }
    protected void leftClick(PVector mouse){

    }
    protected void drag(PVector drag){

    }
    public void handleMouseEvent(MouseEvent event){
        for(Controller child: children){
            child.handleMouseEvent(event);
        }
        alt = event.isAltDown();
        ctrl = event.isControlDown();
        shift = event.isShiftDown();
        if(event.getAction() == MouseEvent.PRESS){
            switch (event.getButton()){
                case PApplet.LEFT:
                    leftClick(new PVector(event.getX(), event.getY()));
                    break;
                case PApplet.RIGHT:
                    rigthClick(new PVector(event.getX(), event.getY()));
                    break;
            }
        }else if(event.getAction() == MouseEvent.MOVE){
            mouseMove(new PVector(event.getX(), event.getY()));
        }else if(event.getAction() == MouseEvent.DRAG){
            drag(new PVector(event.getX(), event.getY()));
        }
    }
    protected void ctrlShiftAlt(char c){

    }
    protected void ctrlShift(char c){

    }
    protected void ctrlAlt(char c){

    }
    protected void ctrl(char c){

    }
    protected void shift(char c){

    }
    protected void alt(char c){

    }
    protected void keyPressed(char c){

    }

    public void handleKeyEvent(KeyEvent event){
        for(Controller child: children){
            child.handleKeyEvent(event);
        }
        if(event.getAction() == KeyEvent.PRESS){
            char c = event.getKey();
            int code = event.getKeyCode();
            ctrl = event.isControlDown();
            shift = event.isShiftDown();
            alt = event.isAltDown();
            if(ctrl){
                if(shift){
                    if(alt){
                        //CTRL SHIFT ALT
                        ctrlShiftAlt(c);
                    }else{
                        //CTRL SHIFT
                        ctrlShift(c);

                    }
                }else if(alt){
                   //CTRL ALT
                    ctrlAlt(c);
                }else{
                    //CTRL
                    ctrl(c);
                }
            }else if(shift){
                //SHIFT
                shift(c);
            }else if(alt){
               //ALT
                alt(c);
            }else{
                //NONE
                keyPressed(c);
            }
        }
    }
}
