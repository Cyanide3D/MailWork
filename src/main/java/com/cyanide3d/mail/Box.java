package com.cyanide3d.mail;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class Box {

    private final int cost;
    private final List<Integer> packages;

    public Box(int cost) {
        packages = new ArrayList<>();
        this.cost = cost;
    }

    public void addPackage(int pack) {
        packages.add(pack);
    }

    public int getBoxSize() {
        return packages.size();
    }

    public int getSumBoxCost() {
        int min = packages.stream().min(Comparator.comparing(Integer::intValue)).orElse(0);
        int max = packages.stream().max(Comparator.comparing(Integer::intValue)).orElse(0);

        return  ((max - min) * (packages.size() * packages.size())) + cost;
    }

}
