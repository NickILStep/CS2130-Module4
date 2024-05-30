package cs2130;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixRelationTest {

    private MatrixRelation emptyM;
    private MatrixRelation emptyL;

    private MatrixRelation m1;
    private MatrixRelation m2;
    private MatrixRelation m3;
    private MatrixRelation m4;
    private MatrixRelation l1;
    private MatrixRelation l2;
    private MatrixRelation l3;

    @BeforeEach
    void setUp() {
        emptyM = new MatrixRelation(5);
        emptyL = new MatrixRelation(7);
        m1 = new MatrixRelation(new int[][] {
                {1, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1}
        });
        m2 = new MatrixRelation(new int[][] {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0}
        });
        m3 = new MatrixRelation(new int[][] {
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1}
        });
        m4 = new MatrixRelation(new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}
        });
        l1 = new MatrixRelation(new int[][] {
                {1, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 1}
        });
        l2 = new MatrixRelation(new int[][] {
                {0, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        });
        l3 = new MatrixRelation(new int[][] {
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 0}
        });

    }

    @Test
    void join() {
        MatrixRelation result = m1.join(emptyM);
        assertTrue(result.isEqual(m1));
        result = emptyM.join(m1);
        assertTrue(result.isEqual(m1));
        result = m4.join(m3);
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1}
        })));
        result = l1.join(emptyL);
        assertTrue(result.isEqual(l1));
        result = l2.join(l3);
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 0}
        })));
    }

    @Test
    void transpose() {
        MatrixRelation result = m2.transpose();
        assertTrue(m2.isEqual(m2));
        result = m3.transpose();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
        })));
        result = m4.transpose();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        })));
        result = l1.transpose();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 1},
                {0, 0, 1, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1}
        })));
        result = l3.transpose();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        })));
    }


    @Test
    void reflexiveClosure() {
        MatrixRelation result = m1.reflexiveClosure();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1}
        })));
        result = m2.reflexiveClosure();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 0, 1, 1}
        })));
        result = m3.reflexiveClosure();
        assertTrue(result.isEqual(m3));
        result = l1.reflexiveClosure();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 1, 0, 0, 1, 0, 1},
                {1, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 0, 1}
        })));
    }

    @Test
    void symmetricClosure() {
        MatrixRelation result = m1.symmetricClosure();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        })));
        result = m2.symmetricClosure();
        assertTrue(result.isEqual(m2));
        result = m3.symmetricClosure();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        })));
        result = l2.symmetricClosure();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        })));
        result = l3.symmetricClosure();
        assertTrue(result.isEqual(new MatrixRelation(new int[][] {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 0}
        })));
    }

    @Test
    void inDegree() {
        assertEquals(2, m2.inDegree(0));
        assertEquals(2, m2.inDegree(4));
        assertEquals(1, m3.inDegree(0));
        assertEquals(3, m3.inDegree(2));
        assertEquals(5, m3.inDegree(4));
        assertEquals(1, l2.inDegree(1));
        assertEquals(0, l2.inDegree(3));

    }

    @Test
    void outDegree() {
        assertEquals(3, m1.outDegree(0));
        assertEquals(0, m1.outDegree(2));
        assertEquals(1, m1.outDegree(3));
        assertEquals(2, l2.outDegree(3));
        assertEquals(0, l3.outDegree(0));
        assertEquals( 2, l3.outDegree(2));
        assertEquals(6, l3.outDegree(6));
    }

    @Test
    void isRootedTreeTrue() {
        assertTrue(m4.isRootedTree());
        assertTrue(l2.isRootedTree());
    }

    @Test
    void isRootedTreeFalse() {
        assertFalse(m1.isRootedTree());
        assertFalse(m2.isRootedTree());
        assertFalse(m3.isRootedTree());
        assertFalse(l1.isRootedTree());
        assertFalse(l3.isRootedTree());
    }

}