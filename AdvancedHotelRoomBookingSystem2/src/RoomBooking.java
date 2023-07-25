import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

public class RoomBooking {
    Customer customer;
    Room room;
    DetaliedBill detaliedBill;

    public RoomBooking(Customer customer, Room room, Date checkIn, Date checkOut) {
        this.customer = customer;
        this.room = room;
        room.setCheckInDate(checkIn);
        room.setCheckOutDate(checkOut);
        generateDetaliedBill();
    }


    public Room getRoom() {
        return room;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(ChronoLocalDate.from((TemporalAccessor) room.getCheckOutDate()));
    }

    public void generateDetaliedBill(){
        int tiv = (int)((room.getCheckOutDate().getTime() - room.getCheckInDate().getTime()) / (24 * 60 * 60 * 1000));
        detaliedBill = new DetaliedBill(customer,room,tiv);
    }


}
