package entity;

import dto.GuitarInPurchaseDto;

import java.sql.JDBCType;

public class GuitarInPurchase implements Entity {

    private static final String TABLE = "guitar_shop.guitar_in_the_bucket";

    private static final int PURCHASE_ID = 0;
    private static final int GUITAR_ID = 1;
    private static final int COUNT = 2;
    private static final int COLUMNS_COUNT = 3;

    private static final String[] COLUMNS = {"id_purchase", "id_guitar", "count"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.INTEGER, JDBCType.SMALLINT};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getPurchaseId() {
        return (Integer) values[PURCHASE_ID];
    }

    public void setPurchaseId(Integer id) {
        values[PURCHASE_ID] = id;
    }

    public Integer getGuitarId() {
        return (Integer) values[GUITAR_ID];
    }

    public void setGuitarId(Integer id) {
        values[GUITAR_ID] = id;
    }

    public Integer getCount() {
        return (Integer) values[COUNT];
    }

    public void setCount(Integer count) {
        values[COUNT] = count;
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
        return new GuitarInPurchase();
    }

    @Override
    public GuitarInPurchaseDto createDto() {
        GuitarInPurchaseDto guitarInPurchaseDto = new GuitarInPurchaseDto();
        guitarInPurchaseDto.setPurchaseId((Integer) values[PURCHASE_ID]);
        guitarInPurchaseDto.setGuitarId((Integer) values[GUITAR_ID]);
        guitarInPurchaseDto.setCount((Integer) values[COUNT]);
        return guitarInPurchaseDto;
    }
}
