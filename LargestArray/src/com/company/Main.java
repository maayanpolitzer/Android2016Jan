package com.company;

public class Main {

    //static int[] arr = {7, -50, 13, 82, -5, 6, -2};
    static int[] arr = {3, 0, 0};
    static int from, to;
    static boolean checked;

    public static void main(String[] args) {

        System.out.println("Largest sum is: " + largestSum());   //should print 96;

        //ADVANCED:

        int[] largestArray = largestArray();
        System.out.print("{");
        for (int i = 0; i < largestArray.length; i++){
            if (i == largestArray.length - 1){
                System.out.print( largestArray[i] + "}");
            }else {
                System.out.print(largestArray[i] + ",");
            }
        }


    }

    private static int largestSum(){
        checked = true;
        int largestSoFar = arr[0];  //3
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int sum = getSum(i, j); //3
                if (sum >= largestSoFar){
                    largestSoFar = sum;
                    from = i;
                    to = j;
                //    System.out.println(from+ "," +  to);
                }
            }
            //System.out.println();
        }
        return largestSoFar;
    }

    private static int getSum(int from, int to){
        int sum = 0;
        for (int i = from ; i <= to; i++){
            sum += arr[i];
        }
        return sum;
    }

    private static int[] largestArray(){
        int[] newArr = new int[to - from + 1];
        if (checked){
            for (int i = 0; i < newArr.length; i++){
                newArr[i] = arr[from + i];
            }
            return newArr;
        }
        return null;
    }
}
