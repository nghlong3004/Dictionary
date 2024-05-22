package dictionary;

public class Word {
	private String wordE, wordVi;
	public String getWordE() {
		return wordE;
	}
	public void setWordE(String wordE) {
		this.wordE = wordE;
	}
	public void setWordVi(String wordVi) {
		this.wordVi = wordVi;
	}
	public void wordTarget(String wordE, String wordVi){
		this.wordE = wordE;
		this.wordVi = wordVi;
	}
	public String wordExplain(){
		return wordVi;
	}
	public Word(String wordE, String wordVi){
		this.wordE = wordE;
		this.wordVi = wordVi;
	}
	public String getWordVi() {
		return wordVi;
	}
	public Word(){
		
	}
}
