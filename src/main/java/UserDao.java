import java.sql.*;

public class UserDao {
    //private static ArrayList<User> userList = new ArrayList<User>();

//    public static void addUser(User user) {
//        userList.add(user);
//        System.out.println("Successfully added user " + user.getName());
//    }
//
//    public static void printUsers() {
//        System.out.println("Here is the user list:");
//        for (int i = 0; i < userList.size(); i++) {
//            System.out.println("User " + (int)(i + 1) + " : " + userList.get(i).getName());
//        }
//    }
//
//    // Update user's name
//    public static void updateUser(User user, String name) {
//        user.setName(name);
//        System.out.println("Update user name to " + user.getName());
//    }
//
//    // Remove user by name
//    public static void removeUser(String name) {
//        for (int i = 0; i < userList.size(); i++) {
//            if (userList.get(i).getName().equals(name)) {
//                userList.remove(i);
//            }
//        }
//        System.out.println("User " + name + " is removed.");
//    }

    private static final String USERNAME = "xiaomi";
    private static final String PASSWORD = "1234";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/users";
    private static int id = 1;

    static Connection conn = null;

    public static void connect() {
        try {
            conn = (Connection) DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Connected");
    }

    public static void add(User user) {
        try {
            connect();

            System.out.println("id:" + id);
            String query = "INSERT INTO users VALUES (" + id + ",'" + user.getEmail() + "','" + user.getPassword() + "','" + user.getName() + "'," + user.getYear() + "," + user.getMonth() + "," + user.getDay() + "," + user.getGender() + ")";
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            int rs = st.executeUpdate(query);

            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        id++;
        System.out.println("Successfully added user " + user.getName());
    }

    public static void print(){
        try {
            connect();
            String query = "SELECT * FROM users";
            // create the java statement
            Statement st = (Statement) conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int year = rs.getInt("year");
                int month = rs.getInt("month");
                int day = rs.getInt("day");
                int gender = rs.getInt("gender");

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s, %s\n", id, name, email, year, month, day, gender);
            }
            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void update(User user, String name) {
        try {
            connect();

            String query = "UPDATE users SET name='" + name + "' WHERE name='" + user.getName() + "'";
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            int rs = st.executeUpdate(query);

            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println("Update user name to " + name);
    }

    public static void remove(String name) {
        try {
            connect();

            String query = "DELETE FROM users WHERE name='" + name + "'";
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            int rs = st.executeUpdate(query);

            st.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("User " + name + " is removed.");
    }

}

