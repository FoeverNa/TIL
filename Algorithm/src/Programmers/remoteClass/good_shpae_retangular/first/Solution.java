package Programmers.remoteClass.good_shpae_retangular.first;


class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));
        while(wl != 0 ) {
            long temp = hl % wl;
            hl = wl;
            wl = temp;
        }

        answer=  (w*h)-((w*h)/ ((w/hl)*(h/hl)));


        return answer;
    }
}