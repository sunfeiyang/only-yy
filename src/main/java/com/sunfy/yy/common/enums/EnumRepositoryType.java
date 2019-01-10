package com.sunfy.yy.common.enums;

/**
 * 定义数据库访问对象的类别
 */
public enum EnumRepositoryType {
    ALLEGORICAL("ALLEGORICAL",
            "【歇后语】",
            false),
    DIC("DIC",
            "【字典】",
            false),
    FAMOUS("FAMOUS",
            "【名人名言】",
            false),
    IDIOM("IDIOM",
            "【成语】",
            false),
    POEM("POEM",
            "【唐诗宋词】",
            false),
    TODAY_HISTORY("TODAY_HISTORY",
            "【历史上的今天】",
            false),
    WORD_SEA("WORD_SEA",
            "【辞海】",
            false),
    M_SUBJECT("M_SUBJECT",
            "【影片详情】",
            false),
    M_IN_THEATERS("M_IN_THEATERS",
            "【正在热映】",
            true),
    M_COMINGSOON("M_COMINGSOON",
            "【即将上映】",
            true),
    M_NEW_MOVIES("M_NEW_MOVIES",
            "【新片榜】",
            true),
    M_TOP250("M_TOP250",
            "【TOP250】",
            false),
    M_WEEKLY("M_WEEKLY",
            "【一周口碑榜】",
            true),
    M_USBOX("M_USBOX",
            "【欧美票房榜】",
            true)
    ;

    private String repositoryType;

    private String content;

    // 是否清空原有数据表中的数据
    private Boolean isDel;

    EnumRepositoryType(String RepositoryType, String content, Boolean isDel) {
        this.repositoryType = RepositoryType;
        this.content = content;
        this.isDel = isDel;
    }

    public String getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(String repositoryType) {
        this.repositoryType = repositoryType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }
}
