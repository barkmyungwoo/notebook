package ncs4.test4;

import java.io.*;

public class GoodsTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		Goods goods = new Goods();

		System.out.println("���� �׸��� ���� �Է��Ͻÿ�.");
		System.out.print("��ǰ�� : ");
		goods.setName(br.readLine());

		System.out.print("��  �� : ");
		
		goods.setPrice(Integer.parseInt(br.readLine()));
		
		System.out.print("��  �� : ");
		goods.setQuantity(Integer.parseInt(br.readLine()));
		
		System.out.println("�Էµ� ����� ������ �����ϴ�.");
		System.out.print(goods.getName()+", ");
		System.out.print(goods.getPrice()+" ��, ");
		System.out.println(goods.getQuantity()+"��, ");
		System.out.println("�� ���� ���� : "+(goods.getPrice()*goods.getQuantity())+" ��.");
	}
}

