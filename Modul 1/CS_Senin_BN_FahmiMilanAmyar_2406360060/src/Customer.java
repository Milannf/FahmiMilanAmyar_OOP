public class Customer{
    Kendaraan Kendaraan;
    String name;

    void showDetail(String name, Kendaraan kendaraan){
        System.out.println("Name: " + name);
        System.out.println("Brand: " + kendaraan.brand);
        System.out.println("Year: " + kendaraan.year);
        System.out.println("Type: " + kendaraan.VechileType);
        System.out.println("Harga: " + kendaraan.harga);
    }

    void getTotalPrice(){

    }

}
