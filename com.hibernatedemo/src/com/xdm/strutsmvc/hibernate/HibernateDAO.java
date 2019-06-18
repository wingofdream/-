package com.xdm.strutsmvc.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDAO implements iHibernate{

	@Override
	public Object save(Object obj) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Serializable key = session.save(obj);
			transaction.commit();
			HibernateUtil.closeSession();
			return key;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
			HibernateUtil.closeSession();
		}
		return 0;
	}

	@Override
	public Object findByID(Class cla, Object id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Object obj = session.get(cla, (Serializable) id);
			HibernateUtil.closeSession();
			return obj;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(obj);
			transaction.commit();
			HibernateUtil.closeSession();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(obj);
			transaction.commit();
			HibernateUtil.closeSession();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return 0;
	}

	@Override
	public int delete(Class cla, Object id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Object obj = session.get(cla, (Serializable) id);
			session.delete(obj);
			transaction.commit();
			HibernateUtil.closeSession();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return 0;
	}

	@Override
	public List select(String hql) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery(hql);
			List list = query.list();
			HibernateUtil.closeSession();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public List select(String hql, Object[] parmas) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery(hql);
			for(int i=0;i<parmas.length;i++){
				query.setParameter(i, parmas[i]);
			}
			List list = query.list();
			HibernateUtil.closeSession();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public Object selectValue(String hql) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Object value = session.createQuery(hql).uniqueResult();
			HibernateUtil.closeSession();
			return value;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public Object selectValue(String hql, Object[] parmas) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery(hql);
			for(int i=0;i<parmas.length;i++){
				query.setParameter(i, parmas[i]);
			}
			Object value = query.uniqueResult();
			HibernateUtil.closeSession();
			return value;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public Long getPageCount(String hql, int perCount) {
		// TODO Auto-generated method stub
		String chql = "select count(*) " + hql;
		Object cnt = selectValue(chql);
		Long objCnt = (Long) cnt;
		long pageCount = 0;
		pageCount =objCnt % perCount == 0?objCnt / perCount:objCnt / perCount + 1;
		return pageCount;
	}

	@Override
	public Long getPageCount(String hql, Object[] parmas, int perCount) {
		// TODO Auto-generated method stub
		String chql = "select count(*) " + hql;
		Object cnt = selectValue(chql,parmas);
		Long objCnt = (Long) cnt;
		long pageCount = 0;
		pageCount =objCnt % perCount == 0?objCnt / perCount:objCnt / perCount + 1;
		return pageCount;
	}

	@Override
	public List selectPage(String hql, int perCount, int index) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult((index-1)*perCount);
			query.setMaxResults(perCount);
			List list = query.list();
			HibernateUtil.closeSession();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return null;
	}

	@Override
	public List selectPage(String hql, Object[] parmas, int perCount, int index) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			Query query = session.createQuery(hql);
			for (int i = 0; i < parmas.length; i++) {
				query.setParameter(i, parmas[i]);
			}
			query.setFirstResult((index-1)*perCount);
			query.setMaxResults(perCount);
			List list = query.list();
			HibernateUtil.closeSession();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HibernateUtil.closeSession();
		}
		return null;
	}
	
}
