
public class Library
{
    private Book books [];
    private int total;
    
    public Library(int totalIn)
    {
        books = new Book [totalIn];
        total = 0;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public boolean isFull()
    {
        if(total == books.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isEmpty()
    {
        if(total == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean add(Book bookIn)
    {
        if(isFull() == false)
        {
            books[total] = bookIn;
            total++;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String list()
    {
        String tempString = "";
        
        if(isEmpty() == true)
        {
            return tempString; //in application class use if statement to check if tempstring.equals("")
        }
        else
        {
            for(int i = 0; i < total; i++)
            {
                tempString = tempString + "\n\nBook ISBN: " + books[i].getBookISBN() + 
                "\nAuthor: " + books[i].getAuthor() + "\nTitle: " + books[i].getBookTitle() +
                "\nBook Cost: " + books[i].getBookCost() + "\nOnLoan? " + books[i].getLoanStatus();
            }
            return tempString;
        }
        
    }
    
    private int search(String ISBNIn)
    {
        for(int i = 0; i < total; i++)
        {
            if(books[i].getBookISBN().equals(ISBNIn))
            {
                return i;
            }
        }
        return -999;
    }
    
    public Book getItem(String ISBNIn)
    {
        if(search(ISBNIn) == -999)
        {
           return null; 
        }
        else
        {
           return books[search(ISBNIn)];
        }
        
    }
    
    public boolean remove(String ISBNIn)
    {
        if(search(ISBNIn) == -999)
        {
            return false;
        }
        else
        {
            for(int i = search(ISBNIn); i < total-1; i++)
            {
                books[i] = books[i+1];
            }
            total--;
            return true;
        }
    }
}