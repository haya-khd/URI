package uri.implementation;

import uri.IPv4Address;

// TODO implement this class or another Implementation of IPv4Address
public class IPv4AddressImplementation extends HostImplementation implements IPv4Address {
private String field;
	public IPv4AddressImplementation(String host) {
		super(host);
		
		// TODO implement this
		this.field=host;
		
	}

	@Override
	public byte[] getOctets() {
		// TODO implement this
		return null;
	}
	public String NewStr(String s) {
		String strNew =s;
		if(strNew.startsWith("0")) {
			 strNew=s.replace("0", "");
			if(strNew.startsWith("0")) {
				 strNew=strNew.replace("0","");
				return strNew;
			}
			
			return strNew;
		}
		
				return strNew;
			
		}
		


	@Override
	public String toString() {
		// TODO implement this
	
		String[] Ip=field.split("\\.");
		String Ip0= NewStr(Ip[0]);
		String Ip1=NewStr(Ip[1]);
		String Ip2=NewStr(Ip[2]);
		String Ip3=NewStr(Ip[3]);
	
		String fieldNew=Ip0 + "." + Ip1 + "." + Ip2 + "." + Ip3;			
				
		
		return fieldNew;
	}

}
