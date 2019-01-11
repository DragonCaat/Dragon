package com.kaha.dragon.dragon.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 社区的实体类
 *
 * @author Darcy
 * @Date 2019/1/5
 * @package com.kaha.dragon.dragon.entity
 * @Desciption
 */
public class Community implements Serializable {

    private String nick;//昵称

    private String des;//描述语

    private int head; //头像

    private String longDes;//长篇段描述

    private List<Integer> imageList;//装九宫格图片的数组


    public Community(String nick, String des, int head, List<Integer> imageList, String longDes) {
        this.des = des;
        this.nick = nick;
        this.head = head;
        this.imageList = imageList;
        this.longDes = longDes;
    }

    public String getLongDes() {
        return longDes;
    }

    public String getNick() {
        return nick;
    }

    public String getDes() {
        return des;
    }

    public int getHead() {
        return head;
    }

    public List<Integer> getImageList() {
        return imageList;
    }
}
