package com.bfm.corpapps.ignite;

import java.util.*;

import org.apache.ignite.*;

public class Client {

    public static void main(String[] args) throws IgniteException {
    	Ignition.setClientMode(true);
    	
        String phrase = "Apache Ignite Compute Demo";
        
    	try (Ignite ignite = Ignition.start("config/ignite-compute.xml")) {
            System.out.println();
            System.out.println(">>> Ignite client started.");

			List<String> params = Arrays.asList(phrase.split(" "));
			Collection<Integer> res = ignite.compute().apply(
                (String word) -> {
                    System.out.println();
                    System.out.println(">>> Computing length of [" + word + "] on this node.");
                    return word.length();
                },
                // Job parameters. Ignite will create as many jobs as there are parameters.
                params
            );

            int sum = res.stream().mapToInt(i -> i).sum();

            System.out.println(">>> Total number of characters in the phrase is '" + sum + "'.");
            System.out.println();
        }
    }
}
