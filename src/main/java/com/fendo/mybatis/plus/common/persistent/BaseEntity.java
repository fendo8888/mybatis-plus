/**
 * projectName: mybatis-plus
 * fileName: BaseEntity.java
 * packageName: com.fendo.mybatis.plus.common.persistent
 * date: 2018-03-24 18:12
 * copyright(c) 2017-2020 xxx公司
 */
package com.fendo.mybatis.plus.common.persistent;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: BaseEntity
 * @packageName: com.fendo.mybatis.plus.common.persistent
 * @description: 实体类基类
 * @data: 2018-03-24 18:12
 **/
public class BaseEntity <T extends Model> extends Model<T> {

    /**
     * 主键ID , 这里故意演示注解可以无
     */
    @TableId(value="ID",type = IdType.UUID)
    @ApiModelProperty("主键")
    private String id;

    /**
     * 创建者
     */
    @TableField("CREATE_BY")
    @ApiModelProperty("创建人")
    private String createBy;
    /**
     * 创建时间
     */
    @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", dataType = "java.util.Date")
    private Date createDate;
    /**
     * 更新者
     */
    @TableField("UPDATE_BY")
    @ApiModelProperty("更新者")
    private String updateBy;
    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_DATE", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "更新时间", dataType = "java.util.Date")
    private Date updateDate;
    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remarks;
    /**
     * 删除标记
     */
    @TableField(value = "DEL_FLAG", fill = FieldFill.INSERT)
    @TableLogic(value = "0")
    @ApiModelProperty(hidden = true)
    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
