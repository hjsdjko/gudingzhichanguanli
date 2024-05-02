package com.entity.view;

import com.entity.BaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 资产报废
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("baofei")
public class BaofeiView extends BaofeiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public BaofeiView() {

	}

	public BaofeiView(BaofeiEntity baofeiEntity) {
		try {
			BeanUtils.copyProperties(this, baofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







}
