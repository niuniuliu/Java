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
        isPrime[1]=false;//1��������
        Arrays.fill(isPrime, 2,range+1,true);//ȫ��Ϊtrue�����ڵ���2��λ���ϣ�
        int n=(int)Math.sqrt(range);//��range������
        for(int i=2;i<=n;i++)//ע����ҪС�ڵ���n
            if(isPrime[i])//�鿴�ǲ����Ѿ���false����
                for(int j=i;j*i<range;j++)//����i������λ����Ϊfalse
                    isPrime[j*i]=false;
        return isPrime;//����һ��boolean����
	}

    

    
}
