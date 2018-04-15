package common;

public class Status {
    private int id;
    private String keyName;
    private String name;

    public Status(int id, String keyName, String name) {
        this.id = id;
        this.keyName = keyName;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
