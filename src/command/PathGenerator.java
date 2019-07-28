/**
 * 
 */
package command;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * @author misskabu
 *
 */
public class PathGenerator {

	/**|
	 * |This class returns current Path.
	 */
	public PathGenerator() {
	}
	/**
	 * 
	 * return the parent path of current directory.
	 */
	public static Path getParentPath(Class<?> cls) throws URISyntaxException {
		ProtectionDomain pd = cls.getProtectionDomain();
		CodeSource cs = pd.getCodeSource();
		URL location = cs.getLocation();
		URI uri = location.toURI();
		Path path = Paths.get(uri);
		path = path.getParent();
		return path;
	}
	public static String getCurrentJarPath(){
		String jarPath = System.getProperty("java.class.path");
		String dirPath = jarPath.substring(0, jarPath.lastIndexOf(File.separator)+1);
		return dirPath;
	}

}
