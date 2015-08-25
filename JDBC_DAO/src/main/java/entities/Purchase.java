package entities;

import dao.Entity;

import java.sql.JDBCType;

public class Purchase implements Entity {

    private static final String TABLE = "guitar_shop.purchase";

    private static final int ID = 0;
    private static final int COUNT = 1;
    private static final int CUSTOMER_ID = 2;
    private static final int GUITAR_ID = 3;
    public static final int COLUMNS_COUNT = 4;

    private static final String[] COLUMNS = {"id_purchase", "count", "id_customer", "id_guitar"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.SMALLINT, JDBCType.INTEGER, JDBCType.INTEGER};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public Integer getCount() {
        return (Integer) values[COUNT];
    }

    public void setCount(Integer count) {
        values[COUNT] = count;
    }

    public Integer getCustomerId() {
        return (Integer) values[CUSTOMER_ID];
    }

    public void setIdCustomer(Integer idCustomer) {
        values[CUSTOMER_ID] = idCustomer;
    }

    public Integer getGuitarId() {
        return (Integer) values[GUITAR_ID];
    }

    public void setIdGuitar(Integer idGuitar) {
        values[GUITAR_ID] = idGuitar;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getId() + " " + getCount() + " " + getCustomerId() + " " + getGuitarId());
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
        return new Purchase();
    }
}
