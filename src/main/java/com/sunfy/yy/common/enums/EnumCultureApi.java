package com.sunfy.yy.common.enums;

/**
 * 枚举（异常处理）
 */
public enum EnumCultureApi {

    ALLEGORICAL("https://api.avatardata.cn/XieHouYu/Search?key=387bcf2fd17944af8695d21b1e41a91d"),
    ALLEGORICAL_RANDOM("https://api.avatardata.cn/XieHouYu/Random?key=387bcf2fd17944af8695d21b1e41a91d"),
    DIC("https://api.avatardata.cn/XinHuaZiDian/LookUp?key=6d04dab2649449bd85e272e71e74258f"),
    FAMOUS("https://api.avatardata.cn/MingRenMingYan/LookUp?key=71f8e8cf64f3428b8fd8d238598aa3d3"),
    FAMOUS_RANDOM("https://api.avatardata.cn/MingRenMingYan/Random?key=71f8e8cf64f3428b8fd8d238598aa3d3"),
    IDIOM("https://api.avatardata.cn/ChengYu/Search?key=2431b0ba7ab24c8191df893243382dc4"),
    IDIOM_DETAILS("https://api.avatardata.cn/ChengYu/LookUp?key=2431b0ba7ab24c8191df893243382dc4"),
    IDIOM_RANDOM("https://api.avatardata.cn/ChengYu/Random?key=2431b0ba7ab24c8191df893243382dc4"),
    POEM("https://api.avatardata.cn/TangShiSongCi/Search?key=8cf90379938940f19cb49b18522db439"),
    POEM_DETAILS("https://api.avatardata.cn/TangShiSongCi/LookUp?key=8cf90379938940f19cb49b18522db439"),
    POEM_RANDOM("https://api.avatardata.cn/TangShiSongCi/Random?key=8cf90379938940f19cb49b18522db439"),
    TODAY_HISTORY("https://api.avatardata.cn/HistoryToday/LookUp?key=a8f8ad8a787c4abca058a1a306423158");

    private String URL;

    EnumCultureApi(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
