package karte;

import java.io.Serializable;

public class Position implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	public Position(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "x:"+x+",y:"+y;
	}
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Position)) return false;
		Position p=(Position)o;
		return ((p.getX()==this.getX())&&(p.getY()==this.getY()));
	}
}
