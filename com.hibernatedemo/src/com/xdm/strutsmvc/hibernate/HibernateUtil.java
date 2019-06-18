package com.xdm.strutsmvc.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final ThreadLocal<Session> threadlocal = new ThreadLocal<Session>();
	private static SessionFactory sessionfactory = null;
	static {
		try {
			Configuration cfg = new Configuration().configure();
			sessionfactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����Ự����ʧ��");
		}
	}
	
	/**
	 * ��ȡsession
	 * @return session����
	 */
	public static Session getSession() throws HibernateException{
		Session session = (Session)threadlocal.get();
		if(session==null||!session.isOpen()){
			if(sessionfactory==null){
				rebuildSessionFactory();
			}
			session = (sessionfactory!=null)?sessionfactory.openSession():null;
			threadlocal.set(session);
		}
		return session;
	}
	/**
	 * �ؽ��Ự����
	 */
	private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			Configuration cfg = new Configuration().configure();
			sessionfactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����Ự����ʧ��");
		}
	}
	/**
	 * ��ȡ�Ự����
	 * @return �Ự����
	 */
	public static SessionFactory getSessionFactory() throws HibernateException{
		return sessionfactory;
	}
	
	public static void closeSession(){
		Session session = (Session)threadlocal.get();
		threadlocal.set(null);
		if(session!=null){
			session.close();
		}
	}
}
