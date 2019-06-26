package com.kaha.dragon.dragon.entity;

import java.io.Serializable;

/**
 * 卡通界面的实体类
 *
 * @author Darcy
 * @Date 2019/1/21
 * @package com.kaha.dragon.dragon.entity
 * @Desciption
 */
public class Cartoon implements Serializable {

    private int imageId;

    private String name;

    private String des;

    private String url;

    public String getUrl() {
        return url;
    }

    public Cartoon(int imageId, String name, String des,String url) {
        this.imageId = imageId;
        this.name = name;
        this.des = des;
        this.url = url;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
