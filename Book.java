package EnglishCenter;

public class Book {
    private String name;
    private double price;
    private int quantity;
    private String author;

    public Book(String name, double price, int quantity, String author) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}