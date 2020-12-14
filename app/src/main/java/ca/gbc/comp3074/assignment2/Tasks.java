package ca.gbc.comp3074.assignment2;

public class Tasks {

    public static final String TABLE_NAME = "TASKS";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "location";
    public static final String COLUMN_ADDRESS = "address";

    public static final String CREATE_TABLE =
            "CREATE TABLE Tasks (" + COLUMN_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT, "
            + COLUMN_ADDRESS + " TEXT)";

    private int id;
    private String name;
    private String address;

    public Tasks(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
