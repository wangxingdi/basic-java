package com.daiyuma.tmp.year2020.month09.day22;

/**
 * 文章分类
 */
public enum ArticleCategoryEnum {
    UNCATEGORIZED("uncategorized", 1),
    TECH("tech", 2),
    FINANCE("finance", 3),
    WORK("work", 4),
    LIFE("life", 5),
    TRAVEL("travel", 6),
    WEB("web", 9),
    CAR("car", 10),
    GAME("game", 11),
    HISTORY("history", 20),
    HEALTH("health", 21);

    private String type;
    private Integer typeId;

    ArticleCategoryEnum(String type, Integer typeId) {
        this.type = type;
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public Integer getTypeId() {
        return typeId;
    }
}
