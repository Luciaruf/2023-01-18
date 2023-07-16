package it.polito.tdp.nyc.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	NYCDao dao;
	Graph<String,DefaultWeightedEdge> graph;

	public Model() {
		this.dao = new NYCDao();
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	}
	
	public List<String> getProvider(){
		return this.dao.getProvider();
	}
	
	public Graph creaGrafo(String provider) {
		this.graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.graph, this.dao.getVertices(provider));
		
		return this.graph;
		
	}
	
	
}
