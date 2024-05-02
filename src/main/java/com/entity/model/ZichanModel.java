package com.entity.model;

import com.entity.ZichanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-06
 */
public class ZichanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 资产名称
     */
    private String zichanName;


    /**
     * 资产分类
     */
    private Integer zichanTypes;


    /**
     * 所属部门
     */
    private Integer bumenTypes;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：资产名称
	 */
    public String getZichanName() {
        return zichanName;
    }


    /**
	 * 设置：资产名称
	 */
    public void setZichanName(String zichanName) {
        this.zichanName = zichanName;
    }
    /**
	 * 获取：资产分类
	 */
    public Integer getZichanTypes() {
        return zichanTypes;
    }


    /**
	 * 设置：资产分类
	 */
    public void setZichanTypes(Integer zichanTypes) {
        this.zichanTypes = zichanTypes;
    }
    /**
	 * 获取：所属部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 设置：所属部门
	 */
    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 获取：规格型号
	 */
    public String getZichanGuige() {
        return zichanGuige;
    }


    /**
	 * 设置：规格型号
	 */
    public void setZichanGuige(String zichanGuige) {
        this.zichanGuige = zichanGuige;
    }
    /**
	 * 获取：生产厂家
	 */
    public String getZichanChangjia() {
        return zichanChangjia;
    }


    /**
	 * 设置：生产厂家
	 */
    public void setZichanChangjia(String zichanChangjia) {
        this.zichanChangjia = zichanChangjia;
    }
    /**
	 * 获取：保养周期
	 */
    public String getZichanBaoyang() {
        return zichanBaoyang;
    }


    /**
	 * 设置：保养周期
	 */
    public void setZichanBaoyang(String zichanBaoyang) {
        this.zichanBaoyang = zichanBaoyang;
    }
    /**
	 * 获取：购买价格
	 */
    public Double getZichanMoney() {
        return zichanMoney;
    }


    /**
	 * 设置：购买价格
	 */
    public void setZichanMoney(Double zichanMoney) {
        this.zichanMoney = zichanMoney;
    }
    /**
	 * 获取：详细信息
	 */
    public String getZichanContent() {
        return zichanContent;
    }


    /**
	 * 设置：详细信息
	 */
    public void setZichanContent(String zichanContent) {
        this.zichanContent = zichanContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
