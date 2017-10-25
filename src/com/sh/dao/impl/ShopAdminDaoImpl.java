package com.sh.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sh.dao.ShopAdminDao;
import com.sh.domain.ShopAdmin;

/**
 * @author Amaze_lee
 * @date 2017年10月25日 下午5:50:34
 * @version V1.0
 * @Description:
 */
public class ShopAdminDaoImpl extends HibernateDaoSupport implements  ShopAdminDao{

	@Override
	public ShopAdmin getByShopAdminCode(String name) {
		// HQL
		return getHibernateTemplate().execute(new HibernateCallback<ShopAdmin>() {
			@Override
			public ShopAdmin doInHibernate(Session session) throws HibernateException {
				String hql = "from ShopAdmin where name = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0,name);
				ShopAdmin admin = (ShopAdmin) query.uniqueResult();
				return admin;
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.sh.dao.ShopAdminDao#save(com.sh.domain.ShopAdmin)
	 */
	@Override
	public void save(ShopAdmin sa) {
		getHibernateTemplate().save(sa);
	}

}
