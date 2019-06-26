package com.kaha.dragon.dragon.entity;

/**
 * @author Darcy
 * @Date 2019/4/15
 * @package com.kaha.dragon.dragon.entity
 * @Desciption
 */
public class RecPeople {

    private int head;

    private String title;

    private String content;


    public RecPeople(int head,String title, String content){
        this.head=head;
        this.title = title;
        this.content = content;
    }

    public int getHead() {
        return head;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
