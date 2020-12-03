import java.util.ArrayList;
import java.util.NoSuchElementException;
public class Tester {
    public static int ERR = 0;
    public static boolean DEBUG = true;
    public static void main(String[] args) {
        if (args.length > 0 && Boolean.parseBoolean(args[0]) == false) DEBUG = false;
        String test = "";

        test = "IntegerSequence.hasNext()";
        try {
            IntegerSequence r = new Range(10, 15);
            ArrayList<Integer> a = new ArrayList<Integer>();
            while (r.hasNext()) {
                a.add(r.next());
            }
            check(test, a.toString(), "[10, 11, 12, 13, 14, 15]");

        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "IntegerSequence.next()";
        try {
            IntegerSequence r = new Range(10, 15);
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 10; i < 17; i++) {
                a.add(r.next());
            }
            noException(test, "NoSuchElementException");
        } catch(NoSuchElementException e) {
            
        } catch(RuntimeException e) {
            except(test, e);
        }

        if (ERR == 0) System.out.println("All good!");
        else if (ERR == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + ERR + " errors found.");
    }

    public static void check(String test, Object actual, Object expected) {
        if (!actual.equals(expected)) {
            System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            ERR++;
        }
    }

    public static void except(String test, RuntimeException e) {
        System.out.println("Failure on " + test + ": RuntimeException");
        if (DEBUG) System.out.println(e.toString());
        ERR++;
    }

    public static void noException(String test, String expected) {
        System.out.println("Failure on " + test + ": Expected " + expected);
        ERR++;
    }
}
