import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void showMenu() {
        System.out.println("-----------MENU-----------");
        System.out.println("a) Thêm sản phẩm cơ bản\n" +
                "b) Thêm hình ảnh cho sản phẩm theo mã\n" +
                "c) Thêm bảng màu sản phẩm theo mã\n" +
                "d) Lấy toàn bộ dữ liệu trong bảng product_details và hiển thị.\n" +
                "e) Thoát");
    }

    public static void main(String[] args) throws SQLException {
        ProductDB productDB = new ProductDB();
        Scanner scanner = new Scanner(System.in);
        String option = "";
        do {
            showMenu();
            System.out.print("Nhap lua chon: ");
            option = scanner.nextLine();
            switch (option){
                case "a":
                    // Lay du lieu phia nguoi dung
                    System.out.print("Nhap ten san pham: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhap mo ta san pham: ");
                    String description = scanner.nextLine();
                    System.out.print("Nhap gia: ");
                    int price = Integer.parseInt(scanner.nextLine());
                    // Ket noi den DB -> insert
                    productDB.insertBaseProduct(name, description, price);
                    break;
                case "b":
                    break;
                case "c":
                    break;
                case "d":
                    productDB.getProductDetails();
                    break;
                case "e":
                    System.out.println("Kết thúc chương trình");
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }
        }
        while (option.compareTo("e") != 0);
        // Dong scanner
        scanner.close();
    }
}
