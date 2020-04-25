package com.zhq.MediumProblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author : ZHQ
 * @date : 2020/4/24
 */
public class Test332 {

    /**
     * 欧拉回路问题
     *
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> retList = new ArrayList<>();
        if (null == tickets || tickets.size() == 0) {
            return retList;
        }
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<String> list = graph.computeIfAbsent(ticket.get(0), k -> new LinkedList<>());
            list.add(ticket.get(1));
        }
        graph.values().forEach(x -> x.sort(String::compareTo));
        DFS(graph, "JFK", retList);

        return retList;
    }


    public void DFS(Map<String, List<String>> graph, String src, List<String> retList) {
        List<String> list = graph.get(src);
        while (null != list && list.size() > 0) {
            String dest = list.remove(0);
            DFS(graph, dest, retList);
        }
        retList.add(0, src);
    }


    @Test
    public void test() {
        List<List<String>> inputMatrix = new ArrayList<>();
        inputMatrix.add(Arrays.asList("MUC", "LHR"));
        inputMatrix.add(Arrays.asList("JFK", "MUC"));
        inputMatrix.add(Arrays.asList("SFO", "SJC"));
        inputMatrix.add(Arrays.asList("LHR", "SFO"));

        List<String> itinerary = findItinerary(inputMatrix);
        for (String s : itinerary) {
            System.out.println(s);
        }

    }




}
