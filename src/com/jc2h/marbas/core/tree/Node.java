package com.jc2h.marbas.core.tree;

import java.util.LinkedList;

public class Node<T extends Node<T>> {
    protected T parent;
    protected LinkedList<T> children;

    public void setParent(T parent){
        if(!isRoot()){
            parent.abandonChild((T)this);
        }
        parent.addChild((T)this);
    }
    public T getParent(){
        return this.parent;
    }
    public void abandonParent(){
        if(!isRoot())
            this.parent.abandonChild((T)this);
    }
    public void replace(T strange){
        if(!isRoot()){
            parent.addChild(strange);
            abandonParent();
        }
    }
    public LinkedList<T> getChildren(){
        return children;
    }
    public Node(){
        parent = null;
        children = new LinkedList<>();
    }

    public void addChild(T child){
        assert child != null;
        children.add(child);
        if(!child.isRoot()){
            child.parent.abandonChild(child);
        }
        child.parent = (T)this;
    }
    public void abandonChild(T child){
        assert child != null;
        children.remove(child);
        child.parent = null;
    }

    public boolean isRoot(){
       return parent == null;
    }

    public boolean isLeaf(){
        return children.isEmpty();
    }
}
