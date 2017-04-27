package compl;

public class Compl {

    static class Complex {

        private final double re;   // the real part
        private final double im;   // the imaginary part

        // create a new object with the given real and imaginary parts
        public Complex(double real, double imag) {
            re = real;
            im = imag;
        }

        // return a string representation of the invoking Complex object
        public String toString() {
            if (im == 0) {
                return re + "";
            }
            if (re == 0) {
                return im + "i";
            }
            if (im < 0) {
                return re + " - " + (-im) + "i";
            }
            return re + " + " + im + "i";
        }

        // return a new Complex object whose value is (this + b)
        public Complex plus(Complex b) {
            Complex a = this;             // invoking object
            double real = a.re + b.re;
            double imag = a.im + b.im;
            return new Complex(real, imag);
        }

        // return a new Complex object whose value is (this - b)
        public Complex minus(Complex b) {
            Complex a = this;
            double real = a.re - b.re;
            double imag = a.im - b.im;
            return new Complex(real, imag);
        }

        // return a new Complex object whose value is (this * b)
        public Complex times(Complex b) {
            Complex a = this;
            double real = a.re * b.re - a.im * b.im;
            double imag = a.re * b.im + a.im * b.re;
            return new Complex(real, imag);
        }

        // return a new Complex object whose value is the reciprocal of this
        public Complex reciprocal() {
            double scale = re * re + im * im;
            return new Complex(re / scale, -im / scale);
        }

        // return the real or imaginary part
        public double re() {
            return re;
        }

        public double im() {
            return im;
        }

        // return a / b
        public Complex divides(Complex b) {
            Complex a = this;
            return a.times(b.reciprocal());
        }

        // a static version of plus
        public static Complex plus(Complex a, Complex b) {
            double real = a.re + b.re;
            double imag = a.im + b.im;
            Complex sum = new Complex(real, imag);
            return sum;
        }
    }

    // sample client for testing
    public static void main(String[] args) {
        Complex a = new Complex(5.0, 6.0);
        Complex b = new Complex(-3.0, 4.0);

        System.out.println("a            = " + a);
        System.out.println("b            = " + b);
        System.out.println("Re(a)        = " + a.re());
        System.out.println("Im(a)        = " + a.im());
        System.out.println("Re(b)        = " + b.re());
        System.out.println("Im(b)        = " + b.im());
        System.out.println("b + a        = " + b.plus(a));
        System.out.println("a - b        = " + a.minus(b));
        System.out.println("a * b        = " + a.times(b));
        System.out.println("a / b        = " + a.divides(b));
    }

}
