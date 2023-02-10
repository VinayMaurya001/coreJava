package _9IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirectoryAndFileRecursively {

	static String TOP_DIRECTORY = "C:\\workspace\\github\\coreJava";

	static int i = 0;
//https://raw.githubusercontent.com/VinayMaurya001/rest/master/pom.xml
	// https://raw.githubusercontent.com/VinayMaurya001/coreJava/master/abhinav/abcd.txt
	// <a
	// href="https://raw.githubusercontent.com/VinayMaurya001/coreJava/master/"></a>
	// coreJava\src\_9IO\0Syllabus.txt

	static String prefix = "<a  href=\"https://raw.githubusercontent.com/VinayMaurya001/coreJava/master/";
	static String suffix = "</a>";

	public static void walk(String path, int i) {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		i++;
		for (File f : list) {
			for (int n = 0; n < i; n++) {
				System.out.print("\t");
			}
			String path2 = f.getAbsoluteFile().toString().substring(20);
			if (f.isDirectory() && isIgnoreDirOrFile(f)) {
				//System.out.println("Dir:" + path2);
				walk(f.getAbsolutePath(), i);
			} else {
				System.out.println(prefix + path2 + "\">" + f.getName() + suffix);
				// System.out.println("File:" + path2);
			}
		}
	}

	private static boolean isIgnoreDirOrFile(File f) {
		String path = f.getAbsolutePath();
		return !(path.contains(".git") || path.contains(".classpath") || path.contains(".gitignore")
				|| path.contains(".project") || path.contains(".settings") || path.contains("allNotes\bin"));
	}

	public static void main(String[] args) throws Exception {

		// m1();
		m2();

		walk(TOP_DIRECTORY, 0);
	}

	private static void m1() throws IOException {
		try (Stream<Path> stream = Files.walk(Paths.get("C:\\workspace\\github\\allNotes"))) {
			// stream.filter(Files::isRegularFile)
			stream.forEach(file -> {
				if (!Files.isRegularFile(file)) {
					i++;
					System.out.println();
					System.out.println(file.toString().substring(20));
				} else {
					for (int j = 0; j < i; j++) {
						System.out.print("\t");
					}
					System.out.println(file.toString().substring(20));
				}
			});
		}
	}

	private static void m2() {
		printDirectoryTree(new File("C:\\workspace\\github\\allNotes\\1DSA"));
	}

	public static String printDirectoryTree(File folder) {
		if (!folder.isDirectory()) {
			throw new IllegalArgumentException("folder is not a Directory");
		}
		int indent = 0;
		StringBuilder sb = new StringBuilder();
		printDirectoryTree(folder, indent, sb);
		return sb.toString();
	}

	private static void printDirectoryTree(File folder, int indent, StringBuilder sb) {
		if (!folder.isDirectory()) {
			throw new IllegalArgumentException("folder is not a Directory");
		}
		sb.append(getIndentString(indent));
		sb.append("+--");
		sb.append(folder.getName());
		sb.append("/");

		sb.append("\n");
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				printDirectoryTree(file, indent + 1, sb);
			} else {
				printFile(file, indent + 1, sb);
			}
		}

	}

	private static void printFile(File file, int indent, StringBuilder sb) {
		sb.append(getIndentString(indent));
		sb.append("+--");
		sb.append(file.getName());
		sb.append("\n");
	}

	private static String getIndentString(int indent) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < indent; i++) {
			sb.append("|  ");
		}
		return sb.toString();
	}
}
