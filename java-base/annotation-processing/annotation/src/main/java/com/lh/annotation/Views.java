package com.lh.annotation;

/**
 * @author lh
 */
public class Views {
    //最简创建或更新字段
    public interface Simple {}
    //通常是可更新的
    public interface Value  {}
    //只能新增时输入，不可修改的
    public interface New extends Value {}
    //简要信息
    public interface Summary {}
    //详细信息
    public interface Detail extends Summary {}
    //可搜索字段
    public interface Search {}
    //单独重置的字段
    public interface Reset {}
}
