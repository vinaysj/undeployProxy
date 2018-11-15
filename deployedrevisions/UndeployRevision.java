package undeploy.notraffic.deployedrevisions;

import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;

//import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class UndeployRevision {
	public static void undeployRevisions(String protocol, Client client, String domainName, String orgName, String env,
			String proxy, String deployedRevision) {

		try {
			WebTarget target = client.target(protocol + "://" + domainName + "/v1/organizations/" + orgName
					+ "/environments/" + env + "/apis/" + proxy + "/revisions/" + deployedRevision + "/deployments");
			target.request().delete();
			System.out.println("SUCCESSFUL: Revision undeployed");
		} catch (Exception e) {
			System.out.println("UNSUCCESSFULL: Could not undeploy the revision");
		}

	}

}
