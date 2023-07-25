import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;
public class Hotel {
    private List<RoomBooking> roomBookings = new LinkedList<>();
    private List<Room> rooms = new LinkedList<>();
    private List<Customer> customers = new LinkedList<>();
    private static final Hotel INSTANCE = new Hotel();
    private Hotel() { }

    public static Hotel getINSTANCE() {
        return INSTANCE;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<RoomBooking> getRoomBookings() {
        return roomBookings;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    private boolean isRoomAvailable(Date checkIn, Date checkOut) {
        for (RoomBooking booking : roomBookings) {
            if (checkIn.before(booking.getRoom().getCheckOutDate()) || checkOut.after(booking.getRoom().
                    getCheckInDate())) {
                return false;
            }
        }
        return true;
    }

    public void addBooking(Customer customer,Room room, Date checkIn, Date checkOut) {
        if(isRoomAvailable(checkIn,checkOut)) {
            RoomBooking newBooking = new RoomBooking(customer, room, checkIn, checkOut);
            roomBookings.add(newBooking);
            customer.addRoomToHestory(room);
            room.addCustomerToHystory(customer);
            rooms.remove(room);
            System.out.println("Room booking done sucsesfuly " + newBooking.detaliedBill.showBill());
        }else{
            System.out.println("You can not book the room");
        }
    }

    public void releaseExpiredBookings() {
        List<RoomBooking> expiredBookings = new LinkedList<>();
        for (int i = 0; i < roomBookings.size(); i++) {
            if (roomBookings.get(i).isExpired()) {
                expiredBookings.add(roomBookings.get(i));
                rooms.add(roomBookings.get(i).getRoom());
            }
        }
        roomBookings.removeAll(expiredBookings);
    }


    public void saveState(String path) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < customers.size(); i++){
                bufferedWriter.write(customers.get(i).toString() + "\n");
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            for(int i = 0; i <  rooms.size(); i++){
                bufferedWriter.write(rooms.get(i).toString() + "\n");
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            for(int i = 0; i <  roomBookings.size(); i++){
                bufferedWriter.write(roomBookings.get(i).toString() + "\n");
            }
            bufferedWriter.write("\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){ }
    }


}
