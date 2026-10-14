package Lab7;
//Challenge

public class FinallyReturn {

    static int test() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");
        }
    }

    public static void main(String[] args) {
        int result = test();
        System.out.println("result = " + result);
    }
    //Prediction: in try, then in finally, then result = 1.
    //Why finally still runs: a finally block runs on every way of leaving the try: normal completion, an exception, break, and return. When Java reaches return 1, it works out the value (1) and holds it. It runs the finally block, and only then hands the value back to the caller, which is why “in finally” prints before result = 1. The only things that stop finally are the JVM shutting down (System.exit) or a crash.
}