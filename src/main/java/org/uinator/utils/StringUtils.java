package org.uinator.utils;

public class StringUtils {

    public static String repeat(String source, int times) {
        String result = "";

        while (times > 0) {
            result = result.concat(source);
            times -= 1;
        }

        return result;
    }

    public static String toCamelCase(String name, String delimiter, StringCase wordCase) {
        String result = new String();

        int last_delimiter_pos = 1;
        for (int i = 0; i < name.length(); i++) {
            String prevChar = name.substring(i > 0 ? i - 1 : 0, i > 0 ? i : 1);
            String currChar = name.substring(i, i + 1);

            switch (wordCase) {
                case UPPER:
                    if (prevChar.equals(delimiter) || (i == 0 && !currChar.equals(delimiter))) {
                        result = result.concat(currChar.toUpperCase());
                    } else {
                        result = result.concat(currChar);
                    }
                    break;
                case LOWER:
                    if (i == 0 || currChar.toUpperCase().equals(currChar)) {
                        if ( i == 0 || ( last_delimiter_pos <= i - 2 ) ) {
                            last_delimiter_pos = i;
                            result = result.concat(delimiter);
                        }

                        result = result.concat(currChar.toLowerCase());
                    } else {
                        result = result.concat(currChar);
                    }
                    break;
            }
        }

        return result;
    }
}
