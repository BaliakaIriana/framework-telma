package local.baledo.root.s6.operateur.test;

import java.util.List;

import org.junit.Test;

import local.baledo.root.s6.operateur.dao.HibernateDao;
import local.baledo.root.s6.operateur.model.Data;
import local.baledo.root.s6.operateur.model.Utilisateur;

public class HibernateDaoTest {

	@Test
	public void testSave() {
		HibernateDao dao = new HibernateDao();
		Utilisateur u = new Utilisateur(0,"rabary","harivola","123456789013",null);
		try {
			dao.save(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindById() {
		HibernateDao dao = new HibernateDao();
		Utilisateur u = new Utilisateur(1,null,null,null,null);
		try {
			dao.findById(u);
			System.out.println(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindAll() {
		HibernateDao dao = new HibernateDao();
		Utilisateur u = new Utilisateur();
		List<Data> utilisateursList = null;
		try {
			utilisateursList = dao.findAll(u);
			for (Data data : utilisateursList) {
				System.out.println(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
