package com.entity.vo;

import com.entity.ZichanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资产
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-06
 */
@TableName("zichan")
public class ZichanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资产名称
     */

    @TableField(value = "zichan_name")
    private String zichanName;


    /**
     * 资产分类
     */

    @TableField(value = "zichan_types")
    private Integer zichanTypes;


    /**
     * 所属部门
     */

    @TableField(value = "bumen_types")
    private Integer bumenTypes;


    /**
     * 规格型号
     */

    @TableField(value = "zichan_guige")
    private String zichanGuige;


    /**
     * 生产厂家
     */

    @TableField(value = "zichan_changjia")
    private String zichanChangjia;


    /**
     * 保养周期
     */

    @TableField(value = "zichan_baoyang")
    private String zichanBaoyang;


    /**
     * 购买价格
     */

    @TableField(value = "zichan_money")
    private Double zichanMoney;


    /**
     * 详细信息
     */

    @TableField(value = "zichan_content")
    private String zichanContent;


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
    public String getZichanName() {
        return zichanName;
    }


    /**
	 * 获取：资产名称
	 */

    public void setZichanName(String zichanName) {
        this.zichanName = zichanName;
    }
    /**
	 * 设置：资产分类
	 */
    public Integer getZichanTypes() {
        return zichanTypes;
    }


    /**
	 * 获取：资产分类
	 */

    public void setZichanTypes(Integer zichanTypes) {
        this.zichanTypes = zichanTypes;
    }
    /**
	 * 设置：所属部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 获取：所属部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：规格型号
	 */
    public String getZichanGuige() {
        return zichanGuige;
    }


    /**
	 * 获取：规格型号
	 */

    public void setZichanGuige(String zichanGuige) {
        this.zichanGuige = zichanGuige;
    }
    /**
	 * 设置：生产厂家
	 */
    public String getZichanChangjia() {
        return zichanChangjia;
    }


    /**
	 * 获取：生产厂家
	 */

    public void setZichanChangjia(String zichanChangjia) {
        this.zichanChangjia = zichanChangjia;
    }
    /**
	 * 设置：保养周期
	 */
    public String getZichanBaoyang() {
        return zichanBaoyang;
    }


    /**
	 * 获取：保养周期
	 */

    public void setZichanBaoyang(String zichanBaoyang) {
        this.zichanBaoyang = zichanBaoyang;
    }
    /**
	 * 设置：购买价格
	 */
    public Double getZichanMoney() {
        return zichanMoney;
    }


    /**
	 * 获取：购买价格
	 */

    public void setZichanMoney(Double zichanMoney) {
        this.zichanMoney = zichanMoney;
    }
    /**
	 * 设置：详细信息
	 */
    public String getZichanContent() {
        return zichanContent;
    }


    /**
	 * 获取：详细信息
	 */

    public void setZichanContent(String zichanContent) {
        this.zichanContent = zichanContent;
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
