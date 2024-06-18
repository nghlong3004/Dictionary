package Sever;

import java.util.TreeMap;

public class Dictionary {
	private final TreeMap<String,String> treeEngVi = new TreeMap<String, String>();
	public TreeMap<String, String> getTree() {
		return this.treeEngVi;
	}
	private final TreeMap<String, String> treeViEng = new TreeMap<String,String>();
	public TreeMap<String, String> getTreeVE(){
		return this.treeViEng;
	}
	
}

