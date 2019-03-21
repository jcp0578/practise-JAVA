package joker;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		HashMap<String,Integer> card_val=new HashMap<String,Integer>();
		card_val.put("3", 1);
		card_val.put("4", 2);
		card_val.put("5", 3);
		card_val.put("6", 4);
		card_val.put("7", 5);
		card_val.put("8", 6);
		card_val.put("9", 7);
		card_val.put("10",8);
		card_val.put("J", 9);
		card_val.put("Q", 10);
		card_val.put("K", 11);
		card_val.put("A", 12);
		card_val.put("2", 13);
		card_val.put("joker", 14);
		card_val.put("JOKER", 15);
		
		while(in.hasNext())
		{
			String read=in.nextLine();
			String[] player=read.split("-");
			String[] card1=player[0].split(" ");
			int val1,val2;
			if(card1.length==2)
			{
				if(!card1[0].equals(card1[1]))//joker JOKER 
					val1=50;
				else
					val1=card_val.get(card1[0]);
			}
			else if(card1.length==4)
				val1=card_val.get(card1[0])+20;
			else
				val1=card_val.get(card1[0]);
			
			String[] card2=player[1].split(" ");
			if(card2.length==2)
			{
				if(!card2[0].equals(card2[1]))//joker JOKER 
					val2=50;
				else
					val2=card_val.get(card2[0]);
			}
			else if(card2.length==4)
				val2=card_val.get(card2[0])+20;
			else
				val2=card_val.get(card2[0]);
			
			if(val1==50 || val2==50)
			{
				System.out.println("joker JOKER");
			}
			else if(card1.length==4 || card2.length==4)
			{
				if(card2.length==4)
				{
					if(val1>val2)
					{
						System.out.println(player[0]);
					}
					else
					{
						System.out.println(player[1]);
					}
				}
				else
				{
					System.out.println(player[0]);
				}
			}
			else if(card2.length==4)
			{
				System.out.println(player[1]);
			}
			else if(card1.length== card2.length)
			{
				if(val1>val2)
				{
					System.out.println(player[0]);
				}
				else
				{
					System.out.println(player[1]);
				}				
			}
			else
			{
				System.out.println("ERROR");
			}
		}
		in.close();

	}

}
