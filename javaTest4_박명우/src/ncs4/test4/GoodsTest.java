package ncs4.test4;

import java.io.*;

public class GoodsTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		Goods goods = new Goods();

		System.out.println("다음 항목의 값을 입력하시오.");
		System.out.print("상품명 : ");
		goods.setName(br.readLine());

		System.out.print("가  격 : ");
		
		goods.setPrice(Integer.parseInt(br.readLine()));
		
		System.out.print("수  량 : ");
		goods.setQuantity(Integer.parseInt(br.readLine()));
		
		System.out.println("입력된 결과는 다음과 같습니다.");
		System.out.print(goods.getName()+", ");
		System.out.print(goods.getPrice()+" 원, ");
		System.out.println(goods.getQuantity()+"개, ");
		System.out.println("총 구매 가격 : "+(goods.getPrice()*goods.getQuantity())+" 원.");
	}
}

