package cs2110;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DutchNationalFlagATest {

    @DisplayName("WHEN an unsorted array with the colors 'w','b','r', "
            + "THEN the method returns a sorted array with colors in the order 'r', 'w', 'b'.")
    @Test
    void testVariantA() {

        char[] dutchNationalFlag1 = new char[]{'r'};
        char[] dutchNationalFlag2 = new char[]{'b', 'r', 'w', 'r', 'b', 'w', 'r'};
        char[] dutchNationalFlag3 = new char[]{'b', 'b', 'r', 'b', 'r', 'r'};
        char[] dutchNationalFlag4 = new char[]{'b', 'b', 'w', 'w', 'r', 'r'};
        char[] dutchNationalFlag5 = new char[]{'w', 'w', 'w', 'w'};
        char[] dutchNationalFlag6 = new char[]{'b', 'r'};
        char[] dutchNationalFlag7 = new char[]{};
        char[] dutchNationalFlag8 = new char[]{'b', 'b', 'b', 'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b'};

        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag1);
        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag2);
        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag3);
        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag4);
        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag5);
        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag6);
        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag7);
        DutchNationalFlagA.dutchNationalFlagAlgorithm(dutchNationalFlag8);

        assertArrayEquals(new char[]{'r'}, dutchNationalFlag1);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag2);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'b', 'b', 'b'}, dutchNationalFlag3);
        assertArrayEquals(new char[]{'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag4);
        assertArrayEquals(new char[]{'w', 'w', 'w', 'w'}, dutchNationalFlag5);
        assertArrayEquals(new char[]{'r', 'b'}, dutchNationalFlag6);
        assertArrayEquals(new char[]{}, dutchNationalFlag7);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b', 'b', 'b', 'b'}, dutchNationalFlag8);
    }

    @DisplayName("WHEN an unsorted array with the colors 'w','b','r', "
            + "THEN the method returns a sorted array with colors in the order 'r', 'w', 'b'.")
    @Test
    void testVariantB() {

        char[] dutchNationalFlag1 = new char[]{'r'};
        char[] dutchNationalFlag2 = new char[]{'b', 'r', 'w', 'r', 'b', 'w', 'r'};
        char[] dutchNationalFlag3 = new char[]{'b', 'b', 'r', 'b', 'r', 'r'};
        char[] dutchNationalFlag4 = new char[]{'b', 'b', 'w', 'w', 'r', 'r'};
        char[] dutchNationalFlag5 = new char[]{'w', 'w', 'w', 'w'};
        char[] dutchNationalFlag6 = new char[]{'b', 'r'};
        char[] dutchNationalFlag7 = new char[]{};
        char[] dutchNationalFlag8 = new char[]{'b', 'b', 'b', 'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b'};

        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag1);
        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag2);
        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag3);
        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag4);
        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag5);
        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag6);
        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag7);
        DutchNationalFlagB.dutchNationalFlagAlgorithm(dutchNationalFlag8);

        assertArrayEquals(new char[]{'r'}, dutchNationalFlag1);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag2);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'b', 'b', 'b'}, dutchNationalFlag3);
        assertArrayEquals(new char[]{'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag4);
        assertArrayEquals(new char[]{'w', 'w', 'w', 'w'}, dutchNationalFlag5);
        assertArrayEquals(new char[]{'r', 'b'}, dutchNationalFlag6);
        assertArrayEquals(new char[]{}, dutchNationalFlag7);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b', 'b', 'b', 'b'}, dutchNationalFlag8);
    }

    @DisplayName("WHEN an unsorted array with the colors 'w','b','r', "
            + "THEN the method returns a sorted array with colors in the order 'r', 'w', 'b'.")
    @Test
    void testVariantC() {

        char[] dutchNationalFlag1 = new char[]{'r'};
        char[] dutchNationalFlag2 = new char[]{'b', 'r', 'w', 'r', 'b', 'w', 'r'};
        char[] dutchNationalFlag3 = new char[]{'b', 'b', 'r', 'b', 'r', 'r'};
        char[] dutchNationalFlag4 = new char[]{'b', 'b', 'w', 'w', 'r', 'r'};
        char[] dutchNationalFlag5 = new char[]{'w', 'w', 'w', 'w'};
        char[] dutchNationalFlag6 = new char[]{'b', 'r'};
        char[] dutchNationalFlag7 = new char[]{};
        char[] dutchNationalFlag8 = new char[]{'b', 'b', 'b', 'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b'};

        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag1);
        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag2);
        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag3);
        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag4);
        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag5);
        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag6);
        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag7);
        DutchNationalFlagC.dutchNationalFlagAlgorithm(dutchNationalFlag8);

        assertArrayEquals(new char[]{'r'}, dutchNationalFlag1);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag2);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'b', 'b', 'b'}, dutchNationalFlag3);
        assertArrayEquals(new char[]{'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag4);
        assertArrayEquals(new char[]{'w', 'w', 'w', 'w'}, dutchNationalFlag5);
        assertArrayEquals(new char[]{'r', 'b'}, dutchNationalFlag6);
        assertArrayEquals(new char[]{}, dutchNationalFlag7);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b', 'b', 'b', 'b'}, dutchNationalFlag8);
    }

    @DisplayName("WHEN an unsorted array with the colors 'w','b','r', "
            + "THEN the method returns a sorted array with colors in the order 'r', 'w', 'b'.")
    @Test
    void testVariantD() {

        char[] dutchNationalFlag1 = new char[]{'r'};
        char[] dutchNationalFlag2 = new char[]{'b', 'r', 'w', 'r', 'b', 'w', 'r'};
        char[] dutchNationalFlag3 = new char[]{'b', 'b', 'r', 'b', 'r', 'r'};
        char[] dutchNationalFlag4 = new char[]{'b', 'b', 'w', 'w', 'r', 'r'};
        char[] dutchNationalFlag5 = new char[]{'w', 'w', 'w', 'w'};
        char[] dutchNationalFlag6 = new char[]{'b', 'r'};
        char[] dutchNationalFlag7 = new char[]{};
        char[] dutchNationalFlag8 = new char[]{'b', 'b', 'b', 'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b'};

        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag1);
        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag2);
        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag3);
        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag4);
        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag5);
        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag6);
        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag7);
        DutchNationalFlagD.dutchNationalFlagAlgorithm(dutchNationalFlag8);

        assertArrayEquals(new char[]{'r'}, dutchNationalFlag1);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag2);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'b', 'b', 'b'}, dutchNationalFlag3);
        assertArrayEquals(new char[]{'r', 'r', 'w', 'w', 'b', 'b'}, dutchNationalFlag4);
        assertArrayEquals(new char[]{'w', 'w', 'w', 'w'}, dutchNationalFlag5);
        assertArrayEquals(new char[]{'r', 'b'}, dutchNationalFlag6);
        assertArrayEquals(new char[]{}, dutchNationalFlag7);
        assertArrayEquals(new char[]{'r', 'r', 'r', 'w', 'w', 'w', 'b', 'b', 'b', 'b', 'b', 'b'}, dutchNationalFlag8);
    }
}
