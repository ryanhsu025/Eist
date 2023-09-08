package de.tum.in.ase.eist;

public class BinaryString {
    private String binary;

    public BinaryString(String binary) {
        if (binary.length() % 8 != 0) {
            throw new IllegalArgumentException("Binary string length must be a multiple of 8.");
        }
        if (!binary.matches("[01]+")) {
            throw new IllegalArgumentException("Numbers other than 0 and 1 are prohibited in a binary string.");
        }
        this.binary = binary;
    }

    public BinaryString addBinary(String binaryToAdd) {
        if (binary.length() % 8 != 0) {
            throw new IllegalArgumentException("Binary string length must be a multiple of 8.");
        }
        if (!binary.matches("[01]+")) {
            throw new IllegalArgumentException("Numbers other than 0 and 1 are prohibited in a binary string.");
        }
        return new BinaryString(this.binary + binaryToAdd);
    }

    public BinaryString removeBinary(int bitsToRemove) {
        if (bitsToRemove % 8 != 0 || bitsToRemove > this.binary.length()) {
            throw new IllegalArgumentException("Number of bits to be removed must be a multiple of 8 and should not exceed the binary string length.");
        }
        return new BinaryString(this.binary.substring(0, this.binary.length() - bitsToRemove));
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }
}

