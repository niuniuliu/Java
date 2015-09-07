import java.util.Arrays;


public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("The args lenght: " + args.length);
//		for (int i = 0; i < args.length; i++){
//			System.out.println(args[i]);
//		}
		 
		for (String string : args) {
			System.out.println(string);
		}
		
		int[] arrBubble = {111, 222, 4, 3, 1, 5, 6, 5655, 2, 3, 6, 9};
		
	}
	
	// Not tested.
	boolean[] printPrime(int range){
        boolean[] isPrime=new boolean[range+1];
        isPrime[1]=false;//1不是质数
        Arrays.fill(isPrime, 2,range+1,true);//全置为true（大于等于2的位置上）
        int n=(int)Math.sqrt(range);//对range开根号
        for(int i=2;i<=n;i++)//注意需要小于等于n
            if(isPrime[i])//查看是不是已经置false过了
                for(int j=i;j*i<range;j++)//将是i倍数的位置置为false
                    isPrime[j*i]=false;
        return isPrime;//返回一个boolean数组
	}

    

    
}
