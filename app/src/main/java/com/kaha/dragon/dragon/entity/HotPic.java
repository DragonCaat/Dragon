package com.kaha.dragon.dragon.entity;

import java.io.Serializable;

/**
 * 首页，热门推荐实体类
 *
 * @author Darcy
 * @Date 2019/4/12
 * @package com.kaha.dragon.dragon.entity
 * @Desciption
 */
public class HotPic implements Serializable {


    private int image;//大图

    private int head;//用户头像

    private String nick;//用户昵称

    private int likeCount;//喜欢数量


    public HotPic(int image, int head, String nick, int likeCount) {
        this.image = image;
        this.head = head;
        this.nick = nick;
        this.likeCount = likeCount;
    }


    public int getImage() {
        return image;
    }

    public int getHead() {
        return head;
    }

    public String getNick() {
        return nick;
    }

    public int getLikeCount() {
        return likeCount;
    }
}
