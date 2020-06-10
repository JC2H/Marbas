package com.jc2h.marbas;

import com.jc2h.marbas.models.Cursor;
import com.jc2h.marbas.models.Scene;
import com.jc2h.mvc.Model;
import com.jc2h.mvc.utils.Color;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.util.ArrayList;

public class Marbas extends PApplet {
    private JSONObject configuration;
    private Scene scene;
    Color windowBackground;

    @Override
    public void settings() {
        configuration = loadJSONObject("config/marbas.json");
        JSONObject windowCfg = configuration.getJSONObject("window");
        loadWindowCfg(windowCfg);
        JSONArray jsonColors = configuration.getJSONArray("colors");
        loadColors(jsonColors);
    }
    private void loadWindowCfg(JSONObject cfg){
        size(cfg.getInt("width"), cfg.getInt("height"));
        windowBackground = Color.loadFromJson(cfg.getJSONObject("color"));
    }
    private void loadColors(JSONArray jsonColors){

        Configuration.colors = new ArrayList<>();
        int colorSize = jsonColors.size();
        Configuration.colors.ensureCapacity(colorSize);
        for(int i = 0; i < colorSize; ++i){
            Configuration.colors.add(Color.loadFromJson(jsonColors.getJSONObject(i)));
        }
    }

    @Override
    public void setup() {
        noCursor();
        scene = new Scene(this);
        Cursor cursor = new Cursor(scene);
    }

    @Override
    public void draw() {
        windowBackground.background(this);
        scene.getView().draw();
    }

    @Override
    protected void handleMouseEvent(MouseEvent event) {
        super.handleMouseEvent(event);
        scene.getController().handleMouseEvent(event);
    }

    @Override
    protected void handleKeyEvent(KeyEvent event) {
        super.handleKeyEvent(event);
        scene.getController().handleKeyEvent(event);
    }
}
