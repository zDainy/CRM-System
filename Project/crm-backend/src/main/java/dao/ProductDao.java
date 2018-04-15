package dao;

import common.DBService;
import common.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {

    public static Product getProduct(int id) {
        String name = "";
        int price = 0;
        String imgSrc = "";
        try {
            PreparedStatement statement = DBService.getConnection().prepareStatement(
                    "SELECT name, price, img_src FROM product " +
                            " WHERE id = ?;"
            );
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                name = res.getString("name");
                price = res.getInt("price");
                imgSrc = res.getString("img_src");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return new Product(id, name, price, imgSrc);
    }

    public static ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        int id;
        String name;
        int price;
        String imgSrc;
        try {
            PreparedStatement statement = DBService.getConnection().prepareStatement(
                    "SELECT id, name, price, img_src FROM product"
            );
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                id = res.getInt("id");
                name = res.getString("name");
                price = res.getInt("price");
                imgSrc = res.getString("img_src");
                products.add(new Product(id, name, price, imgSrc));
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return products;
    }
}
