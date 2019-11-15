package entity;

public class Nos {

	private int id;
	private String descricao;
	private Nos no1;
	private Nos no2;
	private Nos no3;
	private Monstro inimigo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Nos getNo1() {
		return no1;
	}

	public void setNo1(Nos no1) {
		this.no1 = no1;
	}

	public Nos getNo2() {
		return no2;
	}

	public void setNo2(Nos no2) {
		this.no2 = no2;
	}

	public Nos getNo3() {
		return no3;
	}

	public void setNo3(Nos no3) {
		this.no3 = no3;
	}

	public Monstro getInimigo() {
		return inimigo;
	}

	public void setInimigo(Monstro inimigo) {
		this.inimigo = inimigo;
	}

}
