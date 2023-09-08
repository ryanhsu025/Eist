package de.tum.in.ase.eist;

public class BinaryToTextAdapter implements TextConverter{
    private TextString textString;

    public BinaryToTextAdapter(TextString textString) {
        this.textString = textString;
    }
    @Override
    public String convertText(BinaryString binaryString) {
        StringBuilder str = new StringBuilder();

        int intervals = (int) Math.ceil((double) binaryString.getBinary().length() / 8);
        String[] binaryArray = new String[intervals];

        for (int i = 0; i < intervals; i++) {
            int startIndex = i * 8;
            int endIndex = (i + 1) * 8;
            binaryArray[i] = binaryString.getBinary().substring(startIndex, endIndex);
        }

        for (String binary : binaryArray) {
            int decimal = Integer.parseInt(binary, 2);
            char character = (char) decimal;
            str.append(character);
        }

        textString.setText(str.toString());
        return str.toString();
    }

    public TextString getTextString() {
        return textString;
    }

    public void setTextString(TextString textString) {
        this.textString = textString;
    }
}
