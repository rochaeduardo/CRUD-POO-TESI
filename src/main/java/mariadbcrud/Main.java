package mariadbcrud;

import mariadbcrud.dao.ConnectionFactory;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mariadbcrud.dao.UserDao;
import mariadbcrud.model.User;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        //  Criar 2 usuarios e exibir seus dados;
        User user = new User("Mariana Clarice Antonella Freitas", "marianaclariceantonellafreitas@live.com", "marina", "4567");
        User user2 = new User("Guilherme Lorenzo Martin Ramos", "guilhermelorenzomartinramos@celiosilva.com@email", "gui", "987");

        userDao.insert(user);
        userDao.insert(user2);
        System.out.println("Usuário 1: " + user);
        System.out.println("Usuário 2: " + user2);

        User usuario = userDao.findById(1);

        // Alaterar o email e username do primeiro usuario e exibir os dados alterados;
        User updateUser = new User(usuario.getName(), "marianafreitas@live.com", "mari", usuario.getPassword(), 1);
        userDao.update(updateUser);

        System.out.println("Usuário: " + usuario.getName() + " com username: " + usuario.getUserName() + " e e-mail:  " + usuario.getEmail() + " alterados para: " + updateUser.getUserName() + " e " + updateUser.getEmail());

        // Exibir a lista com os dois usuarios cadastrados
        List<User> todos = userDao.findAll();
        System.out.println(todos);

        // Remover os dois usuarios;
        userDao.delete(1);
        userDao.delete(2);

        // Exibir a lista de usuarios após remoção
        List<User> todos2 = userDao.findAll();
        System.out.println(todos2);

    }
}
