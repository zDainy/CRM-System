package common;

import dao.ClientDao;
import dao.DealDao;
import dao.ProductDao;

import java.util.Date;

public class Deal {
    private int id;
    private Date dateCreated;
    private int statusId;
    private int clientId;
    private int productId;
    private String comment;
    private String clientName;
    private String productName;
    private int price;
    private String statusName;

    public Deal(int id, Date dateCreated, int statusId, int clientId, int productId, String comment) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.statusId = statusId;
        this.clientId = clientId;
        this.productId = productId;
        this.comment = comment;
        searchClientName();
        searchProduct();
        searchStatus();
    }

    private void searchClientName() {
        this.clientName = ClientDao.getClient(this.clientId).getFio();
    }

    private void searchProduct() {
        Product p = ProductDao.getProduct(this.productId);
        this.productName = p.getName();
        this.price = p.getPrice();
    }

    private void searchStatus() {
        this.statusName = DealDao.getStatusName(this.statusId);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
