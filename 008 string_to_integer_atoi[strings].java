/*
8. String to Integer (atoi)
---
Implement atoi to convert a string to an integer.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
You are responsible to gather all the input requirements up front.
---
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace
character is found. Then, starting from this character, takes an optional initial plus or minus sign
followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are
ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no
such sequence exists because either str is empty or it contains only whitespace characters,
no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of
the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
---
HINT:
To deal with overflow, inspect the current number before multiplication. If the current number is
greater than 214748364, we know it is going to overflow. On the other hand, if the current number is
equal to 214748364, we know that it will overflow only when the current digit is greater than or equal to 8.
 */

public class Solution {
    /* Overflow explanation: Integer.MAX_VALUE = 2147483647 and Integer.MIN_VALUE = -2147483648 
        is the largest/smallest value that an int primitive can contain.

       Let's simplify this problem. Suppose str1 = " -a649b ", st2 = " a652b ", max = 647, min = -648.
        So if atoi(str) > 647 || atoi(str) < -648 atoi will overflow. In other words, when we've parsed
        num == 64 and the next char is also digit, max / min can directly be returned if the next digit>=8
    */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        
        // trim white spaces
        str = str.trim();
        char[] c = str.toCharArray();
        int i = 0;
        
        // check sign
        int sign = 1;
        if (i < c.length && (c[0] == '-' || c[0] == '+') ) {
            if (c[0] == '-') {
                sign = -1;
            }
            i++;
        }
        
        int number = 0;

        // check overflow: largest/smallest value that an int primitive can contain
        int bound = Integer.MAX_VALUE / 10;
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            int digit = c[i] - '0';
            if (number > bound || (number == bound && digit > 7) ) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            number = (number * 10) + digit;
            i++;
        }
        
        return sign * number;
    }
}


