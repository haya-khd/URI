package uri.implementation;

import uri.Uri;
import uri.UriParser;

// TODO implement this class or another implementation of UriParser
public class UriParserImplementation implements UriParser {

	public String haya;
	public UriParserImplementation(String uri) {
	this.haya = uri;
}

	

	//	public void setName(String uri1) {
//		this.uri1= uri1;
//	}
//	public 
	@Override
	public Uri parse() {
		// TODO implement this
		if(haya=="") {
			return null;
		}
		if(haya== null) {
			return null;
		}
		else {
			return new UriImplementation(haya);
		}
	}

}
