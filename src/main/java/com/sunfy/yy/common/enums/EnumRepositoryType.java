package com.sunfy.yy.common.enums;

/**
 * 定义数据库访问对象的类别
 */
public enum EnumRepositoryType {
    ALLEGORICAL("ALLEGORICAL","【歇后语】"),
    DIC("DIC","【字典】"),
    FAMOUS("FAMOUS","【名人名言】"),
    IDIOM("IDIOM","【成语】"),
    POEM("POEM","【唐诗宋词】"),
    TODAY_HISTORY("TODAY_HISTORY","【历史上的今天】"),
    WORD_SEA("WORD_SEA","【辞海】"),
    M_IN_THEATERS("M_IN_THEATERS","【正在热映】")
    ;

    private String repositoryType;

    private String content;

    EnumRepositoryType(String RepositoryType, String content) {
        this.repositoryType = RepositoryType;
        this.content = content;
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
    }}
