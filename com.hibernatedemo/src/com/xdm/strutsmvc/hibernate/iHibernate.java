package com.xdm.strutsmvc.hibernate;

import java.util.List;

public interface iHibernate {

	/**
	 * ����־û�
	 * @param obj ����
	 * @return ���������
	 */
	public Object save(Object obj);
	
	/**
	 * ��ö���
	 * @param cla ��������
	 * @param id ��������
	 * @return ����
	 */
	public Object findByID(Class cla, Object id);
	/**
	 * �޸Ķ���
	 * @param obj ����
	 * @return ����1�ɹ� ,0ʧ��
	 */
	public int update(Object obj);	
	
	/**
	 * ɾ������
	 * @param obj
	 * @return ����1�ɹ� ,0ʧ��
	 */
	public int delete(Object obj);
	
	/**
	 * ��������ɾ��
	 * @param cla ��������
	 * @param id ����
	 * @return ����1�ɹ� ,0ʧ��
	 */
	public int delete(Class cla, Object id);
	
	/**
	 * ��������ѯ
	 * @param hql hibernate��ѯ���
	 * @return ���󼯺�
	 */
	public List select(String hql);
	
	/**
	 * ��������ѯ
	 * @param hql hibernate��ѯ���
	 * @param parmas ��ѯ����
	 * @return ���󼯺�
	 */ 
	public List select(String hql,Object[] parmas);
	
	/**
	 * �ۺϲ�ѯ
	 * @param hql hibernate��ѯ���
	 * @return �ۺϽ��
	 */
	public Object selectValue(String hql);
	
	/**
	 * �в����ۺϲ�ѯ
	 * @param hql hibernate��ѯ���
	 * @param parmas ����
	 * @return �ۺϽ��
	 */
	public Object selectValue(String hql,Object[] parmas);

	/**
	 * ��÷�ҳ��ѯ��ҳ��
	 * @param hql ��ѯ���from��ͷ
	 * @param perCount ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public Long getPageCount(String hql,int perCount);
	
	/**
	 * �в�����÷�ҳ��ѯ��ҳ��
	 * @param hql ��ѯ���from��ͷ
	 * @param parmas ����
	 * @param perCount ÿҳ��ʾ����
	 * @return ��ҳ��
	 */
	public Long getPageCount(String hql,Object[] parmas,int perCount);
	
	/**
	 * ��ҳ��ѯ
	 * @param hql ��ѯ���
	 * @param perCount ÿҳ��ʾ����
	 * @param index ҳ������
	 * @return ��ҳ��ѯ�����
	 */
	public List selectPage(String hql,int perCount,int index);
	
	/**
	 * �в�����ҳ��ѯ
	 * @param hql ��ѯ���
	 * @param parmas ����
	 * @param perCount ��ѯ���
	 * @param index ҳ������
	 * @return ��ҳ��ѯ�����
	 */
	public List selectPage(String hql,Object[] parmas,int perCount,int index);
}
