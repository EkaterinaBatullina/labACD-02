/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.postfix;

import java.util.Scanner;

/**
 *
 * @author ekaterina
 */
public class Postfix {
//9 9 * 9 9 * + 9 9 * + 9 9 + 9 9 + * +
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //PostfixRealization firstExpression = new PostfixRealization(scanner.nextLine());
        //System.out.println(firstExpression.solve());
        String string = scanner.nextLine();
        int index1 = 2;
        byte flag = 0;
        
        for (int i = 4; i < string.length(); ++i) {
            
            if (((int) string.charAt(i) < 48) & ((int) string.charAt(i) != 32 & (int) string.charAt(i) != 33)) {
                
                int index2 = index1 - 2;
                
                while (((int) string.charAt(index2)) < 48 && (index2 - 1) > -1) {
                    index2--;
                }
                while ((index2 - 1) > -1 && (int) string.charAt(index2 - 1) > 47) {
                    index2--;
                }
                
                String result = "", first= "", second = "";
                int j = 0, k = 0;

                while((int) string.charAt(index2 + j) > 47) {
                    second += string.charAt(index2 + j);
                    j++;
                }
                while((int) string.charAt(index1 + k) > 47) {
                    first += string.charAt(index1 + k);
                    k++;
                }
                
                if (string.charAt(i) == '+'){
                    result = "" + (Integer.parseInt(second) + Integer.parseInt(first));
                }
                if (string.charAt(i) == '*'){
                    result = "" + (Integer.parseInt(second) * Integer.parseInt(first)); 
                }
                if (string.charAt(i) == '-'){
                    result = "" + (Integer.parseInt(second) - Integer.parseInt(first));
                }
                
                
                string = string.substring(0,index2) + result + string.substring(index2 + j, index1) + "!" + string.substring(index1 + k, i) + "!" + string.substring(i + 1);
               
                while (((index1 + 1) < string.length()) && ((int) string.charAt(index1 + 1) < 48)) {
                    index1++;  
                }
                
                if (index1 == string.length() - 1) {
                    while ((int) string.charAt(index1) < 48 && (index1 - 1) > -1) {
                        index1--;
                        flag = 1;   
                    }
                    while ((index1 - 1) > -1 && (int) string.charAt(index1 - 1) > 47) {
                        index1 --;
                    }
                }
            } 
            
            else {
                
                 if (flag != 1) {
                     index1 = i;
                     while ((int) string.charAt(index1) < 48 ) {
                        index1 --;
                     }
                     while ((index1 - 1) > -1 && (int) string.charAt(index1 - 1) > 47) {
                        index1 --;
                     }
                 }
            }
            
        System.out.println(string);
        
        } 
        
        int i = 0;
        while (string.charAt(i) > 47) {
            System.out.print(string.charAt(i));
            i++;
        }
        
    }
    
}
