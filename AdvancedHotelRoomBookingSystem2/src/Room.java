import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Random;
public class Room{
    private Date checkInDate;
    private  Date checkOutDate;
    private int id;
    private final RoomType roomType;
    private Set<String> customersHystory = new LinkedHashSet<>();
    private Hotel hotel = Hotel.getINSTANCE();

    public Room(RoomType roomType) {
        this.roomType = roomType;
        setId();
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    private void setId(){
        Random random = new Random();
        do {
            this.id = random.nextInt(1, Integer.MAX_VALUE);
        }while(idIsntFree(id));
    }

    private boolean idIsntFree(int id){
        boolean b = false;
        for(Room room : hotel.getRooms()){
            if(id == room.getId()){
                b = true;
            }
        }
        return b;
    }

    public int getId() {
        return id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void addCustomerToHystory(Customer customer){
        customersHystory.add(customer.toString());
    }

    @Override
    public String toString() {
        return "Room{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", id=" + id +
                ", roomType=" + roomType +
                ", customersHystory=" + customersHystory +
                ", hotel=" + hotel +
                '}';
    }
}
