package com.jc2h.mvc;

import com.jc2h.marbas.core.tree.Node;
import com.sun.istack.internal.NotNull;
import processing.core.PApplet;

public class Model extends Node<Model> {
    protected View view;
    protected Controller controller;

    protected Model(PApplet pApplet){
        super();
        this.view = new View(pApplet);
        this.controller = new Controller();

    }
    protected Model(Model parent){
        super();
        this.view = new View(parent.view);
        this.controller = new Controller(parent.controller);
        parent.addChild(this);
    }

    public View getView(){return view;}
    public void setView(@NotNull View view){
        assert this.view != null;
        this.view.replace(view);
        this.view = view;
    }
    public Controller getController(){return controller;}
    public void setController(@NotNull Controller controller){
        assert this.controller != null;
        this.controller.replace(controller);
        this.controller = controller;
    }

    public void update(){
        for(Model child: children){
            child.update();
        }
    }


    @Override
    public void abandonParent() {
        super.abandonParent();
        assert this.view != null;
        assert this.controller!= null;

        this.view.abandonParent();
        this.controller.abandonParent();
    }

    @Override
    public void abandonChild(Model child) {
        super.abandonChild(child);
        assert this.view != null;
        assert this.controller!= null;

        this.view.abandonChild(child.view);
        this.controller.abandonChild(child.controller);
    }
}
