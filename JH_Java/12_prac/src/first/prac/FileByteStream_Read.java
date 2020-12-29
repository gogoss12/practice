package first.prac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileByteStream_Read {

	public void FileRead() {
		
		FileInputStream fis = null;
		
		try { 
			byte[] arr = new byte[100];
			fis = new FileInputStream("text1.dat");
			
//			System.out.println(fis.read());
//			System.out.println(fis.read(arr));
//			System.out.println(fis.read());
			
			// 실수 많이 하는 부분 read() 부분이 두번사용되서 건너뛰기 값 나옴
//			while(fis.read() != -1) {
//				System.out.println(fis.read());
//			}
			
//			int value = 0;
//			
//			while((value = fis.read()) != -1) {
//				System.out.println(value);
//			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
