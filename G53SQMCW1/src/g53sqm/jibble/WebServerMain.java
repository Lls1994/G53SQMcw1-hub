package g53sqm.jibble;

import java.io.File;
import java.io.IOException;

/* 
Copyright Paul James Mutton, 2001-2004, http://www.jibble.org/

This file is part of Jibble Web Server / WebServerLite.

This software is dual-licensed, allowing you to choose between the GNU
General Public License (GPL) and the www.jibble.org Commercial License.
Since the GPL may be too restrictive for use in a proprietary application,
a commercial license is also provided. Full license information can be
found at http://www.jibble.org/licenses/

$Author: pjm2 $
$Id: WebServerMain.java,v 1.2 2004/02/01 13:37:35 pjm2 Exp $

*/


/**
 * This class contains the main method for the Jibble Web Server.
 * 
 * @author Copyright Paul Mutton, http://www.jibble.org/
 */
public class WebServerMain {

    public static void main(String[] args) {
        
        String rootDir = "";
        int port = 0;
        
        if (args.length == 0) {
        	File file = new File("C:\\Users\\Liang Sheng\\Desktop\\G53SQM\\jibble\\webfiles");
        	try {
  				rootDir = file.getCanonicalPath();
  				port = 8088;
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
        }
       
        if (args.length > 0) {
        	File file = new File("C:\\Users\\Liang Sheng\\Desktop\\G53SQM\\jibble\\" + args[0]);
            try {
				rootDir = file.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                // Stick with the default value.
            }
        }
        
        try {
            WebServer server = new WebServer(rootDir, port);
            System.out.println("Jibble web server (modified by Liang Sheng Lee for G53SQM)");
            System.out.println("Root Directory: " + rootDir );
            System.out.println("Port: " + port);
            server.activate();
        }
        catch (WebServerException e) {
            System.out.println(e.toString());
        }
    }

}