package com.entity.vo;

import com.entity.WeixiuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产维修
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("weixiu")
public class WeixiuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 维修资产
     */

    @TableField(value = "zichan_id")
    private Integer zichanId;


    /**
     * 负责员工
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 维修费用
     */

    @TableField(value = "weixiu_money")
    private Double weixiuMoney;


    /**
     * 维修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：维修资产
	 */
    public Integer getZichanId() {
        return zichanId;
    }


    /**
	 * 获取：维修资产
	 */

    public void setZichanId(Integer zichanId) {
        this.zichanId = zichanId;
    }
    /**
	 * 设置：负责员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：负责员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：维修费用
	 */
    public Double getWeixiuMoney() {
        return weixiuMoney;
    }


    /**
	 * 获取：维修费用
	 */

    public void setWeixiuMoney(Double weixiuMoney) {
        this.weixiuMoney = weixiuMoney;
    }
    /**
	 * 设置：维修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：维修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
