package Programmers.remoteClass.fanod;

/**
 *문제 설명
 * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
 * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
 *
 * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
 * 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 노드의 개수 n은 2 이상 20,000 이하입니다.
 * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
 * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Node implements Comparable<Node> {
    int index;
    int dist;
    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(dist, o.dist);
    }
}
class Solution {
    public int solution(int n, int[][] edge) {
        int [] dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        List<List<Integer>> adj_lists = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            List<Integer> adj_list = new ArrayList<>();
            for (int[] e: edge) {
                if (e[0] == i) {
                    adj_list.add(e[1]);
                } else if (e[1] == i) {
                    adj_list.add(e[0]);
                }
            }
            adj_lists.add(adj_list);
        }
        PriorityQueue<Node> heap = new PriorityQueue<>();
        dists[1] = 0;
        heap.add(new Node(1, dists[1]));
        while (!heap.isEmpty()) {
            Node node = heap.remove();
            for (int indVisit: adj_lists.get(node.index)) {
                if (node.dist + 1 < dists[indVisit]) {
                    dists[indVisit] = node.dist + 1;
                    heap.add(new Node(indVisit, dists[indVisit]));
                }
            }
        }
        int max = 0;
        int answer = 0;
        dists[0] = 0;
        for (int el: dists) {
            if (el == max) {
                answer++;
            }
            if (el > max) {
                max = el;
                answer = 1;
            }
        }
        return answer;
    }
}