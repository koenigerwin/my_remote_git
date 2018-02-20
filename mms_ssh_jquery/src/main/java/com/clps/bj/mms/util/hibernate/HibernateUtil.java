package com.clps.bj.mms.util.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private final static SessionFactory FACTORY = buildSessionFactory();

	/*满足hibernate4.3一下的测试
	 * private static SessionFactory buildSessionFactory3() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory(serviceRegistry);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		return factory;
	}*/
	
	private static SessionFactory buildSessionFactory(){  
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml"); // 实例化配置文件  
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); // 实例化服务登记  
        return configuration.buildSessionFactory(serviceRegistry); // 获取Session工厂  
    }  
	
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
	
	public static Session openSession() {
		return FACTORY.openSession();
	}
	
	public static void close(Session session) {
		if(session!=null) session.close();
	}
}
