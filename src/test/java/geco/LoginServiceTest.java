package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mayeul Grivet-Roux on 11/21/2016.
 */
public class LoginServiceTest {
    private static final String YOLO = "YOLO";
    private static final String PTDR = "PTDR";
    private LoginService ls;

    @Before
    public void setUp() throws Exception {
        String[] start = new String[1];
        start[0] = YOLO;
        ls = new LoginService(start);
    }

    @Test
    public void testLoginExists() throws Exception {
        boolean res = ls.loginExists(YOLO);
        Assert.assertTrue(res);
        res = ls.loginExists(PTDR);
        Assert.assertFalse(res);
    }

    @Test
    public void testAddLogin() throws Exception {
        ls.addLogin("AAA");
        ls.addLogin("AAA");
        List<String> allLogins = ls.findAllLogins();
        Assert.assertEquals(3, allLogins.size());
    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        List<String> allLogins = ls.findAllLoginsStartingWith("A");
        Assert.assertEquals(1, allLogins.size());
        ls.addLogin("AAA");
        allLogins = ls.findAllLoginsStartingWith("A");
        Assert.assertEquals(2, allLogins.size());
        allLogins = ls.findAllLoginsStartingWith("B");
        Assert.assertEquals(0, allLogins.size());
    }

    @Test
    public void testFindAllLogins() throws Exception {
        List<String> allLogins = ls.findAllLogins();
        Assert.assertEquals(1, allLogins.size());
        ls.addLogin("AAA");
        allLogins = ls.findAllLogins();
        Assert.assertEquals(2, allLogins.size());
    }
}