package com.madama.fabio.backend;

import java.awt.Color;

public class Player {
	
	private Color color;
	private Integer space = 0;
	private Integer x = 0;
	private Integer y = 0;
	private Integer round = 0;
	private boolean stuck = false;
	private boolean win = false;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Integer getSpace() {
		return space;
	}
	public void setSpace(Integer space) {
		this.space = space;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	public boolean isStuck() {
		return stuck;
	}
	public void setStuck(boolean stuck) {
		this.stuck = stuck;
	}
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}

}
