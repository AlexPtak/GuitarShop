package mysql;

import dao.Entity;
import dao.GuitarDao;

public class MySqlGuitarDao implements GuitarDao {

    /*
    @Override
    public Guitar read(int id) throws SQLException {
        String sql = "SELECT * FROM guitar_test.guitar WHERE id_guitar = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Guitar guitar = new Guitar();
        guitar.setId(resultSet.getInt("id_guitar"));
        guitar.setType(resultSet.getString("type"));
        guitar.setCountry(resultSet.getString("country"));
        return guitar;
    }

    @Override
    public List<Entity> getAll() throws SQLException {
        String sql = "SELECT * FROM guitar_test.guitar";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery();
        List<Entity> guitars = new ArrayList<Entity>();
        while (resultSet.next()) {
            Guitar guitar = new Guitar();
            guitar.setId(resultSet.getInt("id_guitar"));
            guitar.setType(resultSet.getString("type"));
            guitar.setCountry(resultSet.getString("country"));
            guitars.add(guitar);
        }
        return guitars;
    }*/
}
