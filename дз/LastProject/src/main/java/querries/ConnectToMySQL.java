package querries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class to connect to MySQL database running on localhost and
 * running SELECT and INSERT SELECT_TABLE_WP_USERS to delete and add data.
 */
public class ConnectToMySQL {
    // JDBC URL, username and PASSWORD of MySQL server
    private static final String URL = "jdbc:mysql://localhost:8889/wordpress";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String SELECT_TABLE_WP_USERS = "select user_login from wordpress.wp_users";
    private static final String SELECT_TABLE_WP_USERMETA = "select user_id from wordpress.wp_usermeta";
    private static final String SELECT_TABLE_WP_COMMENTS = "select user_id from wordpress.wp_comments";
    // JDBC variables for opening and managing connection
    private static Connection CONNECTION;
    private static Statement STATEMENT;
    private static ResultSet RESULTSET;

    /**
     * method which add user and his role to database
     * <p>
     * connection to database is open then add user, his role and  then close connection
     *
     * @param userAdd - variable for querry which add user to database
     * @param role    - variable for querry which add role for user in database
     */
    public void addUsers(String userAdd, String role) {
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
            STATEMENT = CONNECTION.createStatement();

            RESULTSET = STATEMENT.executeQuery(SELECT_TABLE_WP_USERS);
            STATEMENT.executeUpdate(userAdd);

            RESULTSET = STATEMENT.executeQuery(SELECT_TABLE_WP_USERMETA);
            STATEMENT.executeUpdate(role);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                CONNECTION.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                STATEMENT.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                RESULTSET.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    /**
     * method which add user and his role to database
     * <p>
     * connection to database is open then delete user, his role, comments, posts from
     * database and close connection
     *
     * @param userDel    - variable for querry which delete user to database
     * @param delRole    - variable for querry which delete role for user in database
     * @param delComment - variable for querry which delete comment of user in database
     * @param delPost    - variable for querry which delete post of user in database
     * @param delPost2   - variable for querry which delete post of user in database
     */
    public void deleteUsers(String userDel, String delRole, String delComment, String delPost, String delPost2) {
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
            STATEMENT = CONNECTION.createStatement();

            RESULTSET = STATEMENT.executeQuery(SELECT_TABLE_WP_COMMENTS);
            STATEMENT.executeUpdate(delComment);

            STATEMENT.executeUpdate(delPost);
            STATEMENT.executeUpdate(delPost2);

            RESULTSET = STATEMENT.executeQuery(SELECT_TABLE_WP_USERMETA);
            STATEMENT.executeUpdate(delRole);

            RESULTSET = STATEMENT.executeQuery(SELECT_TABLE_WP_USERS);
            STATEMENT.executeUpdate(userDel);


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                CONNECTION.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                STATEMENT.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                RESULTSET.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    /**
     * in method calls method in which execute queries which add Author and his role in database
     */
    public void addAuthor() {
        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, user_email)" +
                        "VALUES ('Author', MD5('1'), 'Author', 'author@author.com');",
                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
                        "VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"author\";b:1;}');");
    }

    /**
     * in method calls method in which execute queries which delete Author, his role,
     * his comments, his posts from database
     */
    public void deleteAuthor() {
        deleteUsers("DELETE FROM wp_users WHERE user_login='Author'",
                "DELETE FROM wp_usermeta WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Author')",
                "DELETE FROM wp_comments WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Author')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Editor')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Editor') AND post_title = 'Auto Draft'");
    }

    /**
     * in method calls method in which execute queries which add Editor and his role in database
     */
    public void addEditor() {
        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, user_email)" +
                        " VALUES ('Editor', MD5('1'), 'Editor', 'Editor@Editor.com');",
                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
                        " VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:6:\"editor\";b:1;}');");
    }

    /**
     * in method calls method in which execute queries which delete Editor, his role,
     * his comments, his posts from database
     */
    public void deleteEditor() {
        deleteUsers("DELETE FROM wp_users WHERE user_login='Editor'",
                "DELETE FROM wp_usermeta WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Editor') LIMIT 40",
                "DELETE FROM wp_comments WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Editor')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Editor')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Editor') AND post_title = 'Auto Draft'");

    }

    /**
     * in method calls method in which execute queries which add Contributer and his role in database
     */
    public void addContributer() {
        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename, user_email) " +
                        "VALUES ('Contributer', MD5('1'), 'Contributer', 'Contributer@Contributer.com');",
                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
                        " VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:11:\"contributer\";b:1;}');");
    }

    /**
     * in method calls method in which execute queries which delete Contributer, his role,
     * his comments, his posts from database
     */
    public void deleteContributer() {
        deleteUsers("DELETE FROM wp_users WHERE user_login='Contributer'",
                "DELETE FROM wp_usermeta WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Contributer')",
                "DELETE FROM wp_comments WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Contributer')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Contributer')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Contributer') AND post_title = 'Auto Draft'");
    }


    /**
     * in method calls method in which execute queries which add Subscriber and his role in database
     */
    public void addSubscriber() {
        addUsers("INSERT INTO wordpress.wp_users (user_login, user_pass, user_nicename," +
                        "user_email) VALUES ('Subscriber', MD5('1'), 'Subscriber', 'Subscraber@Subscraber.com');",
                "INSERT INTO wordpress.wp_usermeta (user_id, meta_key, meta_value)" +
                        " VALUES (LAST_INSERT_ID(), 'wp_capabilities', 'a:1:{s:10:\"subscriber\";b:1;}');");
    }

    /**
     * in method calls method in which execute queries which delete Subscriber, his role,
     * his comments, his posts from database
     */
    public void deleteSubscriber() {
        deleteUsers("DELETE FROM wp_users WHERE user_login='Subscriber'",
                "DELETE FROM wp_usermeta WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Subscriber')",
                "DELETE FROM wp_comments WHERE user_id=" +
                        "(SELECT ID FROM wp_users WHERE user_login='Subscriber')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Subscriber')",
                "DELETE FROM wordpress.wp_posts WHERE post_author = " +
                        "(SELECT ID FROM wp_users WHERE user_login = 'Subscriber') AND post_title = 'Auto Draft'");
    }


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
//            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
//            STATEMENT = CONNECTION.createStatement();
//
//            RESULTSET = STATEMENT.executeQuery(qu);
//            STATEMENT.executeUpdate(addPost);
//
//           RESULTSET = STATEMENT.executeQuery(qu2);
//            STATEMENT.executeUpdate(addMeta);
//        } catch (SQLException sqlEx) {
//            sqlEx.printStackTrace();
//        } finally {
//            try {
//                CONNECTION.close();
//            } catch (SQLException se) { /*can't do anything */ }
//            try {
//                STATEMENT.close();
//            } catch (SQLException se) { /*can't do anything */ }
//            try {
//                RESULTSET.close();
//            } catch (SQLException se) { /*can't do anything */ }
//        }
//    }
}