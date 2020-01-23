package com.lone.leetcode.j;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class Solution71 {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return path;
        }
        String[] arr = path.split("/");
        String[] res = new String[arr.length];
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            String p = arr[i];
            switch (p) {
                case "":
                    break;
                case "..":
                    if(j > 0) {
                        res[--j] = null;
                    }
                    break;
                case ".":
                    break;
                default:
                    res[j++] = p;
                    break;
            }
        }
        StringBuilder str = new StringBuilder("/");
        for (int i = 0; i < j; i++) {
            str.append(res[i]);
            if (i != j-1) {
                str.append("/");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Solution71 soution71 = new Solution71();
        soution71.simplifyPath("/home/");
    }
}
