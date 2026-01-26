package cs2110;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundingBoxTest {

        @DisplayName("When one rectangle is located in another and its upper side extends beyond the boundaries of the first, "
                        + " then it is considered that it does not fit completely in it.")
        @Test
        void testContainsBoxIsFalseLongHeightUp() {

                BoundingBox megaBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox smallBox = new BoundingBox(new Point(2, 7), 7, 4);
                assertFalse(megaBox.containsBox(smallBox));

        }

        @DisplayName("When one rectangle is in another and its bottom side extends beyond the boundaries of the first, "
                        + "then it is considered that it does not fit completely in it.")
        @Test
        void testContainsBoxIsFalseLongWidthDown() {

                BoundingBox megaBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox smallBox = new BoundingBox(new Point(2, 5), 7, 6);
                assertFalse(megaBox.containsBox(smallBox));

        }

        @DisplayName("When one rectangle is inside another and its left side extends beyond the boundaries of the first, "
                        + "then it is considered that it does not fit completely in it.")
        @Test
        void testContainsBoxIsFalsePointOutLeft() {

                BoundingBox megaBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox smallBox = new BoundingBox(new Point(0, 5), 7, 4);
                assertFalse(megaBox.containsBox(smallBox));

        }

        @DisplayName("When one rectangle is inside another and its right side extends beyond the boundaries of the first, "
                        + "then it is considered that it does not fit completely in it.")
        @Test
        void testContainsBoxIsFalseLongWidth() {

                BoundingBox megaBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox smallBox = new BoundingBox(new Point(2, 5), 9, 4);
                assertFalse(megaBox.containsBox(smallBox));

        }

        @DisplayName("When one rectangle is in another and it is larger than the first along all boundaries, "
                        + "then it is considered not to be contained in the first rectangle.")
        @Test
        void testContainsBoxIsFalse() {

                BoundingBox megaBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox smallBox = new BoundingBox(new Point(2, 5), 7, 4);
                assertFalse(smallBox.containsBox(megaBox));

        }

        @DisplayName("When one rectangle is in another and it is equal to the first along all boundaries, "
                        + "then it is considered to be contained in the first rectangle.")
        @Test
        void testContainsBoxIsTrueForEqualsBoxs() {

                BoundingBox megaBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox megaBoxEquals = new BoundingBox(new Point(1, 6), 9, 6);
                assertTrue(megaBox.containsBox(megaBoxEquals));

        }

        @DisplayName("When one rectangle is in another and it is smaller than the first along all borders, "
                        + "then it is considered to be contained in the first rectangle.")
        @Test
        void testContainsBoxIsTrue() {

                BoundingBox megaBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox smallBox = new BoundingBox(new Point(2, 5), 7, 4);
                assertTrue(megaBox.containsBox(smallBox));

        }

        @DisplayName("When a non-empty rectangle is created, "
                        + "then its point 'ulCorner' is considered not null.")
        @Test
        void testMethodIsEmptyFalse() {

                BoundingBox testUlCornerNull = new BoundingBox(new Point(1, 6), 10, 5);

                assertFalse(testUlCornerNull.isEmpty());

        }

        @DisplayName("When an empty rectangle is created, "
                        + "then its point 'ulCorner' is considered to be null.")
        @Test
        void testMethodIsEmptyTrue() {

                BoundingBox testUlCornerNull = new BoundingBox();

                assertTrue(testUlCornerNull.isEmpty());

        }

        @DisplayName("When a non-empty rectangle is created, "
                        + "then the 'BoundingBox' object is considered not null.")
        @Test
        void testNoNullBoundingBox() {

                BoundingBox noNull = new BoundingBox(new Point(-1, -6), 5, 7);

                assertNotNull(noNull);

        }

        @DisplayName("When a non-empty rectangle with negative numbers is created in the 'Point' constructor, "
                        + "then all fields of the 'BoundingBox' object are considered to be valid.")
        @Test
        void testNoEmptyBoundingBoxCheckingVariablesNegative() {

                BoundingBox noEmptyNegativePointBox = new BoundingBox(new Point(-1, -6), 5, 7);

                assertNotNull(noEmptyNegativePointBox.upperLeftCorner());
                assertEquals(5, noEmptyNegativePointBox.width(), "incorrect box width");
                assertEquals(7, noEmptyNegativePointBox.height(), "incorrect box height");
                assertEquals(35, noEmptyNegativePointBox.area(), "incorrect box area");
        }

        @DisplayName("When a non-empty rectangle with zeros is created in the 'Point' constructor, "
                        + "then all fields of the 'BoundingBox' object are considered to be valid.")
        @Test
        void testNoEmptyBoundingBoxCheckingVariablesZero() {

                BoundingBox noEmptyZeroPointAndValueBox = new BoundingBox(new Point(0, 0), 0, 0);

                assertNotNull(noEmptyZeroPointAndValueBox.upperLeftCorner());
                assertEquals(0, noEmptyZeroPointAndValueBox.width(), "incorrect box width");
                assertEquals(0, noEmptyZeroPointAndValueBox.height(), "incorrect box height");
                assertEquals(0, noEmptyZeroPointAndValueBox.area(), "incorrect box area");
        }

        @DisplayName("When a non-empty rectangle with positive numbers is created in the 'Point' constructor, "
                        + "then all fields of the 'BoundingBox' object are considered to be valid.")
        @Test
        void testNoEmptyBoundingBoxCheckingVariablesPositive() {

                BoundingBox noEmptyPositivePointAndValueBox = new BoundingBox(new Point(1, 6), 10, 5);

                assertNotNull(noEmptyPositivePointAndValueBox.upperLeftCorner());
                assertEquals(10, noEmptyPositivePointAndValueBox.width(), "incorrect box width");
                assertEquals(5, noEmptyPositivePointAndValueBox.height(), "incorrect box height");
                assertEquals(50, noEmptyPositivePointAndValueBox.area(), "incorrect box area");

        }

        @DisplayName("When an empty rectangle is created, "
                        + "then all fields of the 'BoundingBox' object are considered to be valid.")
        @Test
        void testEmptyConstruction() {
                BoundingBox emptyBox = new BoundingBox();
                assertNull(emptyBox.upperLeftCorner());
                assertEquals(0, emptyBox.width(), "incorrect box width");
                assertEquals(0, emptyBox.height(), "incorrect box height");
                assertEquals(0, emptyBox.area(), "incorrect box area");
        }

        @DisplayName("When a box has 0 width and height (a point), it is NOT considered empty.")
        @Test
        void testPointBoxIsNotEmpty() {
                BoundingBox pointBox  = new BoundingBox(new Point(2, 2),0,0);
                assertEquals(0, pointBox.width(), "incorrect box width");
                assertEquals(0, pointBox.height(), "incorrect box height");
                assertFalse(pointBox.isEmpty(), "A box with 0 dimensions (a point) should not be empty");
        }

        @DisplayName("When dots are placed on the boundaries of a non-empty rectangle, "
                        + "then it is considered that all points are correctly located on its boundaries.")
        @Test
        void testContainsInteriorPointBordersIsTrue() {

                BoundingBox box = new BoundingBox(new Point(0, 2), 2, 2);
                Point interiorPointLeft = new Point(0, 1);
                Point interiorPointRight = new Point(2, 1);
                Point interiorPointUp = new Point(1, 2);
                Point interiorPointDown = new Point(1, 0);
                assertTrue(box.containsPoint(interiorPointLeft));
                assertTrue(box.containsPoint(interiorPointRight));
                assertTrue(box.containsPoint(interiorPointUp));
                assertTrue(box.containsPoint(interiorPointDown));

        }

        @DisplayName("When dots are placed outside the boundaries of a non-empty rectangle, "
                        + "then it is considered that all points are correctly located outside its boundaries.")
        @Test
        void testContainsInteriorPointIsFalse() {

                BoundingBox box = new BoundingBox(new Point(0, 2), 2, 2);
                Point interiorPoint = new Point(3, 3);
                assertFalse(box.containsPoint(interiorPoint));

        }

        @DisplayName("When dots are placed in the space of an empty non-rectangle, "
                        + "then it is considered that all points are correctly located within its boundaries.")
        @Test
        void testContainsInteriorPoint() {

                BoundingBox box = new BoundingBox(new Point(0, 2), 2, 2);
                Point interiorPoint = new Point(1, 1);
                assertTrue(box.containsPoint(interiorPoint));
        }

        @DisplayName("When two rectangles do not intersect all boundaries, "
                        + "then it is assumed that these rectangles do not intersect.")
        @Test
        void test2DNoIntersection() {

                BoundingBox redBox = new BoundingBox(new Point(0, 2), 2, 2);
                BoundingBox blueBox = new BoundingBox(new Point(3, 2), 2, 2);
                BoundingBox purpleBox = redBox.intersectWith(blueBox);

                assertNotNull(purpleBox);
                assertTrue(purpleBox.isEmpty());
        }

        @DisplayName("When two rectangles intersect at the very border, "
                        + "then it is assumed that these rectangles intersect.")
        @Test
        void testIntersectionCommonBorder() {

                BoundingBox redBox = new BoundingBox(new Point(0, 2), 2, 2);
                BoundingBox blueBox = new BoundingBox(new Point(2, 2), 2, 2);
                BoundingBox purpleBox = redBox.intersectWith(blueBox);

                assertNotNull(purpleBox);
                assertEquals(new Point(2, 2), purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertEquals(0, purpleBox.width(), "incorrect intersection width");
                assertEquals(2, purpleBox.height(), "incorrect intersection height");
        }

        @DisplayName("When two rectangles intersect at a common angle, "
                        + "then it is assumed that these rectangles intersect.")
        @Test
        void testIntersectionCornerTouch() {

                BoundingBox redBox = new BoundingBox(new Point(0, 2), 2, 2);
                BoundingBox blueBox = new BoundingBox(new Point(2, 4), 2, 2);
                BoundingBox purpleBox = redBox.intersectWith(blueBox);

                assertNotNull(purpleBox);
                assertEquals(new Point(2 , 2), purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertEquals(0, purpleBox.width(), "incorrect intersection width");
                assertEquals(0, purpleBox.height(), "incorrect intersection height");
        }

        @DisplayName("When one rectangle is completely contained within another, "
                        + "then it is assumed that these rectangles intersect.")
        @Test
        void test2DIntersectionMatryoshka() {

                BoundingBox redBox = new BoundingBox(new Point(1, 6), 9, 6);
                BoundingBox blueBox = new BoundingBox(new Point(2, 5), 7, 4);
                BoundingBox purpleBox = redBox.intersectWith(blueBox);

                assertNotNull(purpleBox);
                assertEquals(new Point(2, 5), purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertEquals(7, purpleBox.width(), "incorrect intersection width");
                assertEquals(4, purpleBox.height(), "incorrect intersection height");
        }

        @DisplayName("When two rectangles intersect along all edges, "
                        + "then it is assumed that these rectangles intersect.")
        @Test
        void testIntersectionIdentical() {

                BoundingBox redBox = new BoundingBox(new Point(2, 5), 6, 3);
                BoundingBox blueBox = new BoundingBox(new Point(2, 5), 6, 3);
                BoundingBox purpleBox = redBox.intersectWith(blueBox);

                assertNotNull(purpleBox);
                assertEquals(new Point(2, 5), purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertEquals(6, purpleBox.width(), "incorrect intersection width");
                assertEquals(3, purpleBox.height(), "incorrect intersection height");
        }

        @DisplayName("When rectangles intersect crosswise, "
                        + "then it is assumed that these rectangles intersect.")
        @Test
        void test2DIntersectionCross() {

                BoundingBox redBox = new BoundingBox(new Point(0, 3), 6, 3);
                BoundingBox blueBox = new BoundingBox(new Point(2, 5), 2, 7);
                BoundingBox purpleBox = redBox.intersectWith(blueBox);

                assertNotNull(purpleBox);
                assertEquals(new Point(2, 3), purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertEquals(2, purpleBox.width(), "incorrect intersection width");
                assertEquals(3, purpleBox.height(), "incorrect intersection height");
        }

        @DisplayName("When a rectangle intersects with an empty rectangle,"
                        + "then it is assumed that these rectangles do not intersect.")
        @Test
        void test2DIntersectionEmptyBox() {

                BoundingBox redBox = new BoundingBox(new Point(0, 3), 6, 3);
                BoundingBox blueBox = new BoundingBox();
                BoundingBox purpleBox = redBox.intersectWith(blueBox);

                assertNotNull(purpleBox);
                assertEquals(null, purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertTrue(purpleBox.isEmpty(), "intersection with an empty box should result in an empty box");
        }

        @DisplayName("WHEN the intersection of two bounding box is another 2D bounding box, THEN "
                        + "this intersection should have the correct location and dimensions.")
        @Test
        void test2DIntersection() {
                // this is the test case from the handout figure
                BoundingBox redBox = new BoundingBox(new Point(2, 5), 3, 3);
                BoundingBox blueBox = new BoundingBox(new Point(4, 4), 3, 3);

                BoundingBox purpleBox = redBox.intersectWith(blueBox);
                assertEquals(new Point(4, 4), purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertEquals(1, purpleBox.width(), "incorrect intersection width");
                assertEquals(2, purpleBox.height(), "incorrect intersection height");

                // check that the other intersection order also works
                purpleBox = blueBox.intersectWith(redBox);
                assertEquals(new Point(4, 4), purpleBox.upperLeftCorner(), "incorrect upper left corner of intersection");
                assertEquals(1, purpleBox.width(), "incorrect intersection width");
                assertEquals(2, purpleBox.height(), "incorrect intersection height");
        }

}
