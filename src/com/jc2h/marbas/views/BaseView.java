package com.jc2h.marbas.views;

import com.jc2h.mvc.Model;
import com.jc2h.mvc.View;
import com.jc2h.mvc.utils.ModelBind;

public class BaseView<T extends Model> extends View implements ModelBind<T> {
    protected T model;

    public BaseView(T model){
        super(model.getView().getParent());
        this.model = model;
    }

    public void attachModel(T model){
        this.model = model;
    }
}
