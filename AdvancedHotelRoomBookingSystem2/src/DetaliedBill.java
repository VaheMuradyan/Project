class DetaliedBill {
    private Customer customer;
    private Room room;
    private int time;
    private double totalAmount;

    public DetaliedBill(Customer customer, Room room, int time) {
        this.customer = customer;
        this.room = room;
        this.time = time;
    }

    public String showBill(){
        totalAmountGeneration();
        String Bill = "Id: " + room.getId() + " " + room.getRoomType() + " " + customer.getMail() + " " +
                customer.getName() + " days: " + time + " " + totalAmount + "$";
        return Bill;
    }

    private void totalAmountGeneration(){
        double taxes = room.getRoomType().getPrice() * 20 / 100;
        taxes *= time;
        double price = room.getRoomType().getPrice() + taxes;
        double ServiceFees = price * 10 / 100;
        this.totalAmount =  price + ServiceFees;
    }
}
