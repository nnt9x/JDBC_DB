import java.sql.*;

public class ProductDB {
    // Có nhiệm vụ kết nối, truy vấn đến CSDL
    private static String URL_CONNECTION = "jdbc:mysql://localhost:8889/my_store"; // Mac dinh port 3306
    private static String USER_NAME = "root";
    private static String PASSWORD = "root"; // Neu dung xampp, mac dinh pass rong ""

    public ProductDB() {

    }

    public void insertBaseProduct(String name, String description, int price) throws SQLException {
        // Ket noi den CSDL
        Connection conn = DriverManager.getConnection(URL_CONNECTION, USER_NAME, PASSWORD);

        // Tao lenh sql va thuc thi
        String sql = String.format("INSERT INTO products (name, description, price) VALUES ('%s','%s',%d)", name, description, price);

        Statement stmt = conn.createStatement();
        // execute update: insert, update, delete
        int rs = stmt.executeUpdate(sql);
        // Xem ket qua sau thi thuc thi -> in ra thong tin
        if (rs != 0) {
            System.out.println("Thêm thành công!");
        }
        // Đóng kết nối
        conn.close();
    }
    public void getProductDetails() throws SQLException {
        // Ket noi den CSDL
        Connection conn = DriverManager.getConnection(URL_CONNECTION, USER_NAME, PASSWORD);
        // Tao lenh sql va thuc thi
        String sql = "SELECT * FROM product_details";

        Statement stmt = conn.createStatement();
        // SELECT: dung executeQuery -> tra ve ket qua
        ResultSet resultSet = stmt.executeQuery(sql);
        if(!resultSet.next()){
            System.out.println("Không có dữ liệu!");
            return;
        }
        System.out.println("ID \t Name \t PRICE \t IMAGE_URL \t COLOR");
        do{
            System.out.print(resultSet.getInt("product_id") +"\t");
            System.out.print(resultSet.getString("name") +"\t");
            System.out.print(resultSet.getInt("price") +"\t");
            System.out.print(resultSet.getString("image_url") +"\t");
            System.out.println(resultSet.getString("color"));
        }
        while (resultSet.next());
    }


}
