package entity;

public class Aventura {

    private int id;
    private Nos No;
    private int dinheiro;
    private int habilidadeMax;
    private int habilidadeAtual;
    private int energiaMax;
    private int energiaAtual;
    private int sorteMax;
    private int sorteAtual;
    private boolean aventureiro;

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Nos getNo() {
		return No;
	}
	public void setNo(Nos no) {
		No = no;
	}
	public int getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro(int dinheiro) {
		this.dinheiro = dinheiro;
	}
	public int getHabilidadeMax() {
		return habilidadeMax;
	}
	public void setHabilidadeMax(int habilidadeMax) {
		this.habilidadeMax = habilidadeMax;
	}
	public int getHabilidadeAtual() {
		return habilidadeAtual;
	}
	public void setHabilidadeAtual(int habilidadeAtual) {
		this.habilidadeAtual = habilidadeAtual;
	}
	public int getEnergiaMax() {
		return energiaMax;
	}
	public void setEnergiaMax(int energiaMax) {
		this.energiaMax = energiaMax;
	}
	public int getEnergiaAtual() {
		return energiaAtual;
	}
	public void setEnergiaAtual(int energiaAtual) {
		this.energiaAtual = energiaAtual;
	}
	public int getSorteMax() {
		return sorteMax;
	}
	public void setSorteMax(int sorteMax) {
		this.sorteMax = sorteMax;
	}
	public int getSorteAtual() {
		return sorteAtual;
	}
	public void setSorteAtual(int sorteAtual) {
		this.sorteAtual = sorteAtual;
	}
	public boolean isAventureiro() {
		return aventureiro;
	}

	public void setAventureiro(boolean aventureiro) {
		this.aventureiro = aventureiro;
	}
}
