package com.zhq.MediumProblem;

import java.util.*;

/**
 * @author : ZHQ
 * @date : 2020/2/9
 */
public class Test56_3 {
    private static class Interval {
        int start;
        int end;

        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }

    private Map<Interval, List<Interval>> graph;
    private Map<Integer, List<Interval>> nodesInComp;
    private Set<Interval> visited;

    // return whether two intervals overlap (inclusive)
    private boolean overlap(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }

    // build a graph where an undirected edge between intervals u and v exists
    // iff u and v overlap.
    private void buildGraph(List<Interval> intervals) {
        graph = new HashMap<>();
        for (Interval interval : intervals) {
            graph.put(interval, new LinkedList<>());
        }

        for (Interval interval1 : intervals) {
            for (Interval interval2 : intervals) {
                if (overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    // merges all of the nodes in this connected component into one interval.
    private Interval mergeNodes(List<Interval> nodes) {
        int minStart = nodes.get(0).start;
        for (Interval node : nodes) {
            minStart = Math.min(minStart, node.start);
        }

        int maxEnd = nodes.get(0).end;
        for (Interval node : nodes) {
            maxEnd = Math.max(maxEnd, node.end);
        }

        return new Interval(minStart, maxEnd);
    }

    // use depth-first search to mark all nodes in the same connected component
    // with the same integer.
    private void markComponentDFS(Interval start, int compNumber) {
        Stack<Interval> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Interval node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);

                if (nodesInComp.get(compNumber) == null) {
                    nodesInComp.put(compNumber, new LinkedList<>());
                }
                nodesInComp.get(compNumber).add(node);

                for (Interval child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }

    // gets the connected components of the interval overlap graph.
    private void buildComponents(List<Interval> intervals) {
        nodesInComp = new HashMap();
        visited = new HashSet();
        int compNumber = 0;

        for (Interval interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }

    /**
     * 照抄官方题解，没看懂
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        buildGraph(intervals);
        buildComponents(intervals);

        // for each component, merge all intervals into one interval.
        List<Interval> merged = new LinkedList<>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }

        return merged;
    }


    public static void main(String[] args) {
        // TODO: 2020/2/9   没看懂

    }

}
