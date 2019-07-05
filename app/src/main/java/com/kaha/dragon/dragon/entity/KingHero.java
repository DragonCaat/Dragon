package com.kaha.dragon.dragon.entity;

/**
 * 王者荣耀实体
 *
 * @author Darcy
 * @Date 2019/7/4
 * @package com.kaha.dragon.dragon.entity
 * @Desciption
 */
public class KingHero {

    private int heroHead;
    private String heroName;
    private String heroDes;
    private int heroBigPic;

    private String heroWord;
//    private String heroUserNmae;
//    private int heroUserHead;


    public KingHero(int heroHead, String heroName, String heroDes,
                    int heroBigPic, String heroWord) {
        this.heroBigPic = heroBigPic;
        this.heroHead = heroHead;
        this.heroName = heroName;
        this.heroDes = heroDes;
        this.heroWord = heroWord;
//        this.heroUserHead = heroUserHead;
//        this.heroUserNmae = heroUserNmae;
    }


    public String getHeroWord() {
        return heroWord;
    }

    public int getHeroHead() {
        return heroHead;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getHeroDes() {
        return heroDes;
    }

    public int getHeroBigPic() {
        return heroBigPic;
    }

}
