package Sever;

import java.util.TreeMap;

public class Dictionary {
	private final String ADDRESSIMAGE = "image\\";
	private final String ADDRESSFILE = "data.txt";
	private final int H = 60, W = 450;
	public int getH() {
		return H;
	}
	public int getW() {
		return W;
	}
	public String getADDRESSFILE() {
		return ADDRESSFILE;
	}
	public  String getADDRESSIMAGE() {
		return ADDRESSIMAGE;
	}
	private TreeMap<String,String> tree;
	public TreeMap<String, String> getTree() {
		return this.tree;
	}
	public void setTree(TreeMap<String, String> tree) {
		this.tree = tree;
	}
	public Dictionary(){
		tree = new TreeMap<String, String>();
	}
	
}

