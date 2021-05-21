package com.cyanide3d.mail;

import java.util.*;

public class PackageHolder {

    private final Queue<Integer> packages = new ArrayDeque<>();

    public void calculate() {
        Scanner scanner = new Scanner(System.in);

        String[] values = scanner.nextLine().split("");

        int packageAmount = Integer.parseInt(values[0]);
        int packagesInBoxAmount = Integer.parseInt(values[1]);
        int boxCost = Integer.parseInt(values[2]);

        for (int i = 0; i < packageAmount; i++) {
            packages.add(scanner.nextInt());
        }

        Packager packager = new Packager().builder()
                .setPackageAmount(packageAmount)
                .setPackagesInBoxAmount(packagesInBoxAmount)
                .addPackages(packages)
                .build();

        List<Box> boxes = packager.pack(boxCost);
        int sumCost = boxes.stream().mapToInt(Box::getSumBoxCost).sum();
        System.out.println(sumCost);
    }

}
