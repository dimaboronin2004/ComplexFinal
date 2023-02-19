package org.example;

import static java.lang.Math.pow;

public final class Complex {
    private final double re; //Real part of complex num
    private final double im; //Imaginary part of complex num

    public Complex(double re, double im) { //Constructor of class
        this.re = re;
        this.im = im;
    }

    public double getRe() { //Getter of a real part
        return this.re;
    }

    public double getIm() { //Getter of an imaginary part
        return this.im;
    }

    public static Complex toComplex(String string) { //Convertation of string into complex
        double real, imaginary;
        if (string.matches("(-)?\\d+(.\\d+)?\\+\\d+(.\\d+)?i")) {
            String[] splt = string.split("\\+");
            real = Double.parseDouble(splt[0]);
            imaginary = Double.parseDouble(splt[1].substring(0, splt[1].length() - 1));
            return new Complex(real, imaginary);
        }
        else if (string.matches("(-)?\\d+(.\\d+)?-\\d+(.\\d+)?i")) {
            String[] splt = string.split("-");
            if (!string.startsWith("-")) {
                real = Double.parseDouble(splt[0]);
                imaginary = -Double.parseDouble(splt[1].substring(0, splt[1].length() - 1));
            }
            else {
                real = -Double.parseDouble(splt[1]);
                imaginary = -Double.parseDouble(splt[2].substring(0, splt[2].length() - 1));
            }
            return new Complex(real, imaginary);
        }
        else if (string.matches("(-)?\\d+(.\\d+)?")) {
            real = Double.parseDouble(string);
            imaginary = 0.0;
            return new Complex(real, imaginary);
        }
        else if (string.matches("(-)?\\d+(.\\d+)?i")) {
            real = 0.0;
            imaginary = Double.parseDouble(string.substring(0, string.length() - 1));
            return new Complex(real, imaginary);
        }
        else {
            throw new IllegalArgumentException("String inconvertible to complex");
        }
    }

    public Complex plus(Complex other) { //Addition
        double newReal = this.re + other.re;
        double newImaginary = this.im + other.im;
        return new Complex(newReal, newImaginary);
    }

    public Complex unaryMinus() { //Changing of a sign
        double newReal = -this.re;
        double newImaginary = -this.im;
        return new Complex(newReal, newImaginary);
    }

    public Complex minus(Complex other) { //Subtraction
        double newReal = this.re - other.re;
        double newImaginary = this.im - other.im;
        return new Complex(newReal, newImaginary);
    }

    public Complex times(Complex other) { //Multiplication
        double newReal = this.re * other.re - this.im * other.im;
        double newImaginary = this.re * other.im + this.im * other.re;
        return new Complex(newReal, newImaginary);
    }

    public Complex div(Complex other) { //Division
        double newReal = (this.re * other.re + this.im * other.im) / (pow(other.re, 2) + pow(other.im ,2));
        double newImaginary = (this.im * other.re - this.re * other.im) / (pow(other.re, 2) + pow(other.im ,2));
        return new Complex(newReal, newImaginary);
    }

    public boolean equals(Complex other) { //Comparison
        return this.re == other.re && this.im == other.im;
    }

    @Override
    public String toString() { //Convertation into string
        if (this.im == 0) return "" + this.re;
        else if (this.re == 0) return "" + this.im + "i";
        else {
            if (this.im >0) return "" + this.re + "+" + this.im + "i";
            else return "" + this.re + this.im + "i";
        }
    }
}
