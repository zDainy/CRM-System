package dao;

import common.Client;
import common.DBService;
import common.Global;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class ClientDao {

    public static void createClient(String fio, String address, String phone, String passport) {
        try {
            PreparedStatement statement = DBService.getConnection().prepareStatement(
                    "INSERT INTO client (fio, address, phone, passport)" +
                            " VALUES (?, ?, ?, ?, ?);"
            );
            statement.setString(1, fio);
            statement.setString(2, address);
            statement.setString(3, phone);
            statement.setString(4, passport);
            statement.executeQuery();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static Client getClient(int id) {
        String fio = "";
        String address = "";
        String phone = "";
        String passport = "";
        try {
            PreparedStatement statement = DBService.getConnection().prepareStatement(
                    "SELECT fio, address, phone, passport FROM client " +
                            " WHERE id = ?;"
            );
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                fio = res.getString("fio");
                address = res.getString("address");
                phone = res.getString("phone");
                passport = res.getString("passport");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return new Client(id, fio, address, phone, passport);
    }

    public static ArrayList<Client> getClients() {
        ArrayList<Client> clients = new ArrayList<>();
        int id;
        String fio;
        String address;
        String phone;
        String passport;
        try {
            PreparedStatement statement = DBService.getConnection().prepareStatement(
                    "SELECT id, fio, address, phone, passport FROM client"
            );
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                id = res.getInt("id");
                fio = res.getString("fio");
                address = res.getString("address");
                phone = res.getString("phone");
                passport = res.getString("passport");
                clients.add(new Client(id, fio, address, phone, passport));
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return clients;
    }
}
