package tranning.sixth.array;

public class Array {
	//1���迭 
	public static void main(String[] args) {

		int[] a = new int[6];										//�迭 ���� ���
		int b[] = new int[6];										//����. 
		int[] c;													// ���� ���൵ ��. �ʱ�ȭ �Ǵ� �ּ��Ҵ�(new) �� ����ϱ� ���� 
																	//�ʱ�ȭ ���ָ� ��. but ���ϰ� ����ϸ� null point exeption �� �����. 

		//�迭�� ���̻� �⺻ ������ �ƴմϴ�. 
		int d = 0;													//�񱳿� �⺻ ���� ����.
//		System.out.println(d.hashCode());							//�ּҰ� ����!!!!! ������.
		System.out.println(a.hashCode());							//but �ּҰ� �ִ�!!! ��. ���۷��� ������!!!!!!! ���� ����. 

		
																	// ���� �̸��� . ������ ���۷��� ������ ��밡���� ��� �޼ҵ� ����� ������ 
																	//���� length(), toString();, 
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										

		
		//�� ��. ���۷��� ������ �޼ҵ嵵 �ణ�� ����� �ٸ��ϴ�. 

		String str = "hello";
		String[] str2 = new String[5];
		char[] c1 = new char[]{'s','u','p','e','r'}; 				// 
		
		System.out.println(str.length());							// ���ΰ� ����.
		System.out.println(c1.length);								// ���ΰ� ���� ����.
		System.out.println(str2.length);							// ���ΰ� ���� ����!!!!!! string�� ��츸!!! �װ͸� ���ΰ� ����. 
		
					// ������ String�� ��� String�� Ŭ.��.��. ó�� ��޵Ǿ length()�޼ҵ尡 ����Ǵ°�.
					// �⺻�� �迭�� ���� �迭�� ��.��.��.�� ó�� ��޵Ǿ length�� �޼ҵ�ȿ� ���Ե� ��.��.��.��.ó�� ��޵�. 
		
					// ex>	public class String{
					//			public void length(){
					//
					//			}			
					//		}  			

		
					// 			public void array(){
					//				int lenght 
					//			}
		
					//			�̷�����. 
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		//2���� �迭 
		
		
		int[][]aa = new int[2][3];										// 2�� �迭 ����
																		// �����ϴ� ����� ���ʰ��� �̴�. 
																		// �̰� ���� ģ�� ���� �ϳ��ϳ� �� �� �� �ۿ� ����. 
		
		int[][] t = { 													// t�� ��� [4][5]�� �޸� �Ҵ��� �ڵ����� �ȴ�. 	 
				{1, 2, 3, 4, 5},										
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
		};

		
		int[][] t2 = { 													// t2�� ��� [4][]�� �޸� �Ҵ��� �ڵ����� �ȴ�. 	 
				{1, 2, 3},												// �� ���� ��� ���� �ٸ� �������� �޸𸮰� �Ҵ�ȴ�. 
                {6, 7, 8, 9, 10},										// �̰ű��� ������ ���ǹ� ����.
                {11, 12, 13, 14},										// �ϴ� �̰� Ȱ���̳� ��뿡 ���Ͽ� �����ϰ���.
                {16, 17},
		};
		
		System.out.println(t2.length);									//���� ���ϴ� ��� ����ϱ�. t2�� ũ.��.��.!!! t2[]�� ũ.��.��. ���� ��!��!��!!!!! ����!!!!!! �����ϱ�.
		System.out.println(t2[0].length);								//2�� �迭�� ��� ���� ���� ������� ������ �� �� 
		System.out.println(t2[1].length);								// �����ָ� ���� ����.
		System.out.println(t2[2].length);
		System.out.println(t2[3].length);

		//2���� �迭 ���� ����. +for��
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		//���
		for(int ��=0; ��< t2.length; ��++){								// ���ظ� ���� ���� �������� �ѱ۷� ������. �� ������. 
			for(int ĭ = 0 ; ĭ < t2[��].length ; ĭ++ ){					// ���ǽ� ���� ��� �� Ȯ���ϱ�!!!!! t2[��]�� ũ�Ⱑ ���� �ٸ��� ������ �̷��� �ؼ� ���� ������ Ȯ���� �ؼ� ����� �ؾ���. 
				
				System.out.print(t2[��][ĭ]+ ", ");						// ������ ����ϱ� ���Ͽ� print �� �����. 

			}		
			System.out.println();										// t2[��][]	�� ������ ���� ���پ� �ٲ��ϱ� ���ؼ� �� for ������ println
		}

		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		
		//���ϱ�!!
		int sum=0;														// for ���� ������ ���� �ʱ� ���� �ۿ� ����.
		for(int ��=0; ��< t2.length; ��++){								
			for(int ĭ = 0 ; ĭ < t2[��].length ; ĭ++ ){				 
				
				System.out.print(t2[��][ĭ]+ ", ");						// ��� ���� ����.
				sum += t2[��][ĭ];										// sum = sum+ t2[��][ĭ];
			}		

			System.out.println();										
		}				
		System.out.println("�հ� : "+ sum);								// ���� for���� ������ �ۿ��� ���!!
		
		
			
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
			
		
		//���� 1. �л����� ���� ��հ� ������� ���ϱ�.	
		//���ڱ� ����� ��!! ������ �ȵŸ� ���̿� �׷��� �ؼ��Ұ�!!!! �ݵ�� �ؾ���.				

		int ara[][] =new int[5][4];										// 4���� 3���� �� �� �� ��հ� ���� ����� ����. �ϴ� int �迭�̶� ������ ���� �ϰ���.
		int sump=0;														// sump�� ���� �ջ�. �ջ� �� �ۿ��� /3���� ����� ����.

		System.out.println("\t\t����\t����\t����\t���");
		for(int i=0; i< ara.length-1 ; i++) { 							// ���� = �� ������

			System.out.print(i + "�� �л� : ");

			for (int j = 0; j < ara[i].length - 1; j++) { 				// -1�� �ϴ� ������ ������ �ڸ���
																		// ����� �־�� �ϴϱ�.

				ara[i][j] = (int) (Math.random() * 50 + 51); 			// ������ 51~100 ���� ����
																		// �Է�.
				sump += ara[i][j]; 										// for �� �ȿ��� i�� �л� ������ ĭ�� ���� ������ ������.

				System.out.print("\t" + ara[i][j]+"��");

				ara[ara.length - 1][j] += ara[i][j]; 					// ������ �� ������ ĭ�� ���� ����. ���񸶴� ������տ� ���� ���ϴµ� ���.
			}

			ara[i][ara[i].length - 1] = (sump / 3); 					// ���� �ջ��� ������ �ջ�� ������ �ٱ� for������ ����� ���ؼ� �� ������ ĭ�� �Է�. j�� ������ ������ �����鼭 �Ҹ��.
			ara[ara.length - 1][ara[i].length - 1] += (sump / 3); 		// �� ������ ��տ� ���� ����.

			System.out.print("\t" + ara[i][ara[i].length - 1]+"��"); 		// ������ ��� ���. ��ġ�� �ֿ����̰�  -1�� �� ���ִ��� �����ϱ�! ��!!!!!

			sump = 0; 													// ���⼭ �ʱ�ȭ �ؾ� ���� �л� ���̶� ���� �л� ���� �������� ����.

			System.out.println();
		}

		System.out.println("-------------------------------------------");
		System.out.print("���� ��� \t");
		for (int i = 0; i < ara[0].length; i++) {
			System.out.print("\t" + (ara[ara.length - 1][i] / 4)+"��");
		}
		
		// �ϴ� �� ���α׷��� �������̶��� �ȴ�. ���� ���� ���̱⵵ �ϰŴϿ� ���������� �Ҵ�� ������ �ѹ��� �ٱ������ �Է��ϱ⿡ ������ ���鲨��°� �ƴµ�
		// ������ ȸ�� ���α׷� �ҽ��� �� ������~~~~ �ϴ� �ȵǸ� ǥ ������ �����ϰ� ����غ���.
		// �׸��� ��� ���ǹ����� .length�� ���� ������ ���Ͱ��� ���̰� ������ �ְ� ª���� ����� ���������� �л��� ���� �׶� �׶� �ٲ�ų�
		// �ݸ��� ������ �޶� �ٲ���� �Ҷ� �����ϱⰡ ������ �׷���. ������ �þ ���� �ִ°ű�. ���� ��� ������ ���� �𸣴�
		// .length �� ����ؼ� �����ϱ� ���ϰ� �Ϸ��� ����ϴ� ���ӵ�. 
		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		
		//���� 2. ���� for���� �̿��ؼ� �����϶�. �̰͵� �߿�. ���ֻ��.
		
		int[] nsort = new int[8];											//8��¥�� �迭 ����
		int tmp;															//���߿� ������ �� �ʿ��� �ӽ� ���� ����.

		for(int i=0; i<nsort.length; i++){
			nsort[i] = (int)(Math.random()*50+1);							//�迭�� �� �ο�. 1~50
		}
		
		for(int i = 0; i<nsort.length-1;i++){								
			for(int j=i; j<nsort.length;j++){

				if(nsort[i]>nsort[j]){										//�پ� �ִ� �� �迭�� ���� ��. ���� 0��°�� 1��, 1��°�� 2�� ū���� �տ� �ִٸ� ü���� �� ��������!!!!
					tmp=nsort[i];											//�ӽ� ������ ū ���� ����
					nsort[i] =nsort[j];										//ū ���� ������ ���� ���� ����
					nsort[j]=tmp;											//�ӽð����� �ִ� ū ���� �������� �ִ� ������ ����.
				}

			}
		}
		
		for(int i=0; i<nsort.length;i++)
			System.out.print(nsort[i]+", ");
		
		
		//���� �⺻������ ����ϴ� 2�� for��. int j = i�� �� �����ϱ�!!!! �� ������ �����ϴ��� �� �����ϱ�!!!!

		
		System.out.println();										
		System.out.println();										
		System.out.println();										
		System.out.println();										
		
		
	}

}
