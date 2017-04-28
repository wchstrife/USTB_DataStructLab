package j2ds;

public class Lab5 {
	public static void main(String[] args) {
		String graphFilePath;
		if (args.length == 0)
			graphFilePath = "F:\\11.txt";
		else
			graphFilePath = args[0];

		String graphContent = FileUtil.read(graphFilePath, null);// ���ļ��ж�ȡͼ������
		DirectedGraph directedGraph = new DirectedGraph(graphContent);
		try {
			directedGraph.topoSort();
		} catch (Exception e) {
			System.out.println("graph has circle");
			e.printStackTrace();
		}
	}
}
