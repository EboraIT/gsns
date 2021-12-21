package com.eborait.gsns;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.eborait.gsns.persistencia.AgenteBD;

public class Utilidades {

	public final static int max() throws SQLException {
		int max = 0;
		Collection<Collection<Object>> data = AgenteBD.getAgente()
				.select("SELECT coalesce(max(id), 0) FROM vacunacion");
		for (Collection<Object> collection : data) {
			ArrayList<Object> rowData = (ArrayList<Object>) collection;
			max = Integer.parseInt(rowData.get(0).toString());
		}
		return max;
	}
}
