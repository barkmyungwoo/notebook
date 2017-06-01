package ncs.test2;

public class StringTest {

	public static void main(String[] args) {
		String str = "A, b, c, D, a, B, C, d, f, F";

		String[] st = str.split(",");
		
		char[] data = new char[st.length];

		for(int i=0; i<data.length;i++){
			data[i] = st[i].trim().charAt(0);
		}
		
		int j=0;
		while(true){
			if(j==data.length)
				break;
			
			if(data[j]<='Z' && data[j]>='A'){
				System.out.println("data["+j+"] : "+data[j]);
				j++;
			}
			else{
				j++;
				continue;
			}			
		}
	}
}
