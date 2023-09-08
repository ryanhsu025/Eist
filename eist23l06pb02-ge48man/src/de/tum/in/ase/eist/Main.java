package de.tum.in.ase.eist;

public class Main {
    public static void main(String[] args) {
        BinaryString binaryString = new BinaryString("00111011");
        TextString textString = new TextString("");
        BinaryToTextAdapter binaryToTextAdapter = new BinaryToTextAdapter(textString);
        binaryToTextAdapter.convertText(binaryString);
        System.out.println(textString.getText());
        BinaryString binaryString2 = new BinaryString("00111000");
        TextString textString2 = new TextString("");
        BinaryToTextAdapter binaryToTextAdapter2 = new BinaryToTextAdapter(textString2);
        binaryToTextAdapter2.convertText(binaryString2);
        System.out.print(textString2.getText());
    }
}
