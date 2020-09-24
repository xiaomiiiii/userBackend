public class Main {
    public static void main(String[] args) {

        User user = accountUI.userInput();
        UserDao.addUser(user);
        UserDao.printUsers();
        UserDao.updateUser(user, "xiaomiliu");
        UserDao.removeUser("xiaomiliu");
        UserDao.printUsers();
    }
}
