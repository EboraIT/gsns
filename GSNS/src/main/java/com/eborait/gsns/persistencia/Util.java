package com.eborait.gsns.persistencia;

public class Util {
	
	private Util() {
		
	}
	
	public static final String getSQLCriteria(String selectCriteria, String criteria, String value) {
		String sql = "";
		if (criteria == null) {
			sql = selectCriteria;
		} else {
			try {
				Integer.parseInt(value);
				sql = String.format("%s WHERE %s = %s", selectCriteria, criteria, value);
			} catch (NumberFormatException nfe) {
				sql = String.format("%s WHERE %s = '%s'", selectCriteria, criteria, value);
			}
		}
		return sql;
	}
}
