public class Kendaraan {
    String brand;
    int year;
    float harga;
    String VechileType;


    void ShowDetail(String brand, int year, String VechileType, float harga){
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Type: " + VechileType);
        System.out.println("Harga: " + harga);
    }
}

