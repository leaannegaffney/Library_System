
public class LibrarySystem
{
    public static void main(String args [])
    {
        int choice;
        System.out.print("What is the maximum number of books that can be stored in your library? ");
        Library bookWorm = new Library(EasyScanner.nextInt());

        do
        {
            System.out.println();
            System.out.println("1. Enter a new book: ");
            System.out.println("2. List all books: ");
            System.out.println("3. Check if library is empty: ");
            System.out.println("4. Check if library is full: ");
            System.out.println("5. Search for a book: ");
            System.out.println("6. Remove a book: ");
            System.out.println("7. Loan a book: ");
            System.out.println("8. Return a book: ");
            System.out.println("0. Quit: ");
            System.out.println();
            System.out.print("Enter choice [0 - 8]: ");
            choice = EasyScanner.nextInt();

            switch(choice)
            {
                case 1:
                addBook(bookWorm);
                break;

                case 2:
                listBook(bookWorm);
                break;

                case 3:
                isItEmpty(bookWorm);
                break;

                case 4:
                isItFull(bookWorm);
                break;

                case 5:
                searchBook(bookWorm);
                break;

                case 6:
                removeBook(bookWorm);
                break;

                case 7:
                loanBook(bookWorm);
                break;

                case 8:
                returnBook(bookWorm);
                break;

                case 0:
                System.out.println("Thank you for using the system");
                break;

                default:
                System.out.println("Error - Please enter choice [0 - 8]");
            }

        }
        while(choice != 0);
    }

    private static void addBook(Library bookWorm)
    {
        System.out.println();
        System.out.println("Enter the new book details."); 
        System.out.print("       ISBN number: ");
        String num = EasyScanner.nextString();
        System.out.print("       Author: ");
        String author = EasyScanner.nextString();
        System.out.print("       Title: ");
        String title = EasyScanner.nextString();
        System.out.print("       Cost: ");
        double cost = EasyScanner.nextDouble();

        Book book = new Book(num, author, title, cost);

        if(bookWorm.add(book) == false)
        {
            System.out.println();
            System.out.println("The array is full - your book has not been added"); 
        }
        else
        {
            System.out.println();
            System.out.println("Your book has been created"); 
        }
        System.out.println();
    }

    private static void listBook(Library bookWorm)
    {
        if(bookWorm.list().equals(""))
        {
            System.out.println();
            System.out.println("The library has no books"); 
        }
        else
        {
            System.out.println();
            System.out.println("The books that are in the library are: " + bookWorm.list());
        }
        System.out.println();
    }

    private static void isItEmpty(Library bookWorm)
    {
        if(bookWorm.isEmpty() == true)
        {
            System.out.println();
            System.out.println("The library is empty");
        }
        else
        {
            System.out.println();
            System.out.println("The library is not empty");
        }
        System.out.println();
    }

    private static void isItFull(Library bookWorm)
    {
        if(bookWorm.isFull() == true)
        {
            System.out.println();
            System.out.println("The library is full");
        }
        else
        {
            System.out.println();
            System.out.println("The library is not full");
        }
        System.out.println();
    }

    private static void searchBook(Library bookWorm)
    {
        System.out.println();
        System.out.print("Enter the ISBN number: ");
        String num = EasyScanner.nextString();
        System.out.println();

        Book book = bookWorm.getItem(num);

        if(book == null)
        {
            System.out.println("No book with this ISBN exists in the library");
        }
        else
        {

            System.out.println(book.toString());
        }
        System.out.println();
    }

    private static void removeBook(Library bookWorm)
    {
        System.out.println();
        System.out.print("Enter the ISBN number: ");
        String num = EasyScanner.nextString();
        if(bookWorm.remove(num) == false)
        {
            System.out.println();
            System.out.println("No book with ISBN " + num + " exists in the library");
        }
        else
        {
            System.out.println();
            System.out.print("Book removed");
            System.out.println();
        } 
    }

    private static void loanBook(Library bookWorm)
    {
        System.out.println();
        System.out.print("Enter the ISBN number: ");
        String num = EasyScanner.nextString();
        System.out.println();

        Book book = bookWorm.getItem(num);

        if(book == null)
        {
            System.out.println("No book with this ISBN exists in the library");
        }
        else
        {
            if(book.getLoanStatus().equals("not on loan"))
            {
                book.setLoanStatus("on loan");
                System.out.println("The book is available for loan and is now set to 'on loan'");
            }
            else
            {
                System.out.println("The book is already on loan");
            }
        }

    }
    private static void returnBook(Library bookWorm)
    {
        System.out.println();
        System.out.print("Enter the ISBN number: ");
        String num = EasyScanner.nextString();
        System.out.println();

        Book book = bookWorm.getItem(num);

        if(book == null)
        {
            System.out.println("No book with this ISBN exists in the library");
        }
        else
        {
            if(book.getLoanStatus().equals("on loan"))
            {
                book.setLoanStatus("not on loan");
                System.out.println("The book is now returned and back in the library");
            }
            else
            {
                System.out.println("The book is already in the library");
            }
        }

    }
}
