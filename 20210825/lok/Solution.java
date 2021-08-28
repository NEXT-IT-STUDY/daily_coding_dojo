class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        //여기서부터 풀이
        long sum = 0L;
        for(int i=1; i<=count; i++){
            sum += price*i; 
            System.out.print("sum:"+sum);
        }
        if(money-sum >= 0){
            answer = 0;
        }else{
            answer = answer*(money-sum);
        }
        
        return answer;
    }
}
