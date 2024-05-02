package com.dao;

import com.entity.WeixiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiuView;

/**
 * 资产维修 Dao 接口
 *
 * @author 
 * @since 2021-04-06
 */
public interface WeixiuDao extends BaseMapper<WeixiuEntity> {

   List<WeixiuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
