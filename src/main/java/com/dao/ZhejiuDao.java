package com.dao;

import com.entity.ZhejiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhejiuView;

/**
 * 资产折旧 Dao 接口
 *
 * @author 
 * @since 2021-04-06
 */
public interface ZhejiuDao extends BaseMapper<ZhejiuEntity> {

   List<ZhejiuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
