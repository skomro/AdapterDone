package _todoInSection;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.Student;

/**
 * StudentCollection is a collection class that keeps track of all our students.
 * 
 * @author Jorge Vergara, Rick Mercer, and Jeremy Mowery
 *         (jermowery@email.arizona.edu)
 * 
 */
// TODO 1: Adapt this class to a TableModel with the methods JTable needs.
// You can Google the methods or let Eclipse write the method stubs for you
// (after adding implements ListModel to the class heading).
//
// Note: Some ListModel need not be implemented.
public class StudentCollection implements TableModel {

	private List<Student> theStudents;

	@Override
	public int getRowCount() {
		return this.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String result="";
		if(columnIndex==0)
			result = "Name";
		else if(columnIndex ==1)
			result = "Major";
		else if(columnIndex==2)
			result = "GPA";
		else
			result = "Age";
		return result;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> result;
		if(columnIndex==0)
			result = String.class;
		else if(columnIndex ==1)
			result = String.class;
		else if(columnIndex==2)
			result = double.class;
		else
			result = int.class;
		return result;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex==0)
			return theStudents.get(rowIndex).getName();
		else if(columnIndex==1)
			return theStudents.get(rowIndex).getMajor();
		else if(columnIndex==2)
			return theStudents.get(rowIndex).getGPA();
		else if(columnIndex==3)
			return theStudents.get(rowIndex).getAge();
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
	}

	/**
	 * The constructor for a StudentCollection. Initializes the list of
	 * students.
	 */
	public StudentCollection() {
		theStudents = new ArrayList<Student>();
		setUpDefaultList();
	}

	/**
	 * Initializes the list with a few hard-coded students
	 */
	private void setUpDefaultList() {
		theStudents.add(new Student("Kim", "Computer Science", 4.0, 23));
		theStudents.add(new Student("Chris", "Computer Science", 4.0, 23));
		theStudents.add(new Student("Devon", "Math", 2.7, 21));
		theStudents.add(new Student("Ashley", "Biology", 3.29, 27));
		theStudents.add(new Student("Taylor", "Economics", 3.9, 25));
		theStudents.add(new Student("Chris", "Economics", 3.8, 19));
		theStudents.add(new Student("Dakota", "Psychology", 1.99, 22));
	}

	public int size() {
		return theStudents.size();
	}

	public void add(Student newStudent) {
		theStudents.add(newStudent);
	}

	public Student get(int index) {
		return theStudents.get(index);
	}

	public Student getFirstStudentWithName(String name) {
		for (int index = 0; index < size(); index++) {
			if (name.equals(theStudents.get(index).getName()))
				return theStudents.get(index);
		}
		return null; // not found
	}

}
