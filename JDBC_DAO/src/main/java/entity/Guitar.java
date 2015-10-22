package entity;

import dto.GuitarDto;

import java.sql.JDBCType;

public class Guitar implements Entity {

    private static final String TABLE = "guitar_shop.guitar";

    private static final int ID = 0;
    private static final int MODEL = 1;
    private static final int PRICE = 2;
    private static final int COUNTRY = 3;
    private static final int COLOR = 4;
    private static final int NUMBER_OF_STRINGS = 5;
    private static final int NUMBER_OF_FRETS = 6;
    private static final int STATUS_ID = 7;
    private static final int BRAND_ID = 8;
    private static final int TYPE_ID = 9;
    private static final int COLUMNS_COUNT = 10;

    private static final String[] COLUMNS = {
            "id_guitar",
            "model",
            "price",
            "country",
            "color",
            "number_of_strings",
            "number_of_frets",
            "id_guitar_status",
            "id_guitar_brand",
            "id_guitar_type"
    };
    private static final JDBCType[] TYPES = {
            JDBCType.INTEGER,
            JDBCType.VARCHAR,
            JDBCType.DOUBLE,
            JDBCType.VARCHAR,
            JDBCType.VARCHAR,
            JDBCType.SMALLINT,
            JDBCType.SMALLINT,
            JDBCType.INTEGER,
            JDBCType.INTEGER,
            JDBCType.INTEGER
    };
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

    public Integer getBrandId() {
        return (Integer) values[BRAND_ID];
    }

    public void setBrandId(Integer brandId) {
        values[BRAND_ID] = brandId;
    }

    public Integer getTypeId() {
        return (Integer) values[TYPE_ID];
    }

    public void setTypeId(Integer typeId) {
        values[TYPE_ID] = typeId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getColumns().length; i++) {
            builder.append(getColumns()[i] + " - " + getValues()[i] + ";");
            builder.append("\n");
        }
        builder.append("------------------");
        return builder.toString();
    }

    @Override
    public String getTable() {
        return TABLE;
    }

    @Override
    public String[] getColumns() {
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

    @Override
    public Object createDto() {
        GuitarDto guitarDto = new GuitarDto();
        guitarDto.setGuitarId((Integer) values[ID]);
        guitarDto.setModel((String) values[MODEL]);
        guitarDto.setPrice((Double) values[PRICE]);
        guitarDto.setCountry((String) values[COUNTRY]);
        guitarDto.setColor((String) values[COLOR]);
        guitarDto.setNumberOfStrings((Integer) values[NUMBER_OF_STRINGS]);
        guitarDto.setNumberOfFrets((Integer) values[NUMBER_OF_FRETS]);
        guitarDto.setGuitarStatusId((Integer) values[STATUS_ID]);
        guitarDto.setGuitarBrandId((Integer) values[BRAND_ID]);
        guitarDto.setGuitarTypeId((Integer) values[TYPE_ID]);
        return guitarDto;
    }
}
