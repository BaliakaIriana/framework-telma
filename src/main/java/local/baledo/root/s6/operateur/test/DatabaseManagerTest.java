package local.baledo.root.s6.operateur.test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import local.baledo.root.s6.operateur.dao.DatabaseManager;
import local.baledo.root.s6.operateur.model.Forfait;
import local.baledo.root.s6.operateur.model.Sim;
import local.baledo.root.s6.operateur.model.Utilisateur;

public class DatabaseManagerTest {

	@Test
	public void testSave() {
		Forfait f = new Forfait(0,"Bonbon2");
		Utilisateur u = new Utilisateur(0, "Rakoto", "Vao", "123456789102", new Date());
		Sim sim = new Sim(0,"0331123574","0000","1234567",u);
		DatabaseManager dbm = new DatabaseManager();
		try {
			dbm.save(f);
			dbm.save(u);
			dbm.save(sim);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testUpdate() throws NoSuchMethodException, IllegalAccessException, SQLException {
		Forfait f = new Forfait(10,"Bonbon9");
		Utilisateur u = new Utilisateur(7, "Rakoto", "Vao", "123456789102", new Date());
		DatabaseManager dbm = new DatabaseManager();
		try {
			dbm.update(u);
			dbm.update(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
