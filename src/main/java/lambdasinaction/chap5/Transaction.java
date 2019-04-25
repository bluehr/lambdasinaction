package lambdasinaction.chap5;

public class Transaction{

	private Trader trader;
	private int year;
	private int value;
	private Boolean delete;

	public Transaction(Trader trader, int year, int value, Boolean delete) {

		this.trader = trader;
		this.year = year;
		this.value = value;
		this.delete = delete;
	}

	public Trader getTrader(){ 
		return this.trader;
	}

	public int getYear(){
		return this.year;
	}

	public int getValue(){
		return this.value;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public String toString(){
	    return "{" + this.trader + ", " +
	           "year: "+this.year+", " +
	           "value:" + this.value +"}";
	}
}