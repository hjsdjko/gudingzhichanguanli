package com.entity.vo;

import com.entity.ZhejiuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产折旧
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("zhejiu")
public class ZhejiuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
