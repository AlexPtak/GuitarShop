package entities;

import dao.Entity;

import java.sql.JDBCType;

public class Guitar implements Entity {

    public static final String TABLE = "guitar_shop.guitar";

    public static final int ID = 0;
    public static final int MODEL = 1;
    public static final int PRICE = 2;
    public static final int COUNTRY = 3;
    public static final int COLOR = 4;
    public static final int NUMBER_OF_STRINGS = 5;
    public static final int NUMBER_OF_FRETS = 6;
    public static final int STATUS_ID = 7;
    public static final int COLUMNS_COUNT = 8;

    private static final String[] COLUMNS = {"id_guitar", "model", "price", "country", "color", "number_of_strings", "number_of_frets", "id_status"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.VARCHAR, JDBCType.DOUBLE, JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.SMALLINT, JDBCType.SMALLINT, JDBCType.INTEGER};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public String getMedel() {
        return (String) values[MODEL];
    }

    public void setModel(String model) {
        values[MODEL] = model;
    }

    public Double getPrice() {
        return (Double) values[PRICE];
    }

    public void setPrice(String price) {
        values[PRICE] = price;
    }

    public String getCountry() {
        return (String) values[COUNTRY];
    }

    public void setCountry(String country) {
        values[COUNTRY] = country;
    }

    public String getColor() {
        return (String) values[COLOR];
    }

    public void setColor(String color) {
        values[COLOR] = color;
    }

    public Integer getNumberOfFrets() {
        return (Integer) values[NUMBER_OF_FRETS];
    }

    public void setNumberOfFrets(Integer numberOfFrets) {
        values[NUMBER_OF_FRETS] = numberOfFrets;
    }

    public Integer getNumberOfStrings() {
        return (Integer) values[NUMBER_OF_STRINGS];
    }

    public void setNumberOfStrings(Integer numberOfStrings) {
        values[NUMBER_OF_STRINGS] = numberOfStrings;
    }

    public Integer getStatusId() {
        return (Integer) values[STATUS_ID];
    }

    public void setStatusId(Integer statusId) {
        values[STATUS_ID] = statusId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getId() + " " + getMedel() + " " + getMedel() + " " + getPrice() + " " + getCountry() + " " + getColor() + " " + getNumberOfFrets() + " " + getNumberOfStrings() + " " + getStatusId());
        return builder.toString();
    }

    @Override
    public String getTable() {
        return TABLE;
    }

    @Override
    public String[] getCulums() {
        return COLUMNS;
    }

    @Override
    public Object[] getValues() {
        return values;
    }

    @Override
    public JDBCType[] getTypes() {
        return TYPES;
    }

    @Override
    public Entity getEmptyEntity() {
        return new Guitar();
    }
}
