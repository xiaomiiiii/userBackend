import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void setEmail() {
        User user1 = new User("gmail.com", "xiaomi", "xiaomi", 2020, 1, 1, 1);
        String email1 = user1.getEmail();
        Assert.assertEquals(null, email1);

        User user2 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2020, 1, 1, 1);
        String email2 = user2.getEmail();
        Assert.assertEquals("liuxiaomi@gmail.com", email2);
    }

    @Test
    public void setPassword() {
        User user1 = new User("liuxiaomi@gmail.com", "xiaomi", "x", 2020, 1, 1, 1);
        String password1 = user1.getPassword();
        Assert.assertEquals(null, password1);

        User user2 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2020, 1, 1, 1);
        String password2 = user2.getPassword();
        Assert.assertEquals("xiaomi", password2);
    }

    @Test
    public void setName() {
        User user1 = new User("liuxiaomi@gmail.com", "x", "xiaomi", 2020, 1, 1, 1);
        String name1 = user1.getName();
        Assert.assertEquals(null, name1);

        User user2 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2000, 1, 1, 1);
        String name2 = user2.getName();
        Assert.assertEquals("xiaomi", name2);
    }

    @Test
    public void setGender() {
        User user1 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2000, 1, 1, 0);
        int gender1 = user1.getGender();
        Assert.assertEquals(-1, gender1);

        User user2 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2020, 1, 1, 1);
        int gender2 = user2.getGender();
        Assert.assertEquals(1, gender2);
    }

    @Test
    public void setYear() {
        User user1 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 100, 1, 1, 1);
        int year1 = user1.getYear();
        Assert.assertEquals(-1, year1);

        User user2 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2000, 1, 1, 1);
        int year2 = user2.getYear();
        Assert.assertEquals(2000, year2);
    }

    @Test
    public void setMonth() {
        User user1 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2020, 20, 1, 1);
        int month1 = user1.getMonth();
        Assert.assertEquals(-1, month1);

        User user2 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2020, 1, 1, 1);
        int month2 = user2.getMonth();
        Assert.assertEquals(1, month2);
    }

    @Test
    public void setDay() {
        User user1 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2020, 1, 90, 1);
        int day1 = user1.getDay();
        Assert.assertEquals(-1, day1);

        User user2 = new User("liuxiaomi@gmail.com", "xiaomi", "xiaomi", 2020, 1, 1, 1);
        int day2 = user2.getDay();
        Assert.assertEquals(1, day2);
    }
}