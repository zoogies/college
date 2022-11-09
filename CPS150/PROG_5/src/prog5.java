import java.util.Scanner;

public class prog5 {
	
	public static int rollDice() {
		return (int) ((Math.random() * (12 - 2)) + 2);
	}
	
	public static boolean rollWithPoint(int point) {
		Boolean rolling = true;
		Boolean r = null;
		while(rolling) {
			int roll = rollDice();
			if(roll == 7) {
				r = false;
				rolling = false;
			}
			else if(roll == point) {
				r = true;
				rolling = false;
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 100;
		Boolean playing = true;
		int wins = 0;
		int losses = 0;
		
		while(playing) {
			System.out.println("You have $"+money);
			System.out.print("Please enter a wager: ");
			int wager = sc.nextInt();
			
			int roll = rollDice();
			System.out.println("Rolled: "+roll);
			
			if(roll == 7 || roll == 11) {
				System.out.println("You win $"+(wager*2)+"!");
				money += wager*2;
				wins++;
			}
			else if(roll == 2 || roll == 12 || roll == 3) {
				System.out.println("You lost!");
				money -= wager;
				losses++;
			}
			else {
				System.out.println("Your point value is "+roll);
				
				Boolean point = rollWithPoint(roll);
				
				if(point == true) {
					System.out.println("Rolled point until you won $"+(wager)+"!");
					money += wager;
					wins++;
				}
				else {
					System.out.println("Rolled point until you lost!");
					money -= wager;
					losses++;
				}
			}
			
			if(money <= 0) {
				System.out.println("You have run out of money!");
				if((wins+losses) > 0) {
					System.out.println("Your probability of winning on any turn was "+((double) wins / ((double) wins + (double) losses))* 100+"%");
				}
				else {
					System.out.println("Your probability of winning on any turn was 0%");
				}
				playing = false;
			}
			else {
				System.out.print("Do you want to play again? y/n ");
				if(sc.next().equals("n")) {
					playing = false;
					if((wins+losses) > 0) {
						System.out.println("Your probability of winning on any turn was "+((double) wins / ((double) wins + (double) losses)) * 100+"%");
					}
					else {
						System.out.println("Your probability of winning on any turn was 0%");
					}
				}
			}
		}
	}

}
