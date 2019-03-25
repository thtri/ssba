package org.company.application.simplespringbootapp;

import org.company.security.obsolete.sanitizers;
import org.company.database.*;

public class ReportGenerator {
	public String user_lookup ( String email ) {
		// some kind of lookup
		String c_email = sanitizers.sanitize( email );
		String squery = "select * from somewhere where something='" + email + "';";
		
		query q = new query();
		String response = q.runQuery( squery );
		
		return response;
	}
}
