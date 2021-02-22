package com.example.pms.system.model;

public class G_DepartmentModel {
	private Integer id;
	private String code;
	private String name;
	private String description;
	private String parentDepart;
	private String state;
	private String field1;
	private String field2;
	private String createTime;
	private String updateTime;
	private Integer createBy;// 创建人（一般为用户表主键）
	private Integer updateBy;// 更新人（用户表主键）
	private Integer deleted = 0;// 删除标志（0未删除，1已经删除）
	private Double order;// 排序序号（小数类型）
	private Integer type;// 类型（一般为字典表主键）
	private int pageIndex = 1;
	private int pageLimit = 10;
	private int rowStart;// limit 参数，
	private int rowCount;// limit 参数
	private boolean pageOn = false;// 是否分页
	private String orderby;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentDepart() {
		return parentDepart;
	}

	public void setParentDepart(String parentDepart) {
		this.parentDepart = parentDepart;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Double getOrder() {
		return order;
	}

	public void setOrder(Double order) {
		this.order = order;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getRowStart() {
		return rowStart;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public boolean isPageOn() {
		return pageOn;
	}

	public void setPageOn(boolean pageOn) {
		this.pageOn = pageOn;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	@Override
	public String toString() {
		return "G_DepartmentModel [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", parentDepart=" + parentDepart + ", state=" + state + ", field1=" + field1 + ", field2=" + field2
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", createBy=" + createBy + ", updateBy="
				+ updateBy + ", deleted=" + deleted + ", order=" + order + ", type=" + type + "]";
	}

}
