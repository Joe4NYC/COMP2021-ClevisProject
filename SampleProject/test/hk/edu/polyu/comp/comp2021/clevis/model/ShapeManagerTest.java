package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ShapeManagerTest {

    private ShapeManager manager;

    @BeforeEach
    public void setUp() {
        manager = new ShapeManager();  
    }

    @Test
    public void testCreateAndListShapes() {
        manager.createRectangle("r1", 0, 0, 10, 10);
        manager.createCircle("c1", 5, 5, 3);
        manager.createLine("l1", 0, 0, 10, 10);
        manager.createSquare("s1", 20, 20, 5);

        String listAll = manager.listAll();
        assertTrue(listAll.contains("r1"));
        assertTrue(listAll.contains("c1"));
        assertTrue(listAll.contains("l1"));
        assertTrue(listAll.contains("s1"));
    }

    @Test
    public void testMoveAndUndoRedo() {
        manager.createRectangle("r1", 0, 0, 10, 10);
        manager.move("r1", 20, 30);
        assertTrue(manager.listAll().contains("20.00"));
        assertTrue(manager.listAll().contains("30.00"));

        manager.undo();
        assertTrue(manager.listAll().contains("0.00"));
        manager.redo();
        assertTrue(manager.listAll().contains("20.00"));
    }

    @Test
    public void testGroupAndUngroup() {
        manager.createRectangle("r1", 0, 0, 10, 10);
        manager.createCircle("c1", 15, 15, 5);
        manager.group("group g1 r1 c1");

        String all = manager.listAll();
        assertTrue(all.contains("g1"));
        assertTrue(all.contains("r1"));
        assertTrue(all.contains("c1"));

        manager.ungroup("g1");
        all = manager.listAll();
        assertTrue(all.contains("r1"));
        assertTrue(all.contains("c1"));
        assertFalse(manager.listAll().contains("g1"));
    }

    @Test
    public void testDeleteAndUndo() {
        manager.createLine("l1", 0, 0, 10, 10);
        manager.delete("l1");
        assertFalse(manager.listAll().contains("l1"));

        manager.undo();
        assertTrue(manager.listAll().contains("l1"));
    }

    @Test
    public void testBoundingBoxAndIntersect() {
        manager.createRectangle("r1", 0, 0, 10, 10);
        manager.createCircle("c1", 5, 5, 3);

        double[] box = manager.getBoundingBox("r1");
        assertEquals(0.0, box[0], 0.01);
        assertEquals(10.0, box[2], 0.01);

        assertTrue(manager.intersect("r1", "c1"));
    }

    @Test
    public void testShapeAt() {
        manager.createRectangle("r1", 0, 0, 20, 20);
        manager.createCircle("c1", 10, 10, 5);

        assertEquals("c1", manager.shapeAt(15, 10));
        assertEquals("r1", manager.shapeAt(0, 0));
        assertEquals(null, manager.shapeAt(100, 100));
    }

    @Test
    public void testNameConflict() {
        manager.createRectangle("r1", 0, 0, 10, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            manager.createRectangle("r1", 1, 1, 5, 5);
        });
    }

    @Test
    public void testZOrder() {
        manager.createRectangle("r1", 0, 0, 10, 10);
        manager.createCircle("c1", 0, 0, 5);
        assertEquals("c1", manager.shapeAt(5, 0));
    }
}