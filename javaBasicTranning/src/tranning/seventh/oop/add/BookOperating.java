package tranning.seventh.oop.add;

public class BookOperating {
	Book å = new Book();												// ���� ��Ű�� �ȿ� �־ ���� ����Ʈ ���ص� ��. 
	Book �ڼ��� = new Book("����� ��", "�ڸ��",20000, 1985, 9-1, 23);			// �����ε�
	Book[] ����_���� = new Book[10];										// �迭�̿�
	
	
	public void å_���ݺ���(int a){
		å.set����(a);
		System.out.println("������ �����̵Ƴ�?!!");
	}
	
	public void ����ϱ�(){
		System.out.println(å.toString());
		System.out.println(�ڼ���.toString());
		for(int i=0; i<����_����.length;i++){
			����_����[i] = new Book();
			System.out.println(����_����[i].toString());
		}
	}
}
