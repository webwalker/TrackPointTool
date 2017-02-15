import com.ymt.util.Umeng;

public class MainClass {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out
					.println("Input parameter is invalid! example as following:");
			System.out
					.println("java -jar umeng.jar d:\\test.txt d:\\umeng_01.txt");
			return;
		}
		boolean result = Umeng.formatData(args[0], args[1]);
		if (result) {
			System.out.println("success[" + Umeng.itemCount + "]");
		} else {
			System.out.println("fail");
		}
	}
}
