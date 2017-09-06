package com.ll.core.query.user;

import java.util.ArrayList;
import java.util.List;

import com.ll.core.query.BaseQuery;

public class EmployeeQuery extends BaseQuery {
	/**
	 * ==============================������ѯ�����¡�ɾ��ʱ��Where��������======================
	 * ============
	 **/
	private String username;
	public String getUsername() {
		return username;
	}
	public EmployeeQuery setUsername(String username) {
		this.username = username;
		return this;
	}
	private boolean usernameLike;
	public EmployeeQuery setUsernameLike(boolean isLike) {
		this.usernameLike = isLike;
		return this;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public EmployeeQuery setPassword(String password) {
		this.password = password;
		return this;
	}
	private boolean passwordLike;
	public EmployeeQuery setPasswordLike(boolean isLike) {
		this.passwordLike = isLike;
		return this;
	}
	private String degree;
	public String getDegree() {
		return degree;
	}
	public EmployeeQuery setDegree(String degree) {
		this.degree = degree;
		return this;
	}
	private boolean degreeLike;
	public EmployeeQuery setDegreeLike(boolean isLike) {
		this.degreeLike = isLike;
		return this;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public EmployeeQuery setEmail(String email) {
		this.email = email;
		return this;
	}
	private boolean emailLike;
	public EmployeeQuery setEmailLike(boolean isLike) {
		this.emailLike = isLike;
		return this;
	}
	private Integer gender;
	public Integer getGender() {
		return gender;
	}
	public EmployeeQuery setGender(Integer gender) {
		this.gender = gender;
		return this;
	}
	private String imgUrl;
	public String getImgUrl() {
		return imgUrl;
	}
	public EmployeeQuery setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		return this;
	}
	private boolean imgUrlLike;
	public EmployeeQuery setImgUrlLike(boolean isLike) {
		this.imgUrlLike = isLike;
		return this;
	}
	private String phone;
	public String getPhone() {
		return phone;
	}
	public EmployeeQuery setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	private boolean phoneLike;
	public EmployeeQuery setPhoneLike(boolean isLike) {
		this.phoneLike = isLike;
		return this;
	}
	private String realName;
	public String getRealName() {
		return realName;
	}
	public EmployeeQuery setRealName(String realName) {
		this.realName = realName;
		return this;
	}
	private boolean realNameLike;
	public EmployeeQuery setRealNameLike(boolean isLike) {
		this.realNameLike = isLike;
		return this;
	}
	private String school;
	public String getSchool() {
		return school;
	}
	public EmployeeQuery setSchool(String school) {
		this.school = school;
		return this;
	}
	private boolean schoolLike;
	public EmployeeQuery setSchoolLike(boolean isLike) {
		this.schoolLike = isLike;
		return this;
	}
	private Integer isDel;
	public Integer getIsDel() {
		return isDel;
	}
	public EmployeeQuery setIsDel(Integer isDel) {
		this.isDel = isDel;
		return this;
	}
	/**
	 * ==============================������ѯʱ��Order����˳������==========================
	 * ========
	 **/
	 	public class OrderField {
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;

		public String getFieldName() {
			return fieldName;
		}
		public OrderField setFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		public String getOrder() {
			return order;
		}
		public OrderField setOrder(String order) {
			this.order = order;
			return this;
		}
	}
		/**
	 * ==============================������ѯʱ��Order����˳������==========================
	 * ========
	 **/
	/** �����б��ֶ� **/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * �����������ԣ�username
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyUsername(boolean isAsc) {
		orderFields.add(new OrderField("username", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�password
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyPassword(boolean isAsc) {
		orderFields.add(new OrderField("password", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�degree
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyDegree(boolean isAsc) {
		orderFields.add(new OrderField("degree", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�email
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyEmail(boolean isAsc) {
		orderFields.add(new OrderField("email", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�gender
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyGender(boolean isAsc) {
		orderFields.add(new OrderField("gender", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�img_url
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyImgUrl(boolean isAsc) {
		orderFields.add(new OrderField("img_url", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�phone
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyPhone(boolean isAsc) {
		orderFields.add(new OrderField("phone", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�real_name
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyRealName(boolean isAsc) {
		orderFields.add(new OrderField("real_name", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�school
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbySchool(boolean isAsc) {
		orderFields.add(new OrderField("school", isAsc ? "ASC" : "DESC"));
		return this;
	}
	/**
	 * �����������ԣ�is_del
	 * 
	 * @param isAsc
	 *            �Ƿ����򣬷���Ϊ����
	 */
	public EmployeeQuery orderbyIsDel(boolean isAsc) {
		orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
		return this;
	}
}
