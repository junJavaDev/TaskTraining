package ru.jvst.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">1004. Max Consecutive Ones III</a>
 <div class="xFUwe" data-track-load="description_content"><p>Given a binary array <code>nums</code> and an integer <code>k</code>, return <em>the maximum number of consecutive </em><code>1</code><em>'s in the array if you can flip at most</em> <code>k</code> <code>0</code>'s.</p>

 <p>&nbsp;</p>
 <p><strong class="example">Example 1:</strong></p>

 <pre><strong>Input:</strong> nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 <strong>Output:</strong> 6
 <strong>Explanation:</strong> [1,1,1,0,0,<u><strong>1</strong>,1,1,1,1,<strong>1</strong></u>]
 Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.</pre>

 <p><strong class="example">Example 2:</strong></p>

 <pre><strong>Input:</strong> nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 <strong>Output:</strong> 10
 <strong>Explanation:</strong> [0,0,<u>1,1,<strong>1</strong>,<strong>1</strong>,1,1,1,<strong>1</strong>,1,1</u>,0,0,0,1,1,1,1]
 Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 </pre>

 <p>&nbsp;</p>
 <p><strong>Constraints:</strong></p>

 <ul>
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 <li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
 <li><code>0 &lt;= k &lt;= nums.length</code></li>
 </ul>
 </div>
 **/

/*
Похожая задача (для понимания).
Вопрос: вы можете изменить максимум один ноль на 1.
Назовите максимальное количество последовательных чисел.
Идея всегда связана с двумя указателями, например,
когда вам нужно найти самый длинный подмассив с некоторой возможностью модификации в массиве.

public int maxConsecutiveOne(int[] arr){
    // Обработка граничного случая, при пустом массиве
    if(arr.length==0) return 0;

    // Левый (начальный) индекс массива.
    int left=0;

    // Правый (конечный) индекс массива.
    int right=0;

    // Последний индекс нуля. (Инициируется -1).
    int lastZeroIdx=-1;

    Мы ищем такую часть массива, где между левым и правым индексом один 0

    int result=0;

        Проходим правым индексом по всему массиву.
        while(right!=arr.length){

            Если значение в ячейке 0 - Нужно левый индекс поставить
            на следующую ячейку от предыдущего нуля,
            а переменной lastZeroIdx присвоить текущий индекс.

            При первом нуле это будет начало массива, для этого мы инициировали lastZeroIdx -1

            Таким образом мы получим подмассив длинной от предыдущего нуля до текущего

            if(arr[right]==0){
	            left=lastZeroIdx+1;
		        lastZeroIdx=right;
	        }

	        Если текущая ячейка не равна нулю, то длина искомого массива равна
	        от предыдущего нуля невключительно, до текущей единицы. Т.к. мы говорим
	        об индексах, то для вычисления длины к right-left нужно добавить 1.

	        Присваиваем максимальное значение переменной result
	        и делаем следующую итерацию.

            result=Math.max(result,right-left+1);   //both right and left included in window
	        right++;
        }
    return result;
}
 */


    // Для решения текущей задачи, идея та же что и для maxConsecutiveOne,
    // только теперь нужно хранить нулевые индексы в очереди.
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] arr, int k) {
        Queue<Integer> zeroes=new ArrayDeque<>();
        int right=0;
        int left=0;
        int result=0;


        while(right!=arr.length){
            if(arr[right]==0){
                zeroes.add(right);
            }
            if(zeroes.size()==k+1){
                left=zeroes.remove()+1;
            }
            result=Math.max(right-left+1,result);
            right++;
        }
        return result;
    }
}
