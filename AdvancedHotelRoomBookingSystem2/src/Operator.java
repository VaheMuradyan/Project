import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Operator {
    public static void main(String[] args){
        Customer customer = new Customer("Vahe");
        Customer customer1 = new Customer("Arshak");
        Room room = new Room(RoomType.DeluxeRoom);
        Room room1 = new Room(RoomType.SingleRoom);
        Hotel hotel = Hotel.getINSTANCE();
        hotel.addRoom(room);
        hotel.addCustomer(customer);
        hotel.addRoom(room1);
        hotel.addCustomer(customer1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date checkIn1 = dateFormat.parse("2023-07-23");
            Date checkOut1 = dateFormat.parse("2023-07-30");
            hotel.addBooking(customer, room, checkIn1, checkOut1);
        }catch(ParseException e){ }

        try {
            Date checkIn2 = dateFormat.parse("2023-07-24");
            Date checkOut2 = dateFormat.parse("2023-07-26");
            hotel.addBooking(customer1, room1, checkIn2, checkOut2);
        }catch(ParseException e){ }
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        hotel.saveState(path);

    }
}