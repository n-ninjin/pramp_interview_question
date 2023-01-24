package questions.flatten_dictionary;
/*
Flatten a Dictionary
A dictionary is a type of data structure that is supported natively in all major interpreted languages such as JavaScript,
Python, Ruby and PHP, where it’s known as an Object, Dictionary, Hash and Array, respectively.
In simple terms, a dictionary is a collection of unique keys and their values. The values can typically be of
any primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be nested).
However, for this exercise assume that values are either an integer, a string or another dictionary.
Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .
If you’re using a compiled language such Java, C++, C#, Swift and Go, you may want to use a Map/Dictionary/Hash Table
that maps strings (keys) to a generic type (e.g. Object in Java, AnyObject in Swift etc.) to allow nested dictionaries.

If a certain key is empty, it should be excluded from the output (see e in the example below).

Example:

input:  dict = {
            "Key1" : "1",
            "Key2" : {
                "a" : "2",
                "b" : "3",
                "c" : {
                    "d" : "3",
                    "e" : {
                        "" : "1"
                    }
                }
            }
        }

output: {
            "Key1" : "1",
            "Key2.a" : "2",
            "Key2.b" : "3",
            "Key2.c.d" : "3",
            "Key2.c.e" : "1"
        }
 */

import java.util.HashMap;

class Solution {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String, String> res = new HashMap<>();
        helper("", dict, res);
        return res;
    }

    static void helper(String input, HashMap<String, Object> dict, HashMap<String, String> res) {
        for (String key : dict.keySet()) {
            Object value = dict.get(key);

            if (!(value instanceof HashMap<?, ?>)) {
                if (key == "" || input == "" || input == null) {
                    res.put(key + input, "" + value);
                } else {
                    res.put(input + "." + key, "" + value); // key1 : 1
                }
            } else {
                if (key == "" || input == "" || input == null) {
                    helper(key, (HashMap<String, Object>) value, res);
                } else {
                    helper(input + "." + key, (HashMap<String, Object>) value, res);
                }
            }
        }
    }

    public static void main(String[] args) {
    /*
       TC: O(N)
       SC: O(N)
      */
    }
}


