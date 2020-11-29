package mariadbcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariadbcrud.model.User;

public class UserDao implements Dao<User> {

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO user(name, email, username, passwd) VALUES (?, ?, ?, ?)";
        try (Connection conexao = ConnectionFactory.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User update(User user) {
        final String sql = "update user set name = ?, email = ?, username = ?, passwd = ? where id = ?";

        try (Connection conexao = ConnectionFactory.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }

    @Override
    public void delete(Integer id) {

        final String sql = "delete from user where id = %d";

        try (Connection conexao = ConnectionFactory.getConexao();
                Statement statement = conexao.createStatement()) {

            String insertContato = String.format(sql, id);

            statement.execute(insertContato);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, "Erro ao excluir user.", ex);
        }

    }

    @Override
    public User findById(Integer id) {
        final String sql = "select name, email, username, passwd from user where id = %d";
        User user = new User();

        try (Connection conexao = ConnectionFactory.getConexao();
                Statement statement = conexao.createStatement();) {

            ResultSet resultSet = statement.executeQuery(String.format(sql, id));

            if (resultSet.next()) {
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("passwd"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        final String sql = "select name, email, username, passwd from user";
        List<User> users = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConexao();
                Statement statement = conexao.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("passwd"));

                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, "Falha ao consultar a entidade user.", ex);
        }

        return users;

    }
}
