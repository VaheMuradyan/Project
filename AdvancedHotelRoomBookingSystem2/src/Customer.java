import java.util.LinkedHashSet;
import java.util.Set;

public class Customer {
    private final String name;
    private String mail;
    private Set<String> bookingRooms = new LinkedHashSet<>();

    public Customer(String name) {
        this.name = name;
    }

    public void setMail(String mail){
        if(symbolTest(mail)){
            if(mailTest(mail)){
                this.mail = mail;
            }else{
                System.out.println("That is not corect mail");
            }
        }else{
            System.out.println("That is not corect mail");
        }
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public void addRoomToHestory(Room room){
        bookingRooms.add(room.toString());
    }

    private boolean symbolTest(String mail){
        int counter = 0;
        boolean b = false;
        char x = '@';
        for(char y : mail.toCharArray()){
            if(x == y) {
                counter++;
                b = true;
            }
        }
        if(counter > 1){
            b = false;
        }
        return b;
    }

    private boolean mailTest(String mail){
        String mails[] = {"mail.ru", "yahoo.com", "gmail.com", "outlook.com"};
        String arr[] = mail.split("@");
        boolean b = false;
        for(String end : mails){
            if(arr[1].equals(end)){
                b = true;
                break;
            }
        }
        return b;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", bookingRooms=" + bookingRooms +
                '}';
    }
}
