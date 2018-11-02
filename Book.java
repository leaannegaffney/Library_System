
public class Book
{
    private String ISBN;
    private String author;
    private String title;
    private double cost;
    private String loanStatus;
    
    public Book(String bookISBNIn, String authorIn,String titleIn, double costIn)
    {
        ISBN = bookISBNIn;
        author = authorIn;
        title = titleIn;
        cost = costIn;
        loanStatus = "not on loan";
    }
    
    public String getBookISBN()
    {
        return ISBN;
    }
    
    public void setBookISBN(String bookISBNIn)
    {
       ISBN = bookISBNIn; 
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setAuthor(String authorIn)
    {
       author = authorIn; 
    }
    
    public String getBookTitle()
    {
        return title;
    }
    
    public void setBookTitle(String bookTitleIn)
    {
       title = bookTitleIn; 
    }
    
    public double getBookCost()
    {
        return cost;
    }
    
    public void setBookCost(double bookCostIn)
    {
       cost = bookCostIn;
    }
    
    public String getLoanStatus()
    {
        return loanStatus;
    }
    
    public void setLoanStatus(String loanStatusIn)
    {
       loanStatus = loanStatusIn;
    }
    
    public String toString()
    {
        String allDetails = "ISBN: " + ISBN + ", title: " + title + ", author: " + 
        author + ", cost:€ " + cost + ", loan Status: " + loanStatus;
        return allDetails;
    }
    
}