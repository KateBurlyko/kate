import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple Java program to connect to MySQL database running on localhost and
 * running SELECT and INSERT query to retrieve and add data.
 */
public class ConnectToMySQL {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:8889/wordpress";
    private static final String user = "root";
    private static final String password = "root";
    private static final String query = "select user_login from wordpress.wp_users";
    private static final String query1 = "select user_id from wordpress.wp_usermeta";
    private static final String query3 = "select user_id from wordpress.wp_comments";
    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public void addUsers(String userAdd, String role) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            rs = stmt.executeQuery(query);
            stmt.executeUpdate(userAdd);

            rs = stmt.executeQuery(query1);
            stmt.executeUpdate(role);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    public void deleteUsers(String userDel, String role, String delComment) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();

            rs = stmt.executeQuery(query3);
            stmt.executeUpdate(delComment);

            rs = stmt.executeQuery(query1);
            stmt.executeUpdate(role);

            rs = stmt.executeQuery(query);
            stmt.executeUpdate(userDel);


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

//    public void addAuthor() {
//        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
//                        "user_email) VALUES ('Author', MD5('1'), 'Author', 'author@author.com');",
//                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
//                        " VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"author\";b:1;}');");
//    }
//
//    public void deleteAuthor() {
//        deleteUsers("DELETE FROM wp_users WHERE user_login='Author'",
//                "DELETE FROM wp_usermeta WHERE user_id=" +
//                        "(SELECT ID FROM wp_users WHERE user_login='Author')",
//                "DELETE FROM wp_comments WHERE user_id=" +
//                        "(SELECT ID FROM wp_users WHERE user_login='Author')");
    //   }
//
//    public void addContributer() {
//        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
//                        "user_email) VALUES ('Contributer', MD5('1'), 'Contributer', 'Contributer@Contributer.com');",
//                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
//                        " VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:11:\"contributer\";b:1;}');");
//    }
//
//    public void deleteContributer() {
//        deleteUsers("DELETE FROM wp_users WHERE user_login='Contributer'",
//                "DELETE FROM wp_usermeta WHERE user_id=" +
//                        "(SELECT ID FROM wp_users WHERE user_login='Contributer')",
//                "DELETE FROM wp_comments WHERE user_id=" +
//                        "(SELECT ID FROM wp_users WHERE user_login='Contributer')");
//    }

    public void addEditor() {
        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
                        "user_email) VALUES ('Editor', MD5('1'), 'Editor', 'Editor@Editor.com');",
                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
                        " VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"editor\";b:1;}');");
    }

    public void deleteEditor() {
        deleteUsers("DELETE FROM wp_users WHERE user_login='Editor'",
                "DELETE FROM wp_usermeta WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Editor') LIMIT 40",
                "DELETE FROM wp_comments WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Editor')");
    }

//    public void addSubscriber() {
//        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, " +
//                        "user_email) VALUES ('Subscriber', MD5('1'), 'Subscriber', 'Subscraber@Subscraber.com');",
//                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
//                        " VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:10:\"subscriber\";b:1;}');");
//    }

//    public void deleteSubscriber() {
//        deleteUsers("DELETE FROM wp_users WHERE user_login='Subscriber'",
//                "DELETE FROM wp_usermeta WHERE user_id=" +
//                        "(SELECT ID FROM wp_users WHERE user_login='Subscriber')",
//                "DELETE FROM wp_comments WHERE user_id=" +
//                        "(SELECT ID FROM wp_users WHERE user_login='Subscriber')");
//    }


//    public void addPost() {
//        try {
//
//            String qu = "select post_author from wordpress.wp_posts";
//            String qu2 = "select post_author from wordpress.wp_posts";
//           String addPost="INSERT INTO wordpress.wp_posts (post_name, post_author, post_date, post_content, " +
//                    "post_title, post_status, post_type, comment_status, ping_status, post_modified, post_excerpt, to_ping, pinged," +
//                   "post_content_filtered, guid) VALUES ('fwefef',(SELECT ID FROM wp_users WHERE user_login='Author'), '2016-12-17 18:01:46', 'lkjhgfdsertyj " +
//                    "chgchgchcgh', 'hello2', 'draft', 'page', 'closed', 'closed', '2016-12-18 13:04:31', ' ', ' ', ' '," +
//                   "' ', 'http://localhost:8888/?p=83');";
//
//            String addMeta="INSERT INTO wordpress.wp_postmeta (post_id, meta_key, meta_value) VALUES ('83', '_wp_page_template', 'default');";
//            con = DriverManager.getConnection(url, user, password);
//            stmt = con.createStatement();
//
//            rs = stmt.executeQuery(qu);
//            stmt.executeUpdate(addPost);
//
//           rs = stmt.executeQuery(qu2);
//            stmt.executeUpdate(addMeta);
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException se) { /*can't do anything */ }
//            try {
//                stmt.close();
//            } catch (SQLException se) { /*can't do anything */ }
//            try {
//                rs.close();
//            } catch (SQLException se) { /*can't do anything */ }
//        }
//    }


}