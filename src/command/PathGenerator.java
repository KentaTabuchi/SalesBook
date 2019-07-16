/**
 * 
 */
package command;

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
		// TODO Auto-generated constructor stub
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

}
