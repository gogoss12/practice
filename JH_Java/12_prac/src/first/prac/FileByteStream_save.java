package first.prac;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteStream_save {

	public void fileSave() {
		
		FileOutputStream fos = null;

		try{						//   파일명 		기존 파일에 계속 작성하고 싶다면 true (default 값은 false)
			fos = new FileOutputStream("text1.dat");
				
			fos.write('a');
			fos.write('b');
			fos.write(96);
			fos.write(10);
			fos.write(99);
			fos.write('한'); // 한글은 2byte 라 깨져서 저장됨
			
			byte[] arr = {98,102,105};
			
			fos.write(arr);
			
			fos.flush();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}