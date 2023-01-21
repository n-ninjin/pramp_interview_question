package questions.h_tree_construction;

/*
H-Tree Construction
An H-tree is a geometric shape that consists of a repeating pattern resembles the letter “H”.
It can be constructed by starting with a line segment of arbitrary length, drawing two segments of the same length at
right angles to the first through its endpoints, and continuing in the same vein, reducing (dividing) the length of
the line segments drawn at each stage by √2.
Here are some examples of H-trees at different levels of depth:

depth = 1
 |-|
depth = 2
  |-| |-|
    |-|
  |-| |-| .

Write a function drawHTree that constructs an H-tree, given its center (x and y coordinates), a starting length, and depth.
Assume that the starting line is parallel to the X-axis.
Use the function drawLine provided to implement your algorithm. In a production code, a drawLine function would render
a real line between two points. However, this is not a real production environment, so to make things easier, implement
drawLine such that it simply prints its arguments (the print format is left to your discretion).
Analyze the time and space complexity of your algorithm. In your analysis, assume that drawLine's time and space
complexities are constant, i.e. O(1).

Constraints:
[time limit] 5000ms
[input] double x
[input] double y
[input] double length
[input] double depth
0 ≤ depth ≤ 10

 */
class Main {
    static public void main(String args[]) {
        System.out.println("Practice makes Perfect!");
        drawHTree(0, 0, 8, 2);
    }

    public static void drawLine(double x1, double y1, double x2, double y2) {
        System.out.println("Line" + "(" + x1 + "," + y1 + ") " + "and " + "(" + x2 + "," + y2 + ")");
    }

    public static void drawHTree(double x, double y, double len, int depth) {
        if (depth == 0) return;
        double x0 = x - len / 2; // left
        double x1 = x + len / 2; // right
        double y0 = y - len / 2; // down
        double y1 = y + len / 2; // up

        //draw 3 line (left right connect)
        drawLine(x0, y0, x0, y1); // left segment  |
        drawLine(x1, y0, x1, y1); // right segment | => | |
        drawLine(x0, y, x1, y); // connect segment| | => |-|

        // each stage, length of segment decrease by factor
        double newLen = len / Math.sqrt(2);

        //lower left H tree
        drawHTree(x0, y0, newLen, depth - 1);
        //upper left H tree
        drawHTree(x0, y1, newLen, depth - 1);
        //lower right H tree
        drawHTree(x1, y0, newLen, depth - 1);
        //upper right H tree
        drawHTree(x1, y1, newLen, depth - 1);
    }
}

/*
output : drawHTree(0, 0, 8, 2);
Practice makes Perfect!
Line(-4.0,-4.0) and (-4.0,4.0)
Line(4.0,-4.0) and (4.0,4.0)
Line(-4.0,0.0) and (4.0,0.0)
Line(-6.82842712474619,-6.82842712474619) and (-6.82842712474619,-1.1715728752538102)
Line(-1.1715728752538102,-6.82842712474619) and (-1.1715728752538102,-1.1715728752538102)
Line(-6.82842712474619,-4.0) and (-1.1715728752538102,-4.0)
Line(-6.82842712474619,1.1715728752538102) and (-6.82842712474619,6.82842712474619)
Line(-1.1715728752538102,1.1715728752538102) and (-1.1715728752538102,6.82842712474619)
Line(-6.82842712474619,4.0) and (-1.1715728752538102,4.0)
Line(1.1715728752538102,-6.82842712474619) and (1.1715728752538102,-1.1715728752538102)
Line(6.82842712474619,-6.82842712474619) and (6.82842712474619,-1.1715728752538102)
Line(1.1715728752538102,-4.0) and (6.82842712474619,-4.0)
Line(1.1715728752538102,1.1715728752538102) and (1.1715728752538102,6.82842712474619)
Line(6.82842712474619,1.1715728752538102) and (6.82842712474619,6.82842712474619)
Line(1.1715728752538102,4.0) and (6.82842712474619,4.0)
 */