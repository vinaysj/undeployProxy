package undeploy.notraffic.deployedrevisions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ws.rs.client.Client;

public class Controller {

	public static void main(String[] args) throws IOException {

		// get inputs org, env, file location-proxylist
		String userName;
		String password;
		String protocol;
		String domainName;
		String orgName;
		String env;
		String filePath;

		userName = args[0];
		password = args[1];
		protocol = args[2];
		domainName = args[3];
		orgName = args[4];
		env = args[5];
		filePath = args[6];

		String proxy;
		String deployedRevision=null;

		// Client client = Connection.authenticate(userName, password);
		Client client = Connection.authenticate(userName, password);

		// call the method to read the file and store it in the list
		ArrayList<String> proxyList = ReadProxyFile.getProxyList(filePath);

		// call the method to get revision number: use a loop: for all the proxies
		Iterator<String> itr3 = proxyList.iterator();
		while (itr3.hasNext()) {
			proxy = itr3.next();
			System.out.println("\nproxy name: " + proxy);
			deployedRevision = DeployedRevision.deployedRevision(protocol, client, domainName, orgName, env, proxy);
			
			System.out.println("deployed revision: " + deployedRevision);

			// pass these details to undeploy revision
			if(deployedRevision != null) {
			UndeployRevision.undeployRevisions(protocol, client, domainName, orgName, env, proxy, deployedRevision);
			}
			
		}

	}

}
