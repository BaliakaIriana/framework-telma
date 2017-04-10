package local.baledo.root.s6.operateur.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import local.baledo.root.s6.operateur.model.Data;
import local.baledo.root.s6.operateur.util.Util;

public class DatabaseManager {
	public DatabaseManager(){
	}
	public void save(Data data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, SQLException{
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = UtilDao.getConnection();
			getIdToInsert(data,connection);
			String query = saveQuery(data);
//			System.out.println(query);
			stmt = connection.prepareStatement(query);
			executeSave(data,stmt);
			connection.commit();
		} catch (SQLException e) {
			throw e;
		}finally{
			if(stmt != null) stmt.close();
			if(connection != null)connection.close();
		}
	}
	
	private void executeSave(Data data,PreparedStatement stmt) throws SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Field[] fields = data.getClass().getDeclaredFields();
		stmt.setInt(1, data.getId());
		for(int i=0;i<fields.length;i++){
			Object o = getValue(data,fields[i]);
			if(o instanceof java.util.Date){
				stmt.setDate(i+2, new java.sql.Date(((java.util.Date)o).getTime()));
			}else if(o instanceof Data){
				stmt.setInt(i+2, ((Data)o).getId());
			}
			else{
				stmt.setObject(i+2, o);
			}
		}
		stmt.executeUpdate();
	}
	
	/**
	 * Récuperation de la valeur de la sequence selon l'objet à insérer
	 * @param data
	 * @param connection
	 * @throws SQLException
	 */
	private void getIdToInsert(Data data, Connection connection) throws SQLException {
		String seq_name = data.getClass().getSimpleName().toLowerCase()+"_id"+data.getClass().getSimpleName().toLowerCase()+"_seq";
		String query = "select nextval('"+seq_name+"') as id";
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery(query);
		res.next();
		data.setId(res.getInt("id"));
	}
	
	/**
	 * Génération dynamique de la requête SQL INSERT
	 * @param data
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private String saveQuery(Data data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String tablename = data.getClass().getSimpleName().toLowerCase();
		/**
		 * Ajout nom de table depuis la classe
		 */
		String query = "insert into "+tablename;
		/**
		 * Récupération des attributs (colonnes) de table
		 */
		Field[] fields = data.getClass().getDeclaredFields();
		Field[] fieldData = data.getClass().getSuperclass().getDeclaredFields();
		/**
		 * Ajout de la colonne id de la table
		 */
		query += "(";
		query += fieldData[0].getName()+data.getClass().getSimpleName().toLowerCase()+",";
		/**
		 * Définition des colonnes à insérer
		 */
		for(int i=0;i<fields.length;i++){
			if(getValue(data,fields[i]) instanceof Data){
				query += "id" + fields[i].getName().toLowerCase();
			}else{
				query += fields[i].getName();
			}
			if(i != fields.length-1) query += ",";
		}
		query += ") values (";
		query += "?,";
		for(int i=0;i<fields.length;i++){
			query += "?";
			if(i != fields.length-1) query += ",";
		}
		query += ")";
		return query;
	}
	
	private Object getValue(Data data,Field field) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method m = data.getClass().getMethod("get"+Util.toUpperFirst(field.getName()));
		Object o = m.invoke(data);
		return o;
	}
	
	public void update(Data data) throws Exception{
		Connection connection = null;
		PreparedStatement stmt = null;
		String query = updateQuery(data);
		try {
			connection = UtilDao.getConnection();
			stmt = connection.prepareStatement(query);
			System.out.println(query);
			executeUpdate(data,stmt);
			connection.commit();
		} catch (ClassNotFoundException | SQLException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw e;
		}finally{
			if(stmt != null) stmt.close();
			if(connection != null)connection.close();
		}
	}
	
	private String updateQuery(Data data) throws NoSuchFieldException, SecurityException {
		String query = "update "+data.getClass().getSimpleName().toLowerCase();
		query += " set ";
		/**
		 * Récupération des attributs
		 */
		Field[] fields = data.getClass().getDeclaredFields();
		/**
		 * Update des valeurs
		 */
		for(int i=0;i<fields.length;i++){
			query += fields[i].getName()+" = ?";
			if(i != fields.length-1) query += ",";
		}
		query += " where id" + data.getClass().getSimpleName().toLowerCase() + " = ?";
		return query;
	}
	
	private void executeUpdate(Data data,PreparedStatement stmt) throws SQLException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Field[] fields = data.getClass().getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			Object o = getValue(data,fields[i]);
			if(o instanceof java.util.Date){
				stmt.setDate(i+1, new java.sql.Date(((java.util.Date)o).getTime()));
			}else{
				stmt.setObject(i+1, o);
			}
		}
		stmt.setInt(fields.length+1, data.getId());
		stmt.executeUpdate();
	}
	
	@SuppressWarnings("unused")
	public void delete(Data data){
		Connection connection = null;
		PreparedStatement stmt = null;
		String query = deleteQuery(data);
		System.out.println(query);
	}
	private String deleteQuery(Data data) {
		String query = "delete from " + data.getClass().getSimpleName().toLowerCase();
		query += " where id" + data.getClass().getSimpleName().toLowerCase() + " = ?";
		return query;
	}
	
	public List<Data> findById(Data data,boolean recursive) throws Exception{
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Data> ret = null;
		try {
			connection = UtilDao.getConnection();
			String query = findByIdQuery(data, recursive);
			System.out.println(query);
			stmt = connection.prepareStatement(query);
			ret = executeFindById(data, stmt);
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}finally{
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
		}
		return ret;
	}
	String findByIdQuery(Data data,boolean recursive) throws InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, InvocationTargetException{
		String query = "select * from "+data.getClass().getSimpleName().toLowerCase();
		/**
		 * Si l'id est renseigné (!=0) alors on ajoute le critère de recherche sur la clé primaire
		 */
		if(data.getId() != 0){
			query += " where id"+data.getClass().getSimpleName().toLowerCase()+" = ?";
		}
		/**
		 * De même pour les autres attributs
		 */
		Field[] fields = data.getClass().getDeclaredFields();
		for(Field item : fields){
			if(!Util.checkIfDefault(getValue(data, item))){
				if(query.contains("where")) query += " and ";
				else query += " where ";
				if(getValue(data, item) instanceof String){
					query += item.getName() + " like '%'||?||'%'";
				}else{
					query += item.getName() + " = ?";
				}
				System.out.println(item.getName()+ " " +Util.checkIfDefault(getValue(data, item)));
			}
			
		}
		return query;
	}
	List<Data> executeFindById(Data data,PreparedStatement stmt) throws SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		int counter = 1;
		if(data.getId() != 0){
			stmt.setInt(1, data.getId());
			counter ++;
		}
		Field[] field = data.getClass().getDeclaredFields();
		
		for(Field item : field){
			System.out.println(item.getName()+" "+Util.checkIfDefault(getValue(data, item))+" = "+getValue(data, item));
			if(!Util.checkIfDefault(getValue(data, item))){
				Method methodSet = stmt.getClass().getMethod("set"+item.getType().getSimpleName(),int.class, getValue(data, item).getClass());
				methodSet.setAccessible(true);
				methodSet.invoke(stmt, counter, getValue(data, item));
				counter++;
			}
		}
		ResultSet res = stmt.executeQuery();
		List<Data> list = new ArrayList<Data>();
		while(res.next()){
			Data temp = data.getClass().newInstance();
			Field[] fields = temp.getClass().getDeclaredFields();
			for(Field item : fields){
				Method methodSet = temp.getClass().getMethod("set"+Util.toUpperFirst(item.getName()),item.getType());
				if(item.getType().getSuperclass() == Data.class){
					
				}else if(item.getType().getSuperclass() == List.class){
					
				}else{
					Method methodGetRes = res.getClass().getMethod("get"+item.getType().getSimpleName(), String.class);
					Object o = methodGetRes.invoke(res, item.getName());
					methodSet.invoke(temp, o);
				}
				
			}
			list.add(temp);
		}
		return list;
	}
}

