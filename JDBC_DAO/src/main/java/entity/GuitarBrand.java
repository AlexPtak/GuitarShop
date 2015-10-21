package entity;

import dto.GuitarBrandDto;

import java.sql.JDBCType;

public class GuitarBrand implements Entity {

    private static final String TABLE = "guitar_shop.guitar_brand";

    private static final int ID = 0;
    private static final int BRAND = 1;
    private static final int COLUMNS_COUNT = 2;

    private static final String[] COLUMNS = {"id_guitar_brand", "brand"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.VARCHAR};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public String getBrand() {
        return (String) values[BRAND];
    }

    public void setBrand(String brand) {
        values[BRAND] = brand;
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
        return new GuitarBrand();
    }

    @Override
    public GuitarBrandDto createDto() {
        GuitarBrandDto guitarBrandDto = new GuitarBrandDto();
        guitarBrandDto.setBrandId((Integer) values[ID]);
        guitarBrandDto.setBrand((String) values[BRAND]);
        return guitarBrandDto;
    }
}
