import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;


class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        //여기서부터 풀이
        /*
        00 10 20    00 01 02
        01 11 21    10 11 12
        02 12 22    20 21 22
        	 [[70, 49, 90]
            , [68, 50, 38]
            , [73, 31, 100]]

             [[70, 68, 73 ]
            , [49, 50, 31]
            , [90, 38, 100]]
        */

        int length = scores[0].length; //길이는 전부 동일
        int[][] scores_rep = new int[length][length]; //n번 학생의 점수모음

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                scores_rep[j][i] = scores[i][j];
                // 여기서 바로 계산할 경우 시간차가 있어서 올바른 값을 내지 못함
            }
        }


        int[] sum = new int[length];
        double[] avg = new double[length];

        for(int i = 0; i < length; i++){
            String minus = "N"; //자신의 점수를 제외하는지 여부
            //for(int j = 0; j < length; j++){
            //int[][] scores_sort = scores_rep.clone();
            //Arrays.sort(scores_sort[i]);

            int max = Arrays.stream(scores_rep[i]).max().getAsInt();
            int min = Arrays.stream(scores_rep[i]).min().getAsInt();

            ///////////////// 유일 여부 조건 필요
            int me = scores_rep[i][i];

            if(scores_rep[i][i] == max || scores_rep[i][i] == min ){

                int[] num = Arrays.stream(scores[i]).distinct().toArray();
                if(num.length >= 4){
                    //내가 매긴 점수가 max나 min이고 중복되는 숫자 없음(==유일) > 점수제외
                    scores_rep[i][i] = 0;
                    minus = "Y";
                }else{
                    if(Arrays.stream(scores[i]).allMatch(/*Predicate<T>가 와야함 ㅠ*/)){
                        //내가 매긴 점수가 max나 min이고 중복제거가 되었는데 그게 내 점수는 아님(==유일) > 점수제외
                        scores_rep[i][i] = 0;
                        minus = "Y";
                    }else{
                        //내가 매긴 점수가 max나 min이고 중복제거가 되었는데 그게 내 점수(!=유일) > 점수포함
                    }
                }
            }

            sum[i] = Arrays.stream(scores_rep[i]).sum();

            //}

            //분모 구하기
            if(minus.equals("Y")){
                avg[i] = sum[i]/(length-1);
            }else{
                avg[i] = sum[i]/(length);
            }

            //최종 점수 계산
            if(avg[i] >= 90){
                answer += "A";
            }else if(avg[i] >= 80){
                answer += "B";
            }else if(avg[i] >= 70){
                answer += "C";
            }else if(avg[i] >= 50){
                answer += "D";
            }else{
                answer += "F";
            }
        }

        return answer;
    }
}
