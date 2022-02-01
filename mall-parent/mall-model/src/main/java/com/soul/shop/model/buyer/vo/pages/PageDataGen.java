package com.soul.shop.model.buyer.vo.pages;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PageDataGen {

    public static void main(String[] args) {
        //构建 首页装修数据
        TopAdvert topAdvert = new TopAdvert();
        topAdvert.setBgColor("#377CFA");
        topAdvert.setImg("https://static.mszlu.com/mall/9fc491bd51484690a405ce0fab1bb118.jpeg");
        topAdvert.setSize("1200*80");
        topAdvert.setType("topAdvert");
        topAdvert.setUrl("/merchant?id=1376369067769724928");

        System.out.println(JSON.toJSONString(topAdvert));
        NavBar navBar = new NavBar();
        navBar.setType("navBar");
        List<NavBarData> navBarData = new ArrayList<>();
        navBarData.add(new NavBarData("秒杀","/seckill"));
        navBarData.add(new NavBarData("优惠券","/coupon"));
        navBar.setList(navBarData);
        System.out.println(JSON.toJSONString(navBar));

        Carousel carousel = new Carousel();
        carousel.setIcon("md-image");
        carousel.setShowName("");
        carousel.setName("图片轮播");
        carousel.setSize("790*340");
        carousel.setType("carousel");
        CarouselOption carouselOption = new CarouselOption();
        ImageData carouselData = new ImageData();
        carouselData.setImg("https://static.mszlu.com/mall/fda3ca6646a6401b9c4cc664af3a8bb6.png");
        carouselData.setUrl("/goodsList?cateId=1348576427264204943");
        ImageData carouselData1 = new ImageData();
        carouselData1.setImg("https://static.mszlu.com/mall/885ba98892d048049c158296bc4c6759.png");
        carouselData1.setUrl("/goodsList?cateId=1348576427268399379");
        ImageData carouselData2 = new ImageData();
        carouselData2.setImg("https://static.mszlu.com/mall/8e33ab68ef734558bdc158d6b1b1451f.png");
        carouselData2.setUrl("/goodsList?cateId=1348576427264204982");
        List<ImageData> carouselDataList = new ArrayList<>();
        carouselDataList.add(carouselData);
        carouselDataList.add(carouselData1);
        carouselDataList.add(carouselData2);
        carouselOption.setList(carouselDataList);
        carousel.setOptions(carouselOption);
        //唯一标识
        carousel.setKey("1612497034000_84734");
        System.out.println(JSON.toJSONString(carousel));

        DiscountAdvert discountAdvert = new DiscountAdvert();
        discountAdvert.setIcon("md-image");
        discountAdvert.setName("折扣广告");
        discountAdvert.setKey("1612497041000_99064");
        discountAdvert.setType("discountAdvert");
        DiscountAdvertOption discountAdvertOption = new DiscountAdvertOption();
        ImageData imageData = new ImageData();
        imageData.setImg("https://static.mszlu.com/mall/1516301201726549362.png");
        imageData.setUrl("");
        imageData.setSize("1300*586");
        discountAdvertOption.setBgImg(imageData);
        List<ImageData> classification = new ArrayList<>();
        ImageData imageData1 = new ImageData();
        imageData1.setImg("https://static.mszlu.com/mall/8faa5a052b304a19b14f925455305d17.png");
        imageData1.setUrl("/goodsDetail?id=1354319273359335424");
        imageData1.setSize("190*210");
        ImageData imageData2 = new ImageData();
        imageData2.setImg("https://static.mszlu.com/mall/d64d48fa56b340f59bd3064aa8d4bdca.png");
        imageData2.setUrl("/goodsDetail?skuId=1376845635973545984&goodsId=1376845635923214336");
        imageData2.setSize("190*210");
        ImageData imageData3 = new ImageData();
        imageData3.setImg("https://static.mszlu.com/mall/51fc954e0f0f4feda97611a2fecc0ad1.png");
        imageData3.setUrl("/goodsDetail?skuId=1376544591066431488&goodsId=1376544590403731456");
        imageData3.setSize("190*210");
        ImageData imageData4 = new ImageData();
        imageData4.setImg("https://static.mszlu.com/mall/fde5349e6b4c438d884ee36ae8c97096.png");
        imageData4.setUrl("/goodsDetail?skuId=1376554436532371456&goodsId=1376554435945168896");
        imageData4.setSize("190*210");
        ImageData imageData5 = new ImageData();
        imageData5.setImg("https://static.mszlu.com/mall/d64d48fa56b340f59bd3064aa8d4bdca.png");
        imageData5.setUrl("/goodsDetail?skuId=1376556775628603392&goodsId=1376556775007846400");
        imageData5.setSize("190*210");
        ImageData imageData6 = new ImageData();
        imageData6.setImg("https://static.mszlu.com/mall/5259dbfb17fd482894021b86140d2871.png");
        imageData6.setUrl("/goodsDetail?skuId=1381792993853308928&goodsId=1377083477941288960");
        imageData6.setSize("190*210");
        ImageData imageData7 = new ImageData();
        imageData7.setImg("https://static.mszlu.com/mall/a9593607de404546953055f279fd5d54.png");
        imageData7.setUrl("/goodsDetail?skuId=1381793060458856448&goodsId=1377085464581767168");
        imageData7.setSize("190*210");
        ImageData imageData8 = new ImageData();
        imageData8.setImg("https://static.mszlu.com/mall/d53cbd59ce3a4efd8c3c8f476c91f3e9.png");
        imageData8.setUrl("/goodsDetail?skuId=1381791842919514112&goodsId=1376443041593688064");
        imageData8.setSize("190*210");
        ImageData imageData9 = new ImageData();
        imageData9.setImg("https://static.mszlu.com/mall/b95573e65d2b4ffa8e7ed96d94da37c9.png");
        imageData9.setUrl("/goodsDetail?skuId=1381792775162298368&goodsId=1377077664103268352");
        imageData9.setSize("190*210");
        ImageData imageData10 = new ImageData();
        imageData10.setImg("https://static.mszlu.com/mall/6a5182bc98a347a5926e3be24e55719f.png");
        imageData10.setUrl("/goodsDetail?skuId=1381793449228894208&goodsId=137709893411930112");
        imageData10.setSize("190*210");
        classification.add(imageData1);
        classification.add(imageData2);
        classification.add(imageData3);
        classification.add(imageData4);
        classification.add(imageData5);
        classification.add(imageData6);
        classification.add(imageData7);
        classification.add(imageData8);
        classification.add(imageData9);
        classification.add(imageData10);
        discountAdvertOption.setClassification(classification);

        ImageData imageDataBrand1 = new ImageData();
        imageDataBrand1.setImg("https://static.mszlu.com/mall/brand/905c55d7dc7044328314c94adfbe6051.png");
        imageDataBrand1.setUrl("");
        imageDataBrand1.setSize("240*105");
        ImageData imageDataBrand2 = new ImageData();
        imageDataBrand2.setImg("https://static.mszlu.com/mall/brand/de02941684f6423db05fe84ade7bbf35.png");
        imageDataBrand2.setUrl("");
        imageDataBrand2.setSize("240*105");
        ImageData imageDataBrand3 = new ImageData();
        imageDataBrand3.setImg("https://static.mszlu.com/mall/brand/9f6ad605ba4047db90109d45ab9265ca.png");
        imageDataBrand3.setUrl("");
        imageDataBrand3.setSize("240*105");
        ImageData imageDataBrand4 = new ImageData();
        imageDataBrand4.setImg("https://static.mszlu.com/mall/brand/0dd24fb3bc554158973a3deda5edfda5.png");
        imageDataBrand4.setUrl("");
        imageDataBrand4.setSize("240*105");
        List<ImageData> brandList = new ArrayList<>();
        brandList.add(imageDataBrand1);
        brandList.add(imageDataBrand2);
        brandList.add(imageDataBrand3);
        brandList.add(imageDataBrand4);
        discountAdvertOption.setBrandList(brandList);

        discountAdvert.setOptions(discountAdvertOption);
        System.out.println(JSON.toJSONString(discountAdvert));

        //imageView2/1/w/400/h/400/q/75

        PageRecommend pageRecommend = new PageRecommend();
        pageRecommend.setIcon("md-image");
        pageRecommend.setType("recommend");
        pageRecommend.setName("好货推荐");
        pageRecommend.setKey("1612497146000_38763");
        PageRecommendOption pageRecommendOption = new PageRecommendOption();
        PageContent left = new PageContent();
        left.setBgColor("#449dae");
        left.setTitle("发现好货");
        left.setSecondTitle("查看更多");
        left.setUrl("/goodsDetail?id=1346742995118743552");
        List<PageContentImageData> recommendImageDataList = new ArrayList<>();

        PageContentImageData recommendImageData1 = new PageContentImageData();
        recommendImageData1.setName("小米 (MI)Redmi K40 Pro 白色");
        recommendImageData1.setImg("https://static.mszlu.com/mall/b20243bc89a149a398b6d7ef9a097938.jpg?imageView2/1/w/400/h/400/q/75");
        recommendImageData1.setDescribe("也许是每一款经典系列都应该有一个独特的故事吧");
        recommendImageData1.setUrl("/goodsDetail?skuId=1376544591276146688&goodsId=1376544590403731456");
        recommendImageData1.setSize("160*160");
        recommendImageData1.setPrice(new BigDecimal(3999));

        PageContentImageData recommendImageData2 = new PageContentImageData();
        recommendImageData2.setName("一加 OnePlus 9  紫色");
        recommendImageData2.setImg("https://static.mszlu.com/mall/a4c2b5073fd84d60bfe38d6a6c0044c9.jpeg?imageView2/1/w/400/h/400/q/75");
        recommendImageData2.setDescribe("8GB+128GB 5G手机");
        recommendImageData2.setUrl("/goodsDetail?skuId=1376373278989352960&goodsId=1376373278360207360");
        recommendImageData2.setSize("80*80");
        recommendImageData2.setPrice(new BigDecimal(3799));

        PageContentImageData recommendImageData3 = new PageContentImageData();
        recommendImageData3.setName("一加 OnePlus 9  黑色");
        recommendImageData3.setImg("https://static.mszlu.com/mall/df6377650f94456087316c1c9a381952.jpeg?imageView2/1/w/400/h/400/q/75");
        recommendImageData3.setDescribe("8GB+128GB 5G手机");
        recommendImageData3.setUrl("/goodsDetail?skuId=1376373279131959296&goodsId=1376373278360207360");
        recommendImageData3.setSize("80*80");
        recommendImageData3.setPrice(new BigDecimal(3899));

        PageContentImageData recommendImageData4 = new PageContentImageData();
        recommendImageData4.setName("vivo iQOO 7 黑色");
        recommendImageData4.setImg("https://static.mszlu.com/mall/30b3030b9bb44e758146d8eca63a1242.jpeg?imageView2/1/w/400/h/400/q/75");
        recommendImageData4.setDescribe("UFS 3.1 双模5G全网通手机");
        recommendImageData4.setUrl("/goodsDetail?skuId=1376521744352804864&goodsId=1376521743522332672");
        recommendImageData4.setSize("80*80");
        recommendImageData4.setPrice(new BigDecimal(4198));

        PageContentImageData recommendImageData5 = new PageContentImageData();
        recommendImageData5.setName("vivo iQOO 7 白色");
        recommendImageData5.setImg("https://static.mszlu.com/mall/d86a06718d88422baf7422cb0d8b71db.jpeg?imageView2/1/w/400/h/400/q/75");
        recommendImageData5.setDescribe("UFS 3.1 双模5G全网通手机");
        recommendImageData5.setUrl("/goodsDetail?skuId=1376521744608657408&goodsId=1376521743522332672");
        recommendImageData5.setSize("80*80");
        recommendImageData5.setPrice(new BigDecimal(4298));

        PageContentImageData recommendImageData6 = new PageContentImageData();
        recommendImageData6.setName("Apple iPhone 12 黑色");
        recommendImageData6.setImg("https://static.mszlu.com/mall/b3dccb22364f42c9bec193d64f140abb.jpg?imageView2/1/w/400/h/400/q/75");
        recommendImageData6.setDescribe("移动联通电信5G全网通手机");
        recommendImageData6.setUrl("/goodsDetail?skuId=1376529926336806912&goodsId=1376529925690884096");
        recommendImageData6.setSize("80*80");
        recommendImageData6.setPrice(new BigDecimal(4200));

        PageContentImageData recommendImageData7 = new PageContentImageData();
        recommendImageData7.setName("Apple iPhone 12 白色");
        recommendImageData7.setImg("https://static.mszlu.com/mall/af4e8d5341b1433c8d23d44dbf9bf37f.jpg?imageView2/1/w/400/h/400/q/75");
        recommendImageData7.setDescribe("移动联通电信5G全网通手机");
        recommendImageData7.setUrl("/goodsDetail?skuId=1376529926533939200&goodsId=1376529925690884096");
        recommendImageData7.setSize("80*80");
        recommendImageData7.setPrice(new BigDecimal(4100));

        recommendImageDataList.add(recommendImageData1);
        recommendImageDataList.add(recommendImageData2);
        recommendImageDataList.add(recommendImageData3);
        recommendImageDataList.add(recommendImageData4);
        recommendImageDataList.add(recommendImageData5);
        recommendImageDataList.add(recommendImageData6);
        recommendImageDataList.add(recommendImageData7);
        left.setList(recommendImageDataList);
        pageRecommendOption.setContentLeft(left);

        PageContent right = new PageContent();
        right.setBgColor("#a25684");
        right.setTitle("特色推荐");
        right.setSecondTitle("查看更多");
        right.setUrl("/goodsDetail?skuId=1376541893952798720&goodsId=1376541893319458816");
        List<PageContentImageData> rightImageDataList = new ArrayList<>();

        PageContentImageData rightImageData1 = new PageContentImageData();
        rightImageData1.setName("佳能(Canon) EOS 200D II 2代数码单反相机 白色");
        rightImageData1.setImg("https://static.mszlu.com/mall/0544e5c117a348998d80061f7a900400.jpg?imageView2/1/w/400/h/400/q/75");
        rightImageData1.setDescribe("佳能(Canon) 2代数码单反相机");
        rightImageData1.setUrl("/goodsDetail?skuId=1376541893755666432&goodsId=1376541893319458816");
        rightImageData1.setSize("220*110");
        rightImageData1.setPrice(new BigDecimal(4449));

        PageContentImageData rightImageData2 = new PageContentImageData();
        rightImageData2.setName("荣耀Play4T Pro 黑色");
        rightImageData2.setImg("https://static.mszlu.com/mall/e58eae43b3784a1bb1bdf13937442e2d.jpg?imageView2/1/w/400/h/400/q/75");
        rightImageData2.setDescribe("骁龙865丨30W快充");
        rightImageData2.setUrl("/goodsDetail?skuId=1376547794663243776&goodsId=1376547793954406400");
        rightImageData2.setSize("220*110");
        rightImageData2.setPrice(new BigDecimal(2999));

        PageContentImageData rightImageData3 = new PageContentImageData();
        rightImageData3.setName("小米（MI）Redmi K30 至尊纪念版 绿色");
        rightImageData3.setImg("https://static.mszlu.com/mall/745f6ef25634428a8b1972ce23c9c7b3.jpg?imageView2/1/w/400/h/400/q/75");
        rightImageData3.setDescribe("小米（MI）至尊纪念版");
        rightImageData3.setUrl("/goodsDetail?skuId=1376554436532371456&goodsId=1376554435945168896");
        rightImageData3.setSize("220*110");
        rightImageData3.setPrice(new BigDecimal(3000));

        PageContentImageData rightImageData4 = new PageContentImageData();
        rightImageData4.setName("魅族12 白色");
        rightImageData4.setImg("https://static.mszlu.com/mall/5fc6e64e189c4c378e72757af663ff3a.png?imageView2/1/w/400/h/400/q/75");
        rightImageData4.setDescribe("2K四曲微弧屏丨4400W前摄光学防抖");
        rightImageData4.setUrl("/goodsDetail?skuId=1376559979762286592&goodsId=1376559979007311872");
        rightImageData4.setSize("220*110");
        rightImageData4.setPrice(new BigDecimal(4999));

        rightImageDataList.add(rightImageData1);
        rightImageDataList.add(rightImageData2);
        rightImageDataList.add(rightImageData3);
        rightImageDataList.add(rightImageData4);
        right.setList(rightImageDataList);
        pageRecommendOption.setContentRight(right);

        pageRecommend.setOptions(pageRecommendOption);
        System.out.println(JSON.toJSONString(pageRecommend));

        NewGoodsSort newGoodsSort = new NewGoodsSort();
        newGoodsSort.setIcon("md-image");
        newGoodsSort.setName("新品排行");
        newGoodsSort.setKey("1612497051000_82856");
        newGoodsSort.setType("newGoodsSort");
        NewGoodsSortOption newGoodsSortOption = new NewGoodsSortOption();

        PageContent leftPageContent = new PageContent();
        leftPageContent.setBgColor("#c43d7e");
        leftPageContent.setTitle("特卖");
        leftPageContent.setSecondTitle("更多");
        leftPageContent.setUrl("/goodsDetail?id=1346742995596894208");
        List<PageContentImageData> leftPageContentImages = new ArrayList<>();

        PageContentImageData leftPageContentImageData1 = new PageContentImageData();
        leftPageContentImageData1.setName("小米（MI）Redmi K30 至尊纪念版 白色");
        leftPageContentImageData1.setDescribe("满269减50,满999减100");
        leftPageContentImageData1.setImg("https://static.mszlu.com/mall/6fed4b19c53c4b88a5123301dede09c9.jpg?imageView2/1/w/400/h/400/q/75");
        leftPageContentImageData1.setUrl("/goodsDetail?skuId=1376554436721115136&goodsId=1376554435945168896");
        leftPageContentImageData1.setPrice(new BigDecimal(4000));
        leftPageContentImageData1.setSize("160*160");

        PageContentImageData leftPageContentImageData2 = new PageContentImageData();
        leftPageContentImageData2.setName("红气垫 阿玛尼");
        leftPageContentImageData2.setDescribe("轻透精华气垫粉底液");
        leftPageContentImageData2.setImg("https://static.mszlu.com/mall/7896c015be3f4418a99e6ca2efcae386.jpg?imageView2/1/w/400/h/400/q/75");
        leftPageContentImageData2.setUrl("/goodsDetail?skuId=1381796259035086848&goodsId=1377122967070179328");
        leftPageContentImageData2.setPrice(new BigDecimal(400));
        leftPageContentImageData2.setSize("90*90");

        PageContentImageData leftPageContentImageData3 = new PageContentImageData();
        leftPageContentImageData3.setName("MAXFACTOR 蜜丝佛陀");
        leftPageContentImageData3.setDescribe("三合一粉底液");
        leftPageContentImageData3.setImg("https://static.mszlu.com/mall/75b2a1a1f4d74470a9da19158ff805ac.jpg?imageView2/1/w/400/h/400/q/75");
        leftPageContentImageData3.setUrl("/goodsDetail?skuId=1381796144429924352&goodsId=1377121719424122880");
        leftPageContentImageData3.setPrice(new BigDecimal(333));
        leftPageContentImageData3.setSize("90*90");

        PageContentImageData leftPageContentImageData4 = new PageContentImageData();
        leftPageContentImageData4.setName("ARMANI阿玛尼");
        leftPageContentImageData4.setDescribe("紧颜粉底液 03");
        leftPageContentImageData4.setImg("https://static.mszlu.com/mall/389b2ce90fd0425a8a9d988890ad46d2.jpg?imageView2/1/w/400/h/400/q/75");
        leftPageContentImageData4.setUrl("/goodsDetail?skuId=1381789991541145600&goodsId=1377127936569638912");
        leftPageContentImageData4.setPrice(new BigDecimal(666));
        leftPageContentImageData4.setSize("90*90");

        PageContentImageData leftPageContentImageData5 = new PageContentImageData();
        leftPageContentImageData5.setName("NYX 焕彩16色眼影盘");
        leftPageContentImageData5.setDescribe("大地色");
        leftPageContentImageData5.setImg("https://static.mszlu.com/mall/53b1c3cc1f1d4085917c282179f3e2fa.jpg?imageView2/1/w/400/h/400/q/75");
        leftPageContentImageData5.setUrl("/goodsDetail?skuId=1377137907063586816&goodsId=1377137906799345664");
        leftPageContentImageData5.setPrice(new BigDecimal(100));
        leftPageContentImageData5.setSize("90*90");

        leftPageContentImages.add(leftPageContentImageData1);
        leftPageContentImages.add(leftPageContentImageData2);
        leftPageContentImages.add(leftPageContentImageData3);
        leftPageContentImages.add(leftPageContentImageData4);
        leftPageContentImages.add(leftPageContentImageData5);
        leftPageContent.setList(leftPageContentImages);
        newGoodsSortOption.setLeft(leftPageContent);

        PageContent rightPageContent = new PageContent();
        rightPageContent.setBgColor("#b62323");
        rightPageContent.setTitle("排行榜");
        rightPageContent.setSecondTitle("精品风向标");
        rightPageContent.setUrl("");
        List<PageContentImageData> rightPageContentImages = new ArrayList<>();

        PageContentImageData rightPageContentImageData1 = new PageContentImageData();
        rightPageContentImageData1.setName("小米 (MI)Redmi K40 Pro 黑色");
        rightPageContentImageData1.setImg("https://static.mszlu.com/mall/9064c20d62f24bfaa5d3854f72a83c6c.jpg?imageView2/1/w/400/h/400/q/75");
        rightPageContentImageData1.setUrl("/goodsDetail?skuId=1376544591066431488&goodsId=1376544590403731456");
        rightPageContentImageData1.setPrice(new BigDecimal(2999));

        PageContentImageData rightPageContentImageData2 = new PageContentImageData();
        rightPageContentImageData2.setName("一加 OnePlus 9  黑色");
        rightPageContentImageData2.setImg("https://static.mszlu.com/mall/df6377650f94456087316c1c9a381952.jpeg?imageView2/1/w/400/h/400/q/75");
        rightPageContentImageData2.setUrl("/goodsDetail?skuId=1376373279131959296&goodsId=1376373278360207360");
        rightPageContentImageData2.setPrice(new BigDecimal(3899));

        PageContentImageData rightPageContentImageData3 = new PageContentImageData();
        rightPageContentImageData3.setName("一加 OnePlus 9 紫色");
        rightPageContentImageData3.setImg("https://static.mszlu.com/mall/cc724307f056420eb14c5bd35608a024.jpg?imageView2/1/w/400/h/400/q/75");
        rightPageContentImageData3.setUrl("/goodsDetail?skuId=1376556775628603392&goodsId=1376556775007846400");
        rightPageContentImageData3.setPrice(new BigDecimal(5000));

        PageContentImageData rightPageContentImageData4 = new PageContentImageData();
        rightPageContentImageData4.setName("Apple iPhone 12 白色");
        rightPageContentImageData4.setImg("https://static.mszlu.com/mall/af4e8d5341b1433c8d23d44dbf9bf37f.jpg?imageView2/1/w/400/h/400/q/75");
        rightPageContentImageData4.setUrl("/goodsDetail?skuId=1376529926533939200&goodsId=1376529925690884096");
        rightPageContentImageData4.setPrice(new BigDecimal(4100));

        PageContentImageData rightPageContentImageData5 = new PageContentImageData();
        rightPageContentImageData5.setName("荣耀Play4T Pro 黑色");
        rightPageContentImageData5.setImg("https://static.mszlu.com/mall/e58eae43b3784a1bb1bdf13937442e2d.jpg?imageView2/1/w/400/h/400/q/75");
        rightPageContentImageData5.setUrl("/goodsDetail?skuId=1376547794663243776&goodsId=1376547793954406400");
        rightPageContentImageData5.setPrice(new BigDecimal(2999));

        PageContentImageData rightPageContentImageData6 = new PageContentImageData();
        rightPageContentImageData6.setName("魅族12 蓝色");
        rightPageContentImageData6.setImg("https://static.mszlu.com/mall/9ebe5bdb79c840ed9619b4fc72de21a9.png?imageView2/1/w/400/h/400/q/75");
        rightPageContentImageData6.setUrl("/goodsDetail?skuId=1376559979577737216&goodsId=1376559979007311872");
        rightPageContentImageData6.setPrice(new BigDecimal(3999));

        rightPageContentImages.add(rightPageContentImageData1);
        rightPageContentImages.add(rightPageContentImageData2);
        rightPageContentImages.add(rightPageContentImageData3);
        rightPageContentImages.add(rightPageContentImageData4);
        rightPageContentImages.add(rightPageContentImageData5);
        rightPageContentImages.add(rightPageContentImageData6);
        rightPageContent.setList(rightPageContentImages);

        PageContent middlePageContent = new PageContent();
        middlePageContent.setBgColor("#e66a07");
        middlePageContent.setTitle("新品");
        middlePageContent.setSecondTitle("更多新品");
        middlePageContent.setUrl("");
        List<PageContentImageData> middlePageContentImages = new ArrayList<>();

        PageContentImageData middlePageContentImageData1 = new PageContentImageData();
        middlePageContentImageData1.setName("母亲原味牛肉棒");
        middlePageContentImageData1.setDescribe("烧烤味");
        middlePageContentImageData1.setImg("https://static.mszlu.com/mall/c9cbc345f3014affbb09a80306303c7c.jpg?imageView2/1/w/400/h/400/q/75");
        middlePageContentImageData1.setUrl("/goodsDetail?skuId=1381793449233088512&goodsId=1377098934119301120");
        middlePageContentImageData1.setPrice(new BigDecimal(8));
        middlePageContentImageData1.setSize("90*90");

        PageContentImageData middlePageContentImageData2 = new PageContentImageData();
        middlePageContentImageData2.setName("百草味 原味芒果干");
        middlePageContentImageData2.setDescribe("原味");
        middlePageContentImageData2.setImg("https://static.mszlu.com/mall/54dcb9cd0fea4f1f8243e12d49c28af9.png?imageView2/1/w/400/h/400/q/75");
        middlePageContentImageData2.setUrl("/goodsDetail?skuId=1381791842915319808&goodsId=1376443041593688064");
        middlePageContentImageData2.setPrice(new BigDecimal(15));
        middlePageContentImageData2.setSize("90*90");

        PageContentImageData middlePageContentImageData3 = new PageContentImageData();
        middlePageContentImageData3.setName("YSL 圣罗兰");
        middlePageContentImageData3.setDescribe("清新花果香");
        middlePageContentImageData3.setImg("https://static.mszlu.com/mall/31731869956848be8fc34f6751136977.jpg?imageView2/1/w/400/h/400/q/75");
        middlePageContentImageData3.setUrl("/goodsDetail?skuId=1381796591895052288&goodsId=1377145942322446336");
        middlePageContentImageData3.setPrice(new BigDecimal(886));
        middlePageContentImageData3.setSize("90*90");

        PageContentImageData middlePageContentImageData4 = new PageContentImageData();
        middlePageContentImageData4.setName("雀巢(Nestle) 威化饼干");
        middlePageContentImageData4.setDescribe("牛奶味");
        middlePageContentImageData4.setImg("https://static.mszlu.com/mall/fe5b8167b0264c53836d08a6a7003cf0.jpeg?imageView2/1/w/400/h/400/q/75");
        middlePageContentImageData4.setUrl("/goodsDetail?skuId=1381797095073120256&goodsId=1377805575856848896");
        middlePageContentImageData4.setPrice(new BigDecimal(9.9));
        middlePageContentImageData4.setSize("90*90");

        PageContentImageData middlePageContentImageData5 = new PageContentImageData();
        middlePageContentImageData5.setName("夏威夷果 百草味");
        middlePageContentImageData5.setDescribe("坚果");
        middlePageContentImageData5.setImg("https://static.mszlu.com/mall/999746fb087a40a280c2ef2c5abb7cc3.jpg?imageView2/1/w/400/h/400/q/75");
        middlePageContentImageData5.setUrl("/goodsDetail?skuId=1381792548812488704&goodsId=1377071458592751616");
        middlePageContentImageData5.setPrice(new BigDecimal(37));
        middlePageContentImageData5.setSize("90*90");

        PageContentImageData middlePageContentImageData6 = new PageContentImageData();
        middlePageContentImageData6.setName("范思哲VERSACE");
        middlePageContentImageData6.setDescribe("清新水果香");
        middlePageContentImageData6.setImg("https://static.mszlu.com/mall/9b04d1580fb84e67939392a65b9d708d.jpg?imageView2/1/w/400/h/400/q/75");
        middlePageContentImageData6.setUrl("/goodsDetail?skuId=1381796537792724992&goodsId=1377143657961881600");
        middlePageContentImageData6.setPrice(new BigDecimal(199));
        middlePageContentImageData6.setSize("90*90");

        middlePageContentImages.add(middlePageContentImageData1);
        middlePageContentImages.add(middlePageContentImageData2);
        middlePageContentImages.add(middlePageContentImageData3);
        middlePageContentImages.add(middlePageContentImageData4);
        middlePageContentImages.add(middlePageContentImageData5);
        middlePageContentImages.add(middlePageContentImageData6);
        middlePageContent.setList(middlePageContentImages);

        newGoodsSortOption.setLeft(leftPageContent);
        newGoodsSortOption.setMiddle(middlePageContent);
        newGoodsSortOption.setRight(rightPageContent);

        newGoodsSort.setOptions(newGoodsSortOption);
        System.out.println(JSON.toJSONString(newGoodsSort));

        FirstAdvert firstAdvert = new FirstAdvert();
        firstAdvert.setIcon("md-image");
        firstAdvert.setKey("1612497063000_39466");
        firstAdvert.setName("首页广告");
        firstAdvert.setType("firstAdvert");
        FirstAdvertOption firstAdvertOption = new FirstAdvertOption();
        List<DetailImageData> detailImageDataList = new ArrayList<>();

        DetailImageData detailImageData1 = new DetailImageData();
        detailImageData1.setName("爆款直降");
        detailImageData1.setDescribe("爆款最高直降1000元");
        detailImageData1.setUrl("/goodsDetail?id=1351420391981867008");
        detailImageData1.setFromColor("#e89621");
        detailImageData1.setToColor("#f5c568");
        detailImageData1.setSize("170*170");
        detailImageData1.setImg("https://static.mszlu.com/mall/24e82e04abb3430399a888e845f74a54.png");

        DetailImageData detailImageData2 = new DetailImageData();
        detailImageData2.setName("休闲零食");
        detailImageData2.setDescribe("小嘴停不住");
        detailImageData2.setUrl("");
        detailImageData2.setFromColor("#325bb4");
        detailImageData2.setToColor("#4c9afe");
        detailImageData2.setSize("170*170");
        detailImageData2.setImg("https://static.mszlu.com/mall/1bed3dd6c8f04397ae598b626391869b.png");

        DetailImageData detailImageData3 = new DetailImageData();
        detailImageData3.setName("潮流手机");
        detailImageData3.setDescribe("潮流好货无忧购");
        detailImageData3.setUrl("");
        detailImageData3.setFromColor("#1c9daf");
        detailImageData3.setToColor("#40cda7");
        detailImageData3.setSize("170*170");
        detailImageData3.setImg("https://static.mszlu.com/mall/8770b83f90c3409694d36f2ef9b559e4.png");

        DetailImageData detailImageData4 = new DetailImageData();
        detailImageData4.setName("新品好货");
        detailImageData4.setDescribe("新品好货送好礼");
        detailImageData4.setUrl("");
        detailImageData4.setFromColor("#d13837");
        detailImageData4.setToColor("#df6d4f");
        detailImageData4.setSize("170*170");
        detailImageData4.setImg("https://static.mszlu.com/mall/cf8665501b9e4856bb658c17014e35a2.png");

        DetailImageData detailImageData5 = new DetailImageData();
        detailImageData5.setName("码神生鲜");
        detailImageData5.setDescribe("年货带回家 满199减60");
        detailImageData5.setUrl("");
        detailImageData5.setFromColor("#ca4283");
        detailImageData5.setToColor("#eb75cf");
        detailImageData5.setSize("170*170");
        detailImageData5.setImg("https://static.mszlu.com/mall/1515953435885264617.png");

        DetailImageData detailImageData6 = new DetailImageData();
        detailImageData6.setName("码神众筹");
        detailImageData6.setDescribe("备孕有孕检测仪");
        detailImageData6.setUrl("");
        detailImageData6.setFromColor("#5d40c1");
        detailImageData6.setToColor("#8c5fdb");
        detailImageData6.setSize("170*170");
        detailImageData6.setImg("https://static.mszlu.com/mall/1515953436530337827.png");

        detailImageDataList.add(detailImageData1);
        detailImageDataList.add(detailImageData2);
        detailImageDataList.add(detailImageData3);
        detailImageDataList.add(detailImageData4);
        detailImageDataList.add(detailImageData5);
        detailImageDataList.add(detailImageData6);
        firstAdvertOption.setList(detailImageDataList);
        firstAdvert.setOptions(firstAdvertOption);

        System.out.println(JSON.toJSONString(firstAdvert));

        //------------
        NotEnough notEnough = new NotEnough();
        notEnough.setIcon("md-image");
        notEnough.setName("还没逛够");
        notEnough.setType("notEnough");
        notEnough.setKey("1612497066000_30831");
        NotEnoughOption notEnoughOption = new NotEnoughOption();
        List<List<PageContentImageData>> list = new ArrayList<>();

        List<PageContentImageData> pageContentImageDataList1 = new ArrayList<>();

        PageContentImageData pageContentImageData1 = new PageContentImageData();
        pageContentImageData1.setName("【保税发货】NYX 焕彩16色眼影盘 大地色");
        pageContentImageData1.setPrice(new BigDecimal(100));
        pageContentImageData1.setUrl("/goodsDetail?skuId=1377137907063586816&goodsId=1377137906799345664");
        pageContentImageData1.setImg("https://static.mszlu.com/mall/53b1c3cc1f1d4085917c282179f3e2fa.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData2 = new PageContentImageData();
        pageContentImageData2.setName("【保税发货】NYX 焕彩16色眼影盘 朱光色");
        pageContentImageData2.setPrice(new BigDecimal(100));
        pageContentImageData2.setUrl("/goodsDetail?skuId=1377137907063586817&goodsId=1377137906799345664");
        pageContentImageData2.setImg("https://static.mszlu.com/mall/3e7cdac8739c4d338fb0afb770cf5495.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData3 = new PageContentImageData();
        pageContentImageData3.setName("ARMANI阿玛尼 新款蓝标大·师 造型紧颜粉底液 03");
        pageContentImageData3.setPrice(new BigDecimal(666));
        pageContentImageData3.setUrl("/goodsDetail?skuId=1381789991541145600&goodsId=1377127936569638912");
        pageContentImageData3.setImg("https://static.mszlu.com/mall/389b2ce90fd0425a8a9d988890ad46d2.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData4 = new PageContentImageData();
        pageContentImageData4.setName("欧莱雅复颜视黄醇精粹抗皱护肤套装 水");
        pageContentImageData4.setPrice(new BigDecimal(299));
        pageContentImageData4.setUrl("/goodsDetail?skuId=1381793547266555904&goodsId=1377102418646401024");
        pageContentImageData4.setImg("https://static.mszlu.com/mall/0ebd7f52cb9641d4a0f2596c5e862c35.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData5 = new PageContentImageData();
        pageContentImageData5.setName("妮维雅(NIVEA)男士水活多效洁面乳 保湿");
        pageContentImageData5.setPrice(new BigDecimal(23));
        pageContentImageData5.setUrl("/goodsDetail?skuId=1381795951156396032&goodsId=1377104395929387008");
        pageContentImageData5.setImg("https://static.mszlu.com/mall/36e66e081a11449cbe03e9c2df884a9f.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData6 = new PageContentImageData();
        pageContentImageData6.setName("【新年礼】花西子x杜鹃定制东方佳人妆奁彩妆 礼物1");
        pageContentImageData6.setPrice(new BigDecimal(999));
        pageContentImageData6.setUrl("/goodsDetail?skuId=1381796022597976064&goodsId=1377106159533555712");
        pageContentImageData6.setImg("https://static.mszlu.com/mall/d1e7dcda155d454c8f7089298a9bcb82.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData7 = new PageContentImageData();
        pageContentImageData7.setName("雅诗兰黛（EsteeLauder） 持妆粉底液 01");
        pageContentImageData7.setPrice(new BigDecimal(333));
        pageContentImageData7.setUrl("/goodsDetail?skuId=1381796080479371264&goodsId=1377118965985181696");
        pageContentImageData7.setImg("https://static.mszlu.com/mall/432970f4d3d24692bd7b68299c260601.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData8 = new PageContentImageData();
        pageContentImageData8.setName("MAXFACTOR 蜜丝佛陀 三合一防晒粉底液  02");
        pageContentImageData8.setPrice(new BigDecimal(333));
        pageContentImageData8.setUrl("/goodsDetail?skuId=1381796144429924352&goodsId=1377121719424122880");
        pageContentImageData8.setImg("https://static.mszlu.com/mall/75b2a1a1f4d74470a9da19158ff805ac.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData9 = new PageContentImageData();
        pageContentImageData9.setName("粉色安琪sweetpink公主腮红礼盒 01");
        pageContentImageData9.setPrice(new BigDecimal(29));
        pageContentImageData9.setUrl("/goodsDetail?skuId=1381796202034495488&goodsId=1377129270085681152");
        pageContentImageData9.setImg("https://static.mszlu.com/mall/ba6efdfae1fe4493a6160ca86114845e.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData10 = new PageContentImageData();
        pageContentImageData10.setName("红气垫 Armani阿玛尼 轻透精华气垫粉底液 02");
        pageContentImageData10.setPrice(new BigDecimal(400));
        pageContentImageData10.setUrl("/goodsDetail?skuId=1381796259039281152&goodsId=1377122967070179328");
        pageContentImageData10.setImg("https://static.mszlu.com/mall/f4930e4df42c4d80af1ca2a2106e22ad.jpg?imageView2/1/w/400/h/400/q/75");

        pageContentImageDataList1.add(pageContentImageData1);
        pageContentImageDataList1.add(pageContentImageData2);
        pageContentImageDataList1.add(pageContentImageData3);
        pageContentImageDataList1.add(pageContentImageData4);
        pageContentImageDataList1.add(pageContentImageData5);
        pageContentImageDataList1.add(pageContentImageData6);
        pageContentImageDataList1.add(pageContentImageData7);
        pageContentImageDataList1.add(pageContentImageData8);
        pageContentImageDataList1.add(pageContentImageData9);
        pageContentImageDataList1.add(pageContentImageData10);

        list.add(pageContentImageDataList1);

        List<PageContentImageData> pageContentImageDataList2 = new ArrayList<>();

        PageContentImageData pageContentImageData21 = new PageContentImageData();
        pageContentImageData21.setName("一加 OnePlus 9  黑色");
        pageContentImageData21.setPrice(new BigDecimal(3899));
        pageContentImageData21.setUrl("/goodsDetail?skuId=1376373279131959296&goodsId=1376373278360207360");
        pageContentImageData21.setImg("https://static.mszlu.com/mall/df6377650f94456087316c1c9a381952.jpeg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData22 = new PageContentImageData();
        pageContentImageData22.setName("一加 OnePlus 9  紫色");
        pageContentImageData22.setPrice(new BigDecimal(3799));
        pageContentImageData22.setUrl("/goodsDetail?skuId=1376373278989352960&goodsId=1376373278360207360");
        pageContentImageData22.setImg("https://static.mszlu.com/mall/a4c2b5073fd84d60bfe38d6a6c0044c9.jpeg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData23 = new PageContentImageData();
        pageContentImageData23.setName("vivo iQOO 7 黑色");
        pageContentImageData23.setPrice(new BigDecimal(4198));
        pageContentImageData23.setUrl("/goodsDetail?skuId=1376521744352804864&goodsId=1376521743522332672");
        pageContentImageData23.setImg("https://static.mszlu.com/mall/30b3030b9bb44e758146d8eca63a1242.jpeg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData24 = new PageContentImageData();
        pageContentImageData24.setName("vivo iQOO 7 白色");
        pageContentImageData24.setPrice(new BigDecimal(4298));
        pageContentImageData24.setUrl("/goodsDetail?skuId=1376521744608657408&goodsId=1376521743522332672");
        pageContentImageData24.setImg("https://static.mszlu.com/mall/d86a06718d88422baf7422cb0d8b71db.jpeg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData25 = new PageContentImageData();
        pageContentImageData25.setName("Apple iPhone 12 黑色");
        pageContentImageData25.setPrice(new BigDecimal(4200));
        pageContentImageData25.setUrl("/goodsDetail?skuId=1376529926336806912&goodsId=1376529925690884096");
        pageContentImageData25.setImg("https://static.mszlu.com/mall/b3dccb22364f42c9bec193d64f140abb.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData26 = new PageContentImageData();
        pageContentImageData26.setName("Apple iPhone 12 白色");
        pageContentImageData26.setPrice(new BigDecimal(4100));
        pageContentImageData26.setUrl("/goodsDetail?skuId=1376529926533939200&goodsId=1376529925690884096");
        pageContentImageData26.setImg("https://static.mszlu.com/mall/af4e8d5341b1433c8d23d44dbf9bf37f.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData27 = new PageContentImageData();
        pageContentImageData27.setName("佳能(Canon) EOS 200D II 2代数码单反相机 白色");
        pageContentImageData27.setPrice(new BigDecimal(4449));
        pageContentImageData27.setUrl("/goodsDetail?skuId=1376541893755666432&goodsId=1376541893319458816");
        pageContentImageData27.setImg("https://static.mszlu.com/mall/0544e5c117a348998d80061f7a900400.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData28 = new PageContentImageData();
        pageContentImageData28.setName("佳能(Canon) EOS 200D II 2代数码单反相机 黑色");
        pageContentImageData28.setPrice(new BigDecimal(4458));
        pageContentImageData28.setUrl("/goodsDetail?skuId=1376541893952798720&goodsId=1376541893319458816");
        pageContentImageData28.setImg("https://static.mszlu.com/mall/299785007b884e6a823c212c839e092c.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData29 = new PageContentImageData();
        pageContentImageData29.setName("小米 (MI)Redmi K40 Pro 黑色");
        pageContentImageData29.setPrice(new BigDecimal(2999));
        pageContentImageData29.setUrl("/goodsDetail?skuId=1376544591066431488&goodsId=1376544590403731456");
        pageContentImageData29.setImg("https://static.mszlu.com/mall/9064c20d62f24bfaa5d3854f72a83c6c.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData210 = new PageContentImageData();
        pageContentImageData210.setName("小米 (MI)Redmi K40 Pro 白色");
        pageContentImageData210.setPrice(new BigDecimal(3999));
        pageContentImageData210.setUrl("/goodsDetail?skuId=1376544591276146688&goodsId=1376544590403731456");
        pageContentImageData210.setImg("https://static.mszlu.com/mall/b20243bc89a149a398b6d7ef9a097938.jpg?imageView2/1/w/400/h/400/q/75");

        pageContentImageDataList2.add(pageContentImageData21);
        pageContentImageDataList2.add(pageContentImageData22);
        pageContentImageDataList2.add(pageContentImageData23);
        pageContentImageDataList2.add(pageContentImageData24);
        pageContentImageDataList2.add(pageContentImageData25);
        pageContentImageDataList2.add(pageContentImageData26);
        pageContentImageDataList2.add(pageContentImageData27);
        pageContentImageDataList2.add(pageContentImageData28);
        pageContentImageDataList2.add(pageContentImageData29);
        pageContentImageDataList2.add(pageContentImageData210);
        list.add(pageContentImageDataList2);

        List<PageContentImageData> pageContentImageDataList3 = new ArrayList<>();

        PageContentImageData pageContentImageData31 = new PageContentImageData();
        pageContentImageData31.setName("荣耀Play4T Pro 黑色");
        pageContentImageData31.setPrice(new BigDecimal(2999));
        pageContentImageData31.setUrl("/goodsDetail?skuId=1376547794663243776&goodsId=1376547793954406400");
        pageContentImageData31.setImg("https://static.mszlu.com/mall/e58eae43b3784a1bb1bdf13937442e2d.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData32 = new PageContentImageData();
        pageContentImageData32.setName("荣耀Play4T Pro 绿色");
        pageContentImageData32.setPrice(new BigDecimal(2999));
        pageContentImageData32.setUrl("/goodsDetail?skuId=1376547794856181760&goodsId=1376547793954406400");
        pageContentImageData32.setImg("https://static.mszlu.com/mall/a91ea16401974fc29364c8be9ca76e83.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData33 = new PageContentImageData();
        pageContentImageData33.setName("小米（MI）Redmi K30 至尊纪念版 绿色");
        pageContentImageData33.setPrice(new BigDecimal(3000));
        pageContentImageData33.setUrl("/goodsDetail?skuId=1376554436532371456&goodsId=1376554435945168896");
        pageContentImageData33.setImg("https://static.mszlu.com/mall/745f6ef25634428a8b1972ce23c9c7b3.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData34 = new PageContentImageData();
        pageContentImageData34.setName("小米（MI）Redmi K30 至尊纪念版 白色");
        pageContentImageData34.setPrice(new BigDecimal(4000));
        pageContentImageData34.setUrl("/goodsDetail?skuId=1376554436721115136&goodsId=1376554435945168896");
        pageContentImageData34.setImg("https://static.mszlu.com/mall/6fed4b19c53c4b88a5123301dede09c9.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData35 = new PageContentImageData();
        pageContentImageData35.setName("一加 OnePlus 9 紫色");
        pageContentImageData35.setPrice(new BigDecimal(5000));
        pageContentImageData35.setUrl("/goodsDetail?skuId=1376556775628603392&goodsId=1376556775007846400");
        pageContentImageData35.setImg("https://static.mszlu.com/mall/cc724307f056420eb14c5bd35608a024.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData36 = new PageContentImageData();
        pageContentImageData36.setName("一加 OnePlus 9 蓝色");
        pageContentImageData36.setPrice(new BigDecimal(5000));
        pageContentImageData36.setUrl("/goodsDetail?skuId=1376556775825735680&goodsId=1376556775007846400");
        pageContentImageData36.setImg("https://static.mszlu.com/mall/7a90d38c4a9f4c8f84f10e53bc204b84.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData37 = new PageContentImageData();
        pageContentImageData37.setName("魅族12 蓝色");
        pageContentImageData37.setPrice(new BigDecimal(3999));
        pageContentImageData37.setUrl("/goodsDetail?skuId=1376559979577737216&goodsId=1376559979007311872");
        pageContentImageData37.setImg("https://static.mszlu.com/mall/9ebe5bdb79c840ed9619b4fc72de21a9.png?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData38 = new PageContentImageData();
        pageContentImageData38.setName("魅族12 白色");
        pageContentImageData38.setPrice(new BigDecimal(4999));
        pageContentImageData38.setUrl("/goodsDetail?skuId=1376559979762286592&goodsId=1376559979007311872");
        pageContentImageData38.setImg("https://static.mszlu.com/mall/5fc6e64e189c4c378e72757af663ff3a.png?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData39 = new PageContentImageData();
        pageContentImageData39.setName("华为笔记本MateBook  银色");
        pageContentImageData39.setPrice(new BigDecimal(2999));
        pageContentImageData39.setUrl("/goodsDetail?skuId=1376727108025319424&goodsId=1376727107777855488");
        pageContentImageData39.setImg("https://static.mszlu.com/mall/230413f3a04b4dfeb4797211a760f0ce.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData310 = new PageContentImageData();
        pageContentImageData310.setName("Apple/苹果 13 英寸：MacBook Pro Multi-Touch Bar 和 Touch ID 2.9GHz 处理器 512GB 存储容量");
        pageContentImageData310.setPrice(new BigDecimal(6666));
        pageContentImageData310.setUrl("");
        pageContentImageData310.setImg("https://static.mszlu.com/mall/0_thumb_G_1489096810833.jpg?imageView2/1/w/400/h/400/q/75");

        pageContentImageDataList3.add(pageContentImageData31);
        pageContentImageDataList3.add(pageContentImageData32);
        pageContentImageDataList3.add(pageContentImageData33);
        pageContentImageDataList3.add(pageContentImageData34);
        pageContentImageDataList3.add(pageContentImageData35);
        pageContentImageDataList3.add(pageContentImageData36);
        pageContentImageDataList3.add(pageContentImageData37);
        pageContentImageDataList3.add(pageContentImageData38);
        pageContentImageDataList3.add(pageContentImageData39);
        pageContentImageDataList3.add(pageContentImageData310);

        list.add(pageContentImageDataList3);

        List<PageContentImageData> pageContentImageDataList4 = new ArrayList<>();

        PageContentImageData pageContentImageData41 = new PageContentImageData();
        pageContentImageData41.setName("百草味 蜜饯 原味芒果干 一袋");
        pageContentImageData41.setPrice(new BigDecimal(15));
        pageContentImageData41.setUrl("/goodsDetail?skuId=1381791842915319808&goodsId=1376443041593688064");
        pageContentImageData41.setImg("https://static.mszlu.com/mall/54dcb9cd0fea4f1f8243e12d49c28af9.png?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData42 = new PageContentImageData();
        pageContentImageData42.setName("牛肉干 百草味");
        pageContentImageData42.setPrice(new BigDecimal(35));
        pageContentImageData42.setUrl("/goodsDetail?skuId=1381792695176921088&goodsId=1377074868700315648");
        pageContentImageData42.setImg("https://static.mszlu.com/mall/ce9a24a34bb34479b9239f07a9425746.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData43 = new PageContentImageData();
        pageContentImageData43.setName("奥利奥夹心饼干 原味");
        pageContentImageData43.setPrice(new BigDecimal(35));
        pageContentImageData43.setUrl("/goodsDetail?skuId=1381792775162298368&goodsId=1377077664103268352");
        pageContentImageData43.setImg("https://static.mszlu.com/mall/fced3eededaf4018a26af0ebd660238c.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData44 = new PageContentImageData();
        pageContentImageData44.setName("奥利奥夹心饼干 巧克力");
        pageContentImageData44.setPrice(new BigDecimal(35));
        pageContentImageData44.setUrl("/goodsDetail?skuId=1381792775162298368&goodsId=1377077664103268352");
        pageContentImageData44.setImg("https://static.mszlu.com/mall/58411207ec5946c7950be9d6eccd136c.jpg?imageView2/1/w/400/h/400/q/75");

        PageContentImageData pageContentImageData45 = new PageContentImageData();
        pageContentImageData45.setName("母亲原味牛肉棒22g 牛肉干特产肉类 麻辣");
        pageContentImageData45.setPrice(new BigDecimal(8));
        pageContentImageData45.setUrl("/goodsDetail?skuId=1381793449228894208&goodsId=1377098934119301120");
        pageContentImageData45.setImg("https://static.mszlu.com/mall/5b87f8d1439b4dd2b1bd7f9c331eb91b.jpg?imageView2/1/w/400/h/400/q/75");


        PageContentImageData pageContentImageData46 = new PageContentImageData();
        pageContentImageData46.setName("魔法士干脆面【整箱装-混合口味48袋】魔法师干吃方便面 麻辣牛排");
        pageContentImageData46.setPrice(new BigDecimal(2));
        pageContentImageData46.setUrl("/goodsDetail?skuId=1381793503364775936&goodsId=1377100803117940736");
        pageContentImageData46.setImg("https://static.mszlu.com/mall/028c7081275d4c1ea1c7aac206162c44.jpg?imageView2/1/w/400/h/400/q/75");


        PageContentImageData pageContentImageData47 = new PageContentImageData();
        pageContentImageData47.setName("雀巢(Nestle) 脆脆鲨 威化饼干 牛奶味");
        pageContentImageData47.setPrice(new BigDecimal(9.9));
        pageContentImageData47.setUrl("/goodsDetail?skuId=1381797095073120256&goodsId=1377805575856848896");
        pageContentImageData47.setImg("https://static.mszlu.com/mall/fe5b8167b0264c53836d08a6a7003cf0.jpeg?imageView2/1/w/400/h/400/q/75");


        PageContentImageData pageContentImageData48 = new PageContentImageData();
        pageContentImageData48.setName("雀巢（Nestle）咖啡 奶香味10条");
        pageContentImageData48.setPrice(new BigDecimal(39));
        pageContentImageData48.setUrl("/goodsDetail?skuId=1381791962713030656&goodsId=1377057500825649152");
        pageContentImageData48.setImg("https://static.mszlu.com/mall/6ce1382ba55f4284a86f893cfc79eed8.jpg?imageView2/1/w/400/h/400/q/75");


        PageContentImageData pageContentImageData49 = new PageContentImageData();
        pageContentImageData49.setName("杯口留香酸奶燕麦片 水果燕麦片");
        pageContentImageData49.setPrice(new BigDecimal(9));
        pageContentImageData49.setUrl("/goodsDetail?skuId=1381792469200404480&goodsId=1377070177157382144");
        pageContentImageData49.setImg("https://static.mszlu.com/mall/72927f793db7454d9109ab0581ace984.jpg?imageView2/1/w/400/h/400/q/75");


        PageContentImageData pageContentImageData410 = new PageContentImageData();
        pageContentImageData410.setName("坚果 夏威夷果 奶油味");
        pageContentImageData410.setPrice(new BigDecimal(37));
        pageContentImageData410.setUrl("/goodsDetail?skuId=1381792548808294400&goodsId=1377071458592751616");
        pageContentImageData410.setImg("https://static.mszlu.com/mall/b7c76242a9914e60a059b2f2dfee168b.jpg?imageView2/1/w/400/h/400/q/75");



        pageContentImageDataList4.add(pageContentImageData41);
        pageContentImageDataList4.add(pageContentImageData42);
        pageContentImageDataList4.add(pageContentImageData43);
        pageContentImageDataList4.add(pageContentImageData44);
        pageContentImageDataList4.add(pageContentImageData45);
        pageContentImageDataList4.add(pageContentImageData46);
        pageContentImageDataList4.add(pageContentImageData47);
        pageContentImageDataList4.add(pageContentImageData48);
        pageContentImageDataList4.add(pageContentImageData49);
        pageContentImageDataList4.add(pageContentImageData410);

        list.add(pageContentImageDataList4);

        notEnoughOption.setList(list);
        List<Nav> navList = new ArrayList<>();
        navList.add(new Nav("精选","个性美妆"));
        navList.add(new Nav("智能先锋","大电器城"));
        navList.add(new Nav("居家优品","品质生活"));
        navList.add(new Nav("超市百货","百货生鲜"));
        notEnoughOption.setNavList(navList);
        notEnough.setOptions(notEnoughOption);
        System.out.println(JSON.toJSONString(notEnough));
    }
}
