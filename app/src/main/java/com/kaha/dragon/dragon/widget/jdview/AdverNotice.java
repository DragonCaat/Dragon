package com.kaha.dragon.dragon.widget.jdview;

/**
 * 滚动条实体类
 *
 * @author Darcy
 * @Date 2019/7/3
 * @package com.kaha.dragon.dragon.widget.jdview
 * @Desciption
 */
public class AdverNotice {

    private String title;

    private String url;

    public AdverNotice(String title,String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
