package common;

import java.util.Date;

public class Deal {
    private int id;
    private Date dateCreated;
    private int statusId;
    private int clientId;
    private int productId;
    private String comment;

    public Deal(int id, Date dateCreated, int statusId, int clientId, int productId, String comment) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.statusId = statusId;
        this.clientId = clientId;
        this.productId = productId;
        this.comment = comment;
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
