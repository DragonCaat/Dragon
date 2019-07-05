package com.kaha.dragon.dragon.widget;

/**
 * 仿照QQ标识的Tag
 *
 * @author Darcy
 * @Date 2019/6/27
 * @package com.kaha.dragon.dragon.widget
 * @Desciption
 */
public class Tag  {
    private String name;
    private int left;
    private int top;
    private int right;
    private int bottom;
    private int textsize;

    public Tag(String name, int textsize, int left, int top, int right, int bottom){
        this.name = name;
        this.textsize = textsize;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getTextsize() {
        return textsize;
    }

    public void setTextsize(int textsize) {
        this.textsize = textsize;
    }
}
