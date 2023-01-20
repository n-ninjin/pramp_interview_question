package questions.validate_ip_address;

/*
Validate IP Address
Validate an IP address (IPv4). An address is valid if and only if it is in the form "X.X.X.X", where each X is a number
from 0 to 255.
For example, "12.34.5.6", "0.23.25.0", and "255.255.255.255" are valid IP addresses, while "12.34.56.oops", "1.2.3.4.5",
and "123.235.153.425" are invalid IP addresses.

Examples:
ip = '192.168.0.1'
output: true
ip = '0.0.0.0'
output: true
ip = '123.24.59.99'
output: true
ip = '192.168.123.456'
output: false
Constraints:

[time limit] 5000ms
[input] string ip
[output] boolean
 */

import java.io.*;
import java.util.*;

class Solution {
    static boolean validateIP(String ip) {
        // your code goes here
        int l = 0, r = 0;
        int num = 0;
        int dotCnt = 0;
        while (r < ip.length()) {
            if (ip.charAt(r) != '.') {
                if (!Character.isDigit(ip.charAt(r))) return false;
                num = num * 10 + (ip.charAt(r) - '0');
            } else {
                if (l == r) return false;
                if (num > 255) return false;
                num = 0;
                dotCnt++;
                l = r + 1;
            }
            if (r == ip.length() - 1 && num > 255) {
                return false;
            }
            if (dotCnt > 3) return false;
            r++;
        }
        return true;

    }

    public static void main(String[] args) {
        /* Expected output: true */
        System.out.println(validateIP("192.168.0.1"));
        /* Expected output: false */
        System.out.println(validateIP("1..23.4"));
        System.out.println(validateIP("12.34.56.oops"));
        System.out.println(validateIP("1.2.3.4.5"));
        System.out.println(validateIP("192.168.123.456"));
    }
}
