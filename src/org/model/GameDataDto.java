package org.model;

public class GameDataDto {
	double game1;
	double game2;
	double game3;
	double game4;
	double game5;
	String day;
	
	public GameDataDto() {
		this(0,0,0,0,0,"");
	}
	
	public GameDataDto(double game1, double game2, double game3, double game4, double game5, String day) {
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.game4 = game4;
		this.game5 = game5;
		this.day = day;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public double getGame1() {
		return game1;
	}

	public void setGame1(double game1) {
		this.game1 = game1;
	}

	public double getGame2() {
		return game2;
	}

	public void setGame2(double game2) {
		this.game2 = game2;
	}

	public double getGame3() {
		return game3;
	}

	public void setGame3(double game3) {
		this.game3 = game3;
	}

	public double getGame4() {
		return game4;
	}

	public void setGame4(double game4) {
		this.game4 = game4;
	}

	public double getGame5() {
		return game5;
	}

	public void setGame5(double game5) {
		this.game5 = game5;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDataDto other = (GameDataDto) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return day + " : " + game1 + "%\t" + game2 + "%\t" + game3 + "%\t"
				+ game4 + "%\t" + game5 + "%";
	}
	
	
}
