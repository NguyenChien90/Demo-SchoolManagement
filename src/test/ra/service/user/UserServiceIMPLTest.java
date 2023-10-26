package test.ra.service.user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ra.constant.FileName;
import ra.constant.Role;
import ra.constant.Status;
import ra.model.User;
import ra.service.user.UserServiceIMPL;

import java.io.File;

import static org.junit.Assert.*;

public class UserServiceIMPLTest {
    UserServiceIMPL userServiceIMPL;
    File dataDir;
    File userFile;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting test UserService");
        int random = (int) (Math.random() * 1000);
        dataDir = new File("data" + random);
        userFile = new File("data" + random + "/user.dat");
        dataDir.mkdir();
        userFile.createNewFile();
        userServiceIMPL = new UserServiceIMPL("data" + random + "/user.dat");
    }

    @After
    public void tearDown() throws Exception {
        userFile.delete();
        dataDir.delete();
        System.out.println("Delete file complete");
    }

    @Test
    public void save() {
        User user1 = new User("hieutt1", "1234", Role.USER, Status.ACTIVE);
        user1.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user1);
        User user2 = new User("hieutt2", "1234", Role.ADMIN, Status.ACTIVE);
        user2.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user2);

        Assert.assertEquals(2, userServiceIMPL.findAll().size());
    }

    @Test
    public void findAll() {
        User user1 = new User("hieutt1", "1234", Role.USER, Status.ACTIVE);
        user1.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user1);
        User user2 = new User("hieutt2", "1234", Role.ADMIN, Status.ACTIVE);
        user2.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user2);
        Assert.assertTrue(user1.equals(userServiceIMPL.findByID(1)));
        Assert.assertTrue(user2.equals(userServiceIMPL.findByID(2)));

    }

    @Test
    public void getNewId() {
        User user1 = new User("hieutt1", "1234", Role.USER, Status.ACTIVE);
        user1.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user1);
        User user2 = new User("hieutt2", "1234", Role.ADMIN, Status.ACTIVE);
        user2.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user2);
        Assert.assertEquals(3, userServiceIMPL.getNewId());
    }

    @Test
    public void update() {
        User user1 = new User("hieutt1", "1234", Role.USER, Status.ACTIVE);
        user1.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user1);
        User user2 = new User("hieutt2", "1234", Role.ADMIN, Status.ACTIVE);
        user2.setId(userServiceIMPL.getNewId());
        userServiceIMPL.save(user2);
        User updateUser1 = new User(1, "hieutt2", "1234", Role.ADMIN, Status.BLOCK);
        userServiceIMPL.update(updateUser1);

        Assert.assertTrue(userServiceIMPL.findByID(1).equals(updateUser1));
        Assert.assertFalse(userServiceIMPL.findByID(1).equals(user1));
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByID() {
    }

    @Test
    public void login() {
    }
}