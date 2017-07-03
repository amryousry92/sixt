/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose Tools | Templates and open the
 * template in the editor.
 */
package sixt;

import java.util.Arrays;

/**
 *
 * @author Amr
 */
public class Anagram {

    /**
     * @param lhs
     * @param rhs
     * @return
     */
    public static boolean isAnagram(String lhs, String rhs) {
        if (lhs.equals(rhs)) {
            return true;
        }

        char[] lhsArray = lhs.toCharArray();
        char[] rhsArray = rhs.toCharArray();
        if (lhsArray.length != rhsArray.length) {
            return false;
        }
        Arrays.sort(lhsArray);
        Arrays.sort(rhsArray);
        return Arrays.equals(rhsArray, lhsArray);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("baaaan", "aaacan"));
    }
}
