package tranning.fourth.loop1;

import java.util.Scanner;

public class LoopWhile {

	public static void main(String[] args) {
		//while do-while �Բ� ������. 
		
		
//		while(true){													//���� �ݺ�. ������ �ݺ� �޸𸮰� ���� �������� ��ӹݺ�.
//			System.out.println("Ű���� Ű���� Ű���� Ű����");
//		}

		
				
//		do{																//���� �ݺ�. ������ �ݺ� �޸𸮰� ���� �������� ��ӹݺ�.
//			System.out.println("Ű���� Ű���� Ű���� Ű����");
//		}while(true);
		
		
		//����, ����, ���� �Ǵ� ���� ����,
		int a=0;
		while(a <10){													// ()�ȿ� ���ǹ��� �Է��ϸ� ���� ��� �ʿ� ����. �������Ҵ� �ʿ�!!! 
			System.out.println("��!!!");									// ���̸� ���� �����̸� ���ĳ���.
			a++;
		}

		System.out.println("��!");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		a=0;
		do{																// �� { } �ȿ� ���� ���� ����ΰ� �տ� do ���̰� ���� while(); ���̸� ��!!! 
			System.out.println("��!!!");									
			a++;
		}while(a <10);
		System.out.println("��!");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		

		//������ true �϶� break �� ��� ����. 
		a=0;															// a �� ����Ѵ�.
		while(true){
			if(a>10)
				break;
			
			System.out.println("��~");									//�̰� ��� �ݺ� �Ǵ°ɱ�?!?! Ȯ��!!! �� �׷��� �����ϱ�.
			a++;
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		
		a=0;															// a �� ����Ѵ�.
		do{
			if(a>10)
				break;
			
			System.out.println("�G!");									//�̰� ��� �ݺ� �Ǵ°ɱ�?!?! Ȯ��!!! �� �׷��� �����ϱ�.
			a++;
		}while(true);
		
		
		
		//�����.
		
		while(new Scanner(System.in).nextInt()!=0)						//���ٸ� �� �� { } �̰� ���� ��. �Է� �޾Ƽ� �� �ع����� 1�ٷε� ���� �ݺ� ����. 0 ������ ����.
			;
		
		System.out.println("end!");		
		//����. for ���߿� �ﰢ�� ����ϴ°� �̰ɷ� �ٽ� ����� for����� �ȵ�. while ���� ����Ͽ� �����!!
		//tip!! �̰� ���� ���� �˾Ҿ�. ���� �ϰ� ���ϴ� ��ŭ �ݺ����� ������ �� ��Ȳ�� ���� 
		//�ϴ� �ݺ��ؾ� �� ������ ���콺�� �巡�� �� �Ŀ� 		shift + alt + z Ű�� ������ ���� �ϸ� ��!!!!!!! �غ�.
	}

}
