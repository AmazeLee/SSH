package com.sh.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sh.dao.ShopAdminDao;
import com.sh.domain.ShopAdmin;
import com.sh.service.ShopAdminService;

/**
 * @author Amaze_lee
 * @date 2017年10月24日 上午11:58:24
 * @version V1.0
 * @Description: 测试Hibernate框架
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {

	@Resource(name = "sessionFactory")
	private SessionFactory sf;

	@Test
	// 单独测试hibernate
	public void fun1() {
		Configuration conf = new Configuration().configure();

		SessionFactory sf = conf.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		// -------------------------------------------------
		ShopAdmin admin = new ShopAdmin();

		admin.setName("amaze");
		admin.setPassword("123");

		session.save(admin);

		// -------------------------------------------------
		tx.commit();

		session.close();

		sf.close();

	}

	@Test
	// 测试spring管理sessionFactory
	public void fun2() {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		// -------------------------------------------------
		ShopAdmin admin = new ShopAdmin();

		admin.setName("keke");
		admin.setPassword("123");

		session.save(admin);

		// -------------------------------------------------
		tx.commit();

		session.close();

	}

	@Resource(name ="shopAdminDao")
	private ShopAdminDao sad;

	@Test // 测试Dao Hibernate模板
	public void fun3() {

		ShopAdmin sa = sad.getByShopAdminCode("keke");

		System.out.println(sa);
	}

	@Resource(name ="shopAdminService")
	private ShopAdminService sas;

	@Test // 测试aop事务
	public void fun4() {
		
		ShopAdmin sa = new ShopAdmin();

		sa.setName("geek");
		sa.setPassword("123");
		
		sas.saveShopAdmin(sa);
	}
}
