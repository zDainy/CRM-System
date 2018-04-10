package common;

public class Client {
    private int id;
    private String fio;
    private String address;
    private String phone;
    private String passport;

    public Client(int id, String fio, String address, String phone, String passport) {
        this.id = id;
        this.fio = fio;
        this.address = address;
        this.phone = phone;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
