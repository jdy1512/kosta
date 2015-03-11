

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
	public static void main(String[] args) {
		//java.io.File - File/Directory와 관련되 기능을 제공하는 클래스.
		File dir = new File("c:\\JAVA");//directory 객체 - 절대경
		
		File file = new File("Koala.jpg");//File 객체 - 상대경로
		File file2 = new File(dir, "Koala.jpg");//c:\JAVA\koala.jpg
		
//	정보조회 메소드들
		//1. File객체가 가진 정보를 바탕으로 경로를 알려주는 메소드
		String path1 = dir.getPath();
		System.out.println("dir.getPath() : "+path1);
		String path2 = file.getPath();
		System.out.println("file.getPath() : "+path2);
		//2. 절대경로를 알려주는메소드
		String absPath1 = file.getAbsolutePath();
		System.out.println("file의 절대경로 : "+absPath1);
		
		String absPath2 = dir.getAbsolutePath();
		System.out.println("dir의 절대 경로 : "+absPath2);
		
//	파일이나 디렉토리 존재 여부 체크
		boolean flag = file.exists();
		System.out.println(flag);
		flag = dir.exists();
		System.out.println(flag);
		
//	Directory 인지 체크
		System.out.println("File file이 directory 정보인지 체크 : "+file.isDirectory());
		System.out.println("File dir이 directory 정보인지 체크 : "+dir.isDirectory());
//	File인지 체크
		System.out.println("File file이 file 정보인지 체크 : "+file.isFile());
		System.out.println("File file2이 file 정보인지 체크 : "+file2.isFile());
		System.out.println("File dir이 file 정보인지 체크 : "+dir.isFile());
		
//	읽기가능/쓰기가능/실행가능 한 파일/디렉토리인지 체크
		System.out.println(file2.canRead());//읽기 가능?
		System.out.println(file2.canWrite());//쓰기 가능?
		
		//파일의 크기
		long size = file2.length();//byte 
		System.out.println(file2.getAbsolutePath()+"의 크기 : "+size+" byte");
		//파일이 마지막으로 수정된 시간 체크
		long miliSecond = file2.lastModified();//1970.01.01 0: 0: 0
//		System.out.println("수정된 시간 : "+miliSecond);
		Date d = new Date(miliSecond);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(d);
		System.out.println("수정된 일시 : "+dt);
//	특정 디렉토리내의 모든 하위요소들을 조회 (이름) - File이 directory 정보
		String [] list = dir.list();
		System.out.println(dir.getAbsolutePath()+" 경로내의 모든 하위 요소");
		for(String str : list){
			System.out.println(str);
		}
		
//	수정
		//디렉토리 생성 메소드
		File dir2 = new File("c:\\JAVA\\newDir");
		boolean flag2 = dir2.mkdir();//생성 성공하면 true. 
		//실패시 false - 디렉토리가 이미 존재하는 경우. 부모경로가 없는 경우.
		System.out.println("디렉토리 생성여부 : "+flag2);
		File dir3 = new File("c:\\JAVA\\newDir1\\newDir2\\newDir3");
		System.out.println("dir3 생성 여부 : "+dir3.mkdirs());
		//mkdirs() 부모경로가 없는 경우 부모경로까지 생성.
		
		//파일 생성
		File file3 = new File(dir2, "newFile.file");
		try {
			flag2 = file3.createNewFile();//0byte 파일 생성. 파일생성 성공 - true
			System.out.println("파일 생성 여부 : "+flag2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//삭제 
		flag2 = file3.delete();
		System.out.println("삭제 여부 : "+flag2);
		
		//이동
		flag = file3.renameTo(new File("c:\\JAVA\\newDir1\\aaaaa.file"));
		System.out.println("이동 여부 : "+flag);
	}
}


























