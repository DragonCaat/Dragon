package com.kaha.dragon.data;

import com.kaha.dragon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darcy
 * @Date 2019/1/21
 * @package com.kaha.dragon.data
 * @Desciption
 */
public class CartoonData {

    private static List<String> cartoonNames = new ArrayList<>();

    private static List<Integer> cartoonImages = new ArrayList<>();

    private static List<String> cartoonDes = new ArrayList<>();

    private static List<String> cartoonUrl = new ArrayList<>();

    /**
     * 获取卡通的名字实体类
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<String> getNames() {
        cartoonNames.clear();

        cartoonNames.add("101忠狗");
        cartoonNames.add("狡猾飞天德");
        cartoonNames.add("阿拉丁");
        cartoonNames.add("彭彭丁满历险记");
        cartoonNames.add("波波安");
        cartoonNames.add("大力士海格力斯");
        cartoonNames.add("下课后");
        cartoonNames.add("水獭小宝贝");
        cartoonNames.add("泰山");
        cartoonNames.add("火星鼠骑士");
        return cartoonNames;
    }
    /**
     * 获取卡通的百度百科地址
     *
     * @param ，
     * @return List<String> 描述的集合
     * @date 2019-01-07
     */
    public static List<String> getCartoonUrl() {
        cartoonUrl.clear();

        cartoonUrl.add("https://baike.baidu.com/item/101%E5%BF%A0%E7%8B%97/12799418?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E9%A3%9E%E5%A4%A9%E5%BE%B7/2750632?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E9%98%BF%E6%8B%89%E4%B8%81/31155?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E5%BD%AD%E5%BD%AD%E4%B8%81%E6%BB%A1%E5%8E%86%E9%99%A9%E8%AE%B0/777821?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E6%B3%A2%E6%B3%A2%E5%AE%89/2306530?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E5%A4%A7%E5%8A%9B%E5%A3%AB%E6%B5%B7%E6%A0%BC%E5%8A%9B%E6%96%AF/1635330?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E4%B8%8B%E8%AF%BE%E5%90%8E/5130268?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E6%B0%B4%E7%8D%AD%E5%B0%8F%E5%AE%9D%E8%B4%9D/7126737?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E6%B3%B0%E5%B1%B1%E4%B8%8E%E7%8F%8D%E5%A6%AE/14847855?fr=aladdin");
        cartoonUrl.add("https://baike.baidu.com/item/%E7%81%AB%E6%98%9F%E9%BC%A0%E9%AA%91%E5%A3%AB/590345?fr=aladdin");
        return cartoonUrl;
    }



    /**
     * 卡通图片
     *
     * @param ,
     * @return List<Integer>
     * @date 2019-01-21
     */
    public static List<Integer> getCartoonImages() {
        cartoonImages.clear();

        cartoonImages.add(R.mipmap.dog);
        cartoonImages.add(R.mipmap.feitiande);
        cartoonImages.add(R.mipmap.alading);
        cartoonImages.add(R.mipmap.pengpengdingman);
        cartoonImages.add(R.mipmap.boboan);
        cartoonImages.add(R.mipmap.dalishi);
        cartoonImages.add(R.mipmap.xiakehou);
        cartoonImages.add(R.mipmap.shuita);
        cartoonImages.add(R.mipmap.taishan);
        cartoonImages.add(R.mipmap.huoxingshu);
        return cartoonImages;
    }


    /**
     * 卡通描述文字
     *
     * @param ,
     * @return void
     * @date 2019-04-11
     */
    public static List<String> getCartDesList() {
        cartoonDes.clear();
        cartoonDes.add("是美国迪士尼推出的第17部动画长片。该片由华特·迪士尼执导，由罗德·泰勒、汤姆·康威等参与配音演出。" +
                "该片于1961年1月25日在美国首映。");

        cartoonDes.add("飞天德是迪斯尼的一部动画长片的主角，片子叫《狡猾飞天德》诞生于1991年，飞天德是只侦探鸭子！最崇拜的" +
                "歌手是猫王。专门和犯罪分子作对——以耐歌德、快特杰克、耐歌沃特、泊斯容、钢嘴为代表的一系列犯罪分子！");

        cartoonDes.add("《一千零一夜》故事《阿拉丁神灯》中的主人公，这个名字因有众多近代的后续作品而闻名于世，如迪士尼出品的电影" +
                "《阿拉丁》，改编自故事原作，是迪士尼第一部推出续集影音产品首映的经典动画，获得奥斯卡最佳原著配乐奖等.");

        cartoonDes.add("《彭彭丁满历险记》又叫《彭彭和丁满历险记》是迪士尼公司出品的卡通电视节目，承续迪士尼传统精神，故事健康，" +
                "题材新颖，没有冠冕堂皇的说教，有的只是浅显易懂的寓教于乐，以及带给小朋友们欢笑与健康的心理，在潜移默化中，教导小" +
                "朋友处世待人的正确态度，适合全家一起观赏。");

        cartoonDes.add("波波安，女，迪斯尼卡通《波波安》女主角。作为一个喜欢幻想又做事冲动的新新人类，“超酷女孩”波波安的生活" +
                "里总是充满了麻烦与乐趣，在与亲朋好友朝夕相处的美妙时光里，通过一连串新奇搞笑的滑稽经历，她真正体会到了成长的真谛。" +
                "");

        cartoonDes.add("故事主要讲述宙斯的儿子海格力斯如何成为超级英雄，该片曾获得第24届美国电影电视土星奖，" +
                "主题曲“Go the Distance”曾获得奥斯卡最佳歌曲提名。");

        cartoonDes.add("《下课后》是迪士尼频道1997年推出的一部卡通影集，在这部影集中，我们可以看到他们千奇百怪的" +
                "下课後生活。如今他们这一干好友也要登上大银幕了！本片是叙述当一个学年结束了，即将要开始漫长的暑假！");

        cartoonDes.add("描写三只傍湖而居、活泼可爱的小水獭，利用他们纯真自然、腾云驾雾的想象力，创造出超越时空的大冒险" +
                "。三只小水獭花生、果酱和奶油，将在全新内容的『水獭小宝贝』里带来更别出心裁、更可爱有趣的精彩故事。");

        cartoonDes.add("内容叙述 Tarzan和Jane在丛林中结婚一周年庆纪念日将近，Jane想要给Tarzan一个特别的惊喜，" +
                "他们的动物好友Terk和Tantor以及Jane 的爸爸，也都先后来参与帮忙Jane想点子。当Jane想举办宴会，" +
                "却回想起曾经有一次她的姊妹淘好友来访的一段故事");

        cartoonDes.add("传说火星上居住着一种类似地球上的老鼠一样但是体型与人相当的生物.他们在火星上和平居住,繁衍生息,过着无" +
                "忧无虑的生活.突然有一天,远在另一个星系的普鲁塔星人在耗尽了他们自己的能源之后,侵略火星,掠夺火星上的资源,用飞船" +
                "运回普鲁塔星.火星鼠们奋起抵抗,但是他们的力量无法阻挡普鲁塔星人的攻势.他们的三个勇猛战士斯罗特,莫多和维尼被普" +
                "鲁塔星人抓走.这一天,斯罗特等三人躲过普鲁塔星人的监视,抢了一艘飞船赶回火星,可是在途中遇到了普鲁塔星人的巡逻飞船," +
                "在双方交火中火星鼠的飞船不幸被打中,只好改变航向,降落在地球上");

        return cartoonDes;
    }

}
