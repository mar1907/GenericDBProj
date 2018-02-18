package bll;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;

public abstract class AbstractBLL {
	
	/**
	 * Create a JTable with the input data by reflecting over the type of the given list
	 * 
	 * @param objects the list of objects by which the JTable is created
	 * @return
	 */
	public JTable createTable(List<Object> objects){
		Class<?> type=objects.get(0).getClass();
		Vector<Object> columnNames=new Vector<Object>();
		for(Field field:type.getDeclaredFields()){
			columnNames.add(field.getName());
		}
		Vector<Vector<Object>> data=new Vector<Vector<Object>>();
		for(Object entry:objects){
			Vector<Object> row= new Vector<Object>();
			for(Field field:type.getDeclaredFields()){
				try {
					PropertyDescriptor pD=new PropertyDescriptor(field.getName(), type);
					Method method=pD.getReadMethod();
					Object value=method.invoke(entry);
					row.add(value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			data.add(row);
		}
		return new JTable(data, columnNames);
	}
	
}