package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 资产维修
 *
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("weixiu")
public class WeixiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeixiuEntity() {

	}

	public WeixiuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Weixiu{" +
            "id=" + id +
            ", zichanId=" + zichanId +
            ", yonghuId=" + yonghuId +
            ", weixiuMoney=" + weixiuMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
