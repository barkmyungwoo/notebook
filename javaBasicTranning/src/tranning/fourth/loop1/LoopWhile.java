package tranning.fourth.loop1;

import java.util.Scanner;

public class LoopWhile {

	public static void main(String[] args) {
		//while do-while ÇÔ²² ¼³¸íÇÔ. 
		
		
//		while(true){													//¹«ÇÑ ¹Ýº¹. ¹«Á¶°Ç ¹Ýº¹ ¸Þ¸ð¸®°¡ °¡µæ Âû¶§±îÁö °è¼Ó¹Ýº¹.
//			System.out.println("Å°Áö¸¶ Å°Áö¸¶ Å°Áö¸¶ Å°Áö¸¶");
//		}

		
				
//		do{																//¹«ÇÑ ¹Ýº¹. ¹«Á¶°Ç ¹Ýº¹ ¸Þ¸ð¸®°¡ °¡µæ Âû¶§±îÁö °è¼Ó¹Ýº¹.
//			System.out.println("Å°Áö¸¶ Å°Áö¸¶ Å°Áö¸¶ Å°Áö¸¶");
//		}while(true);
		
		
		//¼±¾ð, Á¶°Ç, Á¦¾î ¶Ç´Â Áõ°¡ °¨¼Ò,
		int a=0;
		while(a <10){													// ()¾È¿¡ Á¶°Ç¹®À» ÀÔ·ÂÇÏ¸é µû·Î Á¦¾î¹® ÇÊ¿ä ¾øÀ½. Áõ°¡°¨¼Ò´Â ÇÊ¿ä!!! 
			System.out.println("¿ä!!!");									// ÂüÀÌ¸é ½ÇÇà °ÅÁþÀÌ¸é ¶ÙÃÄ³ª°¨.
			a++;
		}

		System.out.println("³¡!");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		a=0;
		do{																// °Á { } ¾È¿¡ °ªÀº °íµ¥·Î ³»ºñµÎ°í ¾Õ¿¡ do ºÙÀÌ°í ³¡¿¡ while(); ºÙÀÌ¸é ³¡!!! 
			System.out.println("¿¹!!!");									
			a++;
		}while(a <10);
		System.out.println("³¡!");
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		

		//Á¶°ÇÀÌ true ÀÏ¶§ break ¹® »ç¿ë Á¾·á. 
		a=0;															// a °¡ °í»ýÇÑ´Ù.
		while(true){
			if(a>10)
				break;
			
			System.out.println("¿Í~");									//ÀÌ°Ô ¸î¹ø ¹Ýº¹ µÇ´Â°É±î?!?! È®ÀÎ!!! ¿Ö ±×·±Áö ÀÌÇØÇÏ±â.
			a++;
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		
		
		a=0;															// a °¡ °í»ýÇÑ´Ù.
		do{
			if(a>10)
				break;
			
			System.out.println("®G!");									//ÀÌ°Ô ¸î¹ø ¹Ýº¹ µÇ´Â°É±î?!?! È®ÀÎ!!! ¿Ö ±×·±Áö ÀÌÇØÇÏ±â.
			a++;
		}while(true);
		
		
		
		//Ãà¾à±â´É.
		
		while(new Scanner(System.in).nextInt()!=0)						//ÇÑÁÙ¸¸ ÇÒ ¶© { } ÀÌ°Å »©µµ µÊ. ÀÔ·Â ¹Þ¾Æ¼­ ºñ±³ ÇØ¹ö·Á¼­ 1ÁÙ·Îµµ ¹«ÇÑ ¹Ýº¹ °¡´É. 0 ´©¸£¸é Á¾·á.
			;
		
		System.out.println("end!");		
		//°úÁ¦. for ¹®Áß¿¡ »ï°¢Çü Ãâ·ÂÇÏ´Â°Å ÀÌ°É·Î ´Ù½Ã ¸¸µé±â for¹®»ç¿ë ¾ÈµÊ. while ¹®¸¸ »ç¿ëÇÏ¿© ¸¸µé±â!!
		//tip!! ÀÌ°Ç ³ªµµ ¿À´Ã ¾Ë¾Ò¾î. ¸¸¾à ´Ï°¡ ¿øÇÏ´Â ¸¸Å­ ¹Ýº¹¹®À» µ¹·Á¾ß ÇÒ »óÈ²ÀÌ ¿À¸é 
		//ÀÏ´Ü ¹Ýº¹ÇØ¾ß ÇÒ ¿µ¿ªÀ» ¸¶¿ì½º·Î µå·¡±× ÇÑ ÈÄ¿¡ 		shift + alt + z Å°¸¦ ´©¸£°í ¼±ÅÃ ÇÏ¸é µÊ!!!!!!! ÇØºÁ.
	}

}
