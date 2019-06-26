package com.kaha.dragon.dragon.entity;

import java.util.List;

/**
 * 首页banner图的实体
 *
 * @author Darcy
 * @Date 2019/1/11
 * @package com.kaha.dragon.dragon.entity
 * @Desciption
 */
public class BannerData {

    private List<Integer> imageList;//图片地址

    private List<String> titleList;//图片title

    public BannerData(List<Integer> imageList, List<String> titleList) {
        this.imageList = imageList;
        this.titleList = titleList;
    }

    public List<String> getTitleList() {
        return titleList;
    }

    public List<Integer> getImageList() {

        return imageList;
    }
}
