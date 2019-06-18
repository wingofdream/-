package com.xdm.strutsmvc.hibernate;

import java.util.List;

public interface iHibernate {

	/**
	 * 对象持久化
	 * @param obj 对象
	 * @return 对象的主键
	 */
	public Object save(Object obj);
	
	/**
	 * 获得对象
	 * @param cla 对象类型
	 * @param id 对象主键
	 * @return 对象
	 */
	public Object findByID(Class cla, Object id);
	/**
	 * 修改对象
	 * @param obj 对象
	 * @return 返回1成功 ,0失败
	 */
	public int update(Object obj);	
	
	/**
	 * 删除对象
	 * @param obj
	 * @return 返回1成功 ,0失败
	 */
	public int delete(Object obj);
	
	/**
	 * 根据主键删除
	 * @param cla 对象类型
	 * @param id 主键
	 * @return 返回1成功 ,0失败
	 */
	public int delete(Class cla, Object id);
	
	/**
	 * 无条件查询
	 * @param hql hibernate查询语句
	 * @return 对象集合
	 */
	public List select(String hql);
	
	/**
	 * 有条件查询
	 * @param hql hibernate查询语句
	 * @param parmas 查询参数
	 * @return 对象集合
	 */ 
	public List select(String hql,Object[] parmas);
	
	/**
	 * 聚合查询
	 * @param hql hibernate查询语句
	 * @return 聚合结果
	 */
	public Object selectValue(String hql);
	
	/**
	 * 有参数聚合查询
	 * @param hql hibernate查询语句
	 * @param parmas 参数
	 * @return 聚合结果
	 */
	public Object selectValue(String hql,Object[] parmas);

	/**
	 * 获得分页查询总页数
	 * @param hql 查询语句from开头
	 * @param perCount 每页显示条数
	 * @return 总页数
	 */
	public Long getPageCount(String hql,int perCount);
	
	/**
	 * 有参数获得分页查询总页数
	 * @param hql 查询语句from开头
	 * @param parmas 参数
	 * @param perCount 每页显示条数
	 * @return 总页数
	 */
	public Long getPageCount(String hql,Object[] parmas,int perCount);
	
	/**
	 * 分页查询
	 * @param hql 查询语句
	 * @param perCount 每页显示条数
	 * @param index 页码索引
	 * @return 分页查询结果集
	 */
	public List selectPage(String hql,int perCount,int index);
	
	/**
	 * 有参数分页查询
	 * @param hql 查询语句
	 * @param parmas 参数
	 * @param perCount 查询语句
	 * @param index 页码索引
	 * @return 分页查询结果集
	 */
	public List selectPage(String hql,Object[] parmas,int perCount,int index);
}
