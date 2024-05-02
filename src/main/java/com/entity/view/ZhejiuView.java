package com.entity.view;

import com.entity.ZhejiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 资产折旧
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("zhejiu")
public class ZhejiuView extends ZhejiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 zichan
			/**
			* 资产名称
			*/
			private String zichanName;
			/**
			* 资产分类
			*/
			private Integer zichanTypes;
				/**
				* 资产分类的值
				*/
				private String zichanValue;
			/**
			* 所属部门
			*/
			private Integer bumenTypes;
				/**
				* 所属部门的值
				*/
				private String bumenValue;
			/**
			* 规格型号
			*/
			private String zichanGuige;
			/**
			* 生产厂家
			*/
			private String zichanChangjia;
			/**
			* 保养周期
			*/
			private String zichanBaoyang;
			/**
			* 购买价格
			*/
			private Double zichanMoney;
			/**
			* 详细信息
			*/
			private String zichanContent;

	public ZhejiuView() {

	}

	public ZhejiuView(ZhejiuEntity zhejiuEntity) {
		try {
			BeanUtils.copyProperties(this, zhejiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

















				//级联表的get和set zichan
					/**
					* 获取： 资产名称
					*/
					public String getZichanName() {
						return zichanName;
					}
					/**
					* 设置： 资产名称
					*/
					public void setZichanName(String zichanName) {
						this.zichanName = zichanName;
					}
					/**
					* 获取： 资产分类
					*/
					public Integer getZichanTypes() {
						return zichanTypes;
					}
					/**
					* 设置： 资产分类
					*/
					public void setZichanTypes(Integer zichanTypes) {
						this.zichanTypes = zichanTypes;
					}


						/**
						* 获取： 资产分类的值
						*/
						public String getZichanValue() {
							return zichanValue;
						}
						/**
						* 设置： 资产分类的值
						*/
						public void setZichanValue(String zichanValue) {
							this.zichanValue = zichanValue;
						}
					/**
					* 获取： 所属部门
					*/
					public Integer getBumenTypes() {
						return bumenTypes;
					}
					/**
					* 设置： 所属部门
					*/
					public void setBumenTypes(Integer bumenTypes) {
						this.bumenTypes = bumenTypes;
					}


						/**
						* 获取： 所属部门的值
						*/
						public String getBumenValue() {
							return bumenValue;
						}
						/**
						* 设置： 所属部门的值
						*/
						public void setBumenValue(String bumenValue) {
							this.bumenValue = bumenValue;
						}
					/**
					* 获取： 规格型号
					*/
					public String getZichanGuige() {
						return zichanGuige;
					}
					/**
					* 设置： 规格型号
					*/
					public void setZichanGuige(String zichanGuige) {
						this.zichanGuige = zichanGuige;
					}
					/**
					* 获取： 生产厂家
					*/
					public String getZichanChangjia() {
						return zichanChangjia;
					}
					/**
					* 设置： 生产厂家
					*/
					public void setZichanChangjia(String zichanChangjia) {
						this.zichanChangjia = zichanChangjia;
					}
					/**
					* 获取： 保养周期
					*/
					public String getZichanBaoyang() {
						return zichanBaoyang;
					}
					/**
					* 设置： 保养周期
					*/
					public void setZichanBaoyang(String zichanBaoyang) {
						this.zichanBaoyang = zichanBaoyang;
					}
					/**
					* 获取： 购买价格
					*/
					public Double getZichanMoney() {
						return zichanMoney;
					}
					/**
					* 设置： 购买价格
					*/
					public void setZichanMoney(Double zichanMoney) {
						this.zichanMoney = zichanMoney;
					}
					/**
					* 获取： 详细信息
					*/
					public String getZichanContent() {
						return zichanContent;
					}
					/**
					* 设置： 详细信息
					*/
					public void setZichanContent(String zichanContent) {
						this.zichanContent = zichanContent;
					}


}
