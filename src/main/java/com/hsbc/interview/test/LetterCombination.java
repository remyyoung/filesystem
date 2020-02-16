package com.hsbc.interview.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LetterCombination {
    //实现字符的组合
    static ArrayList<String> letterCombinationsUtil(int[] number, int n,
                                                    String[] table)
    {
        // 保存字符
        ArrayList<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while(!q.isEmpty())
        {
            String s = q.remove();


            if (s.length() == n)
                list.add(s);
            else
            {
                String val = table[number[s.length()]];
                for (int i = 0; i < val.length(); i++)
                {
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }



    //创建0-9映射z-z，调用letterCombinationsUtil
    static void letterCombinations(int[] number, int n)
    {

        String[] table = { "", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz" };

        ArrayList<String> list =
                letterCombinationsUtil(number, n, table);

        // 打印
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
    }


    public static void main(String args[])
    {
        int[] number = { 2, 3 };
        int n = number.length;
        letterCombinations(number, n);
    }
}
