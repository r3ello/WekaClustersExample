/**
 * 
 */
package com.example.easyweka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import weka.clusterers.ClusterEvaluation;

import weka.clusterers.EM;
import weka.clusterers.FarthestFirst;
import weka.clusterers.HierarchicalClusterer;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * @author ralph
 *
 */
@Component
public class KMeansService {

	public void Cluster() 
	{


		// Perform K-Means clustering.
		try { 
			URL fileLocation = new ClassPathResource("data1.arff").getURL();	        

			FileReader f = new FileReader(fileLocation.getPath());
			BufferedReader b= new BufferedReader(f);
			DataSource dataS = new DataSource(fileLocation.getPath());
			Instances data = dataS.getDataSet();

			SimpleKMeans kmeans = new SimpleKMeans();
			kmeans.setNumClusters(3);
			kmeans.setMaxIterations(50);
			kmeans.setPreserveInstancesOrder(true);
			kmeans.buildClusterer(data);
			ClusterEvaluation eval = new ClusterEvaluation();
			eval.setClusterer(kmeans);
			eval.evaluateClusterer(data);
			System.out.println(eval.clusterResultsToString());
			

			FarthestFirst farthestFirst = new FarthestFirst();
			farthestFirst.setNumClusters(3);
			farthestFirst.buildClusterer(data);
			eval = new ClusterEvaluation();
			eval.setClusterer(farthestFirst);
			eval.evaluateClusterer(data);
			System.out.println(eval.clusterResultsToString());
			
			

			EM em = new EM();		
			em.setMaxIterations(50);
			em.buildClusterer(data);			
			ClusterEvaluation eval1 = new ClusterEvaluation();
			eval1.setClusterer(em);
			eval1.evaluateClusterer(data);
			System.out.println(eval1.clusterResultsToString());

		} catch (Exception ex) {
			System.err.println("Unable to buld Clusterer: " + ex.getMessage());
			ex.printStackTrace();
		}



	}

}
