
public class Main {
    public static void main(String[] args) {
        Kendaraan kendaraanSupraBapak = new Kendaraan();
        Kendaraan kendaraanKalcer = new Kendaraan();
        Kendaraan kendaraanGuede = new Kendaraan();

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();

        kendaraanSupraBapak.brand = "Honda Supra";
        kendaraanSupraBapak.year = 1998;
        kendaraanSupraBapak.VechileType = "Motor";
        kendaraanSupraBapak.harga = 3000;

        kendaraanKalcer.brand = "VW Beetle";
        kendaraanKalcer.year = 1998;
        kendaraanKalcer.VechileType = "Mobil";
        kendaraanKalcer.harga = 200000;

        kendaraanGuede.brand = "Isuzu Giga";
        kendaraanGuede.year = 2011;
        kendaraanGuede.VechileType = "Truck";
        kendaraanGuede.harga = 300000;

        System.out.println("--------------------");
        customer1.showDetail("Milan", kendaraanSupraBapak );
        System.out.println("--------------------");
        System.out.println("--------------------");
        customer2.showDetail("Jon", kendaraanKalcer);
        System.out.println("--------------------");
        System.out.println("--------------------");
        customer3.showDetail("Lan", kendaraanGuede);
        System.out.println("--------------------");
        System.out.println("--------------------");

    }
}