package EnglishCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

public class BookStoreApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton addToCartButton;
    private JButton payButton;
    private BookList bookList;
    private ArrayList<Book> cartBooks;

    public BookStoreApp() {
        bookList = new BookList();
        cartBooks = new ArrayList<>();
        initialize();
        addSampleBooks();
        updateTable(bookList.getBooks());
    }

    private void initialize() {
        // Create the main frame
        frame = 	new JFrame("BookStoreApp");
        frame.setBounds(100, 100, 710, 630);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Create the book list table
        tableModel = new DefaultTableModel(new Object[]{"Name", "Price", "Quantity", "Author"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 191, 676, 328);
        frame.getContentPane().add(scrollPane);

        // Create the search field
        searchField = new JTextField();
        searchField.setBounds(10, 138, 200, 43);
        frame.getContentPane().add(searchField);

        // Create the search button
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        searchButton.setBounds(220, 138, 110, 43);
        frame.getContentPane().add(searchButton);

        // Create the Add to Cart button
        addToCartButton = new JButton("Add to Cart");
        addToCartButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        addToCartButton.setBounds(366, 529, 155, 54);
        frame.getContentPane().add(addToCartButton);

        // Create the Pay button
        payButton = new JButton("Pay");
        payButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        payButton.setBounds(531, 529, 155, 54);
        frame.getContentPane().add(payButton);
        // Create the Book Store JLabel
        JLabel lblNewLabel = new JLabel("Book Store");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(10, 10, 676, 54);
        frame.getContentPane().add(lblNewLabel);
        // Create the Finding what you need JLabel
        JLabel lblNewLabel_1 = new JLabel("Finding what you need");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(10, 79, 285, 49);
        frame.getContentPane().add(lblNewLabel_1);
        



        // Add action listeners
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchBooks();
            }
        });

        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });

        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openBillFrame();
            }
        });


    }

    private void searchBooks() {
        String searchKeyword = searchField.getText();
        ArrayList<Book> searchResults = new ArrayList<>();

        for (Book book : bookList.getBooks()) {
            if (book.getName().toLowerCase().contains(searchKeyword.toLowerCase())) {
                searchResults.add(book);
            }
        }

        updateTable(searchResults);
    }

    private void updateTable(ArrayList<Book> books) {
        tableModel.setRowCount(0);

        for (Book book : books) {
            Object[] row = {book.getName(), book.getPrice(), book.getQuantity(), book.getAuthor()};
            tableModel.addRow(row);
        }
    }

    private void addToCart() {
        int selectedRowIndex = table.getSelectedRow();

        if (selectedRowIndex != -1) {
            Book selectedBook = bookList.getBooks().get(selectedRowIndex);

            if (selectedBook.getQuantity() > 0) {
                selectedBook.setQuantity(selectedBook.getQuantity() - 1);
                updateTable(bookList.getBooks()); // Cập nhật bảng để hiển thị số lượng sách còn lại
                cartBooks.add(selectedBook);
            } else {
                JOptionPane.showMessageDialog(frame, "Out of Stock");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No book selected");
        }
    }
    private void addSampleBooks() {
        Book book1 = new Book("Luyện thi IELTS", 10.99, 5, "JKRowl");
        Book book2 = new Book("Luyện thi TOEIC", 12.99, 3, "Nhiều tác giả");
        Book book3 = new Book("Những mẹo để thi IELTS", 8.99, 7, "Dale Carnegie");
        Book book4 = new Book("100 ngày với IELTS", 9.00, 7, "Fujiko Fujio");
        Book book5 = new Book("100 ngày với TOEIC", 9.00, 10, "Nhật Minh");

        bookList.addBook(book1);
        bookList.addBook(book2);
        bookList.addBook(book3);
        bookList.addBook(book4);
        bookList.addBook(book5);
    }
    
    private void openBillFrame() {
        JFrame billFrame = new JFrame("BillFrame");
        billFrame.setBounds(100, 100, 400, 300);
        billFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        billFrame.getContentPane().setLayout(new FlowLayout());

        JTextArea billTextArea = new JTextArea();
        billTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(billTextArea);
        scrollPane.setPreferredSize(new Dimension(350, 200));
        billFrame.getContentPane().add(scrollPane);

        double totalAmount = 0;
        for (Book book : cartBooks) {
            double bookTotal = book.getPrice();
            totalAmount += bookTotal;
            billTextArea.append(book.getName() + " - $" + bookTotal + "\n");
        }

        billTextArea.append("Total: $" + totalAmount);

        billFrame.setVisible(true);
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public void showApp() {
	    frame.setVisible(true);
	}

	public void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}

	public void toFront() {
		// TODO Auto-generated method stub
		
	}
}