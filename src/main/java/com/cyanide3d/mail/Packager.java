package com.cyanide3d.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Packager {
    private Queue<Integer> packages;
    int packageAmount;
    int packagesInBoxAmount;

    public Packager() {
    }

    public Packager(Queue<Integer> packages, int packageAmount, int packagesInBoxAmount) {
        this.packages = packages;
        this.packageAmount = packageAmount;
        this.packagesInBoxAmount = packagesInBoxAmount;
    }

    public List<Box> pack(int boxCost) {
        List<Box> boxes = new ArrayList<>();
        while (!packages.isEmpty()) {
            boxes.add(getBox(boxCost));
        }
        return boxes;
    }

    private Box getBox(int boxCost) {
        Box box = new Box(boxCost);
        for (int i = 0; i < packagesInBoxAmount; i++) {
            if (packages.isEmpty()) {
                break;
            }
            box.addPackage(packages.poll());
        }
        return box;
    }

    public PackagerBuilder builder() {
        return new PackagerBuilder();
    }

}

class PackagerBuilder {
    private Queue<Integer> packages;
    private int packageAmount;
    private int packagesInBoxAmount;;

    public PackagerBuilder addPackages(Queue<Integer> packages) {
        this.packages = packages;
        return this;
    }

    public PackagerBuilder setPackageAmount(int packageAmount) {
        this.packageAmount = packageAmount;
        return this;
    }

    public PackagerBuilder setPackagesInBoxAmount(int packagesInBoxAmount) {
        this.packagesInBoxAmount = packagesInBoxAmount;
        return this;
    }


    public Packager build() {
        return new Packager(packages, packageAmount, packagesInBoxAmount);
    }
}
