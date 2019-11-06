/**
 * @ClassName Test
 * @Description TODO
 * @Auther danni
 * @Date 2019/11/6 15:12]
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
    public int findKth(int[] a, int n, int K) {
        return quickSort(a,0,n-1,K);
    }
    private int quickSort(int[] arr, int low, int high,int K){
        int p = partion(arr,low,high);
        if(K == p-low+1){
            return arr[p];
        }else if(p-low+1 > K){
            //递归左边
            return quickSort(arr,low,p-1,K);
        }else{
            //递归右边
            return quickSort(arr,p+1,high,K-(p-low+1));
        }
    }
    private int partion(int[] arr, int low, int high){
       int tmp=arr[low];
        while(low < high){
            while(low < high && arr[high] <= tmp){
                high--;
            }
            if(low == high){
                break;
            }else{
                arr[low] = arr[high];
            }
            while(low < high && arr[low] >= tmp){
                low++;
            }
            if(low == high){
                break;
            }else{
                arr[high] = arr[low];
            }
        }
        arr[low] = tmp;
        return low;
    }

    public static void main(String[] args){
       Main main=new Main();
       int[] a={1,3,5,2,2};
        System.out.println(main.findKth(a,5,4));

    }
}
