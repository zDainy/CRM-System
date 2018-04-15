package dao;

import common.DBService;
import common.Deal;
import common.Global;
import common.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DealDao {

    public static void createDeal(int statusId, int clientId, int productId, String comment) {
        try {
            PreparedStatement statement = DBService.getConnection().prepareStatement(
                    "INSERT INTO deal (status_id, client_id, product_id, \"comment\")" +
                            " VALUES (?, ?, ?, ?);"
            );
            statement.setInt(1, statusId);
            statement.setInt(2, clientId);
            statement.setInt(3, productId);
            statement.setString(4, comment);
            statement.executeQuery();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static String getStatusName(int id) {
        String statusName = "";
        try {
            PreparedStatement statusStatement = DBService.getConnection().prepareStatement(
                    "SELECT name FROM deal_status " +
                            " WHERE id = ?;"
            );
            statusStatement.setInt(1, id);
            ResultSet res = statusStatement.executeQuery();
            if (res.next()) {
                statusName = res.getString("name");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return statusName;
    }

    public static ArrayList<Status> getStatuses() {
        ArrayList<Status> statuses = new ArrayList<>();
        int id;
        String name;
        String keyName;
        try {
            PreparedStatement statement = DBService.getConnection().prepareStatement(
                    "SELECT id, key_name, name FROM deal_status"
            );
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                id = res.getInt("id");
                name = res.getString("name");
                keyName = res.getString("key_name");
                statuses.add(new Status(id, keyName, name));
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return statuses;
    }

    public static void changeDealStatus(int id) {
        int statusId = 0;
        try {
            PreparedStatement statusStatement = DBService.getConnection().prepareStatement(
                    "SELECT status_id FROM deal " +
                            " WHERE id = ?;"
            );
            statusStatement.setInt(1, id);
            ResultSet res = statusStatement.executeQuery();
            if (res.next()) {
                statusId = res.getInt("status_id");
            }
            if (statusId != 5) {
                PreparedStatement statement = DBService.getConnection().prepareStatement(
                        "UPDATE deal SET status_id = ? " +
                                " WHERE id = ?;"
                );
                statement.setInt(1, statusId + 1);
                statement.setInt(2, id);
                statement.executeQuery();
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static ArrayList<Deal> getDeals(int minPriceFilter, int maxPriceFilter, int statusFilter, String clientName, String productName) {
        ArrayList<Deal> deals = new ArrayList<>();
        String query;
        int id;
        Date dateCreated;
        int statusId;
        int clientId;
        int productId;
        String comment;
        try {
            query = "SELECT id, date_created, status_id, client_id, product_id, \"comment\" FROM deal";

            query += " WHERE product_id IN (SELECT id FROM product WHERE price BETWEEN " + minPriceFilter + " AND " + maxPriceFilter + ")";

            if (statusFilter != -1) {
                query += " AND " + "status_id = " + statusFilter;
            }
            if (!clientName.equals(Global.NONE)) {
                query += " AND " + "client_id IN (SELECT id FROM client WHERE fio LIKE ('%" + clientName + "%'))";
            }
            if (!productName.equals(Global.NONE)) {
                query += " AND " + "product_id IN (SELECT id FROM product WHERE name LIKE ('%" + productName + "%'))";
            }

            ResultSet res = DBService.getConnection().createStatement().executeQuery(query);
            while (res.next()) {
                id = res.getInt("id");
                dateCreated = res.getDate("date_created");
                statusId = res.getInt("status_id");
                clientId = res.getInt("client_id");
                productId = res.getInt("product_id");
                comment = res.getString("comment");
                deals.add(new Deal(id, dateCreated, statusId, clientId, productId, comment));
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return deals;
    }
}
