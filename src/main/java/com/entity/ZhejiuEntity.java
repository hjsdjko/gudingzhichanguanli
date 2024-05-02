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
 * 资产折旧
 *
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("zhejiu")
public class ZhejiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhejiuEntity() {

	}

	public ZhejiuEntity(T t) {
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
     * 资产名称
     */
    @TableField(value = "zichan_id")

    private Integer zichanId;


    /**
     * 折旧程度
     */
    @TableField(value = "weixiu_zhejiu")

    private String weixiuZhejiu;


    /**
     * 详细信息
     */
    @TableField(value = "weixiu_content")

    private String weixiuContent;


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
	 * 设置：资产名称
	 */
    public Integer getZichanId() {
        return zichanId;
    }


    /**
	 * 获取：资产名称
	 */

    public void setZichanId(Integer zichanId) {
        this.zichanId = zichanId;
    }
    /**
	 * 设置：折旧程度
	 */
    public String getWeixiuZhejiu() {
        return weixiuZhejiu;
    }


    /**
	 * 获取：折旧程度
	 */

    public void setWeixiuZhejiu(String weixiuZhejiu) {
        this.weixiuZhejiu = weixiuZhejiu;
    }
    /**
	 * 设置：详细信息
	 */
    public String getWeixiuContent() {
        return weixiuContent;
    }


    /**
	 * 获取：详细信息
	 */

    public void setWeixiuContent(String weixiuContent) {
        this.weixiuContent = weixiuContent;
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
        return "Zhejiu{" +
            "id=" + id +
            ", zichanId=" + zichanId +
            ", weixiuZhejiu=" + weixiuZhejiu +
            ", weixiuContent=" + weixiuContent +
            ", createTime=" + createTime +
        "}";
    }
}
