public class Main {
    public static void main(String[] args) {
        String text = "abcdabcdabcd";
        boolean answer = isTriangleText(text);
        int[] array = {56, 24, 17, 12, 96, 13, 16};
        int[] newArray = (getMedian2(array));
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(" " + newArray[i]);
        }
    }

    public static boolean isTriangleText(String text) {
        boolean answer = true;
        if (text.length() % 3 == 0) {
            for (int i = 0; i < text.length() / 3; i++) {
                int diff = text.length() / 3;
                char currentChar = text.charAt(i);
                if (!(currentChar == text.charAt(i + diff) && currentChar == text.charAt(i + diff * 2))) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }

    public static boolean isAlmostTriangleText(String text) {
        boolean answer = false;
        int fouls = 0;
        if (!isTriangleText(text)) {
            if (text.length() % 3 == 0) {
                for (int i = 0; i < text.length() / 3; i++) {
                    int diff = text.length() / 3;
                    char currentChar = text.charAt(i);
                    if (currentChar != text.charAt(i + diff)) {
                        fouls++;
                    }
                    if (currentChar != text.charAt(i + diff + diff)) {
                        fouls++;
                    }
                }
            }
        }
        if (fouls == 1) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    public static boolean isSpecialString(String str) {
        boolean answer = false;
        for (int i = 0; i < str.length(); i++) {
            int myCharCounter = 0;
            int equalCharCounter = 0;
            char myChar = str.charAt(i);
            char equalChar = myChar;
            if (myChar >= 'A' && myChar <= 'Z') {
                equalChar += 32;
            } else {
                equalChar -= 32;
            }
            for (int j = 1; j < str.length(); j++) {
                if (myChar == str.charAt(j)) {
                    myCharCounter++;
                }
            }
        }
        return answer;
    }

    public static int[] turnToRight(int[] array) {
        int[] newArray = new int[array.length];
        newArray[0] = array[array.length - 1];
        for (int i = 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }

    public static int[] turnToLeft(int[] array) {
        int[] newArray = new int[array.length];
        newArray[newArray.length - 1] = array[0];
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i] = array[i + 1];
        }
        return newArray;
    }

    public static int fastestCircularTransformation(int[] original, int[] target) {
        int answer = -1;
        int leftCounter = 0;
        int rightCounter = 0;
        if (original.length == target.length) {
            int[] tempArray = new int[original.length];
            if (original != target) {
                for (int i = 0; i < original.length; i++) {
                    tempArray = turnToLeft(original);
                    if (tempArray[i] == target[i]) {
                        leftCounter++;
                    }
                    if (tempArray == target) {
                        break;
                    }
                }
                for (int j = 0; j < original.length; j++) {
                    tempArray = turnToRight(original);
                    rightCounter++;
                    if (tempArray == target) {
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static int printHighest(int[] array) {
        int theHighest = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (theHighest < array[i]) {
                theHighest = array[i];
            }
        }
        return theHighest;
    }

    public static int[] getMedian(int[] series) {
        int[] tempArray = new int[series.length];
        int counter = 0;
        //int checkNum;
        boolean checkSmall = true;
        //tempArray[tempArray.length-1]=printHighest(series);
        for (int i = 0; i < series.length; i++) {
            //checkNum=series[i];
            for (int j = 1; j < series.length; j++) {
                if ((series[i] > series[j])) {
                    checkSmall = false;
                }
            }
            if (checkSmall) {
                tempArray[counter] = series[i];
                counter++;

            }
            checkSmall = true;
        }
        return tempArray;
    }

    public static int[] getMedian2(int[] series) {
        int[] tempArray = new int[series.length];
        tempArray = series;
        int temp=0;
        for (int i = tempArray.length; i < 1; i--) {
            tempArray[i] = printHighest(series);
            temp=series

        }
        return series;
    }
}