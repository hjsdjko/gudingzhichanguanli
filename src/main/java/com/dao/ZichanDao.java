package com.dao;

import com.entity.ZichanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZichanView;

/**
 * 资产 Dao 接口
 *
 * @author 
 * @since 2021-04-06
 */
public interface ZichanDao extends BaseMapper<ZichanEntity> {

   List<ZichanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
