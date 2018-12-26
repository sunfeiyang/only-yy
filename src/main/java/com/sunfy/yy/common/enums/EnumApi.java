package com.sunfy.yy.common.enums;

/**
 * 枚举（异常处理）
 */
public enum EnumApi {

    ALLEGORICAL("https://api.avatardata.cn/XieHouYu/Search?key=e1a35d0cb95a430eb612dd26cf90974b"),
    ALLEGORICAL_RANDOM("https://api.avatardata.cn/XieHouYu/Random?key=e1a35d0cb95a430eb612dd26cf90974b"),
//    ALLEGORICAL("https://api.avatardata.cn/XieHouYu/Search?key=387bcf2fd17944af8695d21b1e41a91d"),
//    ALLEGORICAL_RANDOM("https://api.avatardata.cn/XieHouYu/Random?key=387bcf2fd17944af8695d21b1e41a91d"),
//    DIC("https://api.avatardata.cn/XinHuaZiDian/LookUp?key=6d04dab2649449bd85e272e71e74258f"),
    DIC("https://api.avatardata.cn/XinHuaZiDian/LookUp?key=dc5d8af96c4c4caa9ec8f770aaccfa79"),
    FAMOUS("https://api.avatardata.cn/MingRenMingYan/LookUp?key=b2683a78fa524f82a91bbaf56c6b8e9e"),
    FAMOUS_RANDOM("https://api.avatardata.cn/MingRenMingYan/Random?key=b2683a78fa524f82a91bbaf56c6b8e9e"),
//    FAMOUS("https://api.avatardata.cn/MingRenMingYan/LookUp?key=71f8e8cf64f3428b8fd8d238598aa3d3"),
//    FAMOUS_RANDOM("https://api.avatardata.cn/MingRenMingYan/Random?key=71f8e8cf64f3428b8fd8d238598aa3d3"),
    IDIOM("https://api.avatardata.cn/ChengYu/Search?key=8edb01d7f5174c42adadf0789a528dd8"),
    IDIOM_DETAILS("https://api.avatardata.cn/ChengYu/LookUp?key=8edb01d7f5174c42adadf0789a528dd8"),
    IDIOM_RANDOM("https://api.avatardata.cn/ChengYu/Random?key=8edb01d7f5174c42adadf0789a528dd8"),
//    IDIOM("https://api.avatardata.cn/ChengYu/Search?key=2431b0ba7ab24c8191df893243382dc4"),
//    IDIOM_DETAILS("https://api.avatardata.cn/ChengYu/LookUp?key=2431b0ba7ab24c8191df893243382dc4"),
//    IDIOM_RANDOM("https://api.avatardata.cn/ChengYu/Random?key=2431b0ba7ab24c8191df893243382dc4"),
//POEM("https://api.avatardata.cn/TangShiSongCi/Search?key=8cf90379938940f19cb49b18522db439"),
//    POEM_DETAILS("https://api.avatardata.cn/TangShiSongCi/LookUp?key=8cf90379938940f19cb49b18522db439"),
//    POEM_RANDOM("https://api.avatardata.cn/TangShiSongCi/Random?key=8cf90379938940f19cb49b18522db439"),
    POEM("https://api.avatardata.cn/TangShiSongCi/Search?key=6390f0216fff4a0f9abb21f1b84935b0"),
    POEM_DETAILS("https://api.avatardata.cn/TangShiSongCi/LookUp?key=6390f0216fff4a0f9abb21f1b84935b0"),
    POEM_RANDOM("https://api.avatardata.cn/TangShiSongCi/Random?key=6390f0216fff4a0f9abb21f1b84935b0"),
//    TODAY_HISTORY("https://api.avatardata.cn/HistoryToday/LookUp?key=a8f8ad8a787c4abca058a1a306423158"),
    TODAY_HISTORY("https://api.avatardata.cn/HistoryToday/LookUp?key=9d0a4638ec9f4c408fe6989898825476"),
    WORD_SEA(" https://api.avatardata.cn/CiHai/query?key=78341ceb68984c1bbb0f0c766059394b"),
    WORD_SEA_DETAILS("https://api.avatardata.cn/CiHai/LookUp?key=78341ceb68984c1bbb0f0c766059394b"),
    WORD_SEA_RANDOM("https://api.avatardata.cn/CiHai/Random?key=78341ceb68984c1bbb0f0c766059394b"),
    M_IN_THEATERS("https://douban.uieee.com/v2/movie/in_theaters")
    ;

    private String URL;

    EnumApi(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
