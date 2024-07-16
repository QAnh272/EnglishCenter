package EnglishCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class RegistrationForm{
	private BookList booklist;
	private JFrame frame;
    private JTextField nameField;
    private JTextField idField;
    private JTextField dobField;
    private JButton addButton;
    private JButton deleteButton;
    private JButton bookstoreButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private StudentManager studentManager;
    private BookStoreApp bookStoreApp;
    private boolean bookStoreAppOpen;

    public RegistrationForm() {
        studentManager = new StudentManager();
        bookStoreAppOpen = false;
        initialize();
        setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("Registration Form");
        frame.setBounds(100, 100, 710, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 676, 240);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nameLabel.setBounds(10, 66, 89, 32);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(132, 66, 235, 32);
        panel.add(nameField);
        nameField.setColumns(10);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        idLabel.setBounds(10, 108, 89, 34);
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(132, 108, 235, 34);
        panel.add(idField);
        idField.setColumns(10);

        JLabel dobLabel = new JLabel("DoB:");
        dobLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        dobLabel.setBounds(10, 152, 89, 34);
        panel.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(132, 152, 235, 34);
        panel.add(dobField);
        dobField.setColumns(10);





        addButton = new JButton("UPDATE");
        addButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        addButton.setBounds(392, 66, 129, 76);
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        deleteButton = new JButton("DELETE");
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        deleteButton.setBounds(537, 66, 129, 76);
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        bookstoreButton = new JButton("Go To BookStore");
        bookstoreButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        bookstoreButton.setBounds(392, 152, 274, 78);
        panel.add(bookstoreButton);
        
        JLabel lblNewLabel = new JLabel("Registration Form");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(0, 0, 676, 56);
        panel.add(lblNewLabel);
        
        bookstoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openBookStore();
                frame.dispose();
            }
        });
        
        frame.setVisible(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 261, 676, 304);
        frame.getContentPane().add(scrollPane);

        studentTable = new JTable();
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Name", "ID", "DoB",});
        studentTable.setModel(tableModel);
        scrollPane.setViewportView(studentTable);

        frame.setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText();
        int id = Integer.parseInt(idField.getText());
        String dob = dobField.getText();

        Student student = new Student(name, id, dob);
        studentManager.addStudent(student);

        tableModel.addRow(new Object[] { name, id, dob});

        clearFields();
    }

    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow >= 0) {
            int id = (int) studentTable.getValueAt(selectedRow, 1);
            Student student = findStudentById(id);
            if (student != null) {
                studentManager.removeStudent(student);
                tableModel.removeRow(selectedRow);
            }
        }
    }

    private Student findStudentById(int id) {
        ArrayList<Student> students = studentManager.getAllStudents();
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private void clearFields() {
        nameField.setText("");
        idField.setText("");
        dobField.setText("");
    }

    private void openBookStore() {
        if (!bookStoreAppOpen) {
            bookStoreAppOpen = true;
            frame.dispose(); // Đóng frame của RegistrationForm
            bookStoreApp = new BookStoreApp(); // Tạo một instance mới của BookStoreApp
            bookStoreApp.showApp(); // Hiển thị BookStoreApp
        }
    }
	public void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void showForm() {
		// TODO Auto-generated method stub
	}
}
