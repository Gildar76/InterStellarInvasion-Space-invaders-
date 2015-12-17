package net.gildargaming.entity;

import net.gildargaming.Direction;
import net.gildargaming.graphics.Sprite;
import net.gildargaming.input.Keyboard;
import net.gildargaming.world.FixedWorld;
import net.gildargaming.world.World;

public class Player extends Mob {
	
	private Keyboard input;


	
	public Player(int x, int y, Sprite sprite, Keyboard input, Sprite projectileSprite) {
		super(x,y,sprite, projectileSprite);
		//this.x = x;
		//this.y = y;
		this.timeUntilNextShot = 0;
		this.input = input;
		this.clamp = true;
		//this.sprite = sprite;
	}
	//Maybe should change fixedworld to world 
	public void update(int eleapsedTimeMilisec, FixedWorld level) {
		//System.out.println("updating player");
		//System.out.println(input.right);
		if (input.left) direction = Direction.LEFT;
		if (input.right) direction = Direction.RIGHT;
		if (input.space) shoot(level, false, 0);
		//System.out.println(this.direction);
		
		
		this.move(eleapsedTimeMilisec);
		this.timeUntilNextShot -= (double)(eleapsedTimeMilisec);
		direction = Direction.NONE;
		
		
	}
	

	
	
}
