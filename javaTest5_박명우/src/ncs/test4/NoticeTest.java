package ncs.test4;

import java.io.*;
import java.util.*;

public class NoticeTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Object[] obArray = new Object[3];
		Scanner sc = new Scanner(System.in);
		int cnt = 0;

		for (int i = 0; i < obArray.length; i++) {
			Notice no = new Notice();
			System.out.println("등록할 공지사항을 입력하시오.");

			System.out.print("제목 : ");
			no.setTitle(sc.nextLine());

			System.out.print("작성자 : ");
			no.setWriter(sc.nextLine());

			System.out.print("내용 : ");
			no.setContent(sc.nextLine());

			no.setDate(new Date());
			no.setNo(cnt);

			obArray[i] = no;
			cnt++;
		}
		new NoticeTest().fileSave(obArray);

		ArrayList<Notice> ar = new NoticeTest().fileRead();

		for (Notice notice : ar) {
			System.out.println(notice.toString());
		}
	}

	public void fileSave(Object[] array) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("notice.dat"));

			for (Object object : array) {						//arrayList 는 하나씩 들어가는게 특징 그래서 for 문 굴려야 함.
				objOut.writeObject(object);
			}

			objOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Notice> fileRead() {
		ArrayList<Notice> ar = new ArrayList<Notice>();

		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("notice.dat"));

			while (true) {										//arrayList 는 하나씩 나오는게 특징!! 그래서 WHILE 문 굴려야 함.
				ar.add((Notice) objIn.readObject());
			}
		} catch (Exception e) {
		}

		return ar;

	}

}
