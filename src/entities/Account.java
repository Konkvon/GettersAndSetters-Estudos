package entities;

public class Account {
	private String id_account;
	private String name;
	private double money;
	
	public Account(String id_account, String name) {
		this.id_account = id_account;
		this.name = name;
	}
	
	public Account(String id_account, String name, Double money) {
		this.id_account = id_account;
		this.name = name;
		this.money = money;
	}
	
	public String getID() {
		return id_account;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getMoney(){
		return money;
	}
	
	public void addMoney(Double money) {
		this.money += money;
	}
	
	public boolean removeMoney(double money) {
	    if (this.money < money) {
	        return false;
	    }
	    this.money -= money + 5.00;
	    return true;
	}

	
	public String toString() {
	    return String.format("%s, Nome: %s, Saldo: R$%.2f", id_account, name, money);
	}
}
