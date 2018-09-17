package com.lone.leetcode.k

/**
 * @author liujinlong
 * @date  2018/9/14
 */
class Solution4 {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val sum = nums1.size + nums2.size
        var first:Int
        var second:Int
        if (sum % 2 == 0) {
            first = sum /2 -1
            second = first + 1
        } else {
            first = sum/2
            second = first
        }
        val nArr = merge(nums1,nums2,second + 1)
        return (nArr[first] + nArr[second])/2.0
    }

    fun merge(nums1: IntArray, nums2: IntArray,length:Int): IntArray {
        val nArr = IntArray(length)
        var n = 0
        var i=0
        var j=0
        while(i < nums1.size && j <nums2.size && n < length) {
            if(nums1[i] > nums2[j]) {
                nArr[n++] = nums2[j++]
            } else {
                nArr[n++] = nums1[i++]
            }
        }

        while(i < nums1.size && n < length) {
            nArr[n++] = nums1[i++]
        }
        while (j < nums2.size && n < length) {
            nArr[n++] = nums2[j++]
        }
        return nArr

    }

}

fun main(args: Array<String>) {
    val nums1 = intArrayOf(1,2)
    val nums2 = intArrayOf(3,4)

    print(Solution4().findMedianSortedArrays(nums1,nums2))
}