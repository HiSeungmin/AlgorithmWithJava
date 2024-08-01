package Hash;

import java.util.HashMap;

public class Hash0818 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,8};
        int[] a2 = {2,3,5,9};
        System.out.println(hash(a,6));
        System.out.println(hash(a2,10));
    }
    public static boolean hash(int[] arr, int target){

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length ; i++) {
            hashMap.put(arr[i],arr[i]);
        }

        for (int i = 0; i < arr.length ; i++) {
            int x = arr[i];
            if(target-x!=x && hashMap.containsKey(target-x)){
                return true;
            }
        }

        return false;
    }
}
