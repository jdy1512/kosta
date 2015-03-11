

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
	public static void main(String[] args) {
		//java.io.File - File/Directory�� ���õ� ����� �����ϴ� Ŭ����.
		File dir = new File("c:\\JAVA");//directory ��ü - �����
		
		File file = new File("Koala.jpg");//File ��ü - �����
		File file2 = new File(dir, "Koala.jpg");//c:\JAVA\koala.jpg
		
//	������ȸ �޼ҵ��
		//1. File��ü�� ���� ������ �������� ��θ� �˷��ִ� �޼ҵ�
		String path1 = dir.getPath();
		System.out.println("dir.getPath() : "+path1);
		String path2 = file.getPath();
		System.out.println("file.getPath() : "+path2);
		//2. �����θ� �˷��ִ¸޼ҵ�
		String absPath1 = file.getAbsolutePath();
		System.out.println("file�� ������ : "+absPath1);
		
		String absPath2 = dir.getAbsolutePath();
		System.out.println("dir�� ���� ��� : "+absPath2);
		
//	�����̳� ���丮 ���� ���� üũ
		boolean flag = file.exists();
		System.out.println(flag);
		flag = dir.exists();
		System.out.println(flag);
		
//	Directory ���� üũ
		System.out.println("File file�� directory �������� üũ : "+file.isDirectory());
		System.out.println("File dir�� directory �������� üũ : "+dir.isDirectory());
//	File���� üũ
		System.out.println("File file�� file �������� üũ : "+file.isFile());
		System.out.println("File file2�� file �������� üũ : "+file2.isFile());
		System.out.println("File dir�� file �������� üũ : "+dir.isFile());
		
//	�бⰡ��/���Ⱑ��/���డ�� �� ����/���丮���� üũ
		System.out.println(file2.canRead());//�б� ����?
		System.out.println(file2.canWrite());//���� ����?
		
		//������ ũ��
		long size = file2.length();//byte 
		System.out.println(file2.getAbsolutePath()+"�� ũ�� : "+size+" byte");
		//������ ���������� ������ �ð� üũ
		long miliSecond = file2.lastModified();//1970.01.01 0: 0: 0
//		System.out.println("������ �ð� : "+miliSecond);
		Date d = new Date(miliSecond);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(d);
		System.out.println("������ �Ͻ� : "+dt);
//	Ư�� ���丮���� ��� ������ҵ��� ��ȸ (�̸�) - File�� directory ����
		String [] list = dir.list();
		System.out.println(dir.getAbsolutePath()+" ��γ��� ��� ���� ���");
		for(String str : list){
			System.out.println(str);
		}
		
//	����
		//���丮 ���� �޼ҵ�
		File dir2 = new File("c:\\JAVA\\newDir");
		boolean flag2 = dir2.mkdir();//���� �����ϸ� true. 
		//���н� false - ���丮�� �̹� �����ϴ� ���. �θ��ΰ� ���� ���.
		System.out.println("���丮 �������� : "+flag2);
		File dir3 = new File("c:\\JAVA\\newDir1\\newDir2\\newDir3");
		System.out.println("dir3 ���� ���� : "+dir3.mkdirs());
		//mkdirs() �θ��ΰ� ���� ��� �θ��α��� ����.
		
		//���� ����
		File file3 = new File(dir2, "newFile.file");
		try {
			flag2 = file3.createNewFile();//0byte ���� ����. ���ϻ��� ���� - true
			System.out.println("���� ���� ���� : "+flag2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//���� 
		flag2 = file3.delete();
		System.out.println("���� ���� : "+flag2);
		
		//�̵�
		flag = file3.renameTo(new File("c:\\JAVA\\newDir1\\aaaaa.file"));
		System.out.println("�̵� ���� : "+flag);
	}
}


























