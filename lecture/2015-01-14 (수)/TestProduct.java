public class TestProduct{
	public static void main(String[] args){
		Product p1 = new Product();
		Product p2 = new Product(1, "����", 1700, "�������");
		Product p3 = new Product(2, "���̴�", 980, "�̸�Ʈ", 37, "���� ������ ���� �� ���ݿ� �Ǹ��ϴ� �̸�Ʈ ���̴�");
		
		System.out.println("p1 : " + p1.getDetails());
		System.out.println("p2 : " + p2.getDetails());
		System.out.println("p3 : " + p3.getDetails());
	}
}