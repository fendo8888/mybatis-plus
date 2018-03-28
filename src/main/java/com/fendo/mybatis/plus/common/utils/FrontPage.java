package com.fendo.mybatis.plus.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * @version: V1.0
 * @author: fendo
 * @className: FrontPage
 * @packageName: com.fendo.mybatis.plus.common.utils
 * @description: 分页数据
 * @data: 2018-03-27 9:23
 **/
@ApiModel
public class FrontPage<T> {
	
	//是否是查询
	@ApiModelProperty(hidden=true)
    private boolean _search;

    //时间戳（毫秒）
    @ApiModelProperty(hidden=true)
    private String nd;

    //每页显示条数
    @ApiModelProperty(value = "每页显示条数")
    private int pageSize = 20;

    //当前页数
    @ApiModelProperty(value = "当前页数")
    private int pageNo = 1;

    //排序的字段
    @ApiModelProperty(hidden=true)
    private String sidx;

    //排序方式 asc升序  desc降序
    @ApiModelProperty(hidden=true)
    private String sord = "asc";
    
    @ApiModelProperty(value = "请求参数")
    private T param;

	public boolean is_search() {
		return _search;
	}

	public void set_search(boolean _search) {
		this._search = _search;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

	public Page<T> getPagePlus(){
		Page<T> pagePlus = new Page<T>();
        pagePlus.setCurrent(this.pageNo);
        pagePlus.setSize(this.pageSize);
        pagePlus.setAsc(this.sord.equals("asc"));
        pagePlus.setOrderByField(this.sidx);
        return pagePlus;
	}

}
