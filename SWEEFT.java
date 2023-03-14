package debili;

import java.util.*;

public class SWEEFT {
    public static int singleNumber(int[]arr){
        int answer = 0;
        for (int i:arr) {
            answer^=i;
        }
        return answer;
    }

    public static int notContain(int[]arr){
        Set<Integer> set = new HashSet<>();
        for(int i:arr){
            if(i>=0)
                set.add(i);
        }
        int i = 0;
        while (set.contains(i)){
            i++;
        }
        return i;
    }

    public static int CountVariants(int n){
        if (n<=2)
            return 1;
        int[]dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    static class List<T>{
        private T info;
        private List<T> next;
        public List(T info){
            this.info = info;
            this.next = null;
        }
        public List(T info,List<T> next){
            this.info = info;
            this.next = next;
        }
    }

    static class Stack<T>{
        List<T> head;

        public Stack(){
            head = null;
        }
        public void push(T info){
            head = new List<>(info,head);
        }
        public T pop(){
            if(head!=null){
                T temp = head.info;
                head = head.next;
                return temp;
            }
            return null;
        }

    }

    public static int minSplit(int amount){
        return f(new int[]{1,5,10,20,50},amount);
    }

    public static int f(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }



    public static void main(String[] args) {
        int [] test1 = {1,1,2,3,2,3,5,7,7,8,8};
        System.out.println(singleNumber(test1));

        int [] test3 = {0,1,2,4,-2,-7,6,7};
        System.out.println(notContain(test3));

        System.out.println(CountVariants(7));
    }

}

