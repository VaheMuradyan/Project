enum RoomType {
    SingleRoom(20,"Single room, Bathroom, TV, Closet"),
    DoubleRoom(35,"Double room, Bathroom, TV, Closet"),
    DeluxeRoom(55,"Minibar, Bathrub, King-Size bed, Sitting area");
    private final double price;
    private final String info;
    RoomType(double price, String info){
        this.price = price;
        this.info = info;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }
}
