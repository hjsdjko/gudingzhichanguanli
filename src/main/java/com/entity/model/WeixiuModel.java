package com.entity.model;

import com.entity.WeixiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产维修
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-06
 */
public class WeixiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 维修资产
     */
    private Integer zichanId;


    /**
     * 负责员工
     */
    private Integer yonghuId;


    /**
     * 维修费用
     */
    private Double weixiuMoney;


    /**
     * 维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：维修资产
	 */
    public Integer getZichanId() {
        return zichanId;
    }


    /**
	 * 设置：维修资产
	 */
    public void setZichanId(Integer zichanId) {
        this.zichanId = zichanId;
    }
    /**
	 * 获取：负责员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：负责员工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：维修费用
	 */
    public Double getWeixiuMoney() {
        return weixiuMoney;
    }


    /**
	 * 设置：维修费用
	 */
    public void setWeixiuMoney(Double weixiuMoney) {
        this.weixiuMoney = weixiuMoney;
    }
    /**
	 * 获取：维修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：维修时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
