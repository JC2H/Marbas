package com.jc2h.mvc.utils;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.data.JSONObject;

public class Color {
    int a,b,c;
    int mode;
    private Color(int a, int b, int c, int mode){
        this.a = a;
        this.b = b;
        this.c = c;
        this.mode = mode;
    }

    public void fill(PApplet applet){
        applet.pushStyle();
        applet.colorMode(this.mode);
        applet.fill(this.a, this.b, this.c);
        applet.popStyle();
    }
    public void fill(PGraphics graphics){
        graphics.pushStyle();
        graphics.colorMode(this.mode);
        graphics.fill(this.a, this.b, this.c);
        graphics.popStyle();
    }

    public void stroke(PApplet applet){
        applet.pushStyle();
        applet.colorMode(this.mode);
        applet.stroke(this.a, this.b, this.c);
        applet.popStyle();
    }
    public void stroke(PGraphics graphics){
        graphics.pushStyle();
        graphics.colorMode(this.mode);
        graphics.stroke(this.a, this.b, this.c);
        graphics.popStyle();
    }
    public void background(PApplet applet){
        applet.pushStyle();
        applet.colorMode(this.mode);
        applet.background(this.a, this.b, this.c);
        applet.popStyle();
    }
    public void background(PGraphics graphics){
        graphics.pushStyle();
        graphics.colorMode(this.mode);
        graphics.background(this.a, this.b, this.c);
        graphics.popStyle();
    }

    public static Color loadFromJson(JSONObject object){
        return new Color(object.getInt("r"), object.getInt("g"), object.getInt("b"),PApplet.RGB);
    }
    public static Color createRGB(int r, int g, int b){
       return new Color(r,g,b, PApplet.RGB);
    }
    public static Color createHSV(int h, int s, int b){
        return new Color(h,s,b,PApplet.HSB);
    }
}
