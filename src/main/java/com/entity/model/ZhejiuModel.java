package com.entity.model;

import com.entity.ZhejiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资产折旧
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-06
 */
public class ZhejiuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 资产名称
     */
    private Integer zichanId;


    /**
     * 折旧程度
     */
    private String weixiuZhejiu;


    /**
     * 详细信息
     */
    private String weixiuContent;


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
    public Integer getZichanId() {
        return zichanId;
    }


    /**
	 * 设置：资产名称
	 */
    public void setZichanId(Integer zichanId) {
        this.zichanId = zichanId;
    }
    /**
	 * 获取：折旧程度
	 */
    public String getWeixiuZhejiu() {
        return weixiuZhejiu;
    }


    /**
	 * 设置：折旧程度
	 */
    public void setWeixiuZhejiu(String weixiuZhejiu) {
        this.weixiuZhejiu = weixiuZhejiu;
    }
    /**
	 * 获取：详细信息
	 */
    public String getWeixiuContent() {
        return weixiuContent;
    }


    /**
	 * 设置：详细信息
	 */
    public void setWeixiuContent(String weixiuContent) {
        this.weixiuContent = weixiuContent;
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
