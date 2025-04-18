public class Book{
    int id;//- id: int
    String isbn;//- isbn: String
    String title;//- title: String
    boolean isCheckedOut;//- isCheckedOut: boolean
    String checkedOutTo;
    Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    void checkOut(String name){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }
    void checkIn(){
        this.checkedOutTo = ""; //clear
        this.isCheckedOut = false;
    }
    //TODO add getters and setters?


}
