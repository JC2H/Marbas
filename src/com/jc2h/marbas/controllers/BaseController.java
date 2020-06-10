package com.jc2h.marbas.controllers;

import com.jc2h.mvc.Controller;
import com.jc2h.mvc.Model;
import com.jc2h.mvc.View;
import com.jc2h.mvc.utils.ModelBind;

public class BaseController<T extends Model> extends Controller implements ModelBind<T> {
    protected T model;

    public BaseController(T model){
        super(model.getController().getParent());
        this.model = model;
    }

    public void attachModel(T model){
        this.model = model;
    }

}
