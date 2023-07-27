package com.test.dao;

import com.test.pojo.useInfo;

import java.util.List;

public interface useInfoMapper {
    /**
     * 增加一条数据
     * @param useInfo 数据
     */
    void add(useInfo useInfo);

    /**
     * 删除一条数据
     * @param id 被删除数据的id
     */
    void delete(Integer id);

    /**
     * 修改一条数据
     * @param useInfo 修改的数据
     */
    void update(useInfo useInfo);

    /**
     * 根据id去查询一条数据
     * @param id 查询的id
     */
    useInfo queryById(Integer id);
    /**
     * 查询全部数据
     * @return
     */
    List<useInfo> queryAll();

}
