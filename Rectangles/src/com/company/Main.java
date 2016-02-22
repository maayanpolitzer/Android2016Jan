package com.company;

public class Main {

    static boolean[][] arr = new boolean[30][50];



    public static void main(String[] args) {

        createRect(5,5,20,10);
        //createRect(7,8,20,10);
        //createRect(9,15,20,10);
        render();


    }

    private static void createRect(int top, int left, int width, int height){
        /*
        for(int i = top; i < top + height; i++){
            for (int j = left; j < left + width; j++){
                arr[i][j] = true;
            }
        }
    `   */

        for (int i = top; i < top + height; i++){
            arr[i][left] = true;
            arr[i][width +left] = true;
        }

        for (int i = left; i <= width + left; i++){
            arr[top][i] = true;
            arr[top + height][i] = true;
        }

    }

    private static void render() {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] ? "# " : ". ");
            }
            System.out.println();
        }
    }
}
