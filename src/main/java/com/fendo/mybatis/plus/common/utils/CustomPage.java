package com.fendo.mybatis.plus.common.utils;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: CustomPage
 * @packageName: com.fendo.mybatis.plus.common.utils
 * @description: 自定义分页数据
 * @data: 2018-03-27 9:23
 **/
@ApiModel
public class CustomPage<T> {
	
	//当前页数
	@ApiModelProperty(value = "当前页数")
    private int pageNo;

    //每页显示数量
	@ApiModelProperty(value = "每页显示数量")
    private int pageSize;

    @ApiModelProperty(value = "总条数")
    private int totalRecord;

    //数据列表
    @ApiModelProperty(value = "数据列表")
    private List<T> parameterType;

    //总页数
    @ApiModelProperty(value = "总页数")
    private int totalPage;

    //排序字段
    @ApiModelProperty(value = "排序字段")
    private String orderByField;

    //是否升序
    @ApiModelProperty(value = "是否升序")
    private boolean isAsc;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getParameterType() {
		return parameterType;
	}

	public void setParameterType(List<T> parameterType) {
		this.parameterType = parameterType;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getOrderByField() {
		return orderByField;
	}

	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}
    
	public CustomPage(){}

    @SuppressWarnings("deprecation")
	public CustomPage(Page<T> page){
        this.pageNo = page.getCurrent();
        this.pageSize = page.getSize();
        this.totalRecord = (int) page.getTotal();
        this.parameterType = page.getRecords();
        this.totalPage = (int) page.getPages();
        this.orderByField = page.getOrderByField();
        this.isAsc = page.isAsc();
    }

}
