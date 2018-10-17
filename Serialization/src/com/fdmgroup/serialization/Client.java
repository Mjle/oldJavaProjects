package com.fdmgroup.serialization;

import com.fdmgroup.serialization.game.*;

public class Client {

	public static void main(String[] args) {
/*
 * Learning Objectives 

•	Serialize an object.
•	Perform custom serialization on information inherited from the non-serializable superclass.
•	Ensure the correct use of the keyword transient.
•	Ensure the appropriate use of the following methods:
private void writeObject(ObjectOutputStream os)
private void readObject(ObjectInputStream is)
Task

You will be adding functionality to classes used in an existing computer game. 
We will give you a jar file with the following classes that you must use:

•	Player – has int healthPoints and a String name.

•	Board – has methods:
o	public void attack(Player player1, Player player2)
o	public void defend(Player player1, Player player2)
o	public void loseHealthPoint(Player player)

•	HealthPack – has an int that stores health packs and the methods:
o	public HealthPack()
o	public HealthPack(int points)
o	public int getHealthPoints()
o	public void setHealthPoints(int points)

•	Backpack – has an ArrayList<HealthPack> and the methods
o	public Backpack()
o	public void addHealthPack(HealthPack hp)
o	public HealthPack useHealthPack()
o	public int getNumPacks()

You will need to extend Player class to create a Wizard. Wizards have Shields and Powers.  

The previous designers created a Backpack class that has a List of HealthPack objects, 
however they did not get around to using these classes. 
You should give your Wizard a Backpack that has HealthPacks in it. 

You may create as many different types of shields and powers as you want.  

At any point you must be able to save the state of your character 
(including name, healthPoints, backpack, shields and powers) into a byte stream. 
Store that byte stream in a file. 

You must be able to restore the state of the game so that the player can continue playing. 

Please note that the previous designer had no idea what serialization was, so you must be able to accommodate his code. 

 */
	}

}
