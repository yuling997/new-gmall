package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.GroupVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;

import java.util.List;


/**
 * 属性分组
 *
 * @author zhaoyuling
 * @email zyl@atguigu.com
 * @date 2020-01-07 18:44:07
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo queryGroupsByCidPage(QueryCondition queryCondition, Long catId);

    GroupVO queryGroupVOByGid(Long gid);

    List<GroupVO> queryGroupVOsByCid(Long cid);
}

