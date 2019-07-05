package com.kaha.dragon.data;

import com.kaha.dragon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darcy
 * @Date 2019/7/4
 * @package com.kaha.dragon.data
 * @Desciption
 */
public class KingHeroData {
    private static List<Integer> kingHeroHead = new ArrayList<>();
    private static List<String> kingHeroName = new ArrayList<>();
    private static List<String> kingHeroDes = new ArrayList<>();
    private static List<Integer> KingHeroBigPic = new ArrayList<>();
    private static List<String> KingHeroWord = new ArrayList<>();

    /**
     * 获取英雄的最常说的话实体类
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<String> getKingHeroWord() {
        KingHeroWord.clear();

        KingHeroWord.add("老兵不死，只会逐渐凋零");
        KingHeroWord.add("大小姐驾到！统统闪开");
        KingHeroWord.add("世界那么大，我想去看看");
        KingHeroWord.add("苏醒了，猎杀时刻");
        KingHeroWord.add("借你们肉体试验下新发明的威力");
        KingHeroWord.add("秘密的密，探案的探");
        KingHeroWord.add("风会带走你曾经存在的证明");
        KingHeroWord.add("罪犯们，你们已无路可逃");
        KingHeroWord.add("千窟为佑，太平无忧");
        KingHeroWord.add("当你凝视深渊的时候 深渊也在凝视你");
        KingHeroWord.add("今天的长城也很和平");
        KingHeroWord.add("红叶最多情，一舞寄相思");
        return KingHeroWord;
    }

    /**
     * 获取英雄的名字实体类
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<String> getNames() {
        kingHeroName.clear();

        kingHeroName.add("黄忠");
        kingHeroName.add("孙尚香");
        kingHeroName.add("马可波罗 ");
        kingHeroName.add("后羿");
        kingHeroName.add("鲁班七号");
        kingHeroName.add("李元芳");
        kingHeroName.add("虞姬");
        kingHeroName.add("狄仁杰");
        kingHeroName.add("伽罗");
        kingHeroName.add("成吉思汗");
        kingHeroName.add("百里守约");
        kingHeroName.add("公孙离");
        return kingHeroName;
    }


    /**
     * 获取英雄的描述实体类
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<String> getKingHeroDes() {
        kingHeroDes.clear();

        kingHeroDes.add("黄忠，是手游《王者荣耀》中的一位射手英雄角色。\n" +
                "黄忠是天生的战场指挥家，做为一名炮手，黄忠不仅继承了准确，坚毅的品质，同时也具备了良好的洞察力和广阔的视野。\n" +
                "需要依靠队友保护，打出成吨的伤害；而作为对手，能在一场团战中迅速找出黄忠且切入集火是赢下一场团战的基础。");
        kingHeroDes.add("孙尚香，是腾讯手游《王者荣耀》中的英雄角色。\n" +
                "孙尚香作为一个射手，包含位移技能，输出爆表，还能收割。 [1] \n" +
                "中后期，孙尚香的装备基本成型，1技能接普攻造成的伤害是非常致命的，孙尚香是一个能在" +
                "敌人碰不到自己的前提下，进行不停消耗的射手，一定要充分利用她的这个特性。");
        kingHeroDes.add("马可波罗是腾讯手游《王者荣耀》中的一名射手型英雄角色。\n" +
                "马可波罗是一名依赖攻速的射手型英雄，具备在正面团战的能力，在游戏的中前期非常强势，" +
                "技能拥有非常高的灵活性以及机动性，其一技能结合平A可以对敌人造成致命的伤害。");
        kingHeroDes.add("后羿，是腾讯手游《王者荣耀》中的射手类ADC英雄角色。\n" +
                "后羿属于高爆发输出型射手英雄，输出能力方面突出。");
        kingHeroDes.add("鲁班七号是手游《王者荣耀》中的英雄角色，游戏中的定位是射手。\n" +
                "鲁班七号是鲁班大师的天才机关造物，原型是春秋时期公输般以及三国时期孙权之女孙鲁班作为外貌原型。\n" +
                "作为一个超远程射手，输出攻击能力自然十分不凡，强大的群体伤害，在团战之中更是无往不利。但因为不具备任何位移技能，" +
                "团战中极度容易被敌方刺客盯上。想要操作好鲁班七号，站位和走位往往是非常重要的。由于鲁班的攻击距离长，更适合远程消耗敌人，" +
                "并且配合减速以及二技能的小段击飞。鲁班没有任何位移，控制技能也只有一技能位于手雷减速和二技能的击飞，前期尽量猥琐塔下。");
        kingHeroDes.add("李元芳，是腾讯手游《王者荣耀》中的一位英雄角色。 [1] \n" +
                "李元芳是一名射手英雄，能够胜任射手位和打野位，其本身拥有极强的单点伤害和快速的清野能力。凭借自身的高爆发能力和位移技能以及快速的刷龙速度，" +
                "让打野位置的李元芳能够更快的把握团队节奏，带领队伍走向胜利");
        kingHeroDes.add("虞姬，手游《王者荣耀》中的一位女性英雄角色。定位为射手。拥有高强的伤害以及爆发力。\n" +
                "虞姬有着很强的消耗能力和控制能力，并且自身还有一定的自保能力，能减轻己方辅助的负担，在团战中有较强的持续作战能力。");
        kingHeroDes.add("狄仁杰，是手游《王者荣耀》中的一名英雄角色，定位为射手。他有着和其他射手一样的射程优势，却又有着近战的爆发和控制技能，非常适合远程输出。\n" +
                "狄仁杰拥有1技能的AOE伤害和2技能的解控效果，不断的走A（移动同时普攻输出）可以使狄仁杰无论是抓人还是逃跑都更加灵活，大招加强了他打前排的能力。");

        kingHeroDes.add("伽罗，是手游《王者荣耀》中的女性射手型英雄角色。她于2018年9月24日抢先服上线，于2018年9月27日正式服上线。她也是王者荣耀正式服的第85位英雄。\n" +
                "伽罗幼年时候，母亲便去世了。身为独女，她在父亲一手教导下长大的。父亲作为族长和学者，拥有广博的学识和高尚人品。他亲自教导女儿学问，以及对书籍深深的热爱。\n" +
                "使用伽罗时，保持安全距离进行攻击，利用射程优势正面压制消耗对方");
        kingHeroDes.add("成吉思汗，是腾讯手游《王者荣耀》的一位英雄角色，定位为射手。\n" +
                "成吉思汗是一名具有独特机动性的射手，擅长与敌人周旋并保持火力输出，依靠稳定高额的单体伤害以及机动性的优势，消磨掉敌人的生命。成吉思汗经过草丛时会提升移动速度，" +
                "合理的规划行进路线会大幅提升跑图能力，围绕草丛与敌人缠斗则会大幅提升成吉思汗的风筝能力");
        kingHeroDes.add("百里守约，是腾讯手游《王者荣耀》的人物之一，2017年8月8日在《王者荣耀》正式服登场。百里守约的背景则是在一次马贼袭击集市时与弟弟" +
                "玄策失散，后加入长城守卫军，找到弟弟，一起与花木兰、铠、苏烈等人一起对抗外来入侵魔种。\n" +
                "百里守约技能以狙击为主，技能解锁的天赋枪也是围绕着狙击枪，射程与爆发力极佳，在对抗赛有着很强的远程优势。是百里玄策的兄长，" +
                "寻找弟弟玄策。");
        kingHeroDes.add("公孙离，是手游《王者荣耀》中的一名英雄角色。职业是射手，拥有很强的敏捷力是她在游戏中重要的体验。\n" +
                "阿离是个被教坊收养的兔子魔种。即便在无比清苦的岁月中，年少的阿离也曾在心里埋下过仰慕的身影和憧憬的对象。而这些成长中的印记，" +
                "潜移默化地影响着阿离，终于有一天，让她代替了那些曾经离开的人，成为长安舞台上新的焦点。也进入了她们曾经逃离的，那些传说中的位" +
                "于暗面的世界。 [1] \n" +
                "阿离手持纸伞时，技能可连续释放两次，在短时间内让敌人叠满4次印记，打出爆发伤害");
        return kingHeroDes;
    }

    /**
     * 获取英雄的头像实体类
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<Integer> getKingHeroHead() {
        kingHeroHead.clear();

        kingHeroHead.add(R.mipmap.huangzhong_head);
        kingHeroHead.add(R.mipmap.ssx_head);
        kingHeroHead.add(R.mipmap.mkbl_head);
        kingHeroHead.add(R.mipmap.hy_head);
        kingHeroHead.add(R.mipmap.lb_head);
        kingHeroHead.add(R.mipmap.lyf_head);
        kingHeroHead.add(R.mipmap.yj_head);
        kingHeroHead.add(R.mipmap.drj_head);
        kingHeroHead.add(R.mipmap.jl_head);
        kingHeroHead.add(R.mipmap.cjsi_head);
        kingHeroHead.add(R.mipmap.blsy_head);
        kingHeroHead.add(R.mipmap.gsl_head);
        return kingHeroHead;
    }

    /**
     * 获取英雄的大图实体类
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<Integer> getKingHeroBigPic() {
        KingHeroBigPic.clear();

        KingHeroBigPic.add(R.mipmap.huangzhong);
        KingHeroBigPic.add(R.mipmap.sunshangxiang);
        KingHeroBigPic.add(R.mipmap.makeboluo);
        KingHeroBigPic.add(R.mipmap.houyi);
        KingHeroBigPic.add(R.mipmap.luban);
        KingHeroBigPic.add(R.mipmap.liyuanfang);
        KingHeroBigPic.add(R.mipmap.yuji);
        KingHeroBigPic.add(R.mipmap.direnjie);
        KingHeroBigPic.add(R.mipmap.jialuo);
        KingHeroBigPic.add(R.mipmap.chengjisihan);
        KingHeroBigPic.add(R.mipmap.bailishouyue);
        KingHeroBigPic.add(R.mipmap.gongsunli);
        return KingHeroBigPic;
    }
}
