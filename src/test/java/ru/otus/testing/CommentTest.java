//package ru.otus.testing;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import javax.ejb.embeddable.EJBContainer;
//import javax.naming.Context;
//import javax.naming.NamingException;
//import java.util.Collection;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class CommentTest {
//    private static Context ctx;
//    private static EJBContainer ejbContainer;
//
//    @BeforeClass
//    public static void setUp() {
//        // Instantiate an embeddable EJB container and search the
//        // JVM class path for eligible EJB modules or directories
//        ejbContainer = EJBContainer.createEJBContainer();
//
//        // Get a naming context for session bean lookups
//        ctx = ejbContainer.getContext();
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        if (ejbContainer != null)
//            ejbContainer.close();
//    }
//
//    @Test
//    public void testApp() throws NamingException {
//
//        CommentService converter = (CommentService) ctx.lookup("java:global/classes/CommentService");
//        assertNotNull(converter);
//
//        Comment t = new Comment();
//        converter.create(t);
//        t = new Comment();
//        converter.create(t);
//        t = new Comment();
//        converter.create(t);
//        t = new Comment();
//        converter.create(t);
//
//        Collection<Comment> ts = converter.getAll();
//
//        assertEquals(4, ts.size());
//    }
//}
