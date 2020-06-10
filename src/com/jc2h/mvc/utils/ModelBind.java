package com.jc2h.mvc.utils;

import com.jc2h.marbas.core.tree.Node;
import com.jc2h.mvc.Model;
import com.jc2h.mvc.View;

public interface ModelBind<T extends Model> {
    void attachModel(T model);
}
