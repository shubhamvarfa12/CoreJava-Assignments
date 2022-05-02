// AssignmentNumber-04

class AccountOverdrawSafeDemo 
{
    static int Total_balance = 1000;
    static synchronized void withdraw(int balance, String name)
    {
        if(Total_balance >= balance)
        {
			   System.out.println("NOW, Safe Thread implemention are given below:\n");
            System.out.println(name+ " Withdraw successfully "+ balance);
            Total_balance = Total_balance-balance;
            System.out.println("Balance after Withdraw : "+Total_balance + "\n");
        try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
			e.printStackTrace(); }
		}
        else{
        System.out.println(name+" : Amount cann't be withdraw "+ balance);
        System.out.println("your Available  Balance is : "+Total_balance);     
		try {
			    Thread.sleep(1000);
			}

			catch (InterruptedException e) {
				e.printStackTrace(); }
	}
	}
}

class AccountOverdrawDemo 
{
    int Total_balance = 1000;
    void withdraw(int balance, String name)
    {
        if(Total_balance >= balance)
        {
         
            System.out.println(name+ " withdraw successfully"+balance);
            Total_balance = Total_balance-balance;
            System.out.println("Balance after Withdraw = "+Total_balance + "\n");
			try {
			    Thread.sleep(1000);
			}

			catch (InterruptedException e) {
				e.printStackTrace(); }
        }
        else{
        System.out.println(name+"= Amount cann't be withdraw");
        System.out.println("your Available  Balance is = "+Total_balance +"\n");     
	}
	}
}

class Account extends Thread
{
   static AccountOverdrawDemo aod; 
   static AccountOverdrawSafeDemo aosd; 
   int balance; String name;
    public void run()
     {
         aod.withdraw(balance,name);    
         aosd.withdraw(balance,name);    
     } 
    public static void main(String ar[])
    {
		System.out.println();
        aod = new AccountOverdrawDemo();
        aosd = new AccountOverdrawSafeDemo();
        
        Account withdraw = new Account();
        withdraw.balance = 700;
		withdraw.name = "shubham";
        withdraw.start(); 
		
		Account withdraw1 = new Account();
        withdraw1.balance = 400;
		withdraw1.name = "sunil";
        withdraw1.start(); 
	}
}