import java.util.Scanner;

public class Main {
    static Book[] books = new Book[20];

    static void available(){
        System.out.println("\nAVAILABLE:");
        for(Book b : books){
            if(b == null || b.isCheckedOut){
                continue;
            }
            System.out.printf("ID: %d - %s, %s\n", b.id, b.title, b.isbn);
        }
        String command = "start";
        Scanner in = new Scanner(System.in);
        while(!command.equalsIgnoreCase("X")){
            System.out.println("""
C - to check out a book.
X - to exit this screen.
                    """);
            command = in.nextLine().trim();
            if(command.equalsIgnoreCase("X")){
                return; //exit function immediately.
            }else if(command.equalsIgnoreCase("C")) {
                System.out.println("Enter book id: ");
                int id = in.nextInt();
                in.nextLine(); // throw away trailing new line
                for (Book b : books) {
                    if (b.id == id) {
                        System.out.println("Enter your name: ");
                        String name = in.nextLine().trim();
                        b.checkOut(name);
                        break;
                    }
                }
            }//end else if
        }//end while
    }
    static void checkedOut(){
        System.out.println("\nCHECKED-OUT:");
        for(Book b : books){
            if(b == null || !b.isCheckedOut){
                continue;
            }
            System.out.printf("%d - %s, %s\n", b.id, b.title, b.checkedOutTo);
        }
        String command = "start";
        Scanner in = new Scanner(System.in);
        while(!command.equalsIgnoreCase("X")){
            System.out.println("""
C - to check in a book.
X - to exit this screen.
                    """);
            command = in.nextLine().trim();
            if(command.equalsIgnoreCase("X")){
                return; //exit function/method immediately
            }else if(command.equalsIgnoreCase("C")) {
                System.out.println("Enter id of book to check in: ");
                int id = in.nextInt();
                if (!command.isEmpty()) {
                    for (Book b : books) {
                        if (b.id == id) {
                            b.checkIn();
                            break;//exit loop
                        }
                    }
                }
            }else{
                System.out.println("No such command at this level: " + command);
            }
        }
    }
    public static void main(String[] args) {
        books[0] = new Book(101,"53975375970", "Spongebob");
        books[1] = new Book(102,"53975375971", "Cooking Guides");
        books[2] = new Book(103,"53975375972", "Finances");
        books[3] = new Book(104,"53975375973", "Baking Guides");
        books[4] = new Book(105,"53975375974", "Racing History");
        books[5] = new Book(106,"53975375975", "Murder Mystery");
        books[6] = new Book(107,"53975375976", "Thrillers");
        books[7] = new Book(108,"53975375977", "Music History");
        books[8] = new Book(109,"53975375978", "Gaming Guides");
        books[9] = new Book(110,"53975375979", "Combat Techniques");
        books[10] = new Book(111,"53975375980", "Rockstar History");
        books[11] = new Book(112,"53975375981", "Golf Guides");
        books[12] = new Book(113,"53975375982", "Knitting Guide");
        books[13] = new Book(114,"53975375983", "Fishing Guide");
        books[14] = new Book(115,"53975375984", "How to Paint");
        books[15] = new Book(116,"53975375985", "Halloween Costumes");
        books[16] = new Book(117,"53975375986", "Music Theory");
        books[17] = new Book(118,"53975375987", "How to Draw Art");
        books[18] = new Book(119,"53975375988", "Building Guides");
        books[19] = new Book(120,"53975375989", "Dogs and Cats");


//        books[1].checkOut("Kevin");
//        available();
//        checkedOut();
        Scanner in = new Scanner(System.in);
        int command = -1;
        while(command != 0) {
            System.out.println("\nMAIN MENU:");
            System.out.print("""
                    1 - Show Available Books
                    2 - Show Checked Out Books
                    0 - Exit - closes out of the application
                    """);
            command = in.nextInt();
            if (command == 0) {
                break; // exit loop right now!!!
            } else if (command == 1) {
                //show available plus menu
                available();
            } else if (command == 2) {
                //show checked out plus menu
                checkedOut();
            } else {
                //no such command
                System.out.println("no such command: " + command);
            }
        }//end outer while loop
        System.out.println("Pleasure doing business with you!");
    }//end main program
}