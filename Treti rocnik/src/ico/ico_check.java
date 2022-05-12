package ico;

import java.util.Arrays;
import java.util.Scanner;

public class ico_check {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(check(sc.nextInt()));
    }

    static boolean check(int ico) {
        if ((String.valueOf(ico).length() != 8)) return false;
        int temp = ico;
        int nums[] = new int[8];
        for (int i = nums.length-1; i >= 0; i--) {
            nums[i] = temp % 10;
            temp /= 10;
        }
        return nums[7] == (11 - ((8*nums[0] + 7*nums[1] + 6*nums[2] + 5*nums[3] + 4*nums[4] + 3*nums[5] + 2*nums[6]) % 11))%10;
    }
}
