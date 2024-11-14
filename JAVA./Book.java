import java.util.Scanner;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}

class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;

    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    @Override
    public String toString() {
        return "Book[name=" + name + ", " + author + ", price=" + price + ", qtyInStock=" + qtyInStock + "]";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get author details from user
        System.out.print("Enter author's name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter author's email: ");
        String authorEmail = scanner.nextLine();

        System.out.print("Enter author's gender (M/F): ");
        char authorGender = scanner.next().charAt(0);
        scanner.nextLine(); // Consume newline character

        // Create Author object
        Author author = new Author(authorName, authorEmail, authorGender);

        // Get book details from user
        System.out.print("Enter book's name: ");
        String bookName = scanner.nextLine();

        System.out.print("Enter book's price: ");
        double bookPrice = scanner.nextDouble();

        System.out.print("Enter quantity in stock: ");
        int qtyInStock = scanner.nextInt();

        // Create Book object
        Book book = new Book(bookName, author, bookPrice, qtyInStock);

        // Display book details
        System.out.println(book);

        scanner.close();
    }
}
